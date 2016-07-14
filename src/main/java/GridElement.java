import java.util.ArrayList;

/**
 * Created by merithim on 7/6/16.
 */
public class GridElement<T> {
    private GridElement back;
    private GridElement front;
    private GridElement left;
    private GridElement right;
    private GridElement down;
    private GridElement top;

    private int x;
    private int y;
    private int z;

    T cargo;

    public GridElement(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int[] getKoord() {
       int[] koord = {x,y,z};
        return koord;
    }

    public GridElement getBack() {
        return back;
    }

    public void setBack(GridElement back) {
        this.back = back;
    }

    public GridElement getFront() {
        return front;
    }

    public void setFront(GridElement front) {
        this.front = front;
    }

    public GridElement getLeft() {
        return left;
    }

    public void setLeft(GridElement left) {
        this.left = left;
    }

    public GridElement getRight() {
        return right;
    }

    public void setRight(GridElement right) {
        this.right = right;
    }

    public GridElement getDown() {
        return down;
    }

    public void setDown(GridElement down) {
        this.down = down;
    }

    public GridElement getTop() {
        return top;
    }

    public void setTop(GridElement top) {
        this.top = top;
    }

    public T getCargo() {
        return cargo;
    }

    public void setCargo(T cargo) {
        this.cargo = cargo;
    }
}
