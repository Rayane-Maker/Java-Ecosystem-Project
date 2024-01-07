public class StaticFood extends GameObject {
    protected Boolean eatable;
    protected Double nutriscore;

    public StaticFood(Double nutriscore, Boolean eatable) {
        this.eatable = eatable;
        this.nutriscore = nutriscore;
    }

    public void displayInfo() {
        System.out.println("I am eatable :" + this.eatable + " (nutriscore :" + this.nutriscore + ")");
    }
}

