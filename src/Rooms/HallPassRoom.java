package Rooms;

import Items.Key;
import People.Person;

public class HallPassRoom extends Room implements Key {
    public HallPassRoom(int x, int y){
        super(x,y);
    }
    public boolean hasKey(Person x) {
        if (hasbeen == true){
            x.HallPass = true;
        }
        return x.HallPass;
    }
    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        hasbeen = true;
        hasKey(x);
        System.out.println("This room contains a hall pass! Now you will not get in trouble if a dean spots you.");
    }
    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }
    public String toString(){
        if (hasbeen){
            return "[#]";}
        else{
            return "{Pass}";
        }
    }
}