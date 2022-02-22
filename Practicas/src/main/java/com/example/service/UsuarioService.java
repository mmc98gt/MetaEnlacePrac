package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.entity.Usuario;
import com.example.entityDTO.UsuarioDTO;

public interface UsuarioService {
	public List<UsuarioDTO> findAllUsuarios();

	public Optional<UsuarioDTO> findUsuarioById(Integer id);

	public Usuario saveUsuario(UsuarioDTO nuevoUsuario);

	public String deleteUsuario(Integer id);

}
