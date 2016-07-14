/**
 * Created by merithim on 7/6/16.
 */
public class Room {

    private boolean isTrapRoom;
    private Player player;

    int x;
    int y;
    int z;

    public Room(int x, int y, int z, boolean isTrap) {
        this.x=x;
        this.y=y;
        this.z=z;
        isTrapRoom = isTrap;
    }

    public void RoomSwap(Direction position) {

    }
    public boolean isTrapRoom() {
        return isTrapRoom;
    }
    public void setPlayer(Player playerHere) {
        player = playerHere;
    }
    public boolean hasPlayer() {
        if(player!=null) {
            return true;
        } else {
            return false;
        }
    }
    //getNeighborRooms

}
