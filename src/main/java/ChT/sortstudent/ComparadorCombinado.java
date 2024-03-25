package ChT.sortstudent;

import java.util.LinkedList;

public class ComparadorCombinado implements IComparador{
    private LinkedList<IComparador> comparadores;

    public ComparadorCombinado(LinkedList<IComparador> comparadores) {
        this.comparadores = comparadores;
    }
    @Override
    public int comparar(Estudiante a, Estudiante b) {

        for (IComparador comparador : comparadores) {
            int resul = comparador.comparar(a, b);
            if (resul != 0) {
                return resul;
            }
        }
        return 0;
    }
}
