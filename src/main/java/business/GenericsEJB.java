package business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Dao;
import dao.DaoImp;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class GenericsEJB
 */
@Stateless
@LocalBean
public class GenericsEJB {

	@PersistenceContext(unitName = "testgenericsPS")
	EntityManager em;

	private Map<String, Dao> daoCache = new HashMap<>();

	private void addDaoToCache(Class c) {
		
		System.out.println(c.getSimpleName());

		daoCache.put(c.getSimpleName(), new DaoImp(em, c));

	}

	private Dao getDaoFromCache(Class c) {

		/*if(daoCache.get(c.getSimpleName())==null) {
			addDaoToCache(c);
			
		}*/
		
		if(!daoCache.containsKey(c.getSimpleName())) {
			addDaoToCache(c);
			
		}
		return  daoCache.get(c.getSimpleName());

	}
	
	

	public GenericsEJB() {
		// TODO Auto-generated constructor stub
	}

	public <T> List<T> trova(Class c) {
		return getDaoFromCache(c).trovaTutti();
		
	
	}

}
