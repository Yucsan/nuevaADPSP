package com.ejemplos.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplos.modelo.Sendero;
import com.ejemplos.service.SenderoService;

@Controller
public class SenderoController {
	

	@Autowired
	private SenderoService senderoService;
	//******************************************
	
	@GetMapping("/index")
	public String inicio(Model model) {
		model.addAttribute("titulo","Prueba del index");
		return "index";
	}
	
	//mostrar
	@GetMapping("/listado")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de senderos");	
		
		try {
			model.addAttribute("senderos", senderoService.obtenerSenderos() );	
		}catch(Exception e1) {
			model.addAttribute("senderos", new ArrayList<Sendero>());
		}
		
		return "listar";
	}
	
		// MUESTRA NIVEL MEDIO
		@GetMapping("/dificultadMedia")
		public String dificultadMedia(Model model) {
			model.addAttribute("titulo","Listado de senderos Medios");	
			try {
				model.addAttribute("senderos", senderoService.obtenerSenderosNivelMedio()  );	
			}catch(Exception e1) {
				model.addAttribute("senderos", new ArrayList<Sendero>());
			}
			return "listar";
		}
		
		// GUARDA EN LA BASE DE DATOS
		@GetMapping("/guardarMedios")
		public String guardarSenderosMedios(Model model) {
		    try {
		        senderoService.guardarSenderosNivelMedio();
		        model.addAttribute("mensaje", "Senderos guardados en MySQL exitosamente.");
		        model.addAttribute("senderos", senderoService.obtenerSenderosNivelMedio()  );
		    } catch (Exception e) {
		        model.addAttribute("mensaje", "Error al guardar senderos: " + e.getMessage());
		    }
		    return "listar"; // Redirige a la vista
		}
		
		
		// GUARDA EN LA BASE DE DATOS
		@GetMapping("/borrarSenderos")
		public String borrarSenderosMedios(Model model) {
			try {
				senderoService.borrarTodosLosSenderosMedios();
				model.addAttribute("mensaje", "Senderos BORRADOS exitosamente.");
			} catch (Exception e) {
				model.addAttribute("mensaje", "Error al BORRAR senderos: " + e.getMessage());
			}
			return "listar"; // Redirige a la vista
		}
		
		
	
	
	
	
	
	
	
	
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")String id) {
		
		senderoService.borrarSendero(id);
		return "redirect:/listado";
	}
	
	// Para insertar Datos
	//fase 1 mostrar formulario
	@GetMapping(value = "/form")
	public String crear(Model model) {
		Sendero sendero = new Sendero(); // objeto mismo nombre que la clase
		
		//paso datos a la vista
		model.addAttribute("sendero", sendero);
		model.addAttribute("titulo", "Formulario de sendero");
		return "formsincss";
	}
	
	/*  2da fase el usuario envia los datos cuando se hace sumit del formulario  
	 se necesita metodo que trate estos datos la url es igual al Post guardar porcesa el formulario y recibe datos*/
	@PostMapping("/form")
	public String guardar(Sendero sendero) {
		senderoService.crearSendero(sendero);
		return "redirect:/listado";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable String id, Model model) {
		
		Sendero sendero = null;
		if(!id.equals("")) {
			sendero = senderoService.obtenerSendero(id);
		}else {
			return "redirect:/listado ";
		}
		model.addAttribute("sendero", sendero);
		model.addAttribute("titulo", "Editar sendero");
		return "formsincss";
		
	}
	
	
	
	
	
	
	
}
