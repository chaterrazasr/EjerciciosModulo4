package ChT.sortstudent;

public class ComparadorNota implements IComparador{
    @Override
    public int comparar(Estudiante a, Estudiante b) {
        return Double.compare(a.nota, b.nota);
    }
}
