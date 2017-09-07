package cardGame;

/**
 * Created by Joaco99 on 06/09/2017.
 */

public interface Selectable {
    //TODO improve

    public boolean isSelected();

    public void select();

    public void selectedAfter(Selectable s);

}
