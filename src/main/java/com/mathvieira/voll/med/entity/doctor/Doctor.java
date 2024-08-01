package com.mathvieira.voll.med.entity.doctor;

import com.mathvieira.voll.med.entity.address.Address;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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
@EqualsAndHashCode(of="idDoctor")
public class Doctor implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idDoctor;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialism specialism;
    
    @Embedded
    private Address address;

    private String password;
    
    public Doctor(DoctorRegistrationData data) {
        this.idDoctor = UUID.randomUUID();
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialism = data.specialism();
        this.address = new Address(data.addressData());
        this.password = data.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return switch(this.specialism) {
            case CARDIOLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_CARDIOLOGIA")
            );
            case ONCOLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_ONCOLOGIA")
            );
            case NEUROLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_NEUROLOGIA")
            );
            case ENDOCRINOLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_ENDOCRINOLOGIA")
            );
            case GASTROENTEROLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_GASTROENTEROLOGIA")
            );
            case UROLOGIA -> List.of(
                new SimpleGrantedAuthority("ROLE_UROLOGIA")
            );
        };       
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
