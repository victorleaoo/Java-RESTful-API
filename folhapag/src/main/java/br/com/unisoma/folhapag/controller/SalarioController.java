package br.com.unisoma.folhapag.controller;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.folhapag.dto.ImpostoDTO;
import br.com.unisoma.folhapag.dto.NovoSalarioDTO;
import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;
import br.com.unisoma.folhapag.service.SalarioService;

@RestController
public class SalarioController {

	private final SalarioService salarioService;
	private final FuncionarioService funciService;
	
    @Autowired
    public SalarioController(SalarioService salarioService, FuncionarioService funciService) {
        this.salarioService = salarioService;
        this.funciService = funciService;
    }
    
	@GetMapping("/api/novoSalario/{cpf}")
	public ResponseEntity<NovoSalarioDTO> novoSalarioByCpf(@PathVariable("cpf") Long cpf) {
		Optional<Funcionario> funciData = funciService.findByCpf(cpf);
		if (funciData.isPresent()) {
			Funcionario funcionario = funciData.get();
			Integer percentual = salarioService.percentualReajuste(funcionario.getSalario());
			Double novoSalario = funcionario.getSalario() * (1 + ((double)percentual/100));
			NovoSalarioDTO novo = new NovoSalarioDTO(funcionario.getCpf(), funcionario.getSalario(), percentual, novoSalario);
			funcionario.setSalario(novoSalario);
			funciService.atualizar(funcionario);
			return new ResponseEntity<>(novo, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/api/imposto/{cpf}")
	public ResponseEntity<ImpostoDTO> impostoFuncionarioByCpf(@PathVariable("cpf") Long cpf){
		Optional<Funcionario> funciData = funciService.findByCpf(cpf);
		if(funciData.isPresent()) {
			Funcionario funcionario = funciData.get();
			Double impostoCalculado = salarioService.calculoImposto(funcionario.getSalario());
			ImpostoDTO imposto = new ImpostoDTO(funcionario.getCpf(), formatarParaDinheiro(impostoCalculado));
			return new ResponseEntity<>(imposto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private String formatarParaDinheiro(double imposto) {
	    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	    if(imposto == 0.0) {
			return "Isento";
		} 
	    return nf.format(imposto);
	}
}
