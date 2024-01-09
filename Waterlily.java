import Mathf.Vector2Double;
import Mathf.Vector2Int;

public class Waterlily extends GameObject {
    private Boolean isFree;
    private int capacity;
    private int occupentCount;
    private StaticFood[] foods;
    private Animal[] animals;

    private Vector2Int pondGridPosition;

    public Waterlily(int capacity, Vector2Int pondGridPosition) {
        super(); // Call parent class constructor using super()
        this.isFree = true;
        this.capacity = capacity;
        this.occupentCount = 0;
        this.foods = foods;
        this.pondGridPosition = pondGridPosition;
        this.animals = animals;
    }

    public Vector2Int getPondGridPosition() {
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


    public String[] listenAnimals() {
        String[] res = new String[0];
        if (this.animals != null) {
            res = new String[animals.length];
                for (int i = 0; i < animals.length; i++) {
                    res[i] = animals[i].toString(); //+ "("+pondGridPosition.x+")"; Uncomment to verify that animal voices are well shuffled in game
                }
        }
        return res;
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
