import Mathf.Vector2;

public class Waterlily extends GameObject {
    private Boolean isFree;
    private int capacity;
    private int occupentCount;
    private StaticFood[] foods;
    private Animal[] animals;

    private Vector2 pondGridPosition;

    public Waterlily(int capacity, Vector2 pondGridPosition) {
        super(); // Call parent class constructor using super()
        this.isFree = true;
        this.capacity = capacity;
        this.occupentCount = 0;
        this.foods = new StaticFood[0]; // Initialize foods array properly
        this.pondGridPosition = pondGridPosition;
        this.animals = new Animal[0]; // Initialize animals array properly
    }

    public Vector2 getPondGridPosition() {
        return this.pondGridPosition;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void displayInfo() {
        System.out.println("I am a Waterlily, I have" + this.occupentCount + "Amphibians on me, and my capacity is" + this.capacity + "!");
    }

    public boolean isFree() {
        return this.capacity > this.occupentCount;
    }


    public void listenAnimals() {
        if (this.animals != null) {
            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
    }

    public void addFood(StaticFood food) {
        StaticFood[] newStaticFoods;

        if (this.foods != null) {
            newStaticFoods = new StaticFood[this.foods.length + 1];
            newStaticFoods[0] = food;

            for (int i = 1; i < newStaticFoods.length; i++) {
                newStaticFoods[i] = this.foods[i-1];
            }
        }else{
            newStaticFoods = new StaticFood[1];
            newStaticFoods[0] = food;
        }
        this.foods = newStaticFoods;
    }
    public boolean addAnimal(Animal animal) {
        if (isFree()) {
            this.occupentCount++;
            Animal[] newAnimals = new Animal[this.occupentCount];
            newAnimals[0] = animal;

            if (animals != null) {
                for (int i = 1; i < occupentCount; i++){
                    newAnimals[i] = this.animals[i-1];
                }
            }
            this.animals = newAnimals;

            animal.position = this.position;
            animal.pondGridPosition = this.pondGridPosition;
            return true;
        }
        return false;
    }

    public boolean removeAnimal(Animal animal) {
        if (this.occupentCount > 0) {
            this.occupentCount--;
            Animal[] newAnimals = new Animal[this.occupentCount];

            for (int i = 0; i < occupentCount; i++){
                if (animal != this.animals[i]){
                    newAnimals[i] = this.animals[i];
                }
            }
            this.animals = newAnimals;
            return true;
        }
        return false;
    }
}
