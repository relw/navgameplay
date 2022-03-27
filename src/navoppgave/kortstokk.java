package navoppgave;

import java.util.ArrayList;
import java.util.Arrays;

public class kortstokk {
    private ArrayList<Integer> bunke1;
    private ArrayList<Integer> bunke2;
    private ArrayList<Integer> bunke3;
    private ArrayList<Integer> bunke4;
    private ArrayList<String> korttyper = new ArrayList<>(Arrays.asList("Hjertere","Rutere","Kløvere","Spar"));

    public kortstokk() {
        bunke1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke3 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
        bunke4 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
    }

    public ArrayList<Integer> getBunke1() {
        return bunke1;
    }

    public void setBunke1(ArrayList<Integer> bunke1) {
        this.bunke1 = bunke1;
    }

    public ArrayList<Integer> getBunke2() {
        return bunke2;
    }

    public void setBunke2(ArrayList<Integer> bunke2) {
        this.bunke2 = bunke2;
    }

    public ArrayList<Integer> getBunke3() {
        return bunke3;
    }

    public void setBunke3(ArrayList<Integer> bunke3) {
        this.bunke3 = bunke3;
    }

    public ArrayList<Integer> getBunke4() {
        return bunke4;
    }

    public void setBunke4(ArrayList<Integer> bunke4) {
        this.bunke4 = bunke4;
    }

    public ArrayList<String> getKorttyper() {
        return korttyper;
    }

    public void setKorttyper(ArrayList<String> korttyper) {
        this.korttyper = korttyper;
    }
}
