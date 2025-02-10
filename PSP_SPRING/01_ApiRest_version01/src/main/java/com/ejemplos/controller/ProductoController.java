package com.ejemplos.controller;

import java.util.List;

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
	
	// se declara como final pq no se va a modificar este repositorio
	private final ProductoRepositorio productoRepositorio;
	
	//se inyecta solo al crear el bean conrtollador
	// Dentro de la carpeta resources esta data.sql
	
	// todos los productos
	
	@GetMapping("/producto") // cada metodo debe tener sus URL únicas sino ERROR
	public List<Producto> obtenerTodos(){
		return productoRepositorio.findAll();
	}
	
	// esto para el navegador
	//http://localhost:8080/h2/
	
	//esto para el Postman
	//http://localhost:8080/producto
	
	
	//Obtenemos un producto en base a su ID
	//@ para id
	//
	
	//@PathVarible : permite inyectar un fragmento de la URL en una variable es decir
	// pasa el valor del id de la URL al metodo como parametro como parametro donde este @PathVarible
	
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		return productoRepositorio.findById(id).orElse(null); // devuelve un optional por el find
		// no manejamos los errores todavia y devolvemos un null	
	}
	
	//en Postman para probarlo url: http://localhost:8080/producto
	
	
	
	//-----------------------------------------------------------------------------------------------------------------
	
	// Insertamos nuevo producto
	//@param nuevo
	//@return producto insertado
	
	//@RequestBody permite inyectar el cuerpo de la petición de un objeto, guardo en ..
	@PostMapping("/producto")
	public Producto nuevoProducto(@RequestBody Producto nuevo) {
		return  productoRepositorio.save(nuevo);
	}
	
	/*
	 *ACTUALIZA PRODUCTO
	 *@param editar
	 *@param id
	 *@return
	 * */
	
	@PutMapping("/producto/{id}")
	public Producto editaProducto(@RequestBody Producto editar, @PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			editar.setId(id);
			return productoRepositorio.save(editar);
		}else {
			return null;
		}
	
	}
	
	//para probarlo en Postman http://localhost:8080/producto/1452
	
	
	//METODO BORRAR
	
	@DeleteMapping("/producto/{id}")
	public void borrarProducto(@PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			productoRepositorio.deleteById(id);
		}
	}
	
	
	@DeleteMapping("/producto/{id}") // da error porque tiene la misma URL
	public Producto borrarProducto2(@PathVariable Long id ) {
		if(productoRepositorio.existsById(id)) {
			Producto result = productoRepositorio.findById(id).get();
			productoRepositorio.deleteById(id);
			return result;
		}else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
