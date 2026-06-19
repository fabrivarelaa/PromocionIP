package app;

/**
 * Clase principal de la aplicacion "Adivina el numero".
 *
 * <p>Contiene el metodo {@code main}, punto de entrada del programa. Crea el
 * controlador del menu y pone en marcha la aplicacion.</p>
 */
public class Main {

    public static void main(String[] args) {
        MenuControlador controlador = new MenuControlador();
        controlador.iniciar();
    }
}
