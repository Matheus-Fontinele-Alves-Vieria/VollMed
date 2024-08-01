package com.mathvieira.voll.med.entity.doctor;

import lombok.Getter;

@Getter
public enum Specialism {
    CARDIOLOGIA("cardiologia"),
    ONCOLOGIA("oncologia"),
    NEUROLOGIA("neurologia"),
    ENDOCRINOLOGIA("endocrinologia"),
    GASTROENTEROLOGIA("gastroenterologia"),
    UROLOGIA("urologia");

    private final String specialism;

    Specialism(String specialism) {
        this.specialism = specialism;
    }
}
