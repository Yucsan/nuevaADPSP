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
	
	//en Postman para probarlo url: http://localhost:8080/producto
	//-----------------------------------------------------------------------------------------------------------------
	
	// 1 Insertamos nuevo producto @param nuevo   2 @return producto insertado
	
	@PostMapping("/producto")
	public  ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		
		/*
		 Producto nuevoProducto = new Producto();
		 nuevoProducto.setNombre(nuevo.getNombre());
		 nuevoProducto.setNombre(nuevo.getPrecio());
		 Categoria categoria = categoriaRepositorio.findById(nuevo.getCategoriaId()
		 nuevoProducto.setCategoria(categoria);
		 return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(nuevoProducto));*/
		
		Producto saved = productoDTOConverter.convertirAProd(nuevo);
		return  ResponseEntity.status(HttpStatus.CREATED).body( productoRepositorio.save(saved)); //201 Created
	}
	
	// http://localhost:8080/producto
	
/*
	 {  "nombre":"Zumo PAPAYA",
    	"precio" : 9,
    	"categoriaId": 1  
     }
	 	*/
	
	// MODIFICA PRODUCTO | @param editar | @param id | @return  
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?>  editaProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			Producto n = productoDTOConverter.convertirAProd(editar);			
			n.setId(id);
			
			if(editar.getCategoriaIdcat()==null)
				n.setCategoria(productoRepositorio.findById(id).get().getCategoria() );
			if(editar.getNombre()==null)
				n.setNombre(productoRepositorio.findById(id).get().getNombre() );
			if(editar.getPrecio()==0.0)
				n.setPrecio(productoRepositorio.findById(id).get().getPrecio() );
			return ResponseEntity.ok(productoRepositorio.save(n)); //ok
		}else {
			return ResponseEntity.notFound().build(); //404 no lo encuentro
		}
	
	}
	
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
