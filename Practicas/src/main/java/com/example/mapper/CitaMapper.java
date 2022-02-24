package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.entity.Cita;
import com.example.entityDTO.CitaDTO;

@Mapper(componentModel = "spring")
public interface CitaMapper {
	
	Cita citaDTOToCita(CitaDTO citaDTO);
	CitaDTO citaToCitaDTO(Cita cita);
	
}
