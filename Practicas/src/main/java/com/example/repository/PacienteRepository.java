package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
