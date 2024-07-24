package com.mathvieira.voll.med.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathvieira.voll.med.doctor.DoctorRegistrationData;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @PostMapping("/register")
    public void register(@RequestBody DoctorRegistrationData data) {
        System.out.println(data);
    }

    @GetMapping("/alldoctors")
    public List<DoctorRegistrationData> getAllDoctors(@RequestParam String param) {
        return List.of();
    }  
}
