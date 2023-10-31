package ar.edu.unlu.poo.ej9;

public class Paralelepipedo extends Cuerpo {
    private Double arista1;
    private Double arista2;
    private Double arista3;

    public Paralelepipedo (double arista1, double arista2, double arista3) {
        setArista1(arista1);
        setArista2(arista2);
        setArista3(arista3);
    }

    public Double getArista1() {
        return arista1;
    }

    public void setArista1(Double arista1) {
        this.arista1 = arista1;
    }

    public Double getArista2() {
        return arista2;
    }

    public void setArista2(Double arista2) {
        this.arista2 = arista2;
    }

    public Double getArista3() {
        return arista3;
    }

    public void setArista3(Double arista3) {
        this.arista3 = arista3;
    }

    @Override
    public Double getArea () {
        return (double) (2 * (arista1 * arista2 + arista1 * arista3 + arista2 * arista3));
    }

    @Override
    public Double getVolumen() {
        return (double) (arista1 * arista2 * arista3);
    }

    @Override
    public String toString() {
        return "Paralelepipedo{" +
                "arista1=" + arista1 +
                ", arista2=" + arista2 +
                ", arista3=" + arista3 +
                '}';
    }
}
