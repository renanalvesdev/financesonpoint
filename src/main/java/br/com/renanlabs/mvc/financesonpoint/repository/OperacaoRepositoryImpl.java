package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

@Repository
public class OperacaoRepositoryImpl implements OperacaoRepositoryCustom{

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Operacao> findByFilter(DespesaFilter filter) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Operacao> criteriaQuery = cb.createQuery(Operacao.class);
		Root<Operacao> operacaoRoot = criteriaQuery.from(Operacao.class);
		
		Predicate p = cb.conjunction();
		
		if(filter.getMonth() != null) {
			Expression<Integer> month = cb.function("month", Integer.class, operacaoRoot.get("data"));
			p = cb.and(p, cb.equal(month, filter.getMonth()));
		}
		
		if(filter.getYear() != null) {
			Expression<Integer> month = cb.function("year", Integer.class, operacaoRoot.get("data"));
			p = cb.and(p, cb.equal(month, filter.getYear()));
		}
		
		if(filter.getCarteira() != null) {
			p = cb.and(p, cb.equal(operacaoRoot.get("carteira"), filter.getCarteira()));
		}
		
		if(filter.getCategoria() != null) {
			p = cb.and(p, cb.equal(operacaoRoot.get("data"), filter.getCategoria()));
		}

		criteriaQuery.orderBy(cb.desc(operacaoRoot.get("valor")));
		criteriaQuery.where(p);
		
		List<Operacao> despesas = entityManager.createQuery(criteriaQuery).getResultList();
		
		return despesas;
	}

}
