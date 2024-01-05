public class Fly {

    //Attributes
    public double mass; //In grams
    public double speed;


    //Constructors
    Fly(float _mass, double _speed){
        this(_mass);
    }

    Fly(double _mass){
        this();
        this.mass = _mass;
    }

    Fly(){
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


    //Specifics methods
    @Override
    public String toString() {
        //return super.toString();
        if (this.mass <= 0){
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f", this.speed);
        }

        return String.format("I'm a speedy fly with %.2f speed and %.2f mass", speed, mass);
    }

    public void grow(int _deltaMass){

        //Make mass change impact speed performance
        float speedIncrFactor = 1;
        float speedDecrFactor = -0.5f;
        speed += mass < 20 ? _deltaMass * speedIncrFactor : _deltaMass * speedDecrFactor;

        //Increase mass
        mass += _deltaMass;
    }

    public boolean isDead(){
        return mass <= 0;
    }
}
