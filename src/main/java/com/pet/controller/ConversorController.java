package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pet.exception.InvalidBinaryException;
import com.pet.model.ConversorResponse;
import com.pet.service.ConversorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ConversorController {

	@Autowired
	private ConversorService service;
	
	@GetMapping(value = {"/bin2dec/{binario}", "/bin2dec/"})
	@Operation(
			summary = "Converte binário para decimal",
			description = "Recebe um valor binário e retorna o correspondente decimal"
	)
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "Conversão realizada com sucesso"
		),
		@ApiResponse(
				responseCode = "400",
				description = "Número binário inválido"
		)
	})
	public ResponseEntity<ConversorResponse> bin2dec(@PathVariable(required = false) String binario) {
		
		if(binario == null || binario.isBlank()) {
			throw new InvalidBinaryException("O valor informado não pode ser nulo ou vazio");
		}
		
		if(!binario.matches("[01]+")) {
			throw new InvalidBinaryException("O valor informado não é um número binário válido");
		}
		//"Valor convertido para decimal é "+service.bin2dec(binario)
		Integer decimal = service.bin2dec(binario);
		
		return ResponseEntity.ok(new ConversorResponse(binario, decimal));
		
	}
	
	
	
}

