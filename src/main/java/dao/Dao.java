package dao;

import java.util.List;

public interface Dao <T>{
	
	public void inserisci(T t);
	public void aggiorna(T t);
	public void cancella(T t);
	public List<T> trovaTutti();
	public T trova(Object o);

}
