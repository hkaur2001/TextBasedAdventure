package People;
import Items.Key;
public class Person {
    int xLoc, yLoc;
    public int strike = 10;
    public boolean HW = false;
    public boolean HallPass = false;
    public int getxLoc() {
        return xLoc;
    }
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }
    public int getyLoc() {
        return yLoc;
    }
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }
    public Person (int xLoc, int yLoc)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
}

