package com.mathvieira.voll.med.repository;

import com.mathvieira.voll.med.entity.doctor.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface  DoctorRepository extends JpaRepository<Doctor, UUID> {
    
}
