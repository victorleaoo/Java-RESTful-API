package br.com.unisoma.folhapag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unisoma.folhapag.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	Optional<Funcionario> findByCpf(Long cpf);
}
