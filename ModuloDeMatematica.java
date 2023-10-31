import ar.edu.unlu.poo.ej9.*;

import java.util.ArrayList;
import java.util.List;

public class ModuloDeMatematica {
    public static void main (String[] args) {

        Figura cubo = new Cubo(12.0);
        Figura triangulo = new Triangulo(5.0, 12.0);

        Cuerpo esfera = new Esfera(8.0);
        Cuerpo paralelepipedo = new Paralelepipedo(15.0, 6.0, 35.0);

        List<Figura> figuras = new ArrayList<>();
        figuras.add(cubo);
        figuras.add(triangulo);

        List<Cuerpo> cuerpos = new ArrayList<>();
        cuerpos.add(esfera);
        cuerpos.add(paralelepipedo);

        System.out.println("Lista de areas: ");
        for (Figura figura: figuras) {
            System.out.println(figura.getArea().toString());
        }

        System.out.println("Lista de volumenes: ");
        for (Cuerpo cuerpo : cuerpos) {
            System.out.println(cuerpo.getVolumen().toString());
        }

    }
}
