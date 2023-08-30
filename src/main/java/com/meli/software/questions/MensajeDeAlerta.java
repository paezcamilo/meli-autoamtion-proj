package com.meli.software.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.AlertText;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("El texto de creación satisfactorio del usuario")
public class MensajeDeAlerta implements  Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return AlertText.currentlyVisible().answeredBy(actor);
    }

    public static Question<String> valor() {
        return new MensajeDeAlerta();
    }
}
