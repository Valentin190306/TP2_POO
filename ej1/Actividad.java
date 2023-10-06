package ar.edu.unlu.poo.ej1;

public class Actividad {
    private String nombre;
    private String descripcion;
    private Enum categoria;

    public Actividad (String nombre, String descripcion, Enum categoria) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
    }

    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Enum getCategoria() {
        return categoria;
    }

    protected void setCategoria(Enum categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString () {
        return nombre + " - " + descripcion + " - " + categoria.toString();
    }
}
