package br.com.renanlabs.mvc.financesonpoint.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;
import br.com.renanlabs.mvc.financesonpoint.repository.PlanejamentoMensalRepository;

@Service
public class PlanejamentoMensalService {
	
	@Autowired
	private PlanejamentoMensalRepository planejamentoMensalRepository;
	
	public void save(PlanejamentoMensal planejamentoMensal) {
		planejamentoMensalRepository.save(planejamentoMensal);
	}
	
	public PlanejamentoMensal findById(Long id) {
		return planejamentoMensalRepository.findById(id).orElse(null);
	}
	
	public List<PlanejamentoMensal> findAll(){
		return planejamentoMensalRepository.findAll();
	}
	
	public List<PlanejamentoMensal> findByMonthAndYear(int mes, int ano){
		return planejamentoMensalRepository.findByMonthAndYear(mes, ano);
	}
	
	public List<PlanejamentoMensal> findByMesAtual(){
		return planejamentoMensalRepository.findByMonthAndYear(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
	}
	
	public List<PlanejamentoMensal> findByMesDeData(LocalDate date){
		return planejamentoMensalRepository.findByMonthAndYear(date.getMonthValue(), date.getYear());
	}
}
