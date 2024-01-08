import Mathf.Vector2;
import java.util.stream.IntStream;

import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.random;

public class Pond {

    final static int ROW_COUNT_MIN = 3, ROW_COUNT_MAX = 8;
    final static int WATERLILIES_COUNT_MIN = 2, WATERLILIES_COUNT_MAX = 5;

    final static int WATERLILIES_CAPACITY_MIN = 3, WATERLILIES_CAPACITY_MAX = 5;
    
    final static int INSECT_TYPE_COUNT = 3;
    final static int FOOD_TYPE_COUNT = 2;
    final static int FOOD_COUNT_MIN = 1, FOOD_COUNT_MAX = 3;
    final static int FOOD_APPARITION_CHANCE = 50, INSECT_APPARITION_CHANCE = 100; //In percentage

    final static Double SPACE_BETWEEN_ROW = 5.0, SPACE_BETWEEN_WATERLILIES = 3.0;


    public static Row[] pond;

    public static Animal[] animals;

    final static String quitCommand = "p";

    final static String eatCommand = "e";
    static Amphibian player;
    static Row nextRow;
    static int score = 0;
    static int scoreMultiplier = 10;

    static boolean gameFinished = false;


    /*********************** Game Lifecycle ***************/
    private static boolean quitGame;
    public static void main(String[] args){
        onStart();

        while (!quitGame) {
            onLoop();
        }

    }
    public static void quitGame(){
        quitGame = true;
    }
    /*******************************************************/




    public static void onStart() {

        //**** Tests ****//

        //Frogs Instances
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10.0 / 12, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog popopo = new Frog("Popopo", 10, 40); //custom


        //Fly Instances
        Fly fl1 = new Fly(1, 3);
        Fly fl6 = new Fly(6);
        Fly flc = new Fly(5, 8); //custom


        //Simulation operations tests
        Frog.setSpecies("1331");

        System.out.println(peepo);
        peepo.eat(fl6);
        System.out.println(fl6);
        peepo.grow(8);
        System.out.println(peepo);

        peepo.eat(fl6);
        System.out.println(fl6);
        System.out.println(peepo);

        System.out.println(popopo);

        peepaw.grow(4);
        System.out.println(peepaw);
        System.out.println(pepe);



        //Game Initialization
        println("\nJava Ecosystem Game (Console Version)\n");

        /* //Load Game Instructions // */
        StringBuilder instructions = new StringBuilder();
        if (readFile("gameManual.txt", instructions)) {
            println(instructions.toString());
        }

        /* // Generate and populate the pond (Automatic/Random approach) // */
        pond = GeneratePound();
        println(String.format("There are %d rows", pond.length));

        //Ask the player for a name for its amphibious character
        println("\nEnter your name : \n");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        //Create the player
        player = new Frog(userInput, rand(0.1, 1), 50);

        //Place the player
        player.move(0, 0, pond);

    }

    public static void onLoop(){

        if (player.pondGridPosition.y.intValue() < pond.length - 1) {

            /* ///////////// Print animals in front of the player /////////// */
            System.out.println(player);
            println(String.format("\nI am at the row number %d. I hear voices coming from the next row: \n", player.pondGridPosition.y.intValue() + 1));
            player.observeForward(pond);

            /* ///////////// Purpose action choices to the player /////// */
            println("\nEnter 'e' to try to eat insects on your waterlily. You can enter one of the following waterlily number to pass and jump on the corresponding waterlily : ");
            nextRow = pond[player.pondGridPosition.y.intValue() + 1];
            IntStream.rangeClosed(1, nextRow.waterlilies.length).forEachOrdered((i) -> System.out.printf(".%d   ",i));
            println("");

        }
        else{
            println(String.format("Your score : %d", score));
            gameFinished = true;
        }

        //Player Actions
        if (!gameFinished) {

            boolean validInput = false;
            //Scan user keyboard inputs
            while (!validInput) {
                Scanner scanner = new Scanner(System.in);

                if (scanner.hasNextInt()) {
                    int waterlilyChoice = scanner.nextInt();
                    if (waterlilyChoice <= nextRow.waterlilies.length && waterlilyChoice > 0) {
                        player.move((int) (player.pondGridPosition.y + 1), waterlilyChoice - 1, pond);
                        validInput = true;
                    } else {
                        println("Please enter a valid waterlily choice number");
                    }
                } else {
                    String userInput = scanner.nextLine();

                    //Quit the game
                    if (Objects.equals(userInput.toLowerCase(), quitCommand)) {
                        quitGame();
                        validInput = true;
                    }

                    //Eat
                    if (Objects.equals(userInput.toLowerCase(), eatCommand)) {
                        Animal[] animals = player.currentWaterlily.getAnimals();
                        if (animals.length > 1) {

                            Animal animalToEat = null;
                            for (Animal animal : animals) {
                                if (animal != player) {
                                    animalToEat = animal;

                                    if (rand(0, 100) < 40) {
                                        break;
                                    }
                                }
                            }

                            if (animalToEat!=null) {
                                player.eat(animalToEat);
                                score += animalToEat.nutriscore;
                            }
                        }
                        validInput = true;
                    }
                }
            }
        }else{
            quitGame();
        }
    }

    ////////////////// Functions ////////////////////////////

    public static Row[] GeneratePound() {
        //Rows of waterlilies
        int rowsCount = (int) rand(ROW_COUNT_MIN, ROW_COUNT_MAX);
        Row[] rows = new Row[rowsCount];
        for (int rowId = 0; rowId < rowsCount; rowId++) {

            //Row waterlilies generation
            int waterliliesCount = (int) rand(WATERLILIES_COUNT_MIN, WATERLILIES_COUNT_MAX);
            Waterlily[] waterlilies = new Waterlily[waterliliesCount];
            double posY = rowId * SPACE_BETWEEN_ROW;;
            for (int wId = 0; wId < waterliliesCount; wId++) {
                double posX = (wId + (waterliliesCount - 1) / 2.0) * SPACE_BETWEEN_WATERLILIES;

                waterlilies[wId] = new Waterlily((int) rand(WATERLILIES_CAPACITY_MIN, WATERLILIES_CAPACITY_MAX), new Vector2(wId, rowId));


                //Static food generation
                if (rand(0, 100) <= FOOD_APPARITION_CHANCE && rowId != 0) {
                    int foodCount = (int) rand(FOOD_COUNT_MIN, FOOD_COUNT_MAX);

                    for (int foodId = 0; foodId < foodCount; foodId++) {
                        Random rnd = new Random();
                        int foodType = rnd.nextInt(FOOD_TYPE_COUNT);
                        StaticFood staticFood = switch (foodType) {
                            case 0 -> new Flower();
                            case 1 -> new Poo();
                            default -> new StaticFood(2);
                        };
                        waterlilies[wId].addFood(staticFood);
                    }

                }


                /*Insect generation, only one insect is generated per waterlily */
                Insect insect;
                if (rand(0, 100) <= INSECT_APPARITION_CHANCE && rowId != 0) {
                    Random rnd = new Random();
                    int insectType = rnd.nextInt(INSECT_TYPE_COUNT);
                    switch (insectType) {
                        case 0:
                            insect = new Fly(4, rand(1,20));
                            break;
                        case 1:
                            insect = new Firefly(5, rand(1,4));
                            break;
                        case 2:
                            insect = new Dragonfly(3, rand(1,8));
                            break;
                        default:
                            insect = new Fly();
                    }
                    insect.position = new Vector2(posX, posY);
                    waterlilies[wId].addAnimal(insect);
                }


                //Set positions (for graphic version)
                waterlilies[wId].position.x = posX;
                waterlilies[wId].position.y = posY;

            }

            //Populate row of generated waterlilies
            rows[rowId] = new Row(waterlilies);

            //Set position (for graphic version)
            rows[rowId].position.x = 0.0;
            rows[rowId].position.y = rowId * SPACE_BETWEEN_ROW;

        }
        return rows;
    }
    

    static void println(String s){
        System.out.println(s);
    };

    //Custom rand function allowing range from min and max
    public static double rand(double min, double max){
        double f = random()/Math.nextDown(1.0);
        return min*(1.0 - f) + max*f;
    }

    public static boolean readFile(String path, StringBuilder output) {
        boolean success = false;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            String line;
            while((line = file.readLine()) != null) {
                output.append(line);
                output.append("\n");
            }
            success = true;
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
