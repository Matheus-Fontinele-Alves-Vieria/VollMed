package com.mathvieira.voll.med.entity.address;

public record AddressData(String publicSpace, 
                          String neighborhood, 
                          String number, 
                          String complement, 
                          String cep, 
                          String city, 
                          String uf) {}
