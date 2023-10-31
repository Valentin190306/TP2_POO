package ar.edu.unlu.poo.ej9;

public class Esfera extends Cuerpo {
    private Double radio;

    public Esfera (double radio) {
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
        return (double) (4 * Math.PI * Math.pow(radio, 2));
    }

    @Override
    public Double getVolumen() {
        return (double) ((4/3) * Math.pow(radio, 3));
    }

    @Override
    public String toString() {
        return "Esfera{" +
                "radio=" + radio +
                '}';
    }
}
