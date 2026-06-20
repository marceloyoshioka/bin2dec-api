package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pet.service.ConversorService;

@RestController
public class ConversorController {

	@Autowired
	private ConversorService service;
	
	@GetMapping("/bin2dec/{binario}")
	public ResponseEntity<String> bin2dec(@PathVariable String binario) {
		
		if(!binario.matches("[01]+")) {
			return ResponseEntity.badRequest().body("O valor informado não é um número binário válido");
		}
		
		return ResponseEntity.ok("Valor convertido para decimal é "+service.bin2dec(binario));
		
	}
	
}
