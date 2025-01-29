package slc.tamagochi;

/**
 *
 * @author Sergio Lopez Casado
 */
public class Herramientas {
    
    /**
     * Existe en Java 21 pero no en versiones anteriores por lo que se crea
     * aquí para evitar incompatibilidades.
     * 
     * Clamps the value to fit between min and max. If the value is less
     * than {@code min}, then {@code min} is returned. If the value is greater
     * than {@code max}, then {@code max} is returned. Otherwise, the original
     * value is returned.
     * <p>
     * While the original value of type long may not fit into the int type,
     * the bounds have the int type, so the result always fits the int type.
     * This allows to use method to safely cast long value to int with
     * saturation.
     * 
     * @param value value to clamp
     * @param min minimal allowed value
     * @param max maximal allowed value
     * @return a clamped value that fits into {@code min..max} interval
     * @throws IllegalArgumentException if {@code min > max}
     * 
     * @since 21
     */
    public static int clamp(long value, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(min + " > " + max);
        }
        return (int) Math.min(max, Math.max(value, min));
    }
}
