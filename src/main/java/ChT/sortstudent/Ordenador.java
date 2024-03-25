package ChT.sortstudent;

import java.util.LinkedList;

public class Ordenador {
    //private OrdenarLista ordenarLista;
    private IComparador comparador;
    private LinkedList<Estudiante> estudiantes;

    public Ordenador(IComparador comparador) {
        this.comparador = comparador;
    }

    public void ordenar(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = 0; j < estudiantes.size() - 1; j++) {
                if (comparador.comparar(estudiantes.get(j), estudiantes.get(j + 1)) > 0) {
                    Estudiante temp = estudiantes.get(j);
                    estudiantes.set(j, estudiantes.get(j + 1));
                    estudiantes.set(j + 1, temp);
                }
            }
        }
    }

    public void print() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.nombre + " <--> " + estudiante.edad + " <--> " + estudiante.nota);
        }
    }
}
