package slc.tamagochi;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Sergio López Casado
 */
public class Perro {

    private static final int BASE_MAX_LEVEL = 100;
    private static final int BASE_MIN_LEVEL = 0;
    private static final Random rand = new Random();

    private final String nombre;
    private final Raza raza;
    private double edad;

    private final Map<Stat, Integer> stats;
    private final Map<Stat, Double> mods;

    private final Set<Estado> estados;

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

    private int statInicial(int min, int max, double modificador) {
        int valorAleatorio = rand.nextInt((max - min) + 1) + min;
        int resultadoFinal = (int) Math.round(valorAleatorio * modificador);
        return Herramientas.clamp(resultadoFinal, BASE_MIN_LEVEL, BASE_MAX_LEVEL);
    }

    public String getNombre() {
        return nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public double getEdad() {
        return edad;
    }

    public int getStat(Stat stat) {
        return stats.getOrDefault(stat, 0);
    }

    public double getMod(Stat stat) {
        return mods.getOrDefault(stat, 1.0);
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public String edadToString() {
        return String.format("%d años y %d meses", getAnnos(), getMeses());
    }

    public int getAnnos() {
        return (int) edad;
    }

    public int getMeses() {
        return (int) ((edad - getAnnos()) * 12);
    }

    public void setEdad(double edad) {
        if (edad < 0 || edad > 29) { // 29 años es la máxima edad registrada
            throw new IllegalArgumentException("La edad debe estar entre 0 y 29 años.");
        }
        this.edad = edad;
    }

    public void setStat(Stat stat, int valor) {
        stats.put(stat, Herramientas.clamp(valor, BASE_MIN_LEVEL, BASE_MAX_LEVEL));
        actualizarEstados();
    }

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
