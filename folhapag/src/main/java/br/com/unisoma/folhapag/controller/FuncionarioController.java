package br.com.unisoma.folhapag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
    private final FuncionarioService service;

    @Autowired
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

	@PostMapping("/cadastrar")
	public Funcionario cadastrar(@RequestParam(value = "name") String name, 
			@RequestParam(value = "cpf") Long cpf,
			@RequestParam(value = "dataNascimento") String dataNasc,
			@RequestParam(value = "telefone") String telefone, 
			@RequestParam(value = "endereco") String endereco, 
			@RequestParam(value = "salario") Double salario) {
		return service.cadastrar(name, cpf, dataNasc, telefone, endereco, salario);
	}
	
}
