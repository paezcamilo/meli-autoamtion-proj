package com.meli.software.stepdefinitions;

import com.meli.software.models.UsuarioGenerico;
import com.meli.software.questions.MensajeDeAlerta;
import com.meli.software.tasks.IniciarSesion;
import com.meli.software.tasks.NavegarPaginaWeb;
import com.meli.software.utils.FuncionesVarias;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import static com.meli.software.utils.UrlPaginaWeb.PAGINA_INICIO_SESION_PERSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ValidateUserSameName extends FuncionesVarias {

    @Dado("{actor} navega a la página de crear persona con el mismo nombre")
    public void usuarioNavegaPaginaDeInicio(Actor actor) {
        actor.wasAbleTo(
                NavegarPaginaWeb.usandoUrl(PAGINA_INICIO_SESION_PERSON.getUrl()));
    }

    @Cuando("Intenta crear el usuario con datos de un usuario ya existente")
    public void ingresaLosDatosDeUsuarioCreadoAntes() {

        FuncionesVarias utilRandom = new FuncionesVarias();
        String userAge = utilRandom.generateRandomNumMayor();
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.paraUsuario(UsuarioGenerico.builder()
                        .firstName("Lionel Andres")
                        .lastName("Messi")
                        .age(userAge).build()));
    }

    @Entonces("debería ver el mensaje de usuario error por ser un usuario ya existente")
    public void deberiaVerMensajeDeCreacionNoExitosa() {

        theActorInTheSpotlight().should(
                seeThat(MensajeDeAlerta.valor(), equalToIgnoringCase("An error occurred: person with same first name and last name already exists"))
        );
    }
}
