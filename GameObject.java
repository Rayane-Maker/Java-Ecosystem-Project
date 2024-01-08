import Mathf.Vector2;

public class GameObject {
    public Vector2 position;
    public double rotation;

    // Constructeur par défaut
    GameObject() {
        position = new Vector2(0.0, 0.0);
        rotation = 0.0;
    }

    // Constructeur avec des paramètres
    GameObject(Vector2 position) {
        this.position = position;
        this.rotation = 0.0;
    }

    // Constructeur avec des paramètres pour position et rotation
    GameObject(Vector2 position, double rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    // Méthode pour définir la position
    public void setPosition(Vector2 newPosition) {
        this.position = newPosition;
    }

    // Méthode pour définir la rotation
    public void setRotation(double newRotation) {
        this.rotation = newRotation;
    }
}
