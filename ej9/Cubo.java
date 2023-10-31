package ar.edu.unlu.poo.ej9;

public class Cubo extends Cuerpo {
    private Double arista;

    public Cubo (double arista) {
        setArista(arista);
    }

    public Double getArista() {
        return arista;
    }

    public void setArista(Double arista) {
        this.arista = arista;
    }

    @Override
    public Double getArea() {
        return (double) (6 * Math.pow(arista, 3));
    }

    @Override
    public Double getVolumen() {
        return (double) (Math.pow(arista, 3));
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "arista=" + arista +
                '}';
    }
}
