import static java.lang.System.out;
import java.util.*;


//////////////////////////
// DESIGN PATTERN NOTES //
//////////////////////////
    

/*
    PATTERN NUMBER 1 - THE STRATEGY PATTERN
    
    Defines a family of algorithms,
    encapsulates each one and makes them
    interchangeable through polymorphism.
    
    Strategy lets the algorithm vary independenyly
    from the client that uses it, making the code
    easier to maintain.

    The behaviour is carried out by a component object.
    Not by the class itself or the superclass.

    TIP:
    Favour composition over inheritence for behaviours.
    
    EXAMPLE:    
*/

abstract class Character{
    WeaponBehaviour weapon;

    public void fight(){
        weapon.useWeapon();
    };

    public void setWeapon(WeaponBehaviour w){
        weapon = w;
    }
}
class Troll extends Character {
}
class Knight extends Character{
}
class King extends Character {
}

interface WeaponBehaviour{
    public void useWeapon ();
}
class SwordBehaviour implements WeaponBehaviour {
    public void useWeapon (){
        out.println ("Slash, Shalsh!");
    }
}
class ClubBehaviour implements WeaponBehaviour {
    public void useWeapon (){
        out.println ("BOINK!");
    }
}
class StrategryTest{
    public void test(){
        Character knight = new Knight();
        knight.setWeapon(new ClubBehaviour ());
        knight.fight();
        // knight character picks up a new weapon
        knight.setWeapon(new SwordBehaviour());
        knight.fight();
    }
}

/*
Instead of the Character class implementing the weapon interface and its methods, the Character class HAS-A WeaponBehaviour component object which carries out the behaviour for it.
*/








//////////////////////////////////////////////








/*

    PATTERN NUMBER 2 - OBSERVER
    
    Used for objects to let other objects know when
    some event has happened or data has changed.
    
    The sender object is known as the SUBJECT.
    The reciever objects are known as OBSERVERS.
    
    Observer objects can register and unregister
    with the subject object dynamically.
    
    The subject holds a list of all current observers
    so that it can update each of them when something
    changes.


    EXAMPLE:
*/


interface Subject{
    public void addObserver(Observer b);
    public void removeObserver(Observer b);
    public void notifyObservers();
}
interface Observer{
    public void update(boolean b);
}


class Shop implements Subject {
    private ArrayList<Observer> observers = new ArrayList <>();

    boolean inStock = true;

    public void addObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i!=-1){
            observers.remove(i);
        }
    }
    public void notifyObservers (){
        for(Observer o: observers ){
            o.update(inStock);
        }
    }
}

class Customer implements Observer{
    public void update(boolean b){
        if (b) {
            out.println("\"I'm going to the store.\"");
        }
    }
}

class Website implements Observer{
    public void update(boolean b){
        if (b){
            out.println("Update item to - in stock.");
        }
    }

}

class ObserverTester{
    public void test(){
        Shop shop = new Shop();
        Customer john = new Customer();
        Website site = new Website();
        shop.addObserver(john);
        shop.addObserver(site);
        shop.notifyObservers();
        out.println("john: \"I've bought the item now, I don't want to be notified everytime they have it in stock. I know, I'll unregister\"");
        shop.removeObserver(john);
    }
}


/* 
    Java has a build in Observable class which
    you can extend. It also has a built in 
    Observable inteface for you to implement.
*/






/////////////////////////////////////////////








/*

    PATTERN NUMBER 3 -


*/






/*




 */























































// THIS CLASS IS JUST FOR TESTING......

public class DesignPattern{
    public static void main (String... args){
        StrategryTest stratergy = new StrategryTest ();
        out.println ("STRATERGY TEST...");
        stratergy.test();
        ObserverTester observer = new ObserverTester();
        out.println ("\nOBSERVER TEST");
        observer.test();
    }
}