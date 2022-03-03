package br.com.unisoma.folhapag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
    private final FuncionarioService funciService;
    
    @Autowired
    public FuncionarioController(FuncionarioService funciService) {
        this.funciService = funciService;
    }

	@PostMapping("/api/cadastrar")
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
	
	@GetMapping("/api/listar")
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
	
}
