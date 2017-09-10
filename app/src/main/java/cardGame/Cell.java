package cardGame;

/**
 * Created by Joaco99 on 09/09/2017.
 */

public class Cell {
    private int v;
    private int h;
    private Object o;

    public Cell(int v, int h    ) {
        this.v = v;
        this.h = h;
    }

    public int getV() {
        return v;
    }

    public int getH() {
        return h;
    }

    public Object getObject() {
        return o;
    }

    public void setObject(Object o){
        this.o = o;
    }
}
