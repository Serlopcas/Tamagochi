package tamagotchi.modelos;

/**
 * Proyecto: Tamagotchi - Simulador de Cuidado de Perros
 * Autor: Sergio López Casado
 * Correo: serlopcas.5@gmail.com
 * LinkedIn: https://www.linkedin.com/in/sergiolopezcasado/
 * GitHub: https://github.com/Serlopcas
 * Fecha de creación: 29/01/2025
 * Descripción: Representa un estado que un perro puede tener en función de sus
 * estadísticas. Cada estado está vinculado a una estadística y tiene
 * condiciones de activación.
 */
public enum Estado {
    HAMBRIENTO(StatPerro.HAMBRE, 70, null, "Tiene hambre"),
    FAMELICO(StatPerro.HAMBRE, 90, null, "Está desnutrido"),
    CANSADO(StatPerro.ENERGIA, null, 30, "Está cansado"),
    EXHAUSTO(StatPerro.ENERGIA, null, 10, "No puede moverse"),
    FELIZ(StatPerro.FELICIDAD, 80, null, "Está muy contento"),
    TRISTE(StatPerro.FELICIDAD, null, 40, "Parece decaído"),
    DEPRIMIDO(StatPerro.FELICIDAD, null, 20, "No tiene ánimos para nada"),
    ENFERMO(StatPerro.SALUD, null, 30, "Parece enfermo"),
    GRAVEMENTE_ENFERMO(StatPerro.SALUD, null, 10, "Está en muy mal estado"),
    SUCIO(StatPerro.LIMPIEZA, null, 30, "Necesita un baño"),
    INFESTADO(StatPerro.LIMPIEZA, null, 10, "Está infestado de parásitos"),
    ANSIOSO(StatPerro.ANSIEDAD, 70, null, "Está inquieto"),
    ESTRESADO(StatPerro.ANSIEDAD, 90, null, "Está bajo mucha tensión"),
    REBELDE(StatPerro.OBEDIENCIA, null, 30, "No obedece órdenes"),
    SOLITARIO(StatPerro.APEGO, null, 30, "Se siente solo"),
    APEGADO(StatPerro.APEGO, 80, null, "Es muy dependiente del dueño"),
    ASUSTADO(StatPerro.ANSIEDAD, 70, null, "Está temeroso"),
    AGRESIVO(StatPerro.SOCIABILIDAD, null, 20, "Muestra comportamiento agresivo");

    private final StatPerro statAsociado;
    private final Integer valorMin;
    private final Integer valorMax;
    private final String descripcion;

    /**
     * Constructor de un estado.
     *
     * @param statAsociado La estadística que influye en este estado.
     * @param valorMin Valor mínimo para que se active el estado (puede ser null).
     * @param valorMax Valor máximo para que se active el estado (puede ser null).
     * @param descripcion Descripción del estado.
     */
    Estado(StatPerro statAsociado, Integer valorMin, Integer valorMax, String descripcion) {
        this.statAsociado = statAsociado;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la estadística asociada a este estado.
     *
     * @return La estadística vinculada al estado.
     */
    public StatPerro getStatAsociado() {
        return statAsociado;
    }

    /**
     * Obtiene el valor mínimo que activa este estado.
     *
     * @return El valor mínimo o null si no hay límite inferior.
     */
    public Integer getValorMin() {
        return valorMin;
    }

    /**
     * Obtiene el valor máximo que activa este estado.
     *
     * @return El valor máximo o null si no hay límite superior.
     */
    public Integer getValorMax() {
        return valorMax;
    }

    /**
     * Obtiene la descripción del estado.
     *
     * @return La descripción del estado.
     */
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
