package cardGame;

/**
 * Created by Joaco99 on 06/09/2017.
 */

public interface Selectable {
    //TODO improve

    boolean isSelected();

    void select();

    void selectedAfter(Selectable s);

}
