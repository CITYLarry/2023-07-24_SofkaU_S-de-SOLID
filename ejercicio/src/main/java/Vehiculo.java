import java.util.ArrayList;

public class Vehiculo {
    ArrayList<String> vehiculos = new ArrayList();
    String tipo;

    public Vehiculo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoVehiculo() {
        return tipo;
    }

    void guardarVehiculoDB(Vehiculo vehiculo) {
        vehiculos.add(vehiculo.tipo);
    }
}
