package br.com.unisoma.folhapag.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private static final Long CPF = 49745282202L;
	private static final String DATANASC = "17/03/2002";
	private static final String TELEFONE = "(61) 9.9184-4198";
	private static final String ENDEREÇO = "Rua 10 - Casa 01";
	private static final Double SALARIO = 4550.50;

	@Mock
	private FuncionarioService service;
	
	@InjectMocks
	private FuncionarioController controller;
	
    @BeforeEach
    void setMockOutput() {
        when(service.cadastrar(ELBERT, CPF, DATANASC, TELEFONE, ENDEREÇO, SALARIO)).thenReturn(new Funcionario(ELBERT, CPF, DATANASC, TELEFONE, ENDEREÇO, SALARIO));
    }

	@Test
	void testFuncionario() {
		Funcionario funci = service.cadastrar(ELBERT, CPF, DATANASC, TELEFONE, ENDEREÇO, SALARIO);
		assertEquals(funci.getNome(), ELBERT);
		assertEquals(funci.getCpf(), CPF);
		assertEquals(funci.getTelefone(), TELEFONE);
		assertEquals(funci.getEndereco(), ENDEREÇO);
		assertEquals(funci.getSalario(), SALARIO);
		assertInstanceOf(LocalDate.class, funci.getDataNascimento());
	}

}
