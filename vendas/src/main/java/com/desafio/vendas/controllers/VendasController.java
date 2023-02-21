package com.desafio.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.vendas.services.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendasController {
	
	@Autowired
	private VendaService service;

	@PostMapping("up")
	public ModelAndView formDirect(@RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		try {
			double valorCalculado = 
			service.processo(file);
			mv.setViewName("receita");
			mv.addObject("receitaBruta", valorCalculado);
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.setViewName("erro");
			mv.addObject("msgErro", e.getMessage());
			return mv;
		}
	}

}
