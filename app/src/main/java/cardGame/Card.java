package cardGame;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Card {
    private int costo;
    private String nombre;

    public Card(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }
}
