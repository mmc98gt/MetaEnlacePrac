package com.example.serviceimplementacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.example.mapper.*;

import com.example.entity.Cita;
import com.example.entity.Medico;
import com.example.entity.Paciente;
import com.example.entityDTO.MedicoDTO;
import com.example.repository.MedicoRepository;
import com.example.repository.PacienteRepository;
import com.example.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicoServiceImpl implements MedicoService{

	private final MedicoRepository medicoRepository;
	private final PacienteRepository pacienteRepository;
	private MedicoMapper mapper;

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
    	this.medicoRepository = medicoRepository;
    	this.pacienteRepository = pacienteRepository;
    }

	@Override
	public List<MedicoDTO> findAllMedicos() {
		List<Medico> medicos =medicoRepository.findAll();
		List<MedicoDTO> medicosdDtos = new LinkedList<MedicoDTO>();
		for (Medico medico : medicos) {
			medicosdDtos.add(mapper.medicoToMedicoDTO(medico));
		}
		return medicosdDtos;
	}

	@Override
	public Optional<MedicoDTO> findMedicoById(Integer id) {
		List<MedicoDTO> medicosDTo = findAllMedicos();
		MedicoDTO test = new MedicoDTO();
		for (MedicoDTO medicodto : medicosDTo) {
			if(medicodto.getMedicoUserID()==id) {
				test = medicodto;
					Optional<MedicoDTO> medicodtoo = Optional.of(test);
					return medicodtoo;			
			}
		}
		return null;
	}

	@Override
	public MedicoDTO saveMedico(MedicoDTO nuevoMedico) {
		if (nuevoMedico != null) {
			List<Paciente> listaPacientes = new ArrayList<Paciente>();
			List<Cita> listaCitas = new ArrayList<Cita>();
			Medico medicoSave = new Medico(0, nuevoMedico.getMedicoUsuario(), nuevoMedico.getMedicoNombre(),
					nuevoMedico.getMedicoApellidos(), nuevoMedico.getMedicoClave(), nuevoMedico.getMedicoNumColegiado(),
					listaPacientes, listaCitas);
			medicoSave.setUserID(medicoRepository.save(medicoSave).getUserID());
			System.out.println("ID del usuario guardado:" + medicoSave.getUserID());
			if (nuevoMedico.getMedicoPacientesUserID() != null) {

				for (Integer IDpaciente : nuevoMedico.getMedicoPacientesUserID()) {
					Optional<Paciente> pacienteExists = pacienteRepository.findById(IDpaciente);
					if (pacienteExists.isPresent()) {
						pacienteExists.get().getMedicos().add(medicoSave);
						pacienteRepository.save(pacienteExists.get());
					}

				}
			}
			return nuevoMedico;
		} else {
			return null;
		}
	}

	@Override
	public String deleteMedico(Integer id) {
		if (medicoRepository.findById(id).isPresent()) {
			medicoRepository.deleteById(id);
			return "Medico eliminado correctamente.";
		}
		return "Error! El Medico no existe";
	}
    
	

}
