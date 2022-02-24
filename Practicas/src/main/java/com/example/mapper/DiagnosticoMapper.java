package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.entity.Diagnostico;
import com.example.entityDTO.DiagnosticoDTO;

@Mapper(componentModel = "spring")
public interface DiagnosticoMapper {
	
	DiagnosticoDTO diagnosticoToDiagnosticoDTO(Diagnostico diagnostico);
	Diagnostico DiagnosticoDTOtoDiagnostico(DiagnosticoDTO diagnosticoDTO);
	
}
