package JPAControladorDao;



import entidades.Autor;

public interface AutorFacade extends AbstractFacadeJPA<Autor> {
	
	public void mostrarTodos();
		
}
