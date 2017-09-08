package cardGame;

import cardGame.utils.Assets;

/**
 * Created by Joaco99 on 08/09/2017.
 */

public class Buttom {

    private boolean touched;


    public void touched(){
        touched = !touched;
        if(touched){
            action();
        }
    }

    public void action(){

    }

    public String image(){
        //TODO change
        return "tommy";
    }
}
