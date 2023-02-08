package com.api.consulta.DTO;

import com.api.consulta.entities.Endereco;

public record EnderecoDTO(String cep, String rua, String complemento, String bairro, String cidade, String estado, Double frete) {

	public EnderecoDTO(Endereco endereco ) {
		
		this(endereco.getCep(), endereco.getRua(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getFrete());
		
	}
	
}
	