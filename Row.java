/**
 * <b>This class inherits from GameObject class and simulates a row of waterlilies.</b>
 *
 * @author Antoine Diez--Latteur
 * @version 1.0
 */

public class Row extends GameObject{

    protected Waterlily[] waterlilies;

    public Row(Waterlily[] waterlilies) {
        super();
        this.waterlilies = waterlilies;
    }
}
