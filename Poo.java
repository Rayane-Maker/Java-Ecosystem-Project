public class Poo extends StaticFood {

    public Poo(Double nutriscore) {
        super(nutriscore, true); // Call parent class constructor using super()
    }

    public void displayInfo() {
        System.out.println("I am a Poo and my nutriscore worth" + nutriscore + "!");
    }
}
