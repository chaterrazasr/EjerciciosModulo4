package ChT.frames;

public class Frame {
    int[] posESIXY; //posicion de la esquina superior izquierda en el eje x y en el eje y
    int[] posESDXY; //posicion de la esquina superior derecha en el eje x y en el eje y
    int[] posEIIXY; //posicion de la esquina inferior izquierda en el eje x y en el eje y
    int[] posEIDXY; //posicion de la esquina inferior derecha en el eje x y en el eje y
    int lon;

    public Frame(int[] posESIXY, int[] posESDXY, int[] posEIIXY, int[] posEIDXY, int lon) {
        this.posESIXY = posESIXY;
        this.posESDXY = posESDXY;
        this.posEIIXY = posEIIXY;
        this.posEIDXY = posEIDXY;
        this.lon = lon;
    }

    public Frame() {
        this.posESIXY = new int[2];
        this.posESDXY = new int[2];
        this.posEIIXY = new int[2];
        this.posEIDXY = new int[2];
        this.lon = 0;
    }

    public int[] getPosESIXY() {
        return posESIXY;
    }

    public void setPosESIXY(int[] posESIXY) {
        this.posESIXY = posESIXY;
    }

    public int[] getPosESDXY() {
        return posESDXY;
    }

    public void setPosESDXY(int[] posESDXY) {
        this.posESDXY = posESDXY;
    }

    public int[] getPosEIIXY() {
        return posEIIXY;
    }

    public void setPosEIIXY(int[] posEIIXY) {
        this.posEIIXY = posEIIXY;
    }

    public int[] getPosEIDXY() {
        return posEIDXY;
    }

    public void setPosEIDXY(int[] posEIDXY) {
        this.posEIDXY = posEIDXY;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}
