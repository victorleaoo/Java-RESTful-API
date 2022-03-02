package br.com.unisoma.folhapag.service;

import org.springframework.stereotype.Service;

@Service
public class SalarioService {

	private final static double FAIXA_4500 = 4500.0;
	private final static double PERCENTUAL_4500 = 0.28;
	
	private final static double FAIXA_3000 = 3000.0;
	private final static double PERCENTUAL_3000 = 0.18;
	
	private final static double FAIXA_2000 = 2000.0;
	private final static double PERCENTUAL_2000 = 0.08;
	
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
		
		if(salario <= FAIXA_2000) {
			return 0.0; // isento
		}
		
		double imposto = 0.0;	
		double imposto_faixa_4500 = 0.0;
		double imposto_faixa_3000 = 0.0;
		if(salario > FAIXA_4500) {
			imposto_faixa_4500 = salario - FAIXA_4500;
			imposto = imposto_faixa_4500 * PERCENTUAL_4500;
		}
		
		if(salario > FAIXA_3000) {
			imposto_faixa_3000 = salario - FAIXA_3000 - imposto_faixa_4500;
			imposto += imposto_faixa_3000 * PERCENTUAL_3000;
		}
		
		if(salario > FAIXA_2000) {
			double imposto_faixa_2000 = salario - FAIXA_2000 - imposto_faixa_3000 - imposto_faixa_4500;
			imposto += imposto_faixa_2000 * PERCENTUAL_2000;
		}
		
		return imposto;
	}	
	
	/*
	 * public static void main(String[] args) {
	 * System.out.println("calculo 4600 -> " + calculoImposto(4600.0));
	 * System.out.println("calculo 3002 -> " + calculoImposto(3002.0)); }
	 */
}
