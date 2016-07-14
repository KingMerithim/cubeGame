

/**
 * Created by merithim on 7/6/16.
 */
public enum Direction {

    LEFT, RIGHT, TOP, DOWN, BACK, FRONT;

    public static Direction reverseDirection(Direction direction) {
        Direction reverseDirection = null;

        switch (direction) {
            case LEFT: {
                reverseDirection = Direction.RIGHT;
                break;
            }
            case RIGHT: {
                reverseDirection = Direction.LEFT;
                break;
            }
            case TOP: {
                reverseDirection = Direction.DOWN;
                break;
            }
            case DOWN: {
                reverseDirection = Direction.TOP;
                break;
            }
            case FRONT: {
                reverseDirection = Direction.BACK;
                break;
            }
            case BACK: {
                reverseDirection = Direction.FRONT;
                break;
            }
        }

        return reverseDirection;
    }



    }
