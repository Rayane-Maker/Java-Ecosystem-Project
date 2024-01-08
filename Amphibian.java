
/**
 * <b>This class inherits from Animal class and simulates a Amphibian.</b>
 * <p>
 * Amphibian class redefine :
 * <ul>
 * <li>eat() method.</li>
 * <li>grow() method.</li>
 * <li>toString().</li>
 * </ul>
 * </p>
 * <p>
 * Amphibian inherits directly from Animal.
 * </p>
 *
 *
 * @author Theo Thuiller
 * @version 1.0
 */
public class Amphibian extends Animal {

    public int age; //In months

    static public String species;
    protected double tongueSpeed;


    //Constructors
    Amphibian(String _name, double ageInYears){
        this(_name);
        this.age = (int)(ageInYears * 12);
    }

    Amphibian(String _name){
        super(); //Call parent class constructor using super()
        this.name = _name;
        this.age = 5;
        Amphibian.species = "Rare Pepe";
    }

    /**
     *If the insect (class Biologic) is alive and the tongue's speed is superior to the insect's speed, it kills it, displays a message and grows the amphibian
     * @param food
     *            The biologic element to try to feed the animal.
     */
    @Override
    public void eat(Biologic food) {
        if (food instanceof Insect insectFood) {

            //Early quit the method if the insect is dead
            if (insectFood.isDead()) {
                return;
            }

            //Kill the fly or make it stronger
            if (tongueSpeed > insectFood.speed) {
                insectFood.setMass(0);
                Class<?> _class = insectFood.getClass();

                System.out.printf("My name is %s and I just eat a %s%n", name, _class.getName());
                grow((int) (insectFood.nutriscore * insectFood.mass));
            } else {
                insectFood.grow(1);
            }
        }
    }

    @Override
    public void grow(int _deltaMass) {
        super.grow(_deltaMass);
    }

    @Override
    public String toString() {
        return String.format("My name is %s and I’m a rare amphibian. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }


}
