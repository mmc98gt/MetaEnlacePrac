package com.example.coontroller;

import java.util.List;
import java.util.Optional;

import com.example.entityDTO.DiagnosticoDTO;

public interface DiagnosticoController {

	public List<DiagnosticoDTO> getDiagnosticos();

	public Optional<DiagnosticoDTO> getDiagnosticoById(Integer id);

	public DiagnosticoDTO addDiagnostico(DiagnosticoDTO diagnostico);

	public String deleteDiagnostico(Integer id);
}
