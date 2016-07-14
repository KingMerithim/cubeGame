/**
 * Created by merithim on 7/6/16.
 */
public class Player {


    boolean isAlive;

    public Player( ) {
        isAlive = true;
    }

    public boolean playerAlive() {
        return isAlive;
    }

    public void killed() {
        isAlive = false;
    }

    public void move() {
    }
}
