public class Amphibian extends Animal {

    public String name;
    public int age; //In months

    static public String species;


    //Constructors
    Amphibian(String _name, double ageInYears){
        this(_name);
        this.age = (int)(ageInYears * 12);
    }

    Amphibian(String _name){
        super(); // Call parent class constructor using super()
        this.name = _name;
        this.age = 5;
        Amphibian.species = "Rare Pepe";
    }



    @Override
    public void eat(Biologic food) {

    }

    @Override
    public void grow(int _deltaMass) {

    }




}
