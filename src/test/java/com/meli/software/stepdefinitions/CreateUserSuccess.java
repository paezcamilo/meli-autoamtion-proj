package com.meli.software.stepdefinitions;

import com.meli.software.models.UsuarioGenerico;
import com.meli.software.questions.MensajeDeAlerta;
import com.meli.software.tasks.IniciarSesion;
import com.meli.software.tasks.NavegarPaginaWeb;
import com.meli.software.utils.FuncionesVarias;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import static com.meli.software.utils.UrlPaginaWeb.PAGINA_INICIO_SESION_PERSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CreateUserSuccess extends FuncionesVarias {

    @Dado("{actor} navega a la página de crear persona")
    public void usuarioNavegaPaginaDeInicio(Actor actor) {
        actor.wasAbleTo(
                NavegarPaginaWeb.usandoUrl(PAGINA_INICIO_SESION_PERSON.getUrl()));
    }

    @Cuando("Crea el usuario porque es mayor de edad")
    public void ingresaLosDatosDeCreaciónUsuario() {

        FuncionesVarias utilRandom = new FuncionesVarias();
        String userData = utilRandom.generateRandomUsePassAlpNum(5);
        String userAge = utilRandom.generateRandomNumMayor();

        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.paraUsuario(UsuarioGenerico.builder()
                        .firstName(userData)
                        .lastName(userData)
                        .age(userAge).build()));
    }

    @Entonces("debería ver el mensaje de usuario creado satisfactoriamente")
    public void deberiaVerMensajeDeCreacionExitosa() {

        theActorInTheSpotlight().should(
                seeThat(MensajeDeAlerta.valor(), equalToIgnoringCase("Person created successfully"))
        );
    }
}
