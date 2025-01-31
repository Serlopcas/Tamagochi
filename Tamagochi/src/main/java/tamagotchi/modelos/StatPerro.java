package tamagotchi.modelos;

/**
 * Proyecto: Tamagotchi - Simulador de Cuidado de Perros
 * Autor: Sergio López Casado
 * Correo: serlopcas.5@gmail.com
 * LinkedIn: https://www.linkedin.com/in/sergiolopezcasado/
 * GitHub: https://github.com/Serlopcas
 * Fecha de creación: 29/01/2025
 * Descripción: Representa las estadísticas que tiene un perro en el juego.
 * Cada estadística tiene un nombre y un emoji asociado para su representación
 * visual.
 */
public enum StatPerro {
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

    /**
     * Constructor de la estadística.
     *
     * @param nombre Nombre descriptivo de la estadística.
     * @param emoji Emoji representativo de la estadística.
     */
    StatPerro(String nombre, String emoji) {
        this.nombre = nombre;
        this.emoji = emoji;
    }

    /**
     * Obtiene el nombre de la estadística.
     *
     * @return Nombre de la estadística.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el emoji asociado a la estadística.
     *
     * @return Emoji de la estadística.
     */
    public String getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
