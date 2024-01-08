import Mathf.Vector2;

public class Row extends GameObject {

    protected Waterlily[] waterlilies;

    // Constructor without pondGridPosition
    public Row(Waterlily[] waterlilies) {
        super();
        this.waterlilies = waterlilies;
    }

    // Constructor with pondGridPosition
    public Row(Waterlily[] waterlilies, Vector2 pondGridPosition) {
        super(pondGridPosition);
        this.waterlilies = waterlilies;
    }
}
