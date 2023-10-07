package ar.edu.unlu.poo.ej214;

public class Transporte extends Proveedor {
    private final Double aumento = 0.3;

    public Transporte (String nombre, String CUIT, String localizacion, Integer MinProv) {
        setNombre(nombre);
        setCUIT(CUIT);
        setLocalizacion(localizacion);
        setMinProv(MinProv);
    }

    public Double calcularValorExtra (Double precioBase, Integer MaxPaq) {
        return MaxPaq * (aumento * precioBase);
    }

    public Double getTasaDeAumento () {
        return aumento;
    }
}
