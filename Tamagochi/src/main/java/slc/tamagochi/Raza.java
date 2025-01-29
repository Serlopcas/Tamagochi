package slc.tamagochi;

/**
 *
 * @author Sergio López Casado
 */
public enum Raza {
    // 🏃 Perros con MUCHA energía
    BORDER_COLLIE("Border Collie", 0.5, 0.1, 0.0, -0.1, -0.3, -0.1, 0.5, 0.3, 0.1), // Perro de trabajo, súper enérgico y obediente.
    ALASKAN_MALAMUTE("Alaskan Malamute", 0.4, 0.1, 0.1, -0.2, -0.4, -0.2, -0.2, 0.5, -0.3), // Resistente pero independiente, difícil de entrenar.
    DALMATA("Dalmata", 0.45, 0.2, 0.0, -0.1, -0.2, -0.05, -0.1, 0.4, -0.2), // Necesita ejercicio constante, muy social.

    // 🍖 Perros con MUCHA hambre
    LABRADOR("Labrador", 0.3, 0.5, 0.1, 0.0, -0.1, -0.1, 0.3, 0.3, 0.5), // Amistoso, glotón y fácil de entrenar.
    BEAGLE("Beagle", 0.1, 0.5, 0.05, -0.1, -0.1, 0.2, -0.2, 0.4, 0.3), // Apasionado por la comida, pero testarudo.
    BULLDOG("Bulldog", -0.3, 0.4, 0.3, 0.0, 0.3, 0.05, -0.3, -0.2, 0.4), // Perezoso pero afectuoso y glotón.

    // 🏥 Perros MUY saludables
    PASTOR_GANADERO_AUSTRALIANO("Pastor Ganadero Australiano", 0.5, 0.1, 0.5, 0.1, -0.3, -0.1, 0.4, 0.1, 0.2), // Perro muy resistente y obediente.
    SHIBA_INU("Shiba Inu", 0.1, 0.0, 0.5, 0.5, 0.1, 0.4, -0.4, -0.1, -0.5), // Independiente y con gran salud, pero poco apegado.

    // 🚿 Perros que se ENSUCIAN rápido o lento
    GOLDEN_RETRIEVER("Golden Retriever", 0.2, 0.3, 0.2, -0.3, -0.1, -0.1, 0.4, 0.5, 0.5), // Sociable, inteligente y propenso a ensuciarse.
    PASTOR_ALEMAN("Pastor Alemán", 0.3, 0.2, 0.4, -0.2, -0.1, -0.2, 0.5, 0.3, 0.4), // Versátil y obediente, pero se ensucia en trabajo.
    CANICHE("Caniche", -0.1, -0.2, 0.1, 0.5, 0.1, 0.0, 0.5, 0.3, 0.3), // Muy limpio, fácil de entrenar y social.

    // 😴 Perros que NECESITAN MUCHO descanso
    BASSET_HOUND("Basset Hound", -0.2, 0.2, 0.3, 0.1, 0.5, -0.1, -0.2, -0.1, 0.5), // Duerme mucho, pero afectuoso.
    GRAN_DANES("Gran Danés", -0.4, 0.3, 0.2, 0.1, 0.5, -0.2, 0.0, 0.1, 0.4), // Gran tamaño = mucho descanso necesario.
    CHIHUAHUA("Chihuahua", 0.2, -0.3, -0.2, 0.3, -0.5, 0.5, -0.3, 0.1, 0.5), // Siempre alerta y ansioso, duerme poco.

    // 😟 Perros con ALTA o BAJA ansiedad
    JACK_RUSSELL_TERRIER("Jack Russell Terrier", 0.5, 0.2, -0.1, -0.1, -0.4, 0.5, 0.1, 0.5, -0.3), // Hiperactivo y ansioso.
    SALCHICHA("Salchicha", 0.1, 0.3, 0.0, 0.0, 0.1, 0.4, -0.1, 0.2, 0.4), // Valiente pero con tendencia a la ansiedad.
    SAN_BERNARDO("San Bernardo", -0.5, 0.0, 0.5, 0.3, 0.4, -0.5, 0.3, -0.1, 0.5), // Tranquilo, cariñoso y baja ansiedad.
    AKITA_INU("Akita Inu", -0.1, -0.2, 0.4, 0.1, 0.3, -0.4, 0.3, -0.3, -0.5); // Independiente, territorial y no muy sociable.

    private final String nombre;
    private final double energiaMod;
    private final double hambreMod;
    private final double saludMod;
    private final double limpiezaMod;
    private final double suennoMod;
    private final double ansiedadMod;
    private final double obedienciaMod;
    private final double sociabilidadMod;
    private final double apegoMod;

    private Raza(String nombre, double energiaMod, double hambreMod, double saludMod, double limpiezaMod, double suennoMod, double ansiedadMod, double obedienciaMod, double sociabilidadMod, double apegoMod) {
        this.nombre = nombre;
        this.energiaMod = energiaMod;
        this.hambreMod = hambreMod;
        this.saludMod = saludMod;
        this.limpiezaMod = limpiezaMod;
        this.suennoMod = suennoMod;
        this.ansiedadMod = ansiedadMod;
        this.obedienciaMod = obedienciaMod;
        this.sociabilidadMod = sociabilidadMod;
        this.apegoMod = apegoMod;
    }

    public String getNombre() {
        return nombre;
    }

    public double getEnergiaMod() {
        return energiaMod;
    }

    public double getHambreMod() {
        return hambreMod;
    }

    public double getSaludMod() {
        return saludMod;
    }

    public double getLimpiezaMod() {
        return limpiezaMod;
    }

    public double getSuennoMod() {
        return suennoMod;
    }

    public double getAnsiedadMod() {
        return ansiedadMod;
    }

    public double getObedienciaMod() {
        return obedienciaMod;
    }

    public double getSociabilidadMod() {
        return sociabilidadMod;
    }

    public double getApegoMod() {
        return apegoMod;
    }
}
