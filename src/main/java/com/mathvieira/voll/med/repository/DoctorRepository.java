package com.mathvieira.voll.med.repository;

import com.mathvieira.voll.med.entity.doctor.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface  DoctorRepository extends JpaRepository<Doctor, UUID> {
    UserDetails findByLogin(String login);
}
