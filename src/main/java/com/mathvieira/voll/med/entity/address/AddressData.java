package com.mathvieira.voll.med.entity.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
    @NotBlank
    String publicSpace,
    
    @NotBlank
    String neighborhood,

    String number, 
    String complement,
    
    @NotBlank
    @Pattern(regexp="^\\d{5}-\\d{3}$", message="Invalid CEP format")
    String cep,
    
    @NotBlank
    String city,
    
    @NotBlank
    String uf) {}
