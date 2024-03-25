package ChT.sortstudent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Lista lista = new Lista();
        //IComparadorFactory comparadorFactory;

        LinkedList<Estudiante> listaEst = leerEstudiantesDesdeArchivo("src/ejercicioclase/data/data.txt");
        lista.setEstudiantes(listaEst);

        for (Estudiante est : lista.getEstudiantes()) {
            System.out.println(est.nombre);
        }
        System.out.println("______________________________________");

        IComparador comparador = ComparadorFactory.getInstance().getComparador("nombre");

        Ordenador ordenador = new Ordenador(comparador);

        ordenador.ordenar(lista.getEstudiantes());

        ordenador.print();
    }

    private static LinkedList<Estudiante> leerEstudiantesDesdeArchivo(String nombreArchivo) {
        LinkedList<Estudiante> listaDeEstudiantes = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    int edad = Integer.parseInt(datos[1].trim());
                    Double nota = Double.parseDouble(datos[2].trim());

                    Estudiante estudiante = new Estudiante();
                    estudiante.nombre = nombre;
                    estudiante.edad = edad;
                    estudiante.nota = nota;
                    listaDeEstudiantes.add(estudiante);
                } else {
                    System.out.println("Error en el formato de línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return listaDeEstudiantes;
    }
}
