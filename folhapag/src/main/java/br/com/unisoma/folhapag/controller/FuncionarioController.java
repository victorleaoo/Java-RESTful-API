package br.com.unisoma.folhapag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.folhapag.dto.ImpostoDTO;
import br.com.unisoma.folhapag.dto.NovoSalarioDTO;
import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;
import br.com.unisoma.folhapag.service.SalarioService;

@RestController
public class FuncionarioController {
	
    private final FuncionarioService funciService;
    private final SalarioService salarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funciService, SalarioService salarioService) {
        this.funciService = funciService;
        this.salarioService = salarioService;
    }

	@PostMapping("/cadastrar")
	public ResponseEntity<Funcionario> cadastrar(@RequestParam(value = "name") String name, 
			@RequestParam(value = "cpf") Long cpf,
			@RequestParam(value = "dataNascimento") String dataNasc,
			@RequestParam(value = "telefone") String telefone, 
			@RequestParam(value = "endereco") String endereco, 
			@RequestParam(value = "salario") Double salario) {
		
		try {
			Funcionario funci = funciService.cadastrar(name, cpf, dataNasc, telefone, endereco, salario);
			return new ResponseEntity<>(funci, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Funcionario>> getAllFuncionario() {
		try {
			List<Funcionario> funcis = funciService.findAll();
			if (funcis.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(funcis, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/novoSalario/{cpf}")
	public ResponseEntity<NovoSalarioDTO> getFuncionarioByCpf(@PathVariable("cpf") Long cpf) {
		Optional<Funcionario> funciData = funciService.findByCpf(cpf);
		if (funciData.isPresent()) {
			Funcionario funcionario = funciData.get();
			Integer percentual = salarioService.percentualReajuste(funcionario.getSalario());
			NovoSalarioDTO novo = new NovoSalarioDTO(funcionario.getCpf(), funcionario.getSalario(), percentual);
			funciService.atualizar(funcionario.getId(), novo.getSalario());
			return new ResponseEntity<>(novo, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/imposto/{cpf}")
	public ResponseEntity<ImpostoDTO> impostoFuncionarioByCpf(@PathVariable("cpf") Long cpf){
		Optional<Funcionario> funciData = funciService.findByCpf(cpf);
		if(funciData.isPresent()) {
			Funcionario funcionario = funciData.get();
			Double impostoCalculado = salarioService.calculoImposto(funcionario.getSalario());
			ImpostoDTO imposto = new ImpostoDTO(funcionario.getCpf(), impostoCalculado);
			return new ResponseEntity<>(imposto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
