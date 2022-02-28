package com.example.coontroller;

import java.util.Optional;

import java.util.List;
import com.example.entityDTO.CitaDTO;

public interface CitaController {
	
	public List<CitaDTO> getCitas();

	public Optional<CitaDTO> getCitaById(Integer id);

	public CitaDTO addCita(CitaDTO cita);

	public String deleteCita(Integer id);
}
