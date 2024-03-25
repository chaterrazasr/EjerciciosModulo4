package ChT.sortstudent;

public class ComparadorEdad implements IComparador{
    @Override
    public int comparar(Estudiante a, Estudiante b) {
        return Integer.compare(a.edad, b.edad);
    }
}
