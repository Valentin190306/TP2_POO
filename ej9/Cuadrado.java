package ar.edu.unlu.poo.ej9;

public class Cuadrado extends Figura {
    private Double lado;

    public Cuadrado (double lado) {
        setLado(lado);
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public Double getArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                '}';
    }
}
