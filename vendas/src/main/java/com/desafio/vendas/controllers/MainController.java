package com.desafio.vendas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
}
