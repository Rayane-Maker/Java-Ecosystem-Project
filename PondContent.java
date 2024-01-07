public class PondContent {
    private Row[] rows;
    private Animal[] animals;

    PondContent(Row[] rows, Animal[] animals){
        this.rows = rows;
        this.animals = animals;
    }

    public Row[] getRows() {
        return rows;
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
