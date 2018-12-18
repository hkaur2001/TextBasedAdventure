package Rooms;

import People.Person;
import Items.Key;


public class TeacherHWRoom extends Room implements Key {
    public TeacherHWRoom(int x, int y){
        super(x,y);
    }
    /*
   PLayer collects hw
     */
    public boolean gotkey(Person x) {
        if (hasbeen == true){
            x.HW = true;
        }
        return x.HW;
    }

    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        hasbeen = true;
        gotkey(x);
        System.out.println("This room contains your completed homework.  Now use this hw to correctly answer a teacher's questions.");
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
            return "{#}";}
        else{
            return "[HW]";
        }
    }
}
