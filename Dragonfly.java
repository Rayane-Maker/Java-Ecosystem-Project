public class Dragonfly extends Insect {

    //Constructors
    Dragonfly(double mass, double speed){
        super(mass,speed); // call the basic constructors from insect
    }

    Dragonfly(double mass){
        this(mass,10); // valeur de base à revoir pour équilibrer le jeu plus tard
    }
    Dragonfly(){
        this(2); // valeur de base à revoir pour équilibrer le jeu plus tard
    }

    public void eat(Fly fly){

        //Early quit the method if the fly is dead
        if (fly.isDead()){
            return;
        } // penser à ajouter une condition sur la position relative des insectes visés

        //Kill the fly or make it stronger
        if (this.getSpeed() > fly.getSpeed() ){
            fly.setMass(0);
        }else {
            fly.grow(1);
        }
    }

    public void eat(Firefly firefly){
        //Early quit the method if the fly is dead
        if (firefly.isDead()){
            return;
        } // penser à ajouter une condition sur la position relative des insectes visés

        //Kill the fly or make it stronger
        if (this.getSpeed() > firefly.getSpeed()){
            firefly.setMass(0);
        }else {
            firefly.grow(1);
        }
    }
}
