package com.mathvieira.voll.med.doctor;

import com.mathvieira.voll.med.address.AddressData;

public record DoctorRegistrationData(String name, 
                                     String email, 
                                     String crm, 
                                     Specialism specialism, 
                                     AddressData addressData) {}
