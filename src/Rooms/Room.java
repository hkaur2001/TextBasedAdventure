package Rooms;

import People.Person;

public class Room {
    Person occupant;
    public boolean hasbeen = false;
    int xLoc,yLoc;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You entered an empty room no dean or teacher to be worry about here!");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }
    /*Prints if player has been there
     */
    public String toString(){
        if (hasbeen){
            return "[#]";}
        else{
            return "[ ]";
        }
    }

}

