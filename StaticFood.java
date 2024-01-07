public class StaticFood extends Biologic {
    protected int nutriscore;

    public StaticFood(int nutriscore) {
        super(); // Call parent class constructor using super()
        this.nutriscore = nutriscore;
    }

    public void displayInfo() {
        System.out.println("I am eatable and my nutriscore is : " + this.nutriscore);
    }
}

