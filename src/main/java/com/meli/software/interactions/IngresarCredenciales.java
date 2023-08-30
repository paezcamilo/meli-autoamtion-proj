package com.meli.software.interactions;

import com.meli.software.models.UsuarioGenerico;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.meli.software.userinterfaces.PaginaInicioSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCredenciales implements Interaction {

    private final String user;
    private final String password;
    private final String age;
    private final String country;

    public IngresarCredenciales(String user, String password, String age, String country) {
        this.user = user;
        this.password = password;
        this.age = age;
        this.country = country;
    }

    @Override
    @Step("#actor ingresa las credenciales")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Enter.theValue(age).into(AGE_FIELD),
                Click.on(COUNTRY_SELECT_FIELD),
                Click.on(COUNTRY_ITEMSELECTED_FIELD),
                Click.on(BUTTON_SIGN_IN)
        );
    }

    public static Performable conModelo(UsuarioGenerico usuarioGenerico) {
        return instrumented(IngresarCredenciales.class, usuarioGenerico.getFirstName(), usuarioGenerico.getLastName(), usuarioGenerico.getAge(), usuarioGenerico.getCountry());
    }
}
