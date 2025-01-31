package tamagotchi.modelos;

/**
 * Proyecto: Tamagotchi - Simulador de Cuidado de Perros
 * Autor: Sergio López Casado
 * Correo: serlopcas.5@gmail.com
 * LinkedIn: https://www.linkedin.com/in/sergiolopezcasado/
 * GitHub: https://github.com/Serlopcas
 * Fecha de creación: 31/01/2025
 * Descripción: TODO
 */
public enum StatJugador {
    DINERO("Dinero", "💰"),
    ENERGIA("Energía", "⚡");

    private final String nombre;
    private final String emoji;

    StatJugador(String nombre, String emoji) {
        this.nombre = nombre;
        this.emoji = emoji;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmoji() {
        return emoji;
    }
}