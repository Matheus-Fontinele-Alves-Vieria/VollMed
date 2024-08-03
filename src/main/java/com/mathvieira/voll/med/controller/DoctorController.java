package com.mathvieira.voll.med.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathvieira.voll.med.dto.DataListingDoctor;
import com.mathvieira.voll.med.entity.doctor.Doctor;
import com.mathvieira.voll.med.entity.doctor.DoctorAuthenticationData;
import com.mathvieira.voll.med.entity.doctor.DoctorRegistrationData;
import com.mathvieira.voll.med.repository.DoctorRepository;
import com.mathvieira.voll.med.security.TokenService;
import com.mathvieira.voll.med.entity.doctor.LoginResponseData;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegistrationData data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Doctor doctor = new Doctor(data);

        doctor.setPassword(encryptedPassword);

        doctorRepository.save(doctor);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public Page<DataListingDoctor> list(@PageableDefault(size=10, sort={"name"}) Pageable pageable) {
        return doctorRepository.findAll(pageable).map(DataListingDoctor::new);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DoctorAuthenticationData data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Doctor) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseData(token));
    }   
}
