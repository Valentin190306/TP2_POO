package ar.edu.unlu.poo.ej9;

public class Circulo extends Figura {
    private Double radio;

    public Circulo (double radio) {
        setRadio(radio);
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }
}
