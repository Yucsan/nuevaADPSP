package com.ejemplos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.CreateProductoDTO;
import com.ejemplos.DTO.ProductoDTO;
import com.ejemplos.DTO.ProductoDTOConverter;
import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.CategoriaRepositorio;
import com.ejemplos.modelo.Material;
import com.ejemplos.modelo.MaterialRepositorio;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // lombok crea el contructor
public class ProductoController {
	
	@Autowired 
	private final ProductoRepositorio productoRepositorio;  // con autowired ya no 
	
	@Autowired
	private ProductoDTOConverter productoDTOConverter;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private MaterialRepositorio materialRepositorio;
	
	@GetMapping("/producto")  
	public ResponseEntity<?> obtenerTodos(){
		List<Producto>result = productoRepositorio.findAll();
		
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			/*
			 sobre la lista de productos creo una serie de objetos(con stream)
			 sobre los objetos Producto llamo a un método map para ejecutar
			 sobre cada producto el método convertirADto
			 el mapa de productoDTO lo convierto con collect nuevamente a lista
		**/
			List<ProductoDTO> dtoList = result.stream()
			.map(productoDTOConverter::convertirADto)
			.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	//http://localhost:8080/producto -----------------------------------------------------------------------------
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Producto result = productoRepositorio.findById(id).orElse(null); 
		
		//not found es el 404
		if(result==null)
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(productoDTOConverter.convertirADto(result));
		}
				
	}
	
	// 1 Insertamos nuevo producto @param nuevo   2 @return producto insertado
	
	@PostMapping("/producto")
	public  ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		
		
		// Imprimir los valores del DTO para verificar
	    System.out.println("Categoria ID: " + nuevo.getCategoriaIdcat());
	    System.out.println("Material ID: " + nuevo.getMaterialIdmat());
	    System.out.println("Nombre del producto: " + nuevo.getNombre());
	    System.out.println("Precio del producto: " + nuevo.getPrecio());
		
		Producto saved = productoDTOConverter.convertirAProd(nuevo);
		return  ResponseEntity.status(HttpStatus.CREATED).body( productoRepositorio.save(saved)); //201 Created
	}
	
	/*{  
    	"nombre":"NUEVO",
    	"precio" : 9,
    	"categoriaIdcat": 2, 
    	"materialIdmat": 3 
     }  */
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?>  editaProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			
			Producto n = productoDTOConverter.convertirAProd(editar);			
			n.setId(id);
			
			if(editar.getCategoriaIdcat()==null)
				n.setCategoria(productoRepositorio.findById(id).get().getCategoria() );
			
			if(editar.getMaterialIdmat()==null)
				n.setMaterial(productoRepositorio.findById(id).get().getMaterial() );
			
			if(editar.getNombre()==null)
				n.setNombre(productoRepositorio.findById(id).get().getNombre() );
			if(editar.getPrecio()==0.0)
				n.setPrecio(productoRepositorio.findById(id).get().getPrecio() );
			
			return ResponseEntity.ok(productoRepositorio.save(n)); //ok
		}else {
			return ResponseEntity.notFound().build(); //404 no lo encuentro
		}
	
	}
	
	
	// MODIFICA PRODUCTO | @param editar | @param id | @return  
	/*
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editaProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id) {
	    if (productoRepositorio.existsById(id)) {
	        Producto n = productoDTOConverter.convertirAProd(editar);
	        n.setId(id);

	        // Verificar si el id de la categoría es nulo y solo asignarlo si es necesario
	        if (editar.getCategoriaIdcat() != null) {
	            Categoria categoria = categoriaRepositorio.findById(editar.getCategoriaIdcat())
	                    .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
	            n.setCategoria(categoria);
	        } else {
	            // Si la categoría es nula, dejamos la existente
	            n.setCategoria(productoRepositorio.findById(id).get().getCategoria());
	        }

	        // Verificar si el id del material es nulo y solo asignarlo si es necesario
	        if (editar.getMaterialIdmat() != null) {
	            Material material = materialRepositorio.findById(editar.getMaterialIdmat())
	                    .orElseThrow(() -> new RuntimeException("Material no encontrado"));
	            n.setMaterial(material);
	        } else {
	            // Si el material es nulo, dejamos el existente
	            n.setMaterial(productoRepositorio.findById(id).get().getMaterial());
	        }

	        // Verificar si el nombre o precio son nulos y solo asignarlos si es necesario
	        if (editar.getNombre() != null) {
	            n.setNombre(editar.getNombre());
	        } else {
	            n.setNombre(productoRepositorio.findById(id).get().getNombre());
	        }

	        if (editar.getPrecio() != 0.0) {
	            n.setPrecio(editar.getPrecio());
	        } else {
	            n.setPrecio(productoRepositorio.findById(id).get().getPrecio());
	        }

	        return ResponseEntity.ok(productoRepositorio.save(n)); //ok
	    } else {
	        return ResponseEntity.notFound().build(); //404 no lo encuentro
	    }
	}
	
	*/
	
	
	/*
	
	 {
	        "nombre": "alegria",
	        "categoriaIdcat": 3,
	        "materialIdmat": 2
	    }
*/
	
	//para probarlo en Postman http://localhost:8080/producto/1452 --------------------------------------------------------------
	//Borrar
		
	@DeleteMapping("/producto/{id}") // da error porque tiene la misma URL
	public ResponseEntity<?> borrarProducto2(@PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			productoRepositorio.deleteById(id);
			return ResponseEntity.noContent().build(); //204
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
