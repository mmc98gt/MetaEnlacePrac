package com.example.serviceimplementacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.example.mapper.*;

import com.example.entity.Cita;
import com.example.entity.Diagnostico;
import com.example.entityDTO.DiagnosticoDTO;
import com.example.repository.CitaRepository;
import com.example.repository.DiagnosticoRepository;

import com.example.service.DiagnosticoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {
	
	private final DiagnosticoRepository diagnosticoRepository;
	private final CitaRepository citaRepository;
	private DiagnosticoMapper mapper;


    @Autowired
    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, CitaRepository citaRepository) {
    	this.diagnosticoRepository = diagnosticoRepository;
    	this.citaRepository = citaRepository;
    }


	@Override
	public List<DiagnosticoDTO> findAllDiagnosticos() {
		List<Diagnostico> diagnosticos =diagnosticoRepository.findAll();
		List<DiagnosticoDTO> diagnosticosDTO = new LinkedList<DiagnosticoDTO>();
		for (Diagnostico diagnostico : diagnosticos) {
			diagnosticosDTO.add(mapper.diagnosticoToDiagnosticoDTO(diagnostico));
		}
		return diagnosticosDTO;
	}


	@Override
	public Optional<DiagnosticoDTO> findDiagnosticoById(Integer id) {
		List<DiagnosticoDTO> diagnosticoDTOs = findAllDiagnosticos();
		DiagnosticoDTO test = new DiagnosticoDTO();
		for (DiagnosticoDTO diagnosticoDTO : diagnosticoDTOs) {
			if(diagnosticoDTO.getDiagnosticoDiagnosticoID()==id) {
				test = diagnosticoDTO;
					Optional<DiagnosticoDTO> diagnosticoDTOo = Optional.of(test);
					return diagnosticoDTOo;			
			}
		}
		return null;
	}


	@Override
	public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO nuevoDiagnostico) {
		if (nuevoDiagnostico != null) {
			Diagnostico diagnostico = new Diagnostico(0, nuevoDiagnostico.getDiagnosticoValoracionEspecialista(),
					nuevoDiagnostico.getDiagnosticoEnfermedad(), null);
			if(nuevoDiagnostico.getDiagnosticoCitaCitaID() != null) {
				Optional<Cita> citaExists = citaRepository.findById(nuevoDiagnostico.getDiagnosticoCitaCitaID());
				if(citaExists.isPresent()) {
					diagnostico.setCita(citaExists.get());
					
					diagnostico.setDiagnosticoID(diagnosticoRepository.save(diagnostico).getDiagnosticoID());
					
					citaExists.get().setDiagnostico(diagnostico);
					citaRepository.save(citaExists.get());

					return nuevoDiagnostico;
				}
			}
			diagnosticoRepository.save(diagnostico);
			return nuevoDiagnostico;
		}
		return null;
	}


	@Override
	public String deleteDiagnostico(Integer id) {
		if (diagnosticoRepository.findById(id).isPresent()) {
			diagnosticoRepository.deleteById(id);
			return "Diagnostico eliminado correctamente.";
		}
		return "Error! El Diagnostico no existe";
	}

	

}
