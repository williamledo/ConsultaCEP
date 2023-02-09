package com.api.consulta.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.api.consulta.DTO.Cep;
import com.api.consulta.DTO.EnderecoDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class EnderecoControllerTest {
	
	private static final Cep CEP_VALIDO = new Cep("54100020");
	private static final Cep CEP_INVALIDO = new Cep("00000000");
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EnderecoController enderecoController;
	
	private Cep cep;
	
	@Test
	public void testConsultar_comCepValido_deveRetornarStatus200() throws Exception {
		
		Mockito.when(enderecoController.consultar(Mockito.any(Cep.class))).thenReturn(ResponseEntity.ok().body(new EnderecoDTO(null, null, null, null, null, null, null)));
		
		ResponseEntity<EnderecoDTO> response = enderecoController.consultar(CEP_VALIDO);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(EnderecoDTO.class, response.getBody().getClass());
	}
	
	@Test
	public void testConsultar_comCepInvalido_deveRetornarStatus400() throws Exception {
		Mockito.when(enderecoController.consultar(Mockito.any(Cep.class))).thenReturn(ResponseEntity.badRequest().body("CEP inválido, verifique e tente novamente"));
		
		ResponseEntity<String> response = enderecoController.consultar(CEP_INVALIDO);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("CEP inválido, verifique e tente novamente", response.getBody());
	}
	
}
