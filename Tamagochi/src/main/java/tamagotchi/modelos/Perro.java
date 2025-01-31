package tamagotchi.modelos;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import tamagotchi.core.Herramientas;

/**
 * Proyecto: Tamagotchi - Simulador de Cuidado de Perros
 * Autor: Sergio López Casado
 * Correo: serlopcas.5@gmail.com
 * LinkedIn: https://www.linkedin.com/in/sergiolopezcasado/
 * GitHub: https://github.com/Serlopcas
 * Fecha de creación: 29/01/2025
 * Descripción: Clase que representa un perro con diferentes atributos y estados
 * dinámicos. Cada perro tiene estadísticas (energía, hambre, salud, etc.),
 * modificadores según su raza y edad, y puede estar en ciertos estados según su
 * condición.
 */
public class Perro {

    /**
     * Valor máximo para las estadísticas del perro
     */
    private static final int BASE_MAX_LEVEL = 100;

    /**
     * Valor mínimo para las estadísticas del perro
     */
    private static final int BASE_MIN_LEVEL = 0;

    /**
     * Generador de números aleatorios para inicializar los valores de los stats
     */
    private static final Random rand = new Random();

    /**
     * Nombre del perro
     */
    private final String nombre;

    /**
     * Raza del perro
     */
    private final Raza raza;

    /**
     * Edad del perro en años y fracción de meses
     */
    private double edad;

    /**
     * Mapa que almacena las estadísticas del perro
     */
    private final Map<Stat, Integer> stats;

    /**
     * Mapa que almacena los modificadores aplicados a las estadísticas
     */
    private final Map<Stat, Double> mods;

    /**
     * Conjunto de estados actuales del perro
     */
    private final Set<Estado> estados;

    /**
     * Constructor para inicializar un nuevo perro con nombre, raza y edad. Se
     * calculan automáticamente sus estadísticas y modificadores.
     *
     * @param nombre Nombre del perro
     * @param raza Raza del perro
     * @param edad Edad del perro en años
     */
    public Perro(String nombre, Raza raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.stats = new EnumMap<>(Stat.class);
        this.mods = new EnumMap<>(Stat.class);
        this.estados = new HashSet<>();

        inicializarModificadores();
        inicializarStats();
    }

    /**
     * Inicializa los modificadores de los stats, aplicando los efectos de la
     * raza y la edad.
     */
    private void inicializarModificadores() {
        for (Stat stat : Stat.values()) {
            mods.put(stat, 1.0 + raza.getMod(stat));
        }

        // Aplicar modificadores por edad
        if (edad <= 2) {// Cachorro
            aplicarModificadores(0.20, 0.10, 0.05, -0.10, 0.15, 0.15, -0.20, 0.10, 0.15);
        } else if (edad >= 9) {// Senior
            aplicarModificadores(-0.25, -0.10, -0.25, 0.10, -0.20, 0.10, -0.15, -0.15, 0.10);
        }
    }

    /**
     * Actualiza el conjunto de modificadores de los stats del perro.
     *
     * @param energia Cantidad a añadir/sustraer del Modificador de energía
     * @param hambre Cantidad a añadir/sustraer del Modificador de hambre
     * @param salud Cantidad a añadir/sustraer del Modificador de salud
     * @param limpieza Cantidad a añadir/sustraer del Modificador de limpieza
     * @param suenno Cantidad a añadir/sustraer del Modificador de sueño
     * @param ansiedad Cantidad a añadir/sustraer del Modificador de ansiedad
     * @param obediencia Cantidad a añadir/sustraer del Modificador de
     * obediencia
     * @param sociabilidad Cantidad a añadir/sustraer del Modificador de
     * sociabilidad
     * @param apego Cantidad a añadir/sustraer del Modificador de apego
     */
    private void aplicarModificadores(double energia, double hambre, double salud, double limpieza,
            double suenno, double ansiedad, double obediencia,
            double sociabilidad, double apego) {
        mods.put(Stat.ENERGIA, mods.getOrDefault(Stat.ENERGIA, 1.0) + energia);
        mods.put(Stat.HAMBRE, mods.getOrDefault(Stat.HAMBRE, 1.0) + hambre);
        mods.put(Stat.SALUD, mods.getOrDefault(Stat.SALUD, 1.0) + salud);
        mods.put(Stat.LIMPIEZA, mods.getOrDefault(Stat.LIMPIEZA, 1.0) + limpieza);
        mods.put(Stat.SUENNO, mods.getOrDefault(Stat.SUENNO, 1.0) + suenno);
        mods.put(Stat.ANSIEDAD, mods.getOrDefault(Stat.ANSIEDAD, 1.0) + ansiedad);
        mods.put(Stat.OBEDIENCIA, mods.getOrDefault(Stat.OBEDIENCIA, 1.0) + obediencia);
        mods.put(Stat.SOCIABILIDAD, mods.getOrDefault(Stat.SOCIABILIDAD, 1.0) + sociabilidad);
        mods.put(Stat.APEGO, mods.getOrDefault(Stat.APEGO, 1.0) + apego);
    }

    /**
     * Inicializa los valores base de los stats del perro aplicando los
     * modificadores.
     */
    private void inicializarStats() {
        stats.put(Stat.ENERGIA, BASE_MAX_LEVEL);
        stats.put(Stat.HAMBRE, BASE_MIN_LEVEL);
        stats.put(Stat.FELICIDAD, statInicial(40, 80, mods.get(Stat.FELICIDAD)));
        stats.put(Stat.SALUD, statInicial(60, 90, mods.get(Stat.SALUD)));
        stats.put(Stat.LIMPIEZA, statInicial(30, 80, mods.get(Stat.LIMPIEZA)));
        stats.put(Stat.SUENNO, statInicial(30, 70, mods.get(Stat.SUENNO)));
        stats.put(Stat.ANSIEDAD, statInicial(10, 50, mods.get(Stat.ANSIEDAD)));
        stats.put(Stat.OBEDIENCIA, statInicial(20, 70, mods.get(Stat.OBEDIENCIA)));
        stats.put(Stat.SOCIABILIDAD, statInicial(30, 80, mods.get(Stat.SOCIABILIDAD)));
        stats.put(Stat.APEGO, statInicial(20, 80, mods.get(Stat.APEGO)));
    }

    /**
     * Calcula un valor inicial aleatorio para un stat dentro de un rango y lo
     * ajusta con su modificador.
     *
     * @param min Valor mínimo
     * @param max Valor máximo
     * @param modificador Modificador aplicado al stat
     * @return Valor inicial ajustado
     */
    private int statInicial(int min, int max, double modificador) {
        int valorAleatorio = rand.nextInt((max - min) + 1) + min;
        int resultadoFinal = (int) Math.round(valorAleatorio * modificador);
        return Herramientas.clamp(resultadoFinal, BASE_MIN_LEVEL, BASE_MAX_LEVEL);
    }

    /**
     * Obtiene el nombre del perro.
     *
     * @return Nombre del perro.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la raza del perro.
     *
     * @return Raza del perro.
     */
    public Raza getRaza() {
        return raza;
    }

    /**
     * Obtiene la edad actual del perro en años (puede incluir decimales para
     * los meses).
     *
     * @return Edad del perro en años.
     */
    public double getEdad() {
        return edad;
    }

    /**
     * Obtiene el valor actual de una estadística específica del perro.
     *
     * @param stat La estadística a consultar.
     * @return Valor de la estadística, o 0 si no está definida.
     */
    public int getStat(Stat stat) {
        return stats.getOrDefault(stat, 0);
    }

    /**
     * Obtiene el modificador aplicado a una estadística específica del perro.
     *
     * @param stat La estadística a consultar.
     * @return Modificador aplicado a la estadística, por defecto 1.0.
     */
    public double getMod(Stat stat) {
        return mods.getOrDefault(stat, 1.0);
    }

    /**
     * Obtiene el conjunto de estados actuales del perro.
     *
     * @return Conjunto de estados en los que se encuentra el perro.
     */
    public Set<Estado> getEstados() {
        return estados;
    }

    /**
     * Devuelve la edad del perro en un formato legible, separando años y meses.
     *
     * @return Cadena con la edad en años y meses.
     */
    public String edadToString() {
        return String.format("%d años y %d meses", getAnnos(), getMeses());
    }

    /**
     * @return La edad en años completos
     */
    public int getAnnos() {
        return (int) edad;
    }

    /**
     * @return La edad en meses restantes después de los años
     */
    public int getMeses() {
        return (int) ((edad - getAnnos()) * 12);
    }

    /**
     * Establece la nueva edad del perro asegurando que esté dentro del rango
     * válido (0-29 años).
     *
     * @param edad Nueva edad del perro en años.
     * @throws IllegalArgumentException Si la edad está fuera del rango
     * permitido.
     */
    public void setEdad(double edad) {
        if (edad < 0 || edad > 29) { // 29 años es la máxima edad registrada
            throw new IllegalArgumentException("La edad debe estar entre 0 y 29 años.");
        }
        this.edad = edad;
    }

    /**
     * Establece un nuevo valor para una estadística del perro, asegurando que
     * esté dentro de los límites permitidos. También actualiza los estados del
     * perro en función del nuevo valor de la estadística.
     *
     * @param stat Estadística a modificar.
     * @param valor Nuevo valor de la estadística.
     */
    public void setStat(Stat stat, int valor) {
        stats.put(stat, Herramientas.clamp(valor, BASE_MIN_LEVEL, BASE_MAX_LEVEL));
        actualizarEstados();
    }

    /**
     * Muestra el estado actual del perro, incluyendo sus estadísticas y estados
     * activos. Imprime la información en la consola.
     */
    public void mostrarEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("🐶 Nombre: %s | Raza: %s | Edad: %s\n", nombre, raza, edadToString()));

        for (Stat stat : Stat.values()) {
            sb.append(String.format("%s %s: %d/100\n",
                    stat.getEmoji(), stat.getNombre(), stats.get(stat)));
        }

        sb.append("📌 Estados activos: ").append(estados.isEmpty() ? "Ninguno" : estados);
        System.out.println(sb);
    }

    /**
     * Actualiza los estados del perro en función de sus estadísticas actuales.
     */
    private void actualizarEstados() {
        Set<Estado> nuevosEstados = new HashSet<>();

        for (Estado estado : Estado.values()) {
            int valorStat = stats.getOrDefault(estado.getStatAsociado(), 0);
            Integer min = estado.getValorMin();
            Integer max = estado.getValorMax();

            if ((min != null && valorStat >= min) || (max != null && valorStat <= max)) {
                nuevosEstados.add(estado);
            }
        }

        if (!estados.equals(nuevosEstados)) {
            estados.clear();
            estados.addAll(nuevosEstados);
        }
    }
}
