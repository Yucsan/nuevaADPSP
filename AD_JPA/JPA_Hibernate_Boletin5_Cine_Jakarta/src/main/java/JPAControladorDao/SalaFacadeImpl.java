package JPAControladorDao;

import java.util.List;

import entidades.Sala;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> implements SalaFacade {

	public SalaFacadeImpl() {
		super(Sala.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Sala>mostrarTodos(){
		TypedQuery <Sala> q=this.getEm().createQuery("SELECT s FROM Sal AS s",Sala.class);
		return q.getResultList();
	}
	
	/**
	 * Ejercicio3
	 */

	@Override
	public List<Long> salasDetermGenero(String genero) {
	    TypedQuery<Long> q3 = this.getEm().createQuery(
	        "SELECT COUNT(sa.codsala) " +
	        "FROM Sala sa, Pas pas, Pelicula p " +
	        "WHERE sa.codsala = pas.sala.codsala " +
	        "AND pas.pelicula.codpelicula = p.codpelicula " +
	        "AND p.genero = '"+genero+"'", Long.class);
	    return q3.getResultList();
	}
	
	@Override
	public List<Tuple>salasComediaMasAnhos(){
		TypedQuery<Tuple>q4=this.getEm().createQuery("SELECT sa.codsala,sa.tipoSonido,sa.numfilas,sa.numasiporfilas,(sa.numasiporfilas*sa.numfilas)AS total_asientos "
				+ "FROM Sala sa "
				+ "JOIN Pas pas ON sa.codsala=pas.sala.codsala "
				+ "JOIN Pelicula p ON pas.pelicula.codpelicula=p.codpelicula "
				+ "WHERE (p.genero='TERROR' OR p.genero='COMEDIA') "
				+ "AND p.fechaProd>STR_TO_DATE('2008-01-01', '%Y-%m-%d') "
				+ "GROUP BY sa.codsala "
				+ "ORDER BY total_asientos DESC",Tuple.class);
		return q4.getResultList();
	}

	@Override
	public List<Tuple> recaudacionTotal() {
		// TODO Auto-generated method stub
		TypedQuery<Tuple>q7=this.getEm().createQuery("SELECT "
				+ "    pas.tipoPase,"
				+ "    SUM(ent.pvp) as RecaudacionTotal "
				+ "FROM "
				+ "    Pas pas "
				+ "JOIN "
				+ "    Entrada ent ON pas.codpase = ent.pas.codpase "
				+ "WHERE "
				+ "    pas.fechaPase>=STR_TO_DATE('2016-06-01','%Y-%m-%d') AND pas.fechaPase<= STR_TO_DATE('2016-06-30','%Y-%m-%d') "
				+ "GROUP BY "
				+ "    pas.tipoPase ",Tuple.class);
		return q7.getResultList();
	}

	

	
	
	
	

}
