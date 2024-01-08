import Mathf.Vector2;

public class Biologic extends GameObject{
    public Vector2 pondGridPosition;
    protected int nutriscore;

    public Biologic(){
        super();
        pondGridPosition = new Vector2(0, 0);
    }

    public void setNutriscore(int nutriscore){this.nutriscore = nutriscore < 0 ? this.nutriscore : nutriscore;}

}
