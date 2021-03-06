package navoppgave;

import java.util.*;

public class spill {
    private kortstokk kortstokk;
    private ArrayList<Integer> premiebunke;
    private String premiebunketype;
    private spiller spiller1;
    private spiller spiller2;

    /** Første metode som starte lagingen av spiller */
    public spill() {
        kortstokk = new kortstokk();
        spiller1 = new spiller("Spiller 1");
        spiller2 = new spiller("Spiller 2");
        fordelBunker();
        skrivSpillInfo();
        startSpill();
    }
    /** Metode som starter metoder for å fordele kortbunker til premiebunke og spillere */
    public void fordelBunker() {
        finnPremieBunke();
        finnSpiller1Bunke();
        finnSpiller2Bunke();
    }
    public void finnPremieBunke(){
        /**Trekker hvilken bunke (Hjerter,Kløver,Spar,Ruter) som skal være premiebunke basert på index i ArrayListen (korstokken) med korttyper*/

        int randomtall1 = (int) Math.floor(Math.random() * 3) + 0;

        premiebunketype=kortstokk.getKorttyper().get(randomtall1);

        /** Tildeler premiebunken */
        premiebunke=kortstokk.getBunke1();

        /** Stokker bunken */
        Collections.shuffle(premiebunke);

        /** Fjerner korttypen fra kortstokken*/
        kortstokk.getKorttyper().remove(premiebunketype);
    }

    public void finnSpiller1Bunke(){
        /**Trekker hvilken bunke som skal være til spiller1 basert på index i ArrayListen (korstokken) med korttyper*/
        int randomtall2 = (int) Math.floor(Math.random() * 2) + 0;
        spiller1.setKorttype(kortstokk.getKorttyper().get(randomtall2));

        /** Fjerner bunken fra kortstokken*/
        kortstokk.getKorttyper().remove(spiller1.getKorttype());
        spiller1.kort=kortstokk.getBunke2();
    }
    public void finnSpiller2Bunke(){
        /** Trekker hvilken bunke som skal være til spiller2 basert på index i ArrayListen (korstokken) med korttyper*/
        int randomtall3 = (int) Math.floor(Math.random() * 1) + 0;
        spiller2.setKorttype(kortstokk.getKorttyper().get(randomtall3));;

        /** Fjerner bunken fra stokken*/
        kortstokk.getKorttyper().remove(spiller2.getKorttype());
        spiller2.kort=kortstokk.getBunke3();

    }
    /**Her starter spillet */
    public void startSpill(){
        int teller=1;
        /** Spillet vil kun ha 8 runder, fordi vi spiller med 8 kort (verdi 2-9)*/
        while(teller<=8){
            /** Trekker første kort i premiebunken*/
            int premiekort=premiebunke.get(0);
            /** Premiekortet blir sendt til spillernes strategier */
            int spiller1verdi=spiller1strategi(premiekort);
            int spiller2verdi=spiller2strategi(premiekort);
            String vinner="";
            /** Vinneren er den som har høyest verdi på kortet de spiller med.*/
            if(spiller1verdi>spiller2verdi){
                vinner="Spiller 1 vant denne runden";
                registrerPoeng(spiller1, 1);
            }
            else if(spiller1verdi<spiller2verdi){
                vinner="Spiller 2 vant denne runden";
                registrerPoeng(spiller2, 1);
            }
            else if(spiller1verdi==spiller2verdi){
                registrerPoeng(spiller1, 1);
                registrerPoeng(spiller2, 1);
                vinner="Uavgjort";
            }

            /** Når hver runde er spilt blir resultatet skrevet ut på skjermen*/
            skrivRundeResultater(teller,premiekort,spiller1verdi,spiller2verdi,vinner);
            premiebunke.remove(0);
            teller++;
            /** Forsinkelse for å få litt spenning*/
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
        }
        /** Når alle rundene er ferdigspilt blir resultatet skrevet ut på skjermen*/
        skrivSluttResultat();

    }
    /** Registrerer poeng til vinneren av hver runde*/
    public void registrerPoeng(spiller spiller, int nypoeng){
        int spillerpoeng=spiller.getPoeng();
        spiller.setPoeng(spillerpoeng+nypoeng);
    }
    /** Metode som skriver ut resultatet etter alle rundene*/
    public void skrivSluttResultat(){
        String vinner="";
        if(spiller1.getPoeng()>spiller2.getPoeng()){
            vinner="Spiller 1 vant";
        }
        else if(spiller1.getPoeng()<spiller2.getPoeng()){
            vinner="Spiller 2 vant";
        }
        else if(spiller1.getPoeng()==spiller2.getPoeng()){
            vinner="Uavgjort";
        }
        System.out.print("----------------------------\nSpiller 1 fikk "+spiller1.getPoeng()+" poeng\nSpiller 2 fikk "+spiller2.getPoeng()+" poeng\n"+vinner);
    }
    /** Metode som skriver ut resultatet etter hver runde*/
    public void skrivRundeResultater(int teller,int premiekort, int spiller1verdi, int spiller2verdi, String vinner){
        System.out.println("----------------------------\n"+teller+" Runde: Premiekort har verdi "+premiekort+
                " ** \nSpiller 1 kort: "+spiller1verdi+"\nSpiller 2 kort: "+spiller2verdi+ "\n"+vinner+"");
    }
    /** Skriver ut fordelingen av bunkene*/
    public void skrivSpillInfo(){
        System.out.println("Premiebunken er av typen "+premiebunketype+"\nSpiller 1 fikk bunken med "+spiller1.getKorttype()+
                "\nSpiller 2 fikk bunken med "+spiller2.getKorttype()+"\nVi legger bort bunken med "+kortstokk.getKorttyper().get(0)+" for denne gang\n");
    }
    public int spiller1strategi(int premiekort){
        /** Spiller 1 skal alltid velge samme verdi som premiekortet. Returnerer samme verdi*/
        int spiller1verdi=premiekort;
        /** Iterator som går gjennom spillerbunken til spiller1 og så fjerner kortet fra bunken.*/
        for(Iterator<Integer> iter = spiller1.kort.iterator(); iter.hasNext();) {
            if(iter.next().equals(premiekort)) {
                iter.remove();
            }
        }

        return spiller1verdi;
    }
    public int spiller2strategi(int premiekort){
        /** Spiller2 skal alltid ha et tilfeldig kort fra sin bunke*/
        Random random_method = new Random();
        int randomkort= random_method.nextInt(spiller2.kort.size());
        int spiller2verdi=spiller2.getKort().get(randomkort);
        /** Iterator som går gjennom spillerbunken til spiller2 og så fjerner kortet fra bunken.*/
        for(Iterator<Integer> iter = spiller2.kort.iterator(); iter.hasNext();) {
            if(iter.next().equals(spiller2verdi)) {
                iter.remove();
            }
        }

        return spiller2verdi;
    }
}
