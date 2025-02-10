package JPAControladorDao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Analisi;
import entidades.Cita;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class CitaFacadeImpl extends AbstractFacadeJPAImpl<Cita> {

	public CitaFacadeImpl() {
		super(Cita.class);
	}

	public List<Cita> mostrarTodos() {
		TypedQuery<Cita> q = em.createQuery("SELECT a FROM Cita as a", Cita.class);
		return q.getResultList();
	}

	//cons 2
	////codigo cita, fecha cita, nombre medico, nombre paciente / ordenado por nom Medico ASC y
	public List<Tuple> consulta2() {
		TypedQuery<Tuple> consulta2 = this.getEm()
				.createQuery("SELECT c.codcita, "
						+ "c.fechacita, c.medico.nombre, c.paciente.nombre  "
						+ "FROM Cita c "
						+ "ORDER BY c.medico.nombre "
						
						,Tuple.class);
	return consulta2.getResultList();

	}  
	
	//cons 3
	//cod medico, nombre medico, num citas
	public List<Tuple> consulta3() {
	TypedQuery<Tuple> consulta2 = this.getEm()
		.createQuery("SELECT m.codmedico, m.nombre, c.codcita  "
					+ "FROM Medico m "
					+ "LEFT JOIN m.citas c"
							,Tuple.class);
	return consulta2.getResultList();

	}  
		
	// 5 coste medio de cada cita, cod medico, nombre, fechaIngreso, 
			//ordenada por antiguedad del medico, citas
	public List<Tuple> consulta5() {
		TypedQuery<Tuple> consulta5 = this.getEm()
			.createQuery("SELECT DISTINCT c.medico.codmedico, c.medico.nombre, "
					+ "c.medico.fechaingreso, AVG(c.coste) as COSTE_MEDIO  "
					+ "FROM Cita c "
					+ "GROUP BY c.medico.codmedico, c.medico.nombre, c.medico.fechaingreso "
									
					,Tuple.class);
		return consulta5.getResultList();

	}  
	// 6 numero de citas y coste total de las citas clasificado por  especialidad medica, 
	public List<Tuple> consulta6() {
		TypedQuery<Tuple> consulta6 = this.getEm()
			.createQuery("SELECT COUNT(c.codcita), SUM(c.coste), c.medico.especialidad "
				+ "FROM Cita c "
				+ "GROUP BY c.medico.especialidad "						
				,Tuple.class);
			return consulta6.getResultList();

		}  
	
	// 7 MEDICOS medicina general ingreso posterior a 12-12-2014, 
	public List<Tuple> consulta7(String especialidad) {
		
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try { fecha = sdf.parse("12-12-2014"); } catch (ParseException e) { e.printStackTrace(); }
		
		TypedQuery<Tuple> consulta7 = this.getEm()
			.createQuery("SELECT c.medico "
				+ "FROM Cita c "
				+ "WHERE c.medico.especialidad = :parametro  "
				+ "OR c.fechacita > :fechita "
				
				,Tuple.class);
		
		consulta7.setParameter("parametro", especialidad);
		consulta7.setParameter("fechita", fecha);
			return consulta7.getResultList();

		}  
	

}
