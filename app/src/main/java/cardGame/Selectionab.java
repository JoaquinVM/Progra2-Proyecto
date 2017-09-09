package cardGame;

/**
 * Created by Joaco99 on 06/09/2017.
 */

public interface Selectionab {

    boolean isSelected();

    void select();

    void selectedAfter(Selectionab s);

}
