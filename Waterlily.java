/**
 * <b>This class inherits from GameObject and simulates a waterlily.</b>
 * <p>
 * Fly class redefine :
 * <ul>
 * <li>eat() method.</li>
 * <li>grow() method.</li>
 * <li>toString().</li>
 * </ul>
 * </p>
 * <p>
 * Fly inherits directly from Insect class which inherits
 * from Animal class.
 * </p>
 *
 *
 * @author Theo Thuiller
 * @version 1.0
 */

import Mathf.Vector2;

public class Waterlily extends GameObject {
    private Boolean isFree;
    private int capacity;
    private int occupantCount;
    private StaticFood[] foods;
    private Animal[] animals;

    private Vector2 pondGridPosition;

    public Waterlily(int capacity, Vector2 pondGridPosition) {
        super(); // Call parent class constructor using super()
        this.isFree = true;
        this.capacity = capacity;
        this.occupantCount = 0;
        this.foods = foods;
        this.pondGridPosition = pondGridPosition;
        this.animals = animals;
    }

    public Vector2 getPondGridPosition() {
        return this.pondGridPosition;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void displayInfo() {
        System.out.println("I am a Waterlily, I have" + this.occupantCount + "Amphibians on me, and my capacity is" + this.capacity + "!");
    }

    public boolean isFree() {
        return this.capacity > this.occupantCount;
    }


    public void listenAnimals() {
        if (this.animals != null) {
            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
    }

    /**
     * allows to add food (class StaticFood) to the waterlily (attribute "foods")
     * if food is already on the waterlily, extends the length of attribute "foods" and adds food
     * else creates simply new food
     * @param food
     */
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

    /**
     * if there is enough space on the waterlily, adds an animal
     * increments attribute "occupantCount"
     * put back already present animals and adds a new animal (class Animal)
     * updates animal's position
     * @param animal
     * @return
     */
    public boolean addAnimal(Animal animal) {
        if (isFree()) {
            this.occupantCount++;
            Animal[] newAnimals = new Animal[this.occupantCount];
            newAnimals[0] = animal;

            if (animals != null) {
                for (int i = 1; i < occupantCount; i++){
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

    /**
     * if there is an animal (class Animal) on the waterlily, removes it from the attribute "animals"
     * creates an array of Animal without the removed animal an put it back in the attribute "anumals"
     * @param animal
     * @return
     */
    public boolean removeAnimal(Animal animal) {
        if (this.occupantCount > 0) {
            this.occupantCount--;
            Animal[] newAnimals = new Animal[this.occupantCount];

            for (int i = 0; i < occupantCount; i++){
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
