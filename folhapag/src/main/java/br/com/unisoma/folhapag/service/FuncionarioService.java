package br.com.unisoma.folhapag.service;

import org.springframework.stereotype.Service;

import br.com.unisoma.folhapag.model.Funcionario;

@Service
public class FuncionarioService {

	public Funcionario cadastrar(String name, Long cpf, String dataNascimento, String telefone, String endereco, Double salario) {
		return new Funcionario(name, cpf, dataNascimento, telefone, endereco, salario);
	}

}
