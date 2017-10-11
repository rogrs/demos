package br.com.rogrs.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rogrs.contatos.model.Contato;
import br.com.rogrs.contatos.repository.ContatoRepository;

@Controller
@RequestMapping("/contatos")
public class ContatosResource {
	
	@Autowired
	private ContatoRepository contatos;
	
	@GetMapping
	public ModelAndView listar() {
		List<Contato> lista = contatos.findAll();
		
		ModelAndView modelAndView = new ModelAndView("contatos");		
		modelAndView.addObject("contatos", lista);
		
		return modelAndView;
	}
}