public class Animal extends Biologic {
    protected String name;

    protected double mass;
    protected double speed;

    public Waterlily currentWaterlily;

    public  Animal(){
        super(); // Call parent class constructor using super()
        this.name = "Anonymous";
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

    public void move(int rowID, int waterlilyID, Row[] pond) {

        Waterlily targetWaterlily = pond[rowID].waterlilies[waterlilyID];

        //Update Waterlily
        if (currentWaterlily != null) {
            currentWaterlily.removeAnimal(this);
        }

        targetWaterlily.addAnimal(this);
        currentWaterlily = targetWaterlily;

    }

    /**
     * Try to eat a biologic food.
     * It can be an animal (dead or not) or  a static food.
     * @param food
     *            The biologic element to try to feed the animal.
     */
    public void eat(Biologic food){
    }

    /**
     * Grow the animal by increasing it key
     * characteristic by delta.
     * Each child class instances has its own
     * implementation of how growing affect the
     * animal ability.
     * @param _delta
     *            Drive how grow the animal.
     */
    public void grow(int _delta){

    }




    public boolean isDead(){
        return this.mass <= 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
