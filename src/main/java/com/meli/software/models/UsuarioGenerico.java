package com.meli.software.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UsuarioGenerico {
    private final String firstName;
    private final String lastName;
    private final String age;
    private final String country;
}
