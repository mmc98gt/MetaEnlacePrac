package com.example.serviceimplementacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import com.example.mapper.*;

import com.example.entity.Cita;
import com.example.entity.Medico;
import com.example.entity.Paciente;
import com.example.entityDTO.PacienteDTO;
import com.example.repository.MedicoRepository;
import com.example.repository.PacienteRepository;
import com.example.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;
	private PacienteMapper mapper;

	
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
    	this.pacienteRepository = pacienteRepository;
    	this.medicoRepository = medicoRepository;
    }


	@Override
	public List<PacienteDTO> findAllPacientes() {
		List<Paciente> pacientes =pacienteRepository.findAll();
		List<PacienteDTO> pacientesDtos = new LinkedList<PacienteDTO>();
		for (Paciente paciente : pacientes) {
			pacientesDtos.add(mapper.pacienteToPacienteDTO(paciente));
		}
		return pacientesDtos;
	}


	@Override
	public Optional<PacienteDTO> findPacienteById(Integer id) {
		List<PacienteDTO> pacientesDTO = findAllPacientes();
		PacienteDTO test = new PacienteDTO();
		for (PacienteDTO pacientedto : pacientesDTO) {
			if(pacientedto.getPacienteUserID()==id) {
				test = pacientedto;
					Optional<PacienteDTO> pac = Optional.of(test);
					return pac;			
			}
		}
		return null;
	}


	@Override
	public PacienteDTO savePaciente(PacienteDTO nuevoPaciente) {
		if (nuevoPaciente != null) {
			List<Medico> listaMedicos = new ArrayList<Medico>();
			if(nuevoPaciente.getPacienteMedicosUserID() != null) {
			
			for(Integer IDmedico: nuevoPaciente.getPacienteMedicosUserID()) {
				Optional<Medico> medicoExists = medicoRepository.findById(IDmedico);
				if (medicoExists.isPresent()) {
					listaMedicos.add(medicoExists.get());
				}
				
				}
			}
			
			List<Cita> listaCitas = new ArrayList<Cita>();
			
			Paciente pacienteSave = new Paciente(0, nuevoPaciente.getPacienteUsuario(),
					nuevoPaciente.getPacienteNombre(), nuevoPaciente.getPacienteApellidos(),
					nuevoPaciente.getPacienteClave(), nuevoPaciente.getPacienteNSS(), nuevoPaciente.getPacienteNumTarjeta(),
					nuevoPaciente.getPacienteTelefono(), nuevoPaciente.getPacienteDireccion(), listaMedicos, listaCitas);
			pacienteRepository.save(pacienteSave);
			
			return nuevoPaciente;
		}else {
			return null;
		}
	}

	
	@Override
	public String deletePaciente(Integer id) {
			if (pacienteRepository.findById(id).isPresent()) {
				pacienteRepository.deleteById(id);
				return "Paciente eliminado correctamente.";
			}
			return "Error! El Paciente no existe";
	}
}
	
	

