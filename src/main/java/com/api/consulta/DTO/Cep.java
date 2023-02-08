package com.api.consulta.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Cep(
		
		@NotBlank
		@Pattern(regexp="^\\d{5}\\-\\d{3}$|^\\d{8}$")
		String cep
		
		) {

}
