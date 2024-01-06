public class Waterlily extends Plant {
    private Boolean isFree;
    private int capacity;
    private int occupentCount;

    public Waterlily(Double nutriscore, Boolean eatable, Boolean isFree) {
        super(nutriscore, eatable); // Call parent class constructor using super()
        this.isFree = isFree;
        this.capacity = capacity;
        this.occupentCount = occupentCount;
    }

    // Override method from parent class
    @Override
    public void displayInfo() {
        System.out.println("I am a Waterlily, I have" + this.occupentCount + "Amphibians on me, and my capacity is" + this.capacity + "!");
    }

    // Additional method specific to Dog class
    public void isFree() {
        if (this.capacity - this.occupentCount > 0) {
            this.isFree = Boolean.TRUE;
        } else {
            this.isFree = Boolean.FALSE;
        }
    }
}
