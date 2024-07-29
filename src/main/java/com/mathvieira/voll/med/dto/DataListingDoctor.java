package com.mathvieira.voll.med.dto;

import com.mathvieira.voll.med.entity.doctor.Specialism;
import com.mathvieira.voll.med.entity.doctor.Doctor;

public record DataListingDoctor(String name, String email, String crm, Specialism specialism) {
    public DataListingDoctor(Doctor doctor) {
        this(doctor.getName(),
             doctor.getEmail(),
             doctor.getCrm(),
             doctor.getSpecialism());
    }
}
