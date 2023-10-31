package ar.edu.unlu.poo.ej9;

public class Tetrahedro extends Cuerpo {
    private Double arista;

    public Tetrahedro (double arista) {
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
        return (double) (Math.pow(arista, 2) * Math.sqrt(3));
    }

    @Override
    public Double getVolumen() {
        return (double) (Math.pow(arista, 3) * (Math.sqrt(2) / 12));
    }

    @Override
    public String toString() {
        return "Tetrahedro{" +
                "arista=" + arista +
                '}';
    }
}
