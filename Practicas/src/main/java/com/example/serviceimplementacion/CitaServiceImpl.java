package com.example.serviceimplementacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.example.mapper.*;

import com.example.entity.Cita;
import com.example.entity.Medico;
import com.example.entity.Paciente;
import com.example.entityDTO.CitaDTO;
import com.example.repository.CitaRepository;
import com.example.repository.MedicoRepository;
import com.example.repository.PacienteRepository;
import com.example.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CitaServiceImpl implements CitaService {
	
	private final CitaRepository citaRepository;
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;
	private CitaMapper mapper;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository, PacienteRepository pacienteRepository,
    		MedicoRepository medicoRepository) {
    	this.citaRepository = citaRepository;
    	this.pacienteRepository = pacienteRepository;
    	this.medicoRepository = medicoRepository;
    }

	@Override
	public List<CitaDTO> findAllCitas() {
		List<Cita> citas =citaRepository.findAll();
		List<CitaDTO> citasDTO = new LinkedList<CitaDTO>();
		for (Cita cita : citas) {
			citasDTO.add(mapper.citaToCitaDTO(cita));
		}
		return citasDTO;
	}

	@Override
	public Optional<CitaDTO> findCitaById(Integer id) {
		List<CitaDTO> citasDto = findAllCitas();
		CitaDTO test = new CitaDTO();
		for (CitaDTO citaDTO : citasDto) {
			if(citaDTO.getCitaCitaID()==id) {
				test = citaDTO;
					Optional<CitaDTO> citaDTOO =Optional.of(test);
					return citaDTOO;			
			}
		}
		return null;
	}

	@Override
	public CitaDTO saveCita(CitaDTO nuevaCita) {
		if (nuevaCita != null) {
			Cita cita = new Cita(0, nuevaCita.getCitaFechaHora(),nuevaCita.getCitaMotivoCita(),0, null, null, null);
			if(nuevaCita.getCitaMedicoUserID() != null && nuevaCita.getCitaPacienteUserID() != null) {
				Optional<Paciente> pacienteExists = pacienteRepository.findById(nuevaCita.getCitaPacienteUserID());
				Optional<Medico> medicoExists = medicoRepository.findById(nuevaCita.getCitaMedicoUserID());
				if(pacienteExists.isPresent() && medicoExists.isPresent()) {
					cita.setPaciente(pacienteExists.get());
					cita.setMedico(medicoExists.get());
					cita.setCitaID(citaRepository.save(cita).getCitaID());
					pacienteExists.get().getCitas().add(cita);
					pacienteRepository.save(pacienteExists.get());
					medicoExists.get().getCitas().add(cita);
					medicoRepository.save(medicoExists.get());
					return nuevaCita;
				}
			}
			citaRepository.save(cita);
			return nuevaCita;
		}
		return null;
	}

	@Override
	public String deleteCita(Integer id) {
		if (citaRepository.findById(id).isPresent()) {
			citaRepository.deleteById(id);
			return "Cita eliminada correctamente.";
		}
		return "Error! La Cita no existe";
	}
	
	

}
