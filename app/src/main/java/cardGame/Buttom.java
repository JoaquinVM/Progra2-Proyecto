package cardGame;

/**
 * Created by Joaco99 on 07/09/2017.
 */

public abstract class Buttom {
    boolean touched = false;

    public void touched(){
        touched = !touched;
    }

    void justTouched(){

    }
}

