package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.entityDTO.DiagnosticoDTO;

public interface DiagnosticoService {
	public List<DiagnosticoDTO> findAllDiagnosticos();

	public Optional<DiagnosticoDTO> findDiagnosticoById(Integer id);

	public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO nuevoDiagnostico);

	public String deleteDiagnostico(Integer id);
}
