public class Poo extends StaticFood {

    static int DEFAULT_NUTRISCORE = 8;
    Poo() {
        super(DEFAULT_NUTRISCORE); // Call parent class constructor using super()
    }

    Poo(int nutriscore) {
        super(nutriscore); // Call parent class constructor using super()
    }

    public void displayInfo() {
        System.out.println("I am a Poo and my nutriscore worth" + nutriscore + "!");
    }
}
