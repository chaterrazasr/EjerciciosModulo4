package ChT.frames;


import java.util.LinkedList;

public class Buscador {
    char esqSupIzq = '┌';
    char esqSupDer = '┐';
    char esqInfIzq = '└';
    char esqInfDer = '┘';
    char lineaHor = '─';
    char lineaVer = '│';
    char[][] mapa;
    LinkedList<Frame> cuadrados = new LinkedList<>();
    LinkedList<int[]> posicionesInterseccion = new LinkedList<>();

    public Buscador(char[][] mapa) {
        this.mapa = mapa;
    }

    //char[][] interseccion = {'┼', '┬', '┤', '┴', '├'};
    char[][] interALadoIzq = {
            {esqInfIzq, esqSupIzq},  // └┌,
            {esqSupIzq, esqSupIzq},  // ┌┌,
            {lineaHor, esqSupIzq}, //   ─┌
            {lineaHor, lineaVer},   //  ─│
            {esqInfIzq, lineaVer},  //  └│
            {esqSupIzq, lineaVer},  //  ┌│
            {lineaHor, esqInfIzq},  //  ─└
            {esqInfIzq, esqInfIzq},  // └└
            {esqSupDer, esqInfIzq},  // ┌└
            //7
    };
    char[][] interALadoDer = {
            {esqSupDer, esqInfDer},  // ┐┘
            {esqSupDer, esqSupDer},  // ┐┐
            {esqSupDer, lineaHor},  //  ┐─
            {lineaVer, lineaHor},   //  │─
            {lineaVer, esqSupDer},  //  │┐
            {lineaVer, esqInfDer},  //  │┘
            {esqInfDer, lineaVer},  //  ┘─
            {esqInfDer, esqInfDer},  // ┘┘
            {esqInfDer, esqSupDer},  // ┘┐
            // 7 -- 7
    };

    char[][] interArriba = {
            // ┌│ ┌    │  ┐ │┐
            // ┌┌ ─ ─ ─ ─ ─ ┐┐
            //                          ┐
            {esqSupIzq, esqSupDer},  // ┌
            //                        ┌
            {esqSupIzq, esqInfIzq},  // ┌
            //                              │
            {esqSupIzq, lineaVer},  //      ┌
            //                         ┌
            {lineaHor, esqSupIzq},  // ─

            //                        │
            {lineaHor, lineaVer},  // ─
            //                              ┐
            {lineaHor, esqSupDer},  //      ─

            //                          │
            {esqSupDer, lineaVer},  //  ┐
            //                              ┐
            {esqSupDer, esqInfDer},  //     ┐
            //                          ┌
            {esqSupDer, esqSupIzq},  // ┐

            // 7-7-6
    };
    char[][] interAbajo = {
            //
            // └└ ─ ─ ─ ─ ─ ┘┘
            // └│ └   │ ┘   │┘
            //                          └
            {esqInfIzq, esqInfDer},  // ┘
            //                          └
            {esqInfIzq, esqSupIzq},  // └
            {esqInfIzq, lineaVer},  // └
            //                         │
            //                         ─
            {lineaHor, esqInfIzq},  // └
            //                         ─
            {lineaHor, lineaVer},  //  │
            {lineaHor, esqInfDer},  // ─
            //                         ┘
            //                          ┘
            {esqInfDer, lineaVer},  //  │
            {esqInfDer, esqInfDer}, // ┘
            //                         ┘
            {esqInfDer, esqInfIzq},  // ┘
            //                          └
            // 7-7-7-7
    };

    public void encontrarEsqSupIzq(char[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if (mapa[i][j] == esqSupIzq) {
                    esCuadradoCompleto(mapa, i, j);
                    //esCuadradoConDobleEsquina(mapa, i, j);
                }
            }
        }
        impFrames();
        //imprimirEsquinasDoble();
    }

    public void buscarCuadrosIntersectadosACadaCuadroCompletoEncontrado() {
        for (Frame frame : cuadrados) {
            buscarCuadrosIntersectados(frame);
        }
    }

    private void buscarCuadrosIntersectados(Frame frame) {
        int[] posESI = frame.getPosESIXY();
        int[] posESD = frame.getPosESDXY();
        int[] posEII = frame.getPosEIIXY();
        int[] posEID = frame.getPosEIDXY();
        int lon = frame.getLon();
        System.out.println("Buscando cuadros intersectados");
        //System.out.println("PosESI: " + posESI[0] + " " + posESI[1] + "lon: " + lon);
        for (int i = posESI[0]; i < mapa.length; i++) { // 4 5 6 7
            for (int j = posESI[1]; j < mapa[0].length; j++) {
                //System.out.println("i: " + i + " j: " + j);
                for (int k = 0; k < interAbajo.length; k++) {
                    revInterAladoIzq(mapa, i, j, k);
                    revInterAladoDer(mapa, i, j, k);
                    revInterArriba(mapa, i, j, k);
                    revInterAbajo(mapa, i, j, k);
                }
            }
        }
    }

    private void revInterAladoIzq(char[][] mapa, int i, int j, int k) {
        if (mapa[i][j - 1] == interALadoIzq[k][0] && mapa[i][j] == interALadoIzq[k][1]) {
            System.out.println("Izquierda : " + i + " " + j + " Interseccion: " + interALadoIzq[k][0]
                    + "interseccion: " + interALadoIzq[k][1]);
            posicionesInterseccion.add(new int[]{i, j});
        }
    }

    private void revInterAladoDer(char[][] mapa, int i, int j, int k) {
        if (mapa[i][j] == interALadoDer[k][0] && mapa[i][j + 1] == interALadoDer[k][1]) {
            System.out.println("Derecha : " + i + " " + j + " Interseccion: " + interALadoDer[k][0]
                    + "interseccion: " + interALadoDer[k][1]);
            posicionesInterseccion.add(new int[]{i, j});
        }
    }

    private void revInterArriba(char[][] mapa, int i, int j, int k) {
        if (mapa[i][j] == interArriba[k][0] && mapa[i - 1][j] == interArriba[k][1]) {
            System.out.println("Arriba : " + i + " " + j + " Interseccion: " + interArriba[k][0]
                    + "interseccion: " + interArriba[k][1]);
            posicionesInterseccion.add(new int[]{i, j});
        }
    }

    private void revInterAbajo(char[][] mapa, int i, int j, int k) {
        if (mapa[i][j] == interAbajo[k][0] && mapa[i + 1][j] == interAbajo[k][1]) {
            System.out.println("Abajo : " + i + " " + j + " Interseccion: " + interAbajo[k][0]
                    + "interseccion: " + interAbajo[k][1]);
            posicionesInterseccion.add(new int[]{i, j});
        }
    }


    private int verificarEsqSupIzq(char[][] mapa, int i, int j) {
        int contLineaHor = 1;
        for (int h = i; h < mapa.length; h++) {
            contLineaHor++;
            if (mapa[h][j] == esqInfIzq) {
                return contLineaHor;
            }
            if (mapa[h][j] != lineaVer) {
                return contLineaHor;
            }
        }
        return contLineaHor;
    }

    private int verificarEsqSupDer(char[][] mapa, int i, int j) {
        int contLineaHor = 1;
        for (int h = j; h < mapa[0].length; h++) {
            contLineaHor++;
            if (mapa[i][h] == esqSupDer) {
                //System.out.println("ESD : " + i + " " + h);
                //System.out.println("Lon: " + contLineaHor);
                return contLineaHor;
            }
            if (mapa[i][h] != lineaHor) {
                return 0;
            }

        }
        return contLineaHor;
    }

    private int verificarEsqInfIzq(char[][] mapa, int i, int j) {
        int contLineaHor = 1;
        /*
          matriz = [
                j    j    j    j
                0    1    2    3
          i 0 ['┌', '─', '─', '┐'],
          i 1 ['│', ' ', ' ', '│'],
          i 2 ['│', ' ', ' ', '│'],
          i 3 ['└', '─', '─', '┘']]
         */
        for (int h = i; h < mapa.length; h++) {
            contLineaHor++;
            if (mapa[h][j] == esqInfIzq) {
                System.out.println("EII: " + h + " " + j);
                //System.out.println("Lon: " + contLineaHor);
                return contLineaHor;

            }
            if (mapa[h][j] != lineaVer) {
                return contLineaHor;
            }
        }
        return contLineaHor;
    }

    private int verificarEsqInfDer(char[][] mapa, int i, int j) {
        int contLineaHor = 1;
        //3 + 1 = 4
        //6 + 3 - 1 = 8
        for (int h = i; h < mapa.length; h++) {
            contLineaHor++;
            if (mapa[h][j] == esqInfDer) {
                //System.out.println("EID: " + h + " " + j);
                //System.out.println("Lon: " + contLineaHor);
                return contLineaHor;
            }
            if (mapa[h][j] != lineaVer) {
                return 0;
            }

        }
        return contLineaHor;
    }

    public void esCuadradoCompleto(char[][] mapa, int i, int j) {

        int lonEsqSupDer = verificarEsqSupDer(mapa, i, j + 1);
        int lonEsqInfIzq = verificarEsqInfIzq(mapa, i + 1, j);
        int lonEsqInfDer = verificarEsqInfDer(mapa, i + 1, j + lonEsqSupDer - 1);

        if (lonEsqSupDer == lonEsqInfIzq && lonEsqInfIzq == lonEsqInfDer) {
            int[] posESI = new int[]{i, j};
            int[] posESD = new int[]{i, j + lonEsqInfDer - 1};
            int[] posEII = new int[]{i + lonEsqInfIzq - 1, j};
            int[] posEID = new int[]{i + lonEsqInfIzq - 1, j + lonEsqInfDer - 1};
            int lon = lonEsqSupDer;
            Frame frame = new Frame(posESI, posESD, posEII, posEID, lon);

            cuadrados.add(frame);
            System.out.println("Es un cuadrado completo");
        }
    }

    private void impFrames() {
        System.out.println("Cuadrados encontrados : " + cuadrados.size());
        for (Frame frame : cuadrados) {
            System.out.println("Esquina Sup Izq: " + frame.getPosESIXY()[0] + " " + frame.getPosESIXY()[1]);
            System.out.println("Esquina Sup Der: " + frame.getPosESDXY()[0] + " " + frame.getPosESDXY()[1]);
            System.out.println("Esquina Inf Izq: " + frame.getPosEIIXY()[0] + " " + frame.getPosEIIXY()[1]);
            System.out.println("Esquina Inf Der: " + frame.getPosEIDXY()[0] + " " + frame.getPosEIDXY()[1]);
            System.out.println("Longitud: " + frame.getLon());
        }
    }
}
