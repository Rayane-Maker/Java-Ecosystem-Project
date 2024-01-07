public class Insect extends Animal{

    //Attributes
    public double mass; //In grams
    public double speed;


    //Constructors
    Insect(float _mass, double _speed){
        this(_mass);
    }

    Insect(double _mass){
        this();
        this.mass = _mass;
    }

    Insect(){
        this.mass = 5;
        this.speed = 10;
    }


    //Setters
    public void setMass(double _mass){
        this.mass = _mass < 0 ? this.mass : _mass;
    }
    public void setSpeed(double _speed) {
        this.speed = _speed;
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

    }

    @Override
    public void grow(int _deltaMass) {

    }

}