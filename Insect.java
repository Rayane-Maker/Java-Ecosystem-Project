public class Insect extends Animal{

    //Constructors
    // constructeurs modifié car mass était un float
    Insect(double mass, double speed){
        this(mass);
        this.speed = speed;
    }

    Insect(double mass){
        this();
        this.mass = mass;
    }

    Insect(){
        this.mass = 5;
        this.speed = 10;
    }


    //Setters
    public void setMass(double mass){
        this.mass = mass < 0 ? this.mass : mass;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //Getters
    public double getMass(){
        return this.mass;
    }
    public double getSpeed() {
        return this.speed;
    }


    @Override
    public void eat(Biologic food) {
        super.eat(food);
    }

    @Override
    public void grow(int _deltaMass) {
        super.grow(_deltaMass);
    }

}