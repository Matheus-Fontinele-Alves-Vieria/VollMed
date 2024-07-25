package com.mathvieira.voll.med.entity.address;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String publicSpace;
    private String neighborhood;
    private String number;
    private String complement;
    private String cep;
    private String city;
    private String uf;

    public Address(AddressData data) {
        this.publicSpace = data.publicSpace();
        this.neighborhood = data.neighborhood();
        this.number = data.number();
        this.complement = data.complement();
        this.cep = data.cep();
        this.city = data.city();
        this.uf = data.uf();
    }
}
