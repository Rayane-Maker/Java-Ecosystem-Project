public class Plant extends GameObject {
    private Boolean eatable;
    private Double nutriscore;

    public Plant(Double nutriscore, Boolean eatable) {
        this.eatable = eatable;
        this.nutriscore = nutriscore;
    }

    public void displayInfo() {
        System.out.println("I am eatable :" + this.eatable + " (nutriscore :" + this.nutriscore + ")");
    }
}

