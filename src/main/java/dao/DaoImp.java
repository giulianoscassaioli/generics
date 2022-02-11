package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DaoImp <T> implements Dao <T>{

	private EntityManager em;
	private Class <T> tipo;
	
	public DaoImp(EntityManager em,Class <T> tipo) {
		this.em=em;
		this.tipo=tipo;
	}
	
	@Override
	public void inserisci(T t) {
		em.persist(t);
		
	}

	@Override
	public void aggiorna(T t) {
		em.merge(t);
		
	}

	@Override
	public void cancella(T t) {
		em.remove(em.merge(t));
		
	}

	@Override
	public List<T> trovaTutti() {
	
		Query q =em.createQuery("SELECT t FROM "+tipo.getSimpleName()+" t ");
	     return q.getResultList();
		
	}

	@Override
	public T trova(Object o) {
		
		return em.find(tipo, o);
	}
	
	public List<T> trovaByQuery(String query){

		Query q =em.createQuery(query);
	     return q.getResultList();
	}

}
