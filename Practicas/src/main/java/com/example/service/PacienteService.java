package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.entityDTO.PacienteDTO;

public interface PacienteService {
	public List<PacienteDTO> findAllPacientes();

	public Optional<PacienteDTO> findPacienteById(Integer id);

	public PacienteDTO savePaciente(PacienteDTO nuevoPaciente);

	public String deletePaciente(Integer id);
}
