/**
 * Created by merithim on 7/6/16.
 */
public class Grid {

    Room current;
    Room behind;
    Room infront;
    Room left;
    Room right;
    Room button;
    Room roof;

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