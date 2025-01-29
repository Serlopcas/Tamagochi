package slc.tamagochi;

/**
 * Clase de utilidad que proporciona métodos estáticos auxiliares para el juego.
 * 
 * @author Sergio López Casado
 */
public class Herramientas {
    
    /**
     * Método de clamp para asegurar que un valor esté dentro de un rango dado.
     * 
     * Este método existe en Java 21, pero se implementa aquí para compatibilidad con versiones anteriores.
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
