public class Firefly extends Insect{
    //Constructors
    Firefly(double mass, double speed){
        super(mass,speed); // call the basic constructors from insect
    }
    Firefly(double mass){
        this(mass,10); // valeur de base à revoir pour équilibrer le jeu plus tard
    }
    Firefly(){
        this(2); // valeur de base à revoir pour équilibrer le jeu plus tard
    }
}
