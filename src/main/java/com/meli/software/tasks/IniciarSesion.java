package com.meli.software.tasks;

import com.meli.software.interactions.IngresarDatosUsuario;
import com.meli.software.models.UsuarioGenerico;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class IniciarSesion implements Task {

    private final UsuarioGenerico usuarioGenerico;



        @Override
        public <T extends Actor > void performAs (T actor){
        actor.attemptsTo(
                IngresarDatosUsuario.conModelo(usuarioGenerico));

    }
        public static Performable paraUsuario (UsuarioGenerico usuarioGenerico){
        return instrumented(IniciarSesion.class, usuarioGenerico);
    }
}
