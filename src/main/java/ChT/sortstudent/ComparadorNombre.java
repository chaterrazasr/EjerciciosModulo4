package ChT.sortstudent;

public class ComparadorNombre implements IComparador{
    @Override
    public int comparar(Estudiante a, Estudiante b) {
        // lista de estudiante = [jose, maria]
        // jose compareTo maria = -1 -> jose va antes que maria  = Jose -> Maria
        // maria compareTo jose = 1 -> maria va despues que jose = Jose -> Maria
        return a.nombre.compareTo(b.nombre);
    }
}
