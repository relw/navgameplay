package navoppgave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kortstokk {
    public ArrayList<Integer> bunke1;
    public ArrayList<Integer> bunke2;
    public ArrayList<Integer> bunke3;
    public ArrayList<Integer> bunke4;

    //BØR LAGE GETTER OG SETTERE TIL SLUTT

    public kortstokk() {
        bunke1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke3 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke4 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));

        //stokkKortStokker();

    }
    /*public void stokkKortStokker(){
        Collections.shuffle(hjerter);
        Collections.shuffle(spar);
        Collections.shuffle(kløver);
        Collections.shuffle(ruter);
    }  */
}