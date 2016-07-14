import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by merithim on 7/6/16.
 */
public class Cube {

    private int roomsPerSize;
    private double precentageOfTraps;
    private Grid<Room> grid;

    public Cube() {
        roomsPerSize = 10;
        precentageOfTraps = 0.3;
        grid = new Grid<Room>(roomsPerSize,roomsPerSize,roomsPerSize);

    }

    public Cube(int rooms, double trapPrecentage) {
        roomsPerSize = rooms;
        precentageOfTraps = trapPrecentage;
        grid = new Grid<Room>(roomsPerSize,roomsPerSize,roomsPerSize);
    }

    public Cube(int rooms) {
        roomsPerSize = rooms;
        precentageOfTraps = 0.3;
        grid = new Grid<Room>(roomsPerSize,roomsPerSize,roomsPerSize);
    }


    public void  build() {
        Random rand = new Random();
        int nextInt;
        double border = 100 * precentageOfTraps;
        Room temp = null;
        for (int z = 0; z < roomsPerSize; z++) {
            for (int y = 0; y < roomsPerSize; y++) {
                for (int x = 0; x < roomsPerSize; x++) {
                    nextInt = rand.nextInt(100);
                    if(nextInt<border) {
                        temp = new Room(x, y, z, true);
                    } else {
                        temp = new Room(x, y, z, false);
                    }
                    GridElement elementOnKoord = grid.getElementOnKoord(x, y, z);
                    elementOnKoord.setCargo(temp);
                }
            }
        }
    }

    public void setPlayerStart(int[] koord) {
        Player player = new Player();
        grid.getElementOnKoord(koord).getCargo().setPlayer(player);
    }


    public List getTrapRooms() {
        List<Room> trapRooms = new ArrayList<Room>();
        for (GridElement<Room> gridElement : grid.getElementsList()) {
            Room cargo = gridElement.getCargo();
            if(cargo.isTrapRoom()) {
                trapRooms.add(cargo);
            }
        }
        return trapRooms;
    }

    private void step() {
        // rooms move
        //list rooms rearrange like they are now
    }

    public int switchRoom(int[] koord, Direction direction) {
        //gridelement wo der derzeitige raum drin ist und dann mit dem nachbarn wechseln
        GridElement<Room> gridElement = grid.getElementOnKoord(koord);
        GridElement<Room> neighbor1 = grid.getNeighbor(gridElement, direction);
        Room temp = gridElement.cargo;
        gridElement.setCargo(neighbor1.getCargo());
        neighbor1.setCargo(temp);

        return 0;
    }
        //einbauen dasüber die cubegrenze hinweg, wieder am anfang der reihe begonnen werden soll....
    public int roomMoveDirection(int[] koord, Direction direction) {
        //gridelement wo der derzeitige raum drin ist und dann mit dem nachbarn wechseln
        GridElement<Room> startNode = grid.getElementOnKoord(koord);
        Direction reverseDirection= Direction.reverseDirection(direction);

            roomMoving(grid.getNeighbor(startNode,reverseDirection),startNode,reverseDirection);

        return 0;
    }

    private Room roomMoving(GridElement<Room> me, GridElement<Room> startnode, Direction direction) {
        Room myRoom = me.cargo;

        GridElement<Room> neighbor = grid.getNeighbor(me, direction);
        //end of row
        if(neighbor==null) {
            int[] koord = me.getKoord();
            switch (direction) {
                case LEFT: {
                    koord[0]=roomsPerSize;
                    break;
                }
                case RIGHT: {
                    koord[0]=0;
                    break;
                }
                case TOP: {
                    koord[1]=roomsPerSize;
                    break;
                }
                case DOWN: {
                    koord[1]=0;
                    break;
                }
                case FRONT: {
                    koord[2]=roomsPerSize;
                    break;
                }
                case BACK: {
                    koord[2]=0;
                    break;
                }
            }
            neighbor=grid.getElementOnKoord(koord);
        }
        Room neighborroom;
        if(me==startnode) {
            neighborroom = neighbor.getCargo();
        } else {
            neighborroom = roomMoving(neighbor, startnode, direction);
        }
        me.setCargo(neighborroom);
        return myRoom;

    }

    public Room getPlayerRoom() {
        List<GridElement<Room>> elementsList = grid.getElementsList();
        for (GridElement<Room> element : elementsList) {
            Room room = element.getCargo();
            if(room.hasPlayer()==true)
                return room;
        }
        return  null;
    }
    public void show() {
        //ebenenweise bis engine bereit steht
        String roomText = "";
        for (int z =0; z < roomsPerSize; z++) {
            for (int y = roomsPerSize-1; y >=0; y--) {
                roomText = "";
                for (int x =0; x < roomsPerSize; x++) {
                    GridElement<Room> elementOnKoord = grid.getElementOnKoord(x, y, z);
                    Room room = elementOnKoord.getCargo();
                    if(room.isTrapRoom()) {
                        roomText+="x";
                    } else {
                        roomText+="o";
                    }
                }
                System.out.printf(roomText+"\n");
            }

            System.out.printf("\n\n");
        }
    }
}
