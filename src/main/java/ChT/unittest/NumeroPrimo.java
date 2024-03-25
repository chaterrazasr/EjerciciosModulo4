package ChT.unittest;

public class NumeroPrimo {
    int numero;

    public NumeroPrimo(int numero) {
        this.numero = numero;
    }
    public boolean esPrimo() {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }


}
