package ar.edu.unlu.poo.ej214;

public class Proveedor {
    private String nombre;
    private String CUIT;
    private String localizacion;
    private Enum<Clasificacion> clasificacion;

    public Proveedor (String nombre, String CUIT, String localizacion, Enum<Clasificacion> clasificacion) {
        setNombre(nombre);
        setNombre(CUIT);
        setNombre(localizacion);
        setClasificacion(clasificacion);
    }

    public enum Clasificacion {MEDIOS_DE_TRANSPORTE, HOSPEDAJES, EXCURSIONES}

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getCUIT () {
        return CUIT;
    }

    public void setCUIT (String CUIT) {
        this.CUIT = CUIT;
    }

    public String getLocalizacion () {
        return localizacion;
    }

    public void setLocalizacion (String localizacion) {
        this.localizacion = localizacion;
    }

    public Enum<Clasificacion> getClasificacion () {
        return clasificacion;
    }

    public void setClasificacion (Enum<Clasificacion> clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString () {
        return CUIT + " - " + nombre + " - " + clasificacion.toString() + " - " + localizacion;
    }
}
