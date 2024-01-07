public class Flower extends StaticFood {

    static int DEFAULT_NUTRISCORE = 4;

    Flower() {
        super(DEFAULT_NUTRISCORE); // Call parent class constructor using super()
    }

    Flower(int nutriscore) {
        super(nutriscore); // Call parent class constructor using super()
    }

    public void displayInfo() {
        System.out.println("I am a Flower and my nutriscore worth" + nutriscore + "!");
    }
}
