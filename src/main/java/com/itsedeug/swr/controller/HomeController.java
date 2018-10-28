package com.itsedeug.swr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String exibirMensagemBoasVindas() {
		return "MensagemBoasVindas";
	}

}
