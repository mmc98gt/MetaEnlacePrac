package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.entity.Usuario;
import com.example.entityDTO.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	Usuario usuarioDTOtoUsuario(UsuarioDTO usuarioDTO);
	UsuarioDTO usuarioToUsuarioDTO(Usuario usuario); 
	
}
