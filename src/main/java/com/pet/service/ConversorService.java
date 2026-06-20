package com.pet.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {

	public Integer bin2dec(String binario) {
		int decimal = 0;
		int expoente = 0;
		int contador = binario.length();
		
		while(contador > 0) {
			//1001
			int numero = Integer.parseInt(binario.substring(contador-1, contador));
			// somar com decimal
			decimal = decimal + (int)(numero*Math.pow(2, expoente));
			
			expoente = expoente + 1;
			contador = contador - 1;
		}
		
		return decimal;
	}
}
