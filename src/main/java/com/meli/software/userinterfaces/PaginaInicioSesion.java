package com.meli.software.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicioSesion {

    public static final Target USERNAME_FIELD = Target.the("Campo para ingresar el usuario").locatedBy("//input[@name = 'first_name']");
    public static final Target PASSWORD_FIELD = Target.the("Campo para ingresar el password de acceso").locatedBy("//input[@name = 'last_name']");
    public static final Target AGE_FIELD = Target.the("Botón para acceder al sistema").locatedBy("//input[@name = 'age']");
    public static final Target COUNTRY_SELECT_FIELD = Target.the("Country of the user").locatedBy("//select[@id='country']");
    public static final Target COUNTRY_ITEMSELECTED_FIELD = Target.the("Country of the user").locatedBy("//option[text()='Uruguay']");
    public static final Target BUTTON_SIGN_IN = Target.the("Botón para acceder al sistema").locatedBy("//button[contains(text(), 'Create Person')]");

    private PaginaInicioSesion() {
    }

}
