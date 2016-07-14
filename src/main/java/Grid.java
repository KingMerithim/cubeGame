import java.util.ArrayList;
import java.util.List;

/**
 * Created by merithim on 7/6/16.
 */
public class Grid<T> {

//speicherung des grids? Liste..

  List<GridElement<T>> elementsList = new ArrayList<GridElement<T>>();

  public Grid(int sizeX, int sizeY, int sizeZ) {
      //mit diesen werten wird das grid gebaut und die GridElemente bekommen nachbarn zugeteilt
      //wenn die raäume erstellt werden, werden diese nur in die entsprechenden x, y, z koordinaten Gridelemente eingehangen

      //beim verschieben wechseln die räume im grid,das grid mit seinen verzweigungen bleibt aber weiterhin bestehen --> der raum weiß keine anchbarn aber das gridelement in dem es hängt
    GridElement<T> tempElement =null;
    for (int z = 0; z < sizeZ; z++) {
      for (int y = 0; y < sizeY; y++) {
        for (int x = 0; x < sizeX; x++) {
          tempElement = new GridElement<T>(x,y,z);
          elementsList.add(tempElement);
        }
      }
    }
    for (GridElement<T> tGridElement : elementsList) {
      setNeighbors(tGridElement);
    }
  }

  private void setNeighbors(GridElement<T> element) {
    element.setLeft(getLeftNeighbor(element));
    element.setRight(getRightNeighbor(element));
    element.setTop(getTopNeighbor(element));
    element.setDown(getBottomNeighbor(element));
    element.setFront(getFrontNeighbor(element));
    element.setBack(getBackNeighbor(element));

    //
  }

  public GridElement<T> getNeighbor(GridElement<T> element, Direction next) {
    GridElement<T> temp = null;
    switch (next) {
      case LEFT:{ temp=getLeftNeighbor(element); break;}
      case RIGHT:{ temp=getRightNeighbor(element); break;}
      case TOP:{ temp=getTopNeighbor(element); break;}
      case DOWN:{ temp=getBottomNeighbor(element); break;}
      case FRONT:{ temp=getFrontNeighbor(element); break;}
      case BACK:{ temp=getBackNeighbor(element); break;}

    }
    return temp;
  }
  private GridElement<T> getLeftNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
    if (x==0) return null;
      return getElementOnKoord(x-1,y,z);
  }

  private GridElement<T> getRightNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
      return getElementOnKoord(x+1,y,z);

  }

  private GridElement<T> getTopNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
      return getElementOnKoord(x,y+1,z);

  }

  private GridElement<T> getBottomNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
    if (y==0) return null;
      return getElementOnKoord(x,y-1,z);

  }
  private GridElement<T> getFrontNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
      return getElementOnKoord(x,y,z+1);
  }
  private GridElement<T> getBackNeighbor(GridElement<T> element) {
    int[] koord = element.getKoord();
    int x = koord[0];
    int y = koord[1];
    int z = koord[2];
    if(z==0) return null;
      return getElementOnKoord(x,y,z-1);

  }

  public GridElement<T> getElementOnKoord(int[] koord) {
    return getElementOnKoord(koord[0], koord[1], koord[2]);
  }
  public GridElement<T> getElementOnKoord(int x, int y, int z) {
    for (GridElement<T> tGridElement : elementsList) {
      int[] koord = tGridElement.getKoord();
      if(koord[0] == x && koord[1] == y && koord[2] == z) {
        return tGridElement;
      }

    }
    return null;
  }

  public List<GridElement<T>> getElementsList() {
    return elementsList;
  }

}



/*1 raum kann mit nachbar tauschen platz
              nachbar schieben
                --> raum am rand wo hingeschoben fällt auf anderer seite wieder rein
        -->in allen 3 dimensionen
        wenn am rand und schiebt kommt er auf andere seite


 ==> algorthmus der 1 raum auswählen und seine aktion bestimmen kann , dies wird dannd as bewegungsmuster für den cube
 --> fängt immer wieder von vorne an --> fixes cubegrid?

 wie räume gespeichert? jeder raum kennt seine nachbarn wenn raum sich bewegt fragt er nach den jeweiligen nachbarn seiner jetzigen nachbarn..

 raumgrid.selectraum.methodeaufraum
              beim anlegen raum1 --> raum2 --> raum3
                            \       \           \
                            raum4-->raum5 --> raum6
              */


//grid mit inhalt -> gridelement miteinander verbunden und kennen ihre nachbarn unabhängig vom inhalt --> 3d speicher

//grid  3d arraylist mit allen elementen