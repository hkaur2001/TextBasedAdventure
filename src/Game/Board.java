package Game;

import Rooms.*;
import People.Person;
public class Board {
    public static Room[][] map;
    int x;
    int y;
    /*
    Board has two different constructors to make varying boards
     */
    public Board(int x, int y) {
        this.map = new Room[x][y];
        for (x = 0; x < this.map.length; x++) {
            for (y = 0; y < this.map[x].length; y++) {
                this.map[x][y] = new Room(x, y);
            }
        }
        for (int i = 0; i <4 ; i++){
            int a = rand();
            int b = rand();
            map[a][b] = new DeanRoom(a, b);
            int q = rand();
            int t = rand();
            map[q][t] = new TeacherRoom(q, t);
        }
        //Generates location of both key types
        int s = rand();
        int d = rand();
        map[s][d] = new TeacherHWRoom(s, d);

        int m = rand();
        int n = rand();
        map[m][n] = new HallPassRoom(m, n);
    }

    /**
     * Default map
     * @param map Room variable
     */
    public Board(Room[][] map) {
        this.map = map;
        //Constructs the board
        for (x = 0; x < this.map.length; x++) {
            for (y = 0; y < this.map[x].length; y++) {
                this.map[x][y] = new Room(x, y);
            }
        }
        //Generates more than one Dean and Teacher rooms in random locations
        for (int i = 0; i <4 ; i++){
            int a = 0;
            int b = 0;
            a = rand();
            b = rand();
            map[a][b] = new DeanRoom(a, b);
            int q = rand();
            int t = rand();
            map[q][t] = new TeacherRoom(q, t);

        }
        //location of the hall pass and the completed hw is created
        int s = rand();
        int d = rand();
        map[s][d] = new TeacherHWRoom(s, d);

        int m = rand();
        int n = rand();
        map[m][n] = new HallPassRoom(m, n);
    }

    /**
     * the board is printed by rows
     */
    public void board() {
        String row = "";
        for (int i = 0; i < map.length; i++) {
            row = " ";
            for (int j = 0; j < map[i].length; j++) {
                row += map[i][j].toString();
            }
            System.out.println(row);
        }
    }
    /*
    checks to see the player is done visiting the teachers and the deans rooms
     */
    public void wins(){
        boolean win = true;
        for( int x = 0; x < map.length; x++){
            for (int y = 0; y < map[0].length; y++){
                if ((map[x][y] instanceof DeanRoom || map[x][y] instanceof TeacherRoom) && map[x][y].hasbeen == false){
                    win = false;
                }
            }
        }
        if(win){
            System.out.println("Congrats, you good student won the game!!!");
            Runner.gameOff();
        }
    }
    /*
    makes a random number for the constructor to use each time
     */
    public static int rand() {
        int a = (int) (Math.random() * map.length);
        return a;
    }
}