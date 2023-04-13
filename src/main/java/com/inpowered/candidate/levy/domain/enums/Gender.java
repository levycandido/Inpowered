package com.inpowered.candidate.levy.domain.enums;

public enum Gender {
    MALE("male"),
    FEMAL("female"),
    NON_BINARY("non binary");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
