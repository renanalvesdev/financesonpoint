package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.stereotype.Component;

import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;


@Component
public interface RealizadorTransacao {

	public void efetua(CarteiraTransacao carteiraTransacao);
}
