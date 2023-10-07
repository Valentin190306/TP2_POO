package ar.edu.unlu.poo.ej214;

public class Hospedaje extends Proveedor {
    private final Double rebaja = 0.5;

    public Hospedaje (String nombre, String CUIT, String localizacion, Integer MinProv) {
        setNombre(nombre);
        setCUIT(CUIT);
        setLocalizacion(localizacion);
        setMinProv(MinProv);
    }

    public Double calcularValorExtra (Double precioBase, Integer MaxPaq) {
        if (MaxPaq > MinProv)
            return (MaxPaq - MinProv) * (rebaja * precioBase);
        return 0.0;
    }

    public Double getTasaDeRebaja () {
        return rebaja;
    }
}
