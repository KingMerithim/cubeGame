import java.util.List;
import org.apache.commons.lang.time.StopWatch;

/**
 * Created by merithim on 7/6/16.
 */
public class Game {

    public static void main(String[] args) {
        //Player user = new Player();

        StopWatch watch = new StopWatch();
        watch.start();
        Cube cube = new Cube(); //default 10 rooms 30% traps
        cube.build();
        watch.stop();
        List trapRooms = cube.getTrapRooms();
       // cube.show();
        System.out.printf("Count traprooms "+trapRooms.size()+"\n");

        System.out.printf("BuildTime "+watch.toString()+"\n");

        int[] koord={1,0,0};
        cube.setPlayerStart(koord);
       // cube.switchRoom(koord,Direction.RIGHT);
       // cube.getPlayerRoom();
        cube.roomMoveDirection(koord, Direction.LEFT);
        cube.show();
    }
}
