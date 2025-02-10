package JPAControladorDao;

import jakarta.persistence.EntityManager;

public interface AbstractFacadeJPA<T> {
	
	Boolean create(T entity); //booleando que indica q tdo va bien
	Boolean update(T entity);
	void remove(T entity);
	T find(Object id);
	EntityManager getEm();
	
}
