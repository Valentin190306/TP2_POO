package ar.edu.unlu.poo.ej214;

public abstract class Proveedor {
    protected String nombre;
    protected String CUIT;
    protected String localizacion;
    protected Integer MinProv = 0;

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

    public Integer getMinProv() {
        return MinProv;
    }

    public void setMinProv(Integer minProv) {
        MinProv = minProv;
    }

    @Override
    public String toString () {
        return CUIT + " - " + nombre + " - " + localizacion;
    }
}
