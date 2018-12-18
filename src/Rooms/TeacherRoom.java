package Rooms;


import Game.Runner;
import People.Person;

import Items.Key;
import People.Person;

import org.omg.CORBA.SystemException;

import java.util.Scanner;

public class TeacherRoom extends Room  {
    boolean strikesavailable = true;
    public TeacherRoom(int x, int y){
        super(x,y);
    }
    /**
     * Method controls the results when a person enters this room. Checks if the player has the hw and asks random english, math, or science question.
     */
    public void enterRoom(Person x){
        this.hasbeen = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        boolean gotkey = false;
        if (x.HW == true){
            gotkey = true;
        }
        if (gotkey){
            String [][] math = {{"What is a comparison using like or as?","2*3+1*0","What type of word is run?","999/9","0!","What is the powerhouse of the cell?","What does a plant cell contain that an animal cell does not?"},{"simile","6","verb","111","1","mitochondria","chloroplasts"}};
            int rand = (int)((Math.random()*7));
            System.out.println("Your teacher will ask questions to validate HW!");
            System.out.println("To get credit, answer this question:"+" "+math[0][rand]);
            Scanner in = new Scanner(System.in);
            String ans = in.nextLine();
            boolean correctAnswer=false;
            while (correctAnswer == false){
                if (x.strike <= 0){
                    System.out.println("Uh oh too many wrong strikes! Games over");
                    Runner.gameOff();
                    break;
                }
                else if (ans.equals(math[1][rand])){
                    System.out.println("Good job, your teacher is satisfied!");
                    strikesavailable = false;
                    correctAnswer=true;
                } else {
                    System.out.println("Hmmm are you sure you did the hw? try again.");
                    x.strike = x.strike-1;
                    System.out.println("Your health is now: " + ""+x.strike);
                    ans = in.nextLine();
                }
            }
        }
        else{
            System.out.println("Hi student why don't you have your hw? Come back to me with your completed hw!");
        }
    }
    /*
    Prints Teacher on board
     */
    public String toString(){
        if (strikesavailable){
            return "[T]";
        } else {
            return "[#]";
        }
    }}