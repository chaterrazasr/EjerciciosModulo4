package ChT.frames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Board {

    char[][] board;
    private int size;

    String urlText = "src/frames/map/tableroDibujado.txt";

    public Board(int alto, int ancho) {
        board = new char[alto][ancho];
    }

    public void draw(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        board[x][y] = 1;
    }
    public void dibujarTablero() {
        System.out.println("Tab: "+board[0].length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public char[][] getBoard() {
        try (BufferedReader br = new BufferedReader(new FileReader(urlText))) {
            String fila;
            for (int i = 0; i < board.length; i++){
                fila = br.readLine();
                for (int j = 0; j < board[i].length; j++){
                    board[i][j] = fila.charAt(j);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }
}
