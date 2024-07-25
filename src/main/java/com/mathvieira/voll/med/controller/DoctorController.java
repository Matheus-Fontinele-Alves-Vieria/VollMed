package com.mathvieira.voll.med.controller;

import com.mathvieira.voll.med.entity.doctor.DoctorRegistrationData;
import com.mathvieira.voll.med.repository.DoctorRepository;
import com.mathvieira.voll.med.entity.doctor.Doctor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/register")
    @Transactional
    public void register(@RequestBody @Valid DoctorRegistrationData data) {
        doctorRepository.save(new Doctor(data));
    }
}
