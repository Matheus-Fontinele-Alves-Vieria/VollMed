package com.mathvieira.voll.med.entity.doctor;

import com.mathvieira.voll.med.entity.address.Address;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@Table(name="doctors")
@Entity(name="Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID idDoctor;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialism specialism;
    
    @Embedded
    private Address address;
    
    public Doctor(DoctorRegistrationData data) {
        this.idDoctor = UUID.randomUUID();
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialism = data.specialism();
        this.address = new Address(data.addressData());
    }
}
