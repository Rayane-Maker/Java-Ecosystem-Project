/**
 * <b>This class equips objects with coordinates.</b>
 *
 * @author Theo Thuiller
 * @version 1.0
 */

import Mathf.Vector2Double;

public class GameObject {
    public Vector2Double position;
    public double rotation;

    GameObject(){
        position = new Vector2Double(0.0,0.0);
    }

}
