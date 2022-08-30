package com.sdhdata.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout,
			Model model,Principal principal, RedirectAttributes attribute) {
		
		if(error!=null) {
			model.addAttribute("error","ERROR DE ACCESO: Usuario o contraseña son incorrectos");
		}
		
		if(principal!=null) {
			attribute.addFlashAttribute("warning", "ATENCIÓN: Ya ha iniciado sesión previamente");
			return "redirect:/spidata_sdh";
		}
		
		if(logout!=null) {
			model.addAttribute("success","ATENCIÓN: Ha finalizado sesión con éxito");
		}
		return "login";
	}

}
