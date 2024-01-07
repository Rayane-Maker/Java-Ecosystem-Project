import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.random;

public class Pond {

    final static int FROGCOUNTMIN = 3, FROGCOUNTMAX = 10;
    final static int WATERLILIES_COUNT_MIN = 3, WATERLILIES_COUNT_MAX = 5;

    final static int WATERLILIES_CAPACITY_MIN = 3, WATERLILIES_CAPACITY_MAX = 5;
    
    final static int INSECT_TYPE_COUNT = 3;
    final static int FOOD_TYPE_COUNT = 2;
    final static int FOOD_COUNT_MIN = 1, FOOD_COUNT_MAX = 3;
    final static int FOOD_APPARITION_CHANCE = 50, INSECT_APPARITION_CHANCE = 80; //In percentage

    final static Double SPACE_BETWEEN_ROW = 5.0, SPACE_BETWEEN_WATERLILIES = 3.0;


    public static Row[] pond;

    public static Animal[] animals;

    String affirmativeResp = "y";
    String yesNo = "(Y/N)";
    static String quitCommand = "p";

    /********** Game Lifecycle ***********/
    private static boolean quitGame;
    public static void main(String[] args){
        Start();

        while (!quitGame) {
            Loop();
        }

    }
    public static void QuitGame(){
        quitGame = true;
    }
    /************************************/




    public static void Start() {

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
        GameInit();
    }

    public static void Loop(){

        /* ///////////// Print pound state /////////// */
        println("\nThe pound contain : ");

        println(String.format("Enter '%s' to quit the game", quitCommand));

        //Scan user keyboard inputs
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        //Quit the game
        if (Objects.equals(userInput.toLowerCase(), quitCommand)){
            QuitGame();
        }

    }

    ////////////////// Functions ////////////////////////////

    public static void GameInit() {
        println("\nJava Ecosystem Game (Console Version)\n");

        /* //Load Game Instructions // */
        StringBuilder instructions = new StringBuilder();
        if (readFile("gameManual.txt", instructions)) {
            println("---- Game Instructions ----");
            println(instructions.toString());
        }

        /* // Generate and populate the pond (Automatic/Random approach) // */
        pond = GeneratePound();
    }
    
    public static Row[] GeneratePound() {
        //Rows of waterlilies
        int rowsCount = (int) rand(FROGCOUNTMIN, FROGCOUNTMAX);
        Row[] rows = new Row[rowsCount];
        for (int rowId = 0; rowId < rowsCount; rowId++) {

            //Row waterlilies generation
            int waterliliesCount = (int) rand(WATERLILIES_COUNT_MIN, WATERLILIES_COUNT_MAX);
            Waterlily[] waterlilies = new Waterlily[waterliliesCount];
            double posY = rowId * SPACE_BETWEEN_ROW;;
            for (int wId = 0; wId < waterliliesCount; wId++) {
                double posX = (wId + (waterliliesCount - 1) / 2.0) * SPACE_BETWEEN_WATERLILIES;

                //Static food generation
                StaticFood[] staticFoods;
                if (rand(0, 100) < FOOD_APPARITION_CHANCE) {
                    int foodCount = (int) rand(FOOD_COUNT_MIN, FOOD_COUNT_MAX);
                    staticFoods = new StaticFood[foodCount];

                    for (int foodId = 0; foodId < foodCount; foodId++) {
                        Random rnd = new Random();
                        int foodType = rnd.nextInt(FOOD_TYPE_COUNT);
                        switch (foodType) {
                            case 0:
                                staticFoods[foodId] = new Flower();
                                break;
                            case 1:
                                staticFoods[foodId] = new Poo();
                                break;
                            default:
                                staticFoods[foodId] = new StaticFood(2);
                        }
                    }
                } else {
                    staticFoods = new StaticFood[0];
                }

                /*Insect generation, only one insect is generated per waterlily
                so a 1 element array is used (because waterlilies take an array for Animal)*/
                Insect[] insects = new Insect[1];
                if (rand(0, 100) < INSECT_APPARITION_CHANCE) {
                    Random rnd = new Random();
                    int insectType = rnd.nextInt(INSECT_TYPE_COUNT);
                    switch (insectType) {
                        case 0:
                            insects[0] = new Fly();
                            break;
                        case 1:
                            insects[0] = new Firefly();
                            break;
                        case 2:
                            insects[0] = new Dragonfly();
                            break;
                        default:
                            insects[0] = new Fly();
                    }
                }else {
                    insects = new Insect[0];
                }

                waterlilies[wId] = new Waterlily((int) rand(WATERLILIES_CAPACITY_MIN, WATERLILIES_CAPACITY_MAX), staticFoods, insects);

                //Set positions (for graphic version)
                waterlilies[wId].position.x = posX;
                waterlilies[wId].position.y = posY;
                insects[0].position = waterlilies[wId].position;

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
