package app;

import java.util.Scanner;

import juego.JuegoAdivinarNumero;

/**
 * Controla el menu principal y coordina las partidas del juego
 * "Adivina el numero".
 *
 * <p>Gestiona la entrada y salida por consola ({@link Scanner} y
 * {@code System.out.println}) y utiliza la clase {@link JuegoAdivinarNumero}
 * para la logica del juego. Mantiene ademas estadisticas de las partidas
 * jugadas.</p>
 */
public class MenuControlador {

    /** Lector de la entrada estandar (teclado). */
    private Scanner scanner;

    /** Estadisticas de la sesion. */
    private int partidasJugadas;
    private int partidasGanadas;
    private int partidasPerdidas;

    public MenuControlador() {
        this.scanner = new Scanner(System.in);
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    /**
     * Muestra el menu principal de forma repetida (bucle while) hasta que el
     * usuario elige salir. Usa una estructura switch para procesar la opcion.
     */
    public void iniciar() {
        System.out.println("************************************************");
        System.out.println("*           ADIVINA EL NUMERO                  *");
        System.out.println("************************************************");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Elija una opcion: ");

            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarInstrucciones();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\nGracias por jugar. Hasta la proxima!");
                    break;
                default:
                    System.out.println("\n[!] Opcion invalida. Ingrese un numero del 1 al 4.");
            }
        }
        scanner.close();
    }

    /** Imprime las opciones del menu principal. */
    private void mostrarMenu() {
        System.out.println("\n------------------- MENU -------------------");
        System.out.println("1. Jugar");
        System.out.println("2. Instrucciones");
        System.out.println("3. Estadisticas");
        System.out.println("4. Salir");
        System.out.println("--------------------------------------------");
    }

    /**
     * Ejecuta una partida completa: el jugador elige la dificultad, el programa
     * genera el numero secreto y el usuario intenta adivinarlo dentro del
     * limite de intentos. Al finalizar muestra un mensaje de victoria o derrota.
     */
    private void jugarPartida() {
        JuegoAdivinarNumero juego = crearJuegoSegunDificultad();

        System.out.println("\nHe pensado un numero entre " + juego.getRangoMin()
                + " y " + juego.getRangoMax() + ".");
        System.out.println("Tenes " + juego.getIntentosMaximos() + " intentos para adivinarlo. Suerte!\n");

        boolean adivino = false;

        // Bucle for: controla la cantidad de intentos disponibles.
        for (int intento = 1; intento <= juego.getIntentosMaximos(); intento++) {
            int numero = leerNumeroEnRango(juego, intento);
            int comparacion = juego.compararIntento(numero);

            // Estructura if / else if / else para dar las pistas.
            if (comparacion == 0) {
                System.out.println(">> CORRECTO! Adivinaste el numero " + juego.getNumeroSecreto() + ".");
                adivino = true;
                break; // sale del bucle al acertar
            } else if (comparacion > 0) {
                System.out.println(">> El numero secreto es MENOR. Tu intento fue demasiado ALTO.");
            } else {
                System.out.println(">> El numero secreto es MAYOR. Tu intento fue demasiado BAJO.");
            }

            int restantes = juego.getIntentosMaximos() - intento;
            System.out.println("   Intentos restantes: " + restantes + "\n");
        }

        // Mensaje final de victoria o derrota.
        partidasJugadas++;
        if (adivino) {
            partidasGanadas++;
            System.out.println("\n***** GANASTE! *****");
        } else {
            partidasPerdidas++;
            System.out.println("\n----- PERDISTE -----");
            System.out.println("Te quedaste sin intentos. El numero era: " + juego.getNumeroSecreto());
        }
    }

    /**
     * Solicita la dificultad y crea la partida con el rango e intentos
     * correspondientes. Demuestra el uso de la estructura switch.
     *
     * @return una nueva instancia de {@link JuegoAdivinarNumero}
     */
    private JuegoAdivinarNumero crearJuegoSegunDificultad() {
        System.out.println("\n--- Elija la dificultad ---");
        System.out.println("1. Facil   (numero del 1 al 50,  10 intentos)");
        System.out.println("2. Medio   (numero del 1 al 100,  7 intentos)");
        System.out.println("3. Dificil (numero del 1 al 200,  8 intentos)");

        int opcion = leerEntero("Opcion: ");

        switch (opcion) {
            case 1:
                return new JuegoAdivinarNumero(1, 50, 10);
            case 3:
                return new JuegoAdivinarNumero(1, 200, 8);
            case 2:
                return new JuegoAdivinarNumero(1, 100, 7);
            default:
                System.out.println("[!] Opcion no valida. Se usara la dificultad MEDIA por defecto.");
                return new JuegoAdivinarNumero(1, 100, 7);
        }
    }

    /** Muestra las instrucciones del juego. */
    private void mostrarInstrucciones() {
        System.out.println("\n--- Instrucciones ---");
        System.out.println("1. El programa genera un numero aleatorio dentro de un rango.");
        System.out.println("2. Tenes una cantidad limitada de intentos para adivinarlo.");
        System.out.println("3. En cada intento, el programa te dira si el numero secreto es");
        System.out.println("   MAYOR o MENOR que tu intento.");
        System.out.println("4. Ganas si lo adivinas antes de quedarte sin intentos.");
    }

    /** Muestra las estadisticas de la sesion. */
    private void mostrarEstadisticas() {
        System.out.println("\n--- Estadisticas de la sesion ---");
        System.out.println("Partidas jugadas:  " + partidasJugadas);
        System.out.println("Partidas ganadas:  " + partidasGanadas);
        System.out.println("Partidas perdidas: " + partidasPerdidas);
    }

    // ------------------- Metodos auxiliares de lectura -------------------

    /**
     * Lee un numero entero por teclado de forma segura. Si el usuario escribe
     * texto en lugar de un numero, captura la excepcion y vuelve a pedir el
     * dato (bucle while), evitando que el programa se cierre por error.
     *
     * @param mensaje texto que se muestra como indicacion
     * @return el numero entero ingresado
     */
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("[!] Entrada invalida: debe ingresar un numero.");
            }
        }
    }

    /**
     * Lee un intento valido que ademas este dentro del rango del juego. Si el
     * numero esta fuera de rango, avisa y lo pide de nuevo (no se descuenta el
     * intento hasta que el valor sea valido).
     *
     * @param juego   partida en curso, de la que se obtiene el rango permitido
     * @param intento numero de intento actual (para mostrarlo al jugador)
     * @return un numero dentro del rango [rangoMin, rangoMax]
     */
    private int leerNumeroEnRango(JuegoAdivinarNumero juego, int intento) {
        while (true) {
            int numero = leerEntero("Intento " + intento + " - Ingresa tu numero: ");
            if (numero < juego.getRangoMin() || numero > juego.getRangoMax()) {
                System.out.println("[!] El numero debe estar entre " + juego.getRangoMin()
                        + " y " + juego.getRangoMax() + ".");
            } else {
                return numero;
            }
        }
    }
}
