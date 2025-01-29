package slc.tamagochi;

/**
 * Representa un estado que un perro puede tener en función de sus estadísticas.
 * Cada estado está vinculado a una estadística y tiene condiciones de activación.
 *
 * @author Sergio López Casado
 */
public enum Estado {
    HAMBRIENTO(Stat.HAMBRE, 70, null, "Tiene hambre"),
    FAMÉLICO(Stat.HAMBRE, 90, null, "Está desnutrido"),
    CANSADO(Stat.ENERGIA, null, 30, "Está cansado"),
    EXHAUSTO(Stat.ENERGIA, null, 10, "No puede moverse"),
    FELIZ(Stat.FELICIDAD, 80, null, "Está muy contento"),
    TRISTE(Stat.FELICIDAD, null, 40, "Parece decaído"),
    DEPRIMIDO(Stat.FELICIDAD, null, 20, "No tiene ánimos para nada"),
    ENFERMO(Stat.SALUD, null, 30, "Parece enfermo"),
    GRAVEMENTE_ENFERMO(Stat.SALUD, null, 10, "Está en muy mal estado"),
    SUCIO(Stat.LIMPIEZA, null, 30, "Necesita un baño"),
    INFESTADO(Stat.LIMPIEZA, null, 10, "Está infestado de parásitos"),
    ANSIOSO(Stat.ANSIEDAD, 70, null, "Está inquieto"),
    ESTRESADO(Stat.ANSIEDAD, 90, null, "Está bajo mucha tensión"),
    REBELDE(Stat.OBEDIENCIA, null, 30, "No obedece órdenes"),
    SOLITARIO(Stat.APEGO, null, 30, "Se siente solo"),
    APEGADO(Stat.APEGO, 80, null, "Es muy dependiente del dueño"),
    ASUSTADO(Stat.ANSIEDAD, 70, null, "Está temeroso"),
    AGRESIVO(Stat.SOCIABILIDAD, null, 20, "Muestra comportamiento agresivo");

    private final Stat statAsociado;
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
    Estado(Stat statAsociado, Integer valorMin, Integer valorMax, String descripcion) {
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
    public Stat getStatAsociado() {
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
