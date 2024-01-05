public class Insect {
    //Attributes
    private double mass; //In grams
    private double speed;

    // Constructors
    Insect(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    //setters
    public void setMass(double mass){this.mass = mass < 0 ? this.mass : mass;}
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

    //Specifics methods
    public void grow(int _deltaMass){

        //Make mass change impact speed performance
        float speedIncrFactor = 1;
        float speedDecrFactor = -0.5f;
        speed += mass < 20 ? _deltaMass * speedIncrFactor : _deltaMass * speedDecrFactor;

        //Increase mass
        mass += _deltaMass;
    }

    public void eat(Fly fly){

    }

    public boolean isDead(){
        return mass <= 0;
    }
}