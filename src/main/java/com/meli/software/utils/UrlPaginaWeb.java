package com.meli.software.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrlPaginaWeb {

    PAGINA_INICIO_SESION_PERSON("http://localhost:8085/persons");

    private final String url;

}
