package Rooms;

import Game.Runner;
import People.Person;
import java.util.Scanner;

    public class DeanRoom extends Room {
        boolean strikesavailable = true;
        public DeanRoom(int x, int y){
            super(x,y);
    }
    /**
     * Method controls the results when a person enters this room. Checks if the player hall pass, and asks schedule questions
     * @param x the Person entering
     */
    public void enterRoom(Person x){
        hasbeen = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        boolean gotkey = false;
        if (x.HallPass == true){
            gotkey = true;
        }
        if (gotkey == true){
            String [][] math = {{"Do you have a hall pass?","How many minutes after the bell rings can you use the bathroom?","What period do you have lunch?","Is it ok to use the teacher elevators?"},{"yes","10","fourth","no",}};
            int rand = (int)((Math.random()*4));
            System.out.println("Uh oh a Dean! They will inquire about your schedule and school policy!");
            System.out.println("To avoid getting a strike answer the questions correctly:"+" "+math[0][rand]);
            Scanner in = new Scanner(System.in);
            String ans = in.nextLine();
            boolean correctAnswer=false;
            while (correctAnswer == false){
                if (x.strike <= 0){
                    System.out.println("You got too many strikes bad student :( game over");
                    Runner.gameOff();
                    break;
                }
                else if (ans.equals(math[1][rand])){
                    System.out.println("Good job, you're a good student :)");
                    strikesavailable = false;
                    correctAnswer=true;
                } else {
                    System.out.println("Hmmm are you sure now? Try again.");
                    x.strike = x.strike-1;
                    System.out.println("Your strike level is now " + ""+x.strike);
                    ans = in.nextLine();
                }
            }
        }
        else{
            System.out.println("Hi student why are you here without a hall pass? Go get a hall pass!");
        }
    }
    /*
    Prints dean on board
     */
    public String toString(){
        if (strikesavailable){
            return "[D]";
        } else {
            return "[#}";
        }
    }}