package br.com.unisoma.folhapag.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;

@ExtendWith(MockitoExtension.class)
class FuncionarioControllerTest {

	private static final String ELBERT = "Elbert";
	private static final Long CPF = 5784110114L;
	private static final LocalDate DATANASC = LocalDate.of(2002, 03, 12);
	private static final String TELEFONE = "(61) 9.9184-4198";
	private static final String ENDEREÇO = "Rua 10 - Casa 01";
	private static final Double SALARIO = 3002.0;
	
	@Mock
	private FuncionarioService service;
	
	@InjectMocks
	private FuncionarioController controller;
	
    @BeforeEach
    void setMockOutputCadastrar() {
        when(service.cadastrar(ELBERT, CPF, DATANASC.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), TELEFONE, ENDEREÇO, SALARIO)).thenReturn(new Funcionario(ELBERT, CPF, DATANASC, TELEFONE, ENDEREÇO, SALARIO));
    }
    
	@Test
	void testFuncionario() {
		Funcionario funci = service.cadastrar(ELBERT, CPF, DATANASC.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), TELEFONE, ENDEREÇO, SALARIO);
		assertEquals(funci.getNome(), ELBERT);
		assertEquals(funci.getCpf(), CPF);
		assertEquals(funci.getTelefone(), TELEFONE);
		assertEquals(funci.getEndereco(), ENDEREÇO);
		assertEquals(funci.getSalario(), SALARIO);
		assertInstanceOf(LocalDate.class, funci.getDataNascimento());
	}

}
