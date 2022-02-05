package com.shkulaku.RealEstate.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;


public enum ERole {
    ROLE_USER("ROLE_USER"),
    ROLE_MODERATOR("ROLE_MODERATOR"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String value;

    ERole(String value){
        this.value = value;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
