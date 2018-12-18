package Game;


import People.Person;
import Rooms.Room;
import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;
    /*
    Initiates the board and game
     */
    public static void main(String[] args)
    {
        Room[][]map1 = new Room[8][8];
        Board map = new Board(map1);
        Person player1 = new Person(0,0);
        map1[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.print("Hi Student! In this game, try to collect your hw and get a hall pass to avoid getting bad strikes.  "+"\n");
        System.out.print("You are going through the hallway and trying to visit teachers to validate your hw completion"+"\n");
        System.out.print("For credit for hw answer the questions correctly or get a negative strike reducing strike score by 2"+"\n");
        System.out.print("When you get to a Dean interaction answer their questions correctly to avoid getting strikes"+"\n");
        System.out.print("You start with 10 possible strikes with each wrong answer as -2.  If you hit zero game ends you are a bad student;("+"\n");
        /*
        Game operates
         */
        while(gameOn)
        {
            map.print();
            map.didWin();
            System.out.println("Where would you like to move? (Choose N, E, S, W)");
            String move = in.nextLine();
            if(validMove(move, player1, map1))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            }
            else {
                System.out.println("Please choose a valid move.");
            }
            map.didWin();
        }
        in.close();
    }
    /*
    Controls for game
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;
        }
        return true;
    }
    /*
    Turns off game
     */
    public static void gameOff()
    {
        gameOn = false;
    }
}