public abstract class Animal extends Biologic {

    double mass;
    double speed;
    int nutriscore;

    public  Animal(){
        super(); // Call parent class constructor using super()
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
    public double getNutriscore(){
        return this.nutriscore;
    }

    //Specifics methods

    /**
     * Try to eat a biologic food.
     * It can be an animal (dead or not) or  a static food.
     * @param food
     *            The biologic element to try to feed the animal.
     */
    public abstract void eat(Biologic food);


    /**
     * Grow the animal by increasing it key
     * characteristic by delta.
     * Each child class instances has its own
     * implementation onn how growing affect the
     * animal ability.
     * @param _delta
     *            Drive how grow the animal.
     */
    public abstract void grow(int _delta);




    public boolean isDead(){
        return mass <= 0;
    }

}
