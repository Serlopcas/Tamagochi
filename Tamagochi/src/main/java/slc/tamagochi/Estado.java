package slc.tamagochi;

/**
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

    Estado(Stat statAsociado, Integer valorMin, Integer valorMax, String descripcion) {
        this.statAsociado = statAsociado;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.descripcion = descripcion;
    }

    public Stat getStatAsociado() {
        return statAsociado;
    }

    public Integer getValorMin() {
        return valorMin;
    }

    public Integer getValorMax() {
        return valorMax;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
