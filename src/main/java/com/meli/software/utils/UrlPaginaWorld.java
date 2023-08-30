package com.meli.software.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrlPaginaWorld {

    PAGINA_INICIO_SESION_WORLD("http://localhost:8085/persons");

    private final String url;

}
