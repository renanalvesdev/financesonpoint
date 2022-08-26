package br.com.renanlabs.mvc.financesonpoint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoDespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;
import br.com.renanlabs.mvc.financesonpoint.service.CarteiraService;
import br.com.renanlabs.mvc.financesonpoint.service.CategoriaService;
import br.com.renanlabs.mvc.financesonpoint.service.ChartService;
import br.com.renanlabs.mvc.financesonpoint.service.PlanejamentoMensalService;

@Controller
@RequestMapping(value={"/","/home"})
public class HomeController {
	
	@Autowired
	private OperacaoRepository repository;
	
	@Autowired
	private PlanejamentoMensalService planejamentoMensalService;
	
	@Autowired
	private CarteiraService carteiraService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ChartService chartService;
	
	
	@GetMapping
	public String home(Model model) {
		
		//fetching data from dropdown
		List<Carteira> carteiras = carteiraService.findAll();
		List<Categoria> categorias = categoriaService.findAll();
		
		//fetching expenses and plenned expenses for month
		List<Operacao> operacoes = repository.findAll();
		List<PlanejamentoMensal> planejamentos = planejamentoMensalService.findAll();
		
		//populating attributes to be seeing in the view
		model.addAttribute("requisicaoDespesaFilter", new RequisicaoDespesaFilter());
		model.addAttribute("carteiras", carteiras);
		model.addAttribute("categorias", categorias);
		model.addAttribute("operacoes", operacoes);
		model.addAttribute("planejamentos", planejamentos);
		
		return "home"; 
	}
	
	@GetMapping("/searchByFilter")
	public String searchByFilter(@Valid RequisicaoDespesaFilter requisicaoDespesaFilter, BindingResult result,  Model model) {
		
		if (result.hasErrors()) {
            return "home";
        }

		DespesaFilter despesaFilter = requisicaoDespesaFilter.toDespesaFilter();
		
		List<Operacao> operacoes = repository.findByFilter(despesaFilter);
		List<PlanejamentoMensal> planejamentos = planejamentoMensalService.findByMonthAndYear(despesaFilter.getMonth(), despesaFilter.getYear());
		
		Double totalDespesas = 0.00;
		
		totalDespesas += operacoes.stream().mapToDouble(Operacao::getValor).sum();
		
		model.addAttribute("chartAmountCarteiraData", getChartAmountCarteira(despesaFilter.getMonth(), despesaFilter.getYear()));
		model.addAttribute("chartAmountCategoriaData", getChartAmountCategoria(despesaFilter.getMonth(), despesaFilter.getYear()));
		model.addAttribute("operacoes", operacoes);
		model.addAttribute("planejamentos", planejamentos);
		model.addAttribute("totalMes", totalDespesas);
		
		return "home";
	}
	
	private List<List<Object>> getChartAmountCarteira(Integer mes, Integer ano) { 
		
        return List.of(
        		chartService
        		.amountCarteiraPorMesAndAno(mes, ano)
        		.stream()
        		.map(a -> List.of(a.getDescricao(), a.getTotal()))
        		.collect(Collectors.toList()));
    }
	
	private List<List<Object>> getChartAmountCategoria(Integer mes, Integer ano) { 
		
        return List.of(
        		chartService
        		.amountCategoriaPorMesAndAno(mes, ano)
        		.stream()
        		.map(a -> List.of(a.getDescricao(), a.getTotal()))
        		.collect(Collectors.toList()));
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
