package tamagotchi.core;

/**
 * Proyecto: Tamagotchi - Simulador de Cuidado de Perros
 * Autor: Sergio López Casado
 * Correo: serlopcas.5@gmail.com
 * LinkedIn: https://www.linkedin.com/in/sergiolopezcasado/
 * GitHub: https://github.com/Serlopcas
 * Fecha de creación: 29/01/2025
 * Descripción: Clase de utilidad que proporciona métodos estáticos auxiliares
 * para el juego.
 */
public class Herramientas {

    /**
     * Método de clamp para asegurar que un valor esté dentro de un rango dado.
     *
     * Este método existe en Java 21, pero se implementa aquí para
     * compatibilidad con versiones anteriores.
     *
     * @param value Valor a ajustar.
     * @param min Valor mínimo permitido.
     * @param max Valor máximo permitido.
     * @return Un valor ajustado dentro del rango especificado.
     * @throws IllegalArgumentException si {@code min > max}.
     */
    public static int clamp(long value, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(min + " > " + max);
        }
        return (int) Math.min(max, Math.max(value, min));
    }
}
