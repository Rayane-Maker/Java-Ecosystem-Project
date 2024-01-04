import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Math.random;

public class Pond {
    public static void main(String[] args){

        //*********************************************************** Tests *****************************************************************//

        //Frogs Instances
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10.0/365, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog popopo = new Frog("Popopo", 10, 40); //custom


        //Fly Instances
        Fly fl1 = new Fly(1, 3);
        Fly fl6 = new Fly(6);
        Fly flc = new Fly(5,8); //custom


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



        //*********************************************************** Game *****************************************************************//
        String affirmativeResp = "y";
        String yesNo = "(Y/N)";
        String quitCommand = "p";
        //Initializations
        println("\nJava Ecosystem Game (Console Version)");
        String instructions = null;
        readFile("gameManual.txt", instructions);
        println("---- Game Instructions ----");
        println(instructions);



        /* ///////////// Populate the pound (Random approach) /////////// */

        //Frogs
        int frogCountInit = (int)rand(3, 10);
        Frog[] frogs = new Frog[frogCountInit];
        for (int i = 0; i < frogCountInit; i++) {
            frogs[i] = new Frog("Frog " + (i + 1));
        }



        //Game loop
        while(true){


            /* ///////////// Print pound state /////////// */
            println("\nThe pound contain : ");

            //Frogs
            for (int i = 0; i < frogCountInit; i++) {
                println(frogs[i].toString());
            }

            //Flies

            println(String.format("Enter '%s' to quit the game", quitCommand));


            //Scan user keyboard inputs
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            //Quit the game
            if (Objects.equals(userInput.toLowerCase(), quitCommand)){
                break;
            }


        }


    }


    ////////////////// Functions ////////////////////////////
    static void println(String s){
        System.out.println(s);
    };

    //Custom rand function allowing range from min and max
    public static double rand(double min, double max){
        double f = random()/Math.nextDown(1.0);
        return min*(1.0 - f) + max*f;
    }

    public static boolean readFile(String path, String output) {
        output = "";
        boolean res = false;
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            String line;
            StringBuilder content = new StringBuilder();
            while((line = file.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
            output = content.toString();
            res = true;
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }
}
