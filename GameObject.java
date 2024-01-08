/**
 * <b>This class equips objects with coordinates.</b>
 *
 * @author Theo Thuiller
 * @version 1.0
 */

import Mathf.Vector2;

public class GameObject {
    public Vector2 position;
    public double rotation;

    GameObject(){
        position = new Vector2(0.0,0.0);
    }

}
