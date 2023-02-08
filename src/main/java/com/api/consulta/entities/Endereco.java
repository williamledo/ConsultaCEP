package com.api.consulta.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cep;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Double frete;
	
	public Endereco(ViaCep viaCep) {
		
		this.cep = viaCep.getCep();
		this.rua = viaCep.getLogradouro();
		this.complemento = viaCep.getComplemento();
		this.bairro = viaCep.getBairro();
		this.cidade = viaCep.getLocalidade();
		this.estado = viaCep.getUf();
		
		switch (viaCep.getUf()) {
		
			case "SP":
				this.frete = 7.85;
				break;
			
			case "MG":
				this.frete = 7.85;
				break;
				
			case "ES":
				this.frete = 7.85;
				break;
				
			case "RJ":
				this.frete = 7.85;
				break;
				
			case "GO":
				this.frete = 12.50;
				break;
				
			case "MT":
				this.frete = 12.50;
				break;
				
			case "MS":
				this.frete = 12.50;
				break;
				
			case "DF":
				this.frete = 12.50;
				break;
			
			case "MA":
				this.frete = 15.98;
				break;
				
			case "PI":
				this.frete = 15.98;
				break;
				
			case "CE":
				this.frete = 15.98;
				break;
				
			case "RN":
				this.frete = 15.98;
				break;
				
			case "PB":
				this.frete = 15.98;
				break;
				
			case "PE":
				this.frete = 15.98;
				break;
				
			case "AL":
				this.frete = 15.98;
				break;
				
			case "SE":
				this.frete = 15.98;
				break;
				
			case "BA":
				this.frete = 15.98;
				break;
				
			case "PR":
				this.frete = 17.30;
				break;
				
			case "SC":
				this.frete = 17.30;
				break;
				
			case "RS":
				this.frete = 17.30;
				break;
				
			case "RO":
				this.frete = 20.83;
				break;
				
			case "AC":
				this.frete = 20.83;
				break;
				
			case "AM":
				this.frete = 20.83;
				break;
				
			case "RR":
				this.frete = 20.83;
				break;
				
			case "PA":
				this.frete = 20.83;
				break;
				
			case "AP":
				this.frete = 20.83;
				break;
				
			case "TO":
				this.frete = 7.85;
				break;
		
		}
		
	}
	
}
