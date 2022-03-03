package br.com.unisoma.folhapag.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.unisoma.folhapag.dto.NovoSalarioDTO;
import br.com.unisoma.folhapag.model.Funcionario;
import br.com.unisoma.folhapag.service.FuncionarioService;
import br.com.unisoma.folhapag.service.SalarioService;


@ExtendWith(MockitoExtension.class)
class SalarioControllerTest {

	@Mock private SalarioService salarioService;
	@Mock private FuncionarioService funciService;
	
	@InjectMocks
	private SalarioController controller;
	
	private static final Long CPF = 5784110114L;
	
	@Test
	void testSalario() {
		Optional<Funcionario> funcionario = Optional.of(new Funcionario("TESTE", CPF, null, null, null, 3002.0));
		when(funciService.findByCpf(CPF)).thenReturn(funcionario);
		when(salarioService.percentualReajuste(3002.0)).thenReturn(Integer.valueOf(4));
		
		ResponseEntity<NovoSalarioDTO> response = controller.novoSalarioByCpf(CPF);
		assertNotNull(response);
		NovoSalarioDTO novoSalario = (NovoSalarioDTO)response.getBody();
		assertEquals(4, novoSalario.getPercentual());
		assertEquals(3122.08, novoSalario.getSalario());
	}

}
