package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.entityDTO.CitaDTO;

public interface CitaService {
	
	public List<CitaDTO> findAllCitas();

	public Optional<CitaDTO> findCitaById(Integer id);

	public CitaDTO saveCita(CitaDTO nuevaCita);

	public String deleteCita(Integer id);
}
