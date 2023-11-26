import java.util.ArrayList;

// Interfaz que define el método obtenerImpactoEcologico
interface ImpactoEcologico {
    double obtenerImpactoEcologico();
}

// Clase Edificio que implementa la interfaz
class Edificio implements ImpactoEcologico {
    private String nombre;
    private double consumoEnergetico; // en kilovatios por hora

    public Edificio(String nombre, double consumoEnergetico) {
        this.nombre = nombre;
        this.consumoEnergetico = consumoEnergetico;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Supongamos que el factor de conversión es 0.5 para edificios
        return consumoEnergetico * 0.5;
    }
}

// Clase Auto que implementa la interfaz
class Auto implements ImpactoEcologico {
    private String modelo;
    private double emisionesCO2; // en kilogramos de CO2 por kilómetro

    public Auto(String modelo, double emisionesCO2) {
        this.modelo = modelo;
        this.emisionesCO2 = emisionesCO2;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Supongamos que el factor de conversión es 2 para autos
        return emisionesCO2 * 2;
    }
}

// Clase Bicicleta que implementa la interfaz
class Bicicleta implements ImpactoEcologico {
    private String tipo;
    private boolean esElectrica;

    public Bicicleta(String tipo, boolean esElectrica) {
        this.tipo = tipo;
        this.esElectrica = esElectrica;
    }

    @Override
    public double obtenerImpactoEcologico() {
        // Las bicicletas eléctricas tienen bajo impacto (supongamos 0.1), las no eléctricas tienen impacto nulo
        return esElectrica ? 0.1 : 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear objetos de cada clase
        Edificio edificio = new Edificio("Edificio A", 1000);
        Auto auto = new Auto("Modelo X", 0.15);
        Bicicleta bicicleta = new Bicicleta("De montaña", false);

        // Colocar referencias en un ArrayList<ImpactoEcologico>
        ArrayList<ImpactoEcologico> lista = new ArrayList<>();
        lista.add(edificio);
        lista.add(auto);
        lista.add(bicicleta);

        // Iterar a través del ArrayList e invocar el método obtenerImpactoEcologico
        for (ImpactoEcologico objeto : lista) {
            System.out.println("Objeto: " + objeto.getClass().getSimpleName());
            System.out.println("Impacto ecológico: " + objeto.obtenerImpactoEcologico());
            System.out.println("------------------------------");
        }
    }
}
