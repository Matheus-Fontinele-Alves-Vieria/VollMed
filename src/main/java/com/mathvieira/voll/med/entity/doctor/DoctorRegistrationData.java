package com.mathvieira.voll.med.entity.doctor;

import com.mathvieira.voll.med.entity.address.AddressData;

public record DoctorRegistrationData(String name, 
                                     String email,
                                     String telephone, 
                                     String crm, 
                                     Specialism specialism, 
                                     AddressData addressData) {}
