public class Flower extends StaticFood {

    public Flower(Double nutriscore) {
        super(nutriscore, true); // Call parent class constructor using super()
    }

    public void displayInfo() {
        System.out.println("I am a Flower and my nutriscore worth" + nutriscore + "!");
    }
}
