package com.mathvieira.voll.med.entity.doctor;

import com.mathvieira.voll.med.entity.address.AddressData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.Valid;

public record DoctorRegistrationData(
    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telephone,
    
    @NotBlank
    @Pattern(regexp="^\\d{4,6}-[A-Z]{2}$", message="Invalid CRM format")
    String crm,
    
    @NotNull
    Specialism specialism,
    
    @NotNull
    @Valid
    AddressData addressData) {}
