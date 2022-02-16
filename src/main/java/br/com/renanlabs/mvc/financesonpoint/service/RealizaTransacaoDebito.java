package br.com.renanlabs.mvc.financesonpoint.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;


@Service
public class RealizaTransacaoDebito implements RealizadorTransacao{
	
	private Operacao despesa;
	
	@Autowired
	private CarteiraService carteiraService;
	
	
	@Autowired
	private CarteiraTransacaoService carteiraTransacaoService;
	
	public RealizaTransacaoDebito() {
		
	}
	
	public RealizaTransacaoDebito(Operacao despesa) {
		this.despesa = despesa;
	}
	
	@Override
	public void efetua() {
		
		Carteira carteira = despesa.getCarteira();
		carteira.setValor(carteira.getValor() - despesa.getValor());
		
		CarteiraTransacao carteiraTransacao = new CarteiraTransacao();

		carteiraTransacao.setCarteira(carteira);
		carteiraTransacao.setDespesa(despesa);
		carteiraTransacao.setData(LocalDate.now());
		carteiraTransacao.setTipo(TipoTransacao.DEBITO);
		carteiraTransacao.setValor(despesa.getValor());
		
		carteiraService.save(carteira);
		carteiraTransacaoService.save(carteiraTransacao);
		
	}
	
	
	public Operacao getDespesa() {
		return despesa;
	}
	public void setDespesa(Operacao despesa) {
		this.despesa = despesa;
	}
	
	

}
