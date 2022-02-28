package com.example.coontroller;

import java.util.List;
import java.util.Optional;

import com.example.entityDTO.MedicoDTO;

public interface MedicoController {

	public List<MedicoDTO> getMedicos();

	public Optional<MedicoDTO> getMedicoById(Integer id);

	public MedicoDTO addMedico(MedicoDTO medico);

	public String deleteMedico(Integer id);
	
}
