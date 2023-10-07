package ar.edu.unlu.poo.ej214;

public class GuiaTuristico extends Proveedor {
    private final Integer MinProv = 200;

    public GuiaTuristico(String nombre, String CUIT, String localizacion) {
        setNombre(nombre);
        setCUIT(CUIT);
        setLocalizacion(localizacion);
    }

    public Double calcularValorExtra (Integer MaxPaq) {
        if (MaxPaq > MinProv)
            return 90.0;
        return 0.0;
    }
}
