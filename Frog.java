public class Frog extends Amphibian{

    //Attributes
    public double tongueSpeed;

    public boolean isFroglet;



    //Constructors
    Frog(String _name, double _ageInYears, double _tongueSpeed){
        super(_name, _ageInYears);
        this.tongueSpeed = _tongueSpeed;
    }
    Frog(String _name, double ageInYears){
        super(_name);
        this.age = (int)(ageInYears * 12);
    }

    Frog(String _name){
        super(_name);
        this.tongueSpeed = 5;
    }


    //Setters
    public static void setSpecies(String _species) {
        Frog.species = _species;
    }

    //Getters
    public static String getSpecies() {
        return species;
    }


    //Specific methods
    @Override
    public void grow(int _deltaAge){

        //Make age change impact tongue speed performance
        float speedIncrFactor = 1;
        float speedDecrFactor = 1;
        tongueSpeed += age < 12 ? _deltaAge * speedIncrFactor :
                       age > 30 ? _deltaAge * speedDecrFactor : 0;

        //Increase age
        age += _deltaAge;

        //Constrain tongue speed
        tongueSpeed = tongueSpeed < 5 ? 5 : tongueSpeed;

        //Update froglet status
        isFroglet = age > 1 && age < 7;
    }

    public void grow(){
        grow(1);
    }

    @Override
    public void eat(Biologic food){

        if (food instanceof Insect insectFood) {
            //Early quit the method if the fly is dead
            if (insectFood.isDead()) {
                return;
            }

            //Kill the fly or make it stronger
            if (tongueSpeed > insectFood.speed) {
                insectFood.setMass(0);
            } else {
                insectFood.grow(1);
            }
        }
    }

    @Override
    public String toString() {
        //return super.toString();
        if (isFroglet){
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }

        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }




}