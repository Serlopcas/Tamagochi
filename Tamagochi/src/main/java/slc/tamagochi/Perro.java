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

        calcularModificadores();
        inicializarStats();
    }

    private void calcularModificadores() {
        for (Stat stat : Stat.values()) {
            mods.put(stat, 1.0);
        }
        // Aplicar modificadores de la raza
        mods.put(Stat.ENERGIA, 1 + raza.getEnergiaMod());
        mods.put(Stat.HAMBRE, 1 + raza.getHambreMod());
        mods.put(Stat.SALUD, 1 + raza.getSaludMod());
        mods.put(Stat.LIMPIEZA, 1 + raza.getLimpiezaMod());
        mods.put(Stat.SUENNO, 1 + raza.getSuennoMod());
        mods.put(Stat.ANSIEDAD, 1 + raza.getAnsiedadMod());
        mods.put(Stat.OBEDIENCIA, 1 + raza.getObedienciaMod());
        mods.put(Stat.SOCIABILIDAD, 1 + raza.getSociabilidadMod());
        mods.put(Stat.APEGO, 1 + raza.getApegoMod());

        // Aplicar modificadores por edad
        if (edad <= 2) {// Cachorro
            mods.put(Stat.ENERGIA, mods.get(Stat.ENERGIA) + 0.20);
            mods.put(Stat.HAMBRE, mods.get(Stat.HAMBRE) + 0.10);
            mods.put(Stat.SALUD, mods.get(Stat.SALUD) + 0.05);
            mods.put(Stat.LIMPIEZA, mods.get(Stat.LIMPIEZA) - 0.10);
            mods.put(Stat.SUENNO, mods.get(Stat.SUENNO) + 0.15);
            mods.put(Stat.ANSIEDAD, mods.get(Stat.ANSIEDAD) + 0.15);
            mods.put(Stat.OBEDIENCIA, mods.get(Stat.OBEDIENCIA) - 0.20);
            mods.put(Stat.SOCIABILIDAD, mods.get(Stat.SOCIABILIDAD) + 0.10);
            mods.put(Stat.APEGO, mods.get(Stat.APEGO) + 0.15);
        } else if (edad >= 9) {// Senior
            mods.put(Stat.ENERGIA, mods.get(Stat.ENERGIA) - 0.25);
            mods.put(Stat.HAMBRE, mods.get(Stat.HAMBRE) - 0.10);
            mods.put(Stat.SALUD, mods.get(Stat.SALUD) - 0.25);
            mods.put(Stat.LIMPIEZA, mods.get(Stat.LIMPIEZA) + 0.10);
            mods.put(Stat.SUENNO, mods.get(Stat.SUENNO) - 0.20);
            mods.put(Stat.ANSIEDAD, mods.get(Stat.ANSIEDAD) + 0.10);
            mods.put(Stat.OBEDIENCIA, mods.get(Stat.OBEDIENCIA) - 0.15);
            mods.put(Stat.SOCIABILIDAD, mods.get(Stat.SOCIABILIDAD) - 0.15);
            mods.put(Stat.APEGO, mods.get(Stat.APEGO) + 0.10);
        }
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
        return Math.clamp(resultadoFinal, BASE_MIN_LEVEL, BASE_MAX_LEVEL);
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
    
    public String edadToString(){
        String edadString = getAnnos() + " años y " + getMeses() + " meses";
        return edadString;
    }

    public int getAnnos() {
        return (int) edad;
    }

    public int getMeses() {
        double meses = (edad - getAnnos()) * 12;
        return (int) meses;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public void setStat(Stat stat, int valor) {
        stats.put(stat, Math.clamp(valor, BASE_MIN_LEVEL, BASE_MAX_LEVEL));
        actualizarEstados();
    }

    public void mostrarEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append("🐶 Nombre: ").append(nombre).append(" | Raza: ").append(raza).append(" | Edad: ").append(edadToString()).append(".\n");
        for (Stat stat : Stat.values()) {
            sb.append(stat.getEmoji()).append(" ").append(stat.getNombre()).append(": ").append(stats.get(stat)).append("/100\n");
        }
        sb.append("📌 Estados activos: ").append(estados.isEmpty() ? "Ninguno" : estados);
        System.out.println(sb);
    }

    private void actualizarEstados() {
        estados.clear();

        for (Estado estado : Estado.values()) {
            int valorStat = stats.getOrDefault(estado.getStatAsociado(), 0);
            Integer min = estado.getValorMin();
            Integer max = estado.getValorMax();

            if ((min != null && valorStat >= min) || (max != null && valorStat <= max)) {
                estados.add(estado);
            }
        }
    }
}
