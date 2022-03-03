package br.com.unisoma.folhapag.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository repository;
	
	public Funcionario cadastrar(String name, Long cpf, String dataNascimento, String telefone, String endereco, Double salario) {
		Funcionario funci = repository
				.save(new Funcionario(name, cpf, strToDate(dataNascimento), telefone, endereco, salario));
		
		return funci;
	}

	public List<Funcionario> findAll() {
		List<Funcionario> funcis = new ArrayList<Funcionario>();
		repository.findAll().forEach(funcis::add);
		return funcis;
	}

	public Optional<Funcionario> findByCpf(Long cpf) {
		return repository.findByCpf(cpf);
	}
	
	private LocalDate strToDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = LocalDate.parse(str, formatter);
		return dateTime;
	}

	public void atualizar(Funcionario funcionario) {
		repository.save(funcionario);
	}
}
