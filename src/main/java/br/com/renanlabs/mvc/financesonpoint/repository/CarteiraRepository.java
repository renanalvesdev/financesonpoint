package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
	public List<Carteira> findByAtivo(Boolean ativo);
}