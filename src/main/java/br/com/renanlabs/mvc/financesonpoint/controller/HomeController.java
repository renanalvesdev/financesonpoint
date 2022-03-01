package br.com.renanlabs.mvc.financesonpoint.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoDespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private OperacaoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		List<Operacao> operacoes = repository.findAll();
		model.addAttribute("requisicaoDespesaFilter", new RequisicaoDespesaFilter());
		model.addAttribute("operacoes", operacoes);
		return "home"; 
	}
	
	@PostMapping("/searchByFilter")
	public String searchByFilter(@Valid RequisicaoDespesaFilter requisicaoDespesaFilter, BindingResult result, Model model) {
		
		List<Operacao> operacoes = new ArrayList<Operacao>();
		
		try {
			DespesaFilter despesaFilter = requisicaoDespesaFilter.toDespesaFilter();
			operacoes = repository.findByMonthAndYear(despesaFilter.getMonth(), despesaFilter.getYear());
			
		} catch (Exception e) {
			System.out.println("Houve um erro ao tentar filtrar : [" + e.getMessage() + "] -> trazendo todos os resultados...");
			operacoes = repository.findAll();
		}
		model.addAttribute("operacoes", operacoes);
		
		return "home";
	}
	
	/*
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Operacao> operacoes = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("operacoes", operacoes);
		model.addAttribute("status", status);
		return "home"; 
	}*/
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
