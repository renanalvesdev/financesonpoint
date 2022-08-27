package br.com.renanlabs.mvc.financesonpoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoNovaOperacao;
import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;
import br.com.renanlabs.mvc.financesonpoint.service.CategoriaService;
import br.com.renanlabs.mvc.financesonpoint.service.OperacaoService;
import br.com.renanlabs.mvc.financesonpoint.service.PlanejamentoMensalService;

@Controller
@RequestMapping("operacao")
public class OperacaoController {

	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private OperacaoService operacaoService;
	
	@Autowired
	private PlanejamentoMensalService planejamentoMensalService;


	
	/**methods to handling showing of form**/
	
	//show new Operation form
	@GetMapping("formulario")
	public String showNewForm(RequisicaoNovaOperacao requisicao, Model model) {

		List<Carteira> carteiras = carteiraRepository.findAll();
		List<Categoria> categorias = categoriaService.findAll();
		List<PlanejamentoMensal> planejamentos = planejamentoMensalService.findByMesAtual(); 
		
		model.addAttribute("categorias", categorias);
		model.addAttribute("carteiras", carteiras);
		model.addAttribute("planejamentos", planejamentos);
		
		return "operacao/formulario";
	}

	// show fetched Operation form
	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		
		List<Carteira> carteiras = carteiraRepository.findAll();
		List<Categoria> categorias = categoriaService.findAll();
		
		Operacao operacao = operacaoService.buscaPorId(id);
		
		List<PlanejamentoMensal> planejamentos = planejamentoMensalService.findByMesDeData(operacao.getData()); 

		
		RequisicaoNovaOperacao requisicaoNovaOperacao = new RequisicaoNovaOperacao(operacao);
		
		model.addAttribute("categorias", categorias);
		model.addAttribute("carteiras", carteiras);
		model.addAttribute("planejamentos", planejamentos);

		model.addAttribute("requisicaoNovaOperacao", requisicaoNovaOperacao);
		
		return "operacao/formulario";
	}
	
	@GetMapping("despesaModal")
    public String showDespesaModal(@RequestParam("id") String id, Model model) {
		
		Operacao operacao = operacaoService.buscaPorId(Integer.valueOf(id));
        model.addAttribute("operacao", operacao);
        return "despesaModal";
    }

	
	/** methods to handling CRUD operations to entity 'Operations' **/
	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoNovaOperacao requisicao, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "operacao/formulario";
		}

		try {
			operacaoService.save(requisicao.toOperacao());			
		} catch (FinancesOnPointException e) {
			 model.addAttribute("errorMessage",e.getMessage());
			 return "operacao/formulario";
		}

		return "redirect:/home";
	}
	
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		operacaoService.delete(id.intValue());
		return "redirect:/home";
	}

}
