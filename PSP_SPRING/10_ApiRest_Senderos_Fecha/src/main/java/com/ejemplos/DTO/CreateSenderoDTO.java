package com.ejemplos.DTO;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateSenderoDTO {
	
	
	private String id;
	private String nombre;
	private Integer distancia;
	private String dificultad;
	private LocalDate fecha;
	private String municipioIdmuni;

}
