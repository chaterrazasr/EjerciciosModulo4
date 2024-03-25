package ChT.sortstudent;

import java.util.LinkedList;

public class ComparadorFactory implements IComparadorFactory {

    private static ComparadorFactory instance;

    private ComparadorFactory() {
    }

    static ComparadorFactory getInstance() {
        if (instance == null) {
            instance = new ComparadorFactory();
        }
        return instance;
    }
    @Override
    public IComparador getComparador(String tipo) {
        String[] listaDeCampos = tipo.split(" ");

        LinkedList<IComparador> comparadores = new LinkedList<>();
        for (String campo : listaDeCampos) {
            comparadores.add(obtenerComparador(campo));
        }
        return new ComparadorCombinado(comparadores);
    }



    private IComparador obtenerComparador(String tipo) {
        switch (tipo) {
            case "nombre":
                return new ComparadorNombre();
            case "edad":
                return new ComparadorEdad();
            case "nota":
                return new ComparadorNota();

            default:
                return null;
        }
    }
}
