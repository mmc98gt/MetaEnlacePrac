package com.example.coontroller;

import java.util.List;
import java.util.Optional;

import com.example.entityDTO.PacienteDTO;

public interface PacienteController {

	public List<PacienteDTO> getPacientes();

	public Optional<PacienteDTO> getPacienteById(Integer id);

	public PacienteDTO addPaciente(PacienteDTO paciente);

	public String deletePaciente(Integer id);
}
