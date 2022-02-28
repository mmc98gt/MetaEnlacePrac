package com.example.coontroller;

import java.util.List;
import java.util.Optional;

import com.example.entity.Usuario;
import com.example.entityDTO.UsuarioDTO;


public interface UsuarioController {

	public List<UsuarioDTO> getUsuarios();

	public Optional<UsuarioDTO> getUsuarioById(Integer id);

	public Usuario addUsuario(UsuarioDTO usuario);

	public String deleteUsuario(Integer id);
	
}
