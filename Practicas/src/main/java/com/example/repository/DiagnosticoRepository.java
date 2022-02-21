package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Diagnostico;


public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

}
