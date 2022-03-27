package navoppgave;

import java.util.ArrayList;

public class spiller {
    private String navn;
    public ArrayList<Integer> kort;
    private String korttype;
    private int poeng=0;

    public spiller(String navn) {
        navn=this.navn;
        kort=new ArrayList<>();

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Integer> getKort() {
        return kort;
    }

    public void setKort(ArrayList<Integer> kort) {
        this.kort = kort;
    }

    public String getKorttype() {
        return korttype;
    }

    public void setKorttype(String korttype) {
        this.korttype = korttype;
    }

    public int getPoeng() {
        return poeng;
    }

    public void setPoeng(int poeng) {
        this.poeng = poeng;
    }
}
