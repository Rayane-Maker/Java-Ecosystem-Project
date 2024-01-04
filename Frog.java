public class Frog {


    //Attributes
    public String name;
    public int age; //In months

    public double tongueSpeed;

    public boolean isFroglet;

    static public String species;


    //Constructors
    Frog(String _name, double _ageInYears, double _tongueSpeed){
        this(_name, _ageInYears);
        this.tongueSpeed = _tongueSpeed;
    }
    Frog(String _name, double ageInYears){
        this(_name);
        this.age = (int)(ageInYears * 12);
    }

    Frog(String _name){
        this.name = _name;
        this.age = 5;
        this.tongueSpeed = 5;
        Frog.species = "Rare Pepe";
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

    public void eat(Fly fly){

        //Early quit the method if the fly is dead
        if (fly.isDead()){
           return;
        }

        //Kill the fly or make it stronger
        if (tongueSpeed > fly.speed){
            fly.setMass(0);
        }else {
            fly.grow(1);
        }
    }

    @Override
    public String toString() {
        //return super.toString();
        if (isFroglet){
            return String.format("“My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }

        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }




}