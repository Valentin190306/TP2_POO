package ar.edu.unlu.poo.ej9;

public class Triangulo extends Figura {
    private Double base;
    private Double altura;

    public Triangulo (double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public Double getArea() {
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}
