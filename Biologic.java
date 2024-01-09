import Mathf.Vector2Double;
import Mathf.Vector2Int;

public class Biologic extends GameObject{
    public Vector2Int pondGridPosition;
    protected int nutriscore;

    public Biologic(){
        super();
        pondGridPosition = new Vector2Int(0, 0);
    }

    public void setNutriscore(int nutriscore){this.nutriscore = nutriscore < 0 ? this.nutriscore : nutriscore;}

}
