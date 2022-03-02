package br.com.unisoma.folhapag.service;

import org.springframework.stereotype.Service;

@Service
public class SalarioService {

	private final static double FAIXA_3 = 4500.0;
	private final static double PERCENTUAL_3 = 0.28;
	
	private final static double FAIXA_2 = 3000.0;
	private final static double PERCENTUAL_2 = 0.18;
	
	private final static double FAIXA_1 = 2000.0;
	private final static double PERCENTUAL_1 = 0.08;
	
	public Integer percentualReajuste(Double salario) {
				
		if(salario >= 0 && salario <= 400) {
			return 15;
		} else if (salario <= 800) {
			return 12;
		} else if (salario <= 1200) {
			return 10;
		} else if (salario <= 2000) {
			return 7;
		} 
		return 4;
	}
	
	public static double calculoImposto(double salario) {
		
		if(salario <= FAIXA_1) {
			return 0.0; // isento
		}
		
		double imposto = 0.0;	
		double imposto_faixa_3 = 0.0;
		double imposto_faixa_2 = 0.0;
		if(salario > FAIXA_3) {
			imposto_faixa_3 = salario - FAIXA_3;
			imposto = imposto_faixa_3 * PERCENTUAL_3;
		}
		
		if(salario > FAIXA_2) {
			imposto_faixa_2 = salario - FAIXA_2 - imposto_faixa_3;
			imposto += imposto_faixa_2 * PERCENTUAL_2;
		}
		
		if(salario > FAIXA_1) {
			double imposto_faixa_1 = salario - FAIXA_1 - imposto_faixa_2 - imposto_faixa_3;
			imposto += imposto_faixa_1 * PERCENTUAL_1;
		}
		
		return imposto;
	}	
}
