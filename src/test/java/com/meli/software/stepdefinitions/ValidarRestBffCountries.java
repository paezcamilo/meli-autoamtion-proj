package com.meli.software.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ValidarRestBffCountries {

    @Dado("{actor} la URL del servicio rest de countries {string}")
    public void theBaseURLIs(Actor actor, String baseUrl) {
        actor.whoCan(CallAnApi.at(baseUrl));

    }

    @Cuando("Envío un GET request al endpoint de countries {string}")
    public void iSendAGETRequestTo(String endpoint) {
        theActorInTheSpotlight().attemptsTo(Get.resource(endpoint));
    }

    @Entonces("El código de respuesta para countries debería ser {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse("The response status code",
                response -> response.statusCode(statusCode)));
    }

    @Entonces("El mensaje de respuesta para countries debe ser {string}")
    public void theResponseShouldContain(String expectedContent) {
        theActorInTheSpotlight().should(seeThatResponse("The response content",
                response -> response.body(Matchers.containsString(expectedContent))));
    }
}