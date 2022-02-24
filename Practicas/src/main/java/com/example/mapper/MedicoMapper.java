package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.entity.Medico;
import com.example.entityDTO.MedicoDTO;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

	MedicoDTO medicoToMedicoDTO(Medico medico);
	Medico medicoDTOToMedico(MedicoDTO medicodto);
	
}
