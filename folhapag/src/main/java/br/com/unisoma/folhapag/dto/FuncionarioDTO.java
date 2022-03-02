package br.com.unisoma.folhapag.dto;

import br.com.unisoma.folhapag.model.Funcionario;

public class FuncionarioDTO {
	private Funcionario funci;
	private String mensagem;
	private Double novoSalario;
	
	public Funcionario getFunci() {
		return funci;
	}
	public void setFunci(Funcionario funci) {
		this.funci = funci;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Double getNovoSalario() {
		return novoSalario;
	}
	public void setNovoSalario(Double novoSalario) {
		this.novoSalario = novoSalario;
	}
}
