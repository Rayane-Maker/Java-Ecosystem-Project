
/**
 * <b>This class inherits from Insect class and simulates a dragonfly.</b>
 * <p>
 * Dragonfly class redefine :
 * <ul>
 * <li>eat() method.</li>
 * <li>grow() method.</li>
 * <li>toString().</li>
 * </ul>
 * </p>
 * <p>
 * Firefly inherits directly from Insect class which inherits
 * from Animal class.
 * </p>
 *
 *
 * @author Theo Thuiller
 * @version 1.0
 */

public class Dragonfly extends Insect{

    //Constructors
    Dragonfly(double _mass, double _speed){
        super(_mass, _speed);
        this.nutriscore = 6;

    }

    Dragonfly(double _mass){
        super(_mass);
        this.nutriscore = 6;

    }

    Dragonfly(){
        super();
        this.nutriscore = 6;

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
            return String.format("I'm dead, but I used to be a Dragonfly with a speed of %.2f", this.speed);
        }

        return String.format("I'm a speedy Dragonfly with %.2f speed and %.2f mass", speed, mass);
    }


    @Override
    public void eat(Biologic food){
        super.eat(food);
        if (food instanceof Animal animalFood) { //Pattern variable
            if (animalFood.isDead()) {
                this.grow(animalFood.nutriscore);
            }
        }
    }


    @Override
    public void grow(int _deltaMass){

        //Make mass change impact speed performance
        float speedIncrFactor = 1;
        float speedDecrFactor = -0.5f;
        speed += mass < 20 ? _deltaMass * speedIncrFactor : _deltaMass * speedDecrFactor;

        //Increase mass
        mass += _deltaMass;
    }

}
