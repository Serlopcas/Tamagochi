package slc.tamagochi;

/**
 *
 * @author Sergio López Casado
 */
public enum Stat {
    ENERGIA("Energía", "⚡"),
    HAMBRE("Hambre", "🍖"),
    FELICIDAD("Felicidad", "😊"),
    SALUD("Salud", "🏥"),
    LIMPIEZA("Limpieza", "🚿"),
    SUENNO("Sueño", "😴"),
    ANSIEDAD("Ansiedad", "😟"),
    OBEDIENCIA("Obediencia", "🎓"),
    SOCIABILIDAD("Sociabilidad", "🐶"),
    APEGO("Apego", "👨‍👦");

    private final String nombre;
    private final String emoji;

    Stat(String nombre, String emoji) {
        this.nombre = nombre;
        this.emoji = emoji;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
