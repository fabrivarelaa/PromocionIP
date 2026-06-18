package juego;

import java.util.Random;

/**
 * Representa una partida del juego "Adivina el numero".
 *
 * <p>Esta clase aplica el paradigma orientado a objetos: encapsula los datos
 * de la partida (atributos privados) y ofrece metodos publicos para operar
 * sobre ellos. Se encarga unicamente de la logica del juego (generar el numero
 * secreto y comparar los intentos); la interaccion con el usuario se realiza
 * en la clase {@code MenuControlador}.</p>
 *
 * @author Introduccion a la Programacion
 */
public class JuegoAdivinarNumero {

    // ----- Atributos privados (encapsulamiento) -----

    /** Valor minimo del rango en el que se genera el numero secreto. */
    private int rangoMin;

    /** Valor maximo del rango en el que se genera el numero secreto. */
    private int rangoMax;

    /** Cantidad maxima de intentos permitidos al jugador. */
    private int intentosMaximos;

    /** Numero que el jugador debe adivinar. */
    private int numeroSecreto;

    /** Generador de numeros aleatorios. */
    private Random random;

    /**
     * Crea una nueva partida y genera automaticamente el numero secreto.
     *
     * @param rangoMin        valor minimo posible del numero secreto
     * @param rangoMax        valor maximo posible del numero secreto
     * @param intentosMaximos cantidad de intentos disponibles
     */
    public JuegoAdivinarNumero(int rangoMin, int rangoMax, int intentosMaximos) {
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        this.intentosMaximos = intentosMaximos;
        this.random = new Random();
        generarNumeroSecreto();
    }

    /**
     * Genera un numero aleatorio dentro del rango [rangoMin, rangoMax]
     * (ambos extremos incluidos) y lo guarda como numero secreto.
     */
    private void generarNumeroSecreto() {
        this.numeroSecreto = random.nextInt(rangoMax - rangoMin + 1) + rangoMin;
    }

    /**
     * Compara el intento del jugador con el numero secreto.
     *
     * @param intento numero propuesto por el jugador
     * @return un valor negativo si el intento es menor que el secreto
     *         (demasiado bajo), {@code 0} si adivino el numero, o un valor
     *         positivo si el intento es mayor que el secreto (demasiado alto)
     */
    public int compararIntento(int intento) {
        return Integer.compare(intento, numeroSecreto);
    }

    // ----- Getters (acceso de solo lectura a los datos de la partida) -----

    public int getRangoMin() {
        return rangoMin;
    }

    public int getRangoMax() {
        return rangoMax;
    }

    public int getIntentosMaximos() {
        return intentosMaximos;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }
}
