package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ejemplos.modelo.MaterialRepositorio;
import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.CategoriaRepositorio;
import com.ejemplos.modelo.Material;
import com.ejemplos.modelo.Producto;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private MaterialRepositorio materialRepositorio;
	

	public ProductoDTO convertirADto(Producto producto) {
		return modelMapper.map(producto,  ProductoDTO.class);
	}
	
	public Producto convertirAProd(CreateProductoDTO createProductoDTO) {
	    // Crear un nuevo Producto usando ModelMapper
	    Producto producto = modelMapper.map(createProductoDTO, Producto.class);

	    // Cargar la categoría desde la base de datos
	    Categoria categoria = categoriaRepositorio.findById(createProductoDTO.getCategoriaIdcat())
	            .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + createProductoDTO.getCategoriaIdcat()));
	    producto.setCategoria(categoria);

	    // Cargar el material desde la base de datos
	    Material material = materialRepositorio.findById(createProductoDTO.getMaterialIdmat())
	            .orElseThrow(() -> new RuntimeException("Material no encontrado con id: " + createProductoDTO.getMaterialIdmat()));
	    producto.setMaterial(material);

	    return producto;
	}

	
	
}
