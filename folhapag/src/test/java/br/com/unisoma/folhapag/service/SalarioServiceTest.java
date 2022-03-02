package br.com.unisoma.folhapag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class SalarioServiceTest {
	
	@Autowired
	private SalarioService service;
	
	@Test
	void testImposto() {
		double imposto = service.calculoImposto(3002.0);
		assertEquals(80.36, imposto);
	}

}
