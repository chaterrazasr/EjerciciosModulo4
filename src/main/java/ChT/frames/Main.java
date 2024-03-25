package ChT.frames;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(20, 50);
        Buscador buscador = new Buscador(board.getBoard());
        buscador.encontrarEsqSupIzq(board.getBoard());
        buscador.buscarCuadrosIntersectadosACadaCuadroCompletoEncontrado();
        board.getBoard();
        board.dibujarTablero();
    }
}