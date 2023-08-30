package com.meli.software.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ValidarRestPing {

    @Given("{actor} la URL del servicio rest {string}")
    public void theBaseURLIs(Actor actor, String baseUrl) {
        actor.whoCan(CallAnApi.at(baseUrl));

    }

    @When("Envío un GET request al endpoint {string}")
    public void iSendAGETRequestTo(String endpoint) {
        theActorInTheSpotlight().attemptsTo(Get.resource(endpoint));
    }

    @Then("El código de respuesta debería ser {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse("The response status code",
                response -> response.statusCode(statusCode)));
    }

    @Then("El mensaje de respuesta debe ser {string}")
    public void theResponseShouldContain(String expectedContent) {
        theActorInTheSpotlight().should(seeThatResponse("The response content",
                response -> response.body(Matchers.containsString(expectedContent))));
    }
}