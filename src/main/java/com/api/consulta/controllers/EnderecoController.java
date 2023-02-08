package com.api.consulta.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.consulta.DTO.Cep;
import com.api.consulta.entities.Endereco;
import com.api.consulta.entities.ViaCep;
import com.google.gson.Gson;

import jakarta.validation.Valid;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

	@PostMapping(value = "/")
    public ResponseEntity cadastrar(@RequestBody @Valid Cep dados) throws Exception {

		String mascaraCep = dados.cep();
        String cepLimpo = mascaraCep.replaceAll("\\D", "");
        
		URL url = new URL("https://viacep.com.br/ws/"+cepLimpo+"/json/");
		URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        
        while ((cep = br.readLine()) != null) {
        	jsonCep.append(cep);
        }
        
        ViaCep response = new Gson().fromJson(jsonCep.toString(), ViaCep.class);
        
        if (response.getErro() == null) {
        	
        	 Endereco endereco = new Endereco(response);
             
     		return ResponseEntity.ok().body(endereco);
        	
        } else {
        	return ResponseEntity.badRequest().body("CEP inválido, verifique e tente novamente");
        }
		
    }
	
	
}
