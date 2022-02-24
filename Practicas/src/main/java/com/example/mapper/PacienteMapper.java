package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.entity.Paciente;
import com.example.entityDTO.PacienteDTO;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

	Paciente pacienteDTOtoPaciente(PacienteDTO pacienteDTO);
	PacienteDTO pacienteToPacienteDTO(Paciente paciente);
	
}
