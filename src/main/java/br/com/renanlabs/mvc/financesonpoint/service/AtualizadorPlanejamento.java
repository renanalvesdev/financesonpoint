package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.stereotype.Component;

import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;

@Component
public class AtualizadorPlanejamento {

	public void atualiza(PlanejamentoMensal planejamentoMensal) {
		planejamentoMensal.setGasto(planejamentoMensal.getGasto());
		planejamentoMensal.setSaldo(planejamentoMensal.getSaldo());
	}
	
}
