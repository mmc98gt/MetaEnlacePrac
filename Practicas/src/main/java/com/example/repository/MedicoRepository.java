package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
