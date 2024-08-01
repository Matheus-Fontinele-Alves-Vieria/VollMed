package com.mathvieira.voll.med.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.mathvieira.voll.med.entity.doctor.Doctor;

public interface  DoctorRepository extends JpaRepository<Doctor, UUID> {
    UserDetails findByEmail(String email);
}
