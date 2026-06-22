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
	
	public String dec2bin(Integer decimal) {
		// Caso especial: se o número já for zero, retorna "0" direto
	    if (decimal == 0) {
	        return "0";
	    }
	    
	    String binario = "";
	    
	    // O laço continua enquanto o número for maior que zero
	    while (decimal > 0) {
	        int resto = decimal % 2;     // Pega o resto da divisão (será sempre 0 ou 1)
	        binario = resto + binario;   // Concatena o resto À ESQUERDA da string (inverte a ordem automaticamente)
	        decimal = decimal / 2;       // Divide o número por 2 para a próxima iteração
	    }
	    
	    return binario;	
	}

}
