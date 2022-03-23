package com.example.serviceimplementacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import com.example.mapper.*;

import com.example.entity.Usuario;
import com.example.entityDTO.UsuarioDTO;
import com.example.repository.UsuarioRepository;
import com.example.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private UsuarioMapper mapper;
	
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    	this.usuarioRepository = usuarioRepository;
    }

	@Override
	public List<UsuarioDTO> findAllUsuarios() {
		List<Usuario> usuarios =usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new LinkedList<UsuarioDTO>();
		for (Usuario usuario : usuarios) {
			usuariosDTO.add(mapper.usuarioToUsuarioDTO(usuario));
		}
		return usuariosDTO;
	}

	@Override
	public Optional<UsuarioDTO> findUsuarioById(Integer id) {
		List<UsuarioDTO> usuariosDto = findAllUsuarios();
		UsuarioDTO test = new UsuarioDTO();
		for (UsuarioDTO userdto : usuariosDto) {
			if(userdto.getUsuarioUserID()==id) {
				test = userdto;
					Optional<UsuarioDTO> userr = Optional.of(test);
					return userr;			
			}
		}
		return null;
	}

	@Override
	public Usuario saveUsuario(UsuarioDTO nuevoUsuario) {
		if (nuevoUsuario != null) {
			Usuario usuario = new Usuario (0, nuevoUsuario.getUsuarioUsuario(),
					nuevoUsuario.getUsuarioNombre(), nuevoUsuario.getUsuarioApellidos(),
					nuevoUsuario.getUsuarioClave());
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	@Override
	public String deleteUsuario(Integer id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El Usuario no existe";
	}


}
