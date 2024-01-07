public class Waterlily extends GameObject {
    private Boolean isFree;
    private int capacity;
    private int occupentCount;
    private StaticFood[] food;
    private Animal[] animals;
    public Waterlily(int capacity, StaticFood[] food, Animal[] animals) {
        super(); // Call parent class constructor using super()
        this.isFree = true;
        this.capacity = capacity;
        this.occupentCount = 0;
        this.food = food;
    }

    // Override method from parent class
    public void displayInfo() {
        System.out.println("I am a Waterlily, I have" + this.occupentCount + "Amphibians on me, and my capacity is" + this.capacity + "!");
    }

    // Additional method specific to Dog class
    public void isFree() {
        if (this.capacity - this.occupentCount > 0) {
            this.isFree = true;
        } else {
            this.isFree = false;
        }
    }

    public void arrive() {
        if (this.isFree) {
            this.occupentCount++;
        }
    }

    public void quit() {
        if (this.occupentCount > 0) {
            this.occupentCount--;
        }
    }
}
