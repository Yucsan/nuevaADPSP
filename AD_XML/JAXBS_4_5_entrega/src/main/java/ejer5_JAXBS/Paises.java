package ejer5_JAXBS;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Paises")
public class Paises {
	private List<PaisHijo>listaPaises;

	public Paises() {
		listaPaises = new ArrayList<PaisHijo>(); 
	}
	

    public void agregarPais(PaisHijo pais) {
        if (listaPaises.add(pais)) { // HashSet devuelve true si se agregó correctamente
            System.out.println(pais.getNombre() + " agregado");
        } else {
            System.out.println(pais.getNombre() + " ya está en Lista ");
        }
    }

    public void muestra() {
    	for(PaisHijo p: listaPaises) {
    	System.out.println(p.toString());
    	
    	}
    }
    
    @XmlElement(name = "Pais")
    public void setListaPaises(List<PaisHijo> listaPaises) {
		this.listaPaises = listaPaises;
	}


	public List<PaisHijo> getListaPaises() {
        return listaPaises;
    }


	@Override
	public String toString() {
		return "Paises [listaPaises=" + listaPaises + "]";
	}
	
	
    
    
	
}
