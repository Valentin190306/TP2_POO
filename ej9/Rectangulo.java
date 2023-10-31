package ar.edu.unlu.poo.ej9;

public class Rectangulo extends Figura {
    private Double base;
    private Double altura;

    public Rectangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public Double getBase() {
        return base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public Double getArea() {
        return base * altura;
    }

    @Override
    public String toString() {
        return "Paralelogramo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}
