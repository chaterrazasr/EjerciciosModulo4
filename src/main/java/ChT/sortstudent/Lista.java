package ChT.sortstudent;

import java.util.LinkedList;

public class Lista {
    LinkedList<Estudiante> estudiantes;

    public Lista() {
        estudiantes = new LinkedList<>();
    }

    public void add(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> listaEst) {
        estudiantes = listaEst;
    }
}
