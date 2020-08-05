package br.com.professorisidro.validacpf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.validacpf.service.Validador;

@RestController
@CrossOrigin("*")
public class ValidadorController {
	
	@GetMapping("/validacpf")
	public String validaCPF(@RequestParam (required = false) String cpf) {

		if(cpf == "" || cpf == " "){
			return "{\"status\": \"conteudo_vazio\"}";
		}

		if (Validador.isCPF(cpf)) {
			return "{\"status\": \"valido\"}";
		}
		 	return "{\"status\": \"invalido\"}";
	}

	@GetMapping("/")
	public String index (){
		return "{\"status\": \"bem-vindo a API\"}";
	}

}
