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
