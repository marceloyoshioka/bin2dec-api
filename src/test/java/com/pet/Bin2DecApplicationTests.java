package com.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pet.service.ConversorService;

@SpringBootTest
class Bin2DecApplicationTests {

	@Autowired
	private ConversorService service;
	
	@Test
	void deveConverterPara9() {
		assertEquals(9, service.bin2dec("1001"));
	}
	
	@Test
	void deveReceberInteiroERetornarString() {
		assertEquals("0", service.dec2bin(0));
	}
	
	@Test
	void deveConverter9Para1001() {
		assertEquals("1001", service.dec2bin(9));
	}
	
	@Test
	void deveConverter0Para0() {
		assertEquals("0", service.dec2bin(0));
	}

}







