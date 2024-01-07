package Mathf;

public class Vector2{
    public Double x;
    public Double y;

    public Vector2(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    public static Double distance (Vector2 vec1, Vector2 vec2){
        return Math.sqrt((vec1.x - vec2.x) * (vec1.x - vec2.x) + (vec1.y - vec2.y) * (vec1.y - vec2.y));
    }
}
