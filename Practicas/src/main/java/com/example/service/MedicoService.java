package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.entityDTO.MedicoDTO;

public interface MedicoService {
	public List<MedicoDTO> findAllMedicos();

	public Optional<MedicoDTO> findMedicoById(Integer id);

	public MedicoDTO saveMedico(MedicoDTO nuevoMedico);

	public String deleteMedico(Integer id);
}
