package com.ejemplos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // lombok crea el contructor
public class ProductoController {
	
	private final ProductoRepositorio productoRepositorio;
	
	@GetMapping("/producto") 
	public ResponseEntity<?> obtenerTodos(){
		List<Producto>result = productoRepositorio.findAll();
		
		if(result.isEmpty()) {
			//devolvemos unarespuesta coom instancia de RepsonseEntity
			return ResponseEntity.notFound().build();
		}else {
			/*queremos devolver la lista
			  pero como el if devolvemos una respuesta
			  404 usando la clase ResponseEntity
			  debemos seguir usando la clase en la respuesta*/
			return ResponseEntity.ok(result);
		}
	}
	
	//http://localhost:8080/h2/
	//http://localhost:8080/producto     -----------------------------------------------------------------------------
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		Producto result = productoRepositorio.findById(id).orElse(null); 
		
		//not found es el 404
		if(result==null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(result); // 200	
	}
	
	//en Postman para probarlo url: http://localhost:8080/producto
	//-----------------------------------------------------------------------------------------------------------------
	
	// 1 Insertamos nuevo producto @param nuevo   2 @return producto insertado
	
	@PostMapping("/producto")
	public  ResponseEntity<?> nuevoProducto(@RequestBody Producto nuevo) {
		Producto saved = productoRepositorio.save(nuevo);
		return  ResponseEntity.status(HttpStatus.CREATED).body(saved); //201 Created
	}
	
	// ACTUALIZA PRODUCTO | @param editar | @param id | @return  
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?>  editaProducto(@RequestBody Producto editar, @PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			editar.setId(id);
			return ResponseEntity.ok(productoRepositorio.save(editar)); //ok
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
