package navoppgave;

import java.util.*;

public class spill {
    public kortstokk kortstokk;
    public ArrayList<Integer> premiebunke;
    public String premiebunketype;
    public spiller spiller1;
    public spiller spiller2;
    public ArrayList<String> korttyper = new ArrayList<>(Arrays.asList("Hjertere","Rutere","Kløvere","Spar"));

    public spill() {
        kortstokk = new kortstokk();
        spiller1 = new spiller("Spiller 1");
        spiller2 = new spiller("Spiller 2");
        fordelBunker();
        skrivSpillInfo();
        startSpill();
    }

    public void fordelBunker() {
        finnPremieBunke();
        finnSpiller1Bunke();
        finnSpiller2Bunke();
    }
    public void finnPremieBunke(){
        /*Trekker hvilken bunke som skal være premiebunke basert på index */

        int randomtall1 = (int) Math.floor(Math.random() * 3) + 0;
        premiebunketype=korttyper.get(randomtall1);

        /* Tildeler premiebunken */
        premiebunke=kortstokk.bunke1;

        /* Stokker bunken */
        Collections.shuffle(premiebunke);

        /* Fjerner typen fra kortstokken*/
        korttyper.remove(premiebunketype);
    }
    public void finnSpiller1Bunke(){
        /*Trekker hvilken bunke som skal være til spiller1 basert på index */
        int randomtall2 = (int) Math.floor(Math.random() * 2) + 0;
        spiller1.korttype=korttyper.get(randomtall2);

        /* Fjerner bunken fra stokken*/
        korttyper.remove(spiller1.korttype);
        spiller1.kort=kortstokk.bunke2;
    }
    public void finnSpiller2Bunke(){
        /*Trekker hvilken bunke som skal være til spiller2 basert på index */
        int randomtall3 = (int) Math.floor(Math.random() * 1) + 0;
        spiller2.korttype=korttyper.get(randomtall3);

        /* Fjerner bunken fra stokken*/
        korttyper.remove(spiller2.korttype);
        spiller2.kort=kortstokk.bunke3;

    }
    public void startSpill(){
        //System.out.println("1 runde: Premiekort har verdi "+premiebunke.get(0));
        int teller=1;
        //int teller=7;
         //while(premiebunke.size()>1){
        while(teller<=8){
            int premiekort=premiebunke.get(0);
            int spiller1verdi=spiller1strategi(premiekort);
            int spiller2verdi=spiller2strategi(premiekort);
            String vinner="";
            if(spiller1verdi>spiller2verdi){
                vinner="Spiller 1 vant denne runden \uD83D\uDE0A";
                registrerPoeng(spiller1, 1);
            }
            else if(spiller1verdi<spiller2verdi){
                vinner="Spiller 2 vant denne runden \uD83D\uDE0E";
                registrerPoeng(spiller2, 1);
            }
            else if(spiller1verdi==spiller2verdi){
                registrerPoeng(spiller1, 1);
                registrerPoeng(spiller2, 1);
                vinner="Uavgjort \uD83D\uDC4C";
            }


            skrivRundeResultater(teller,premiekort,spiller1verdi,spiller2verdi,vinner);
            premiebunke.remove(0);
             //Registrer vinne funnksjon her lag
             teller++;
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
         }
        skrivSluttResultat();

    }
    public void registrerPoeng(spiller spiller, int nypoeng){
        int spillerpoeng=spiller.getPoeng();
        spiller.setPoeng(spillerpoeng+nypoeng);
    }
    public void skrivSluttResultat(){
        String vinner="";
        if(spiller1.getPoeng()>spiller2.getPoeng()){
            vinner="Spiller 1 vant \uD83D\uDE0A";
        }
        else if(spiller1.getPoeng()<spiller2.getPoeng()){
            vinner="Spiller 2 vant \uD83D\uDE0E";
        }
        else if(spiller1.getPoeng()==spiller2.getPoeng()){
            vinner="Uavgjort \uD83D\uDC4C";
        }
        System.out.print("Spiller 1 fikk "+spiller1.getPoeng()+" poeng\"Spiller 2 fikk "+spiller2.getPoeng()+"poeng\n  "+vinner);
    }
    public void skrivRundeResultater(int teller,int premiekort, int spiller1verdi, int spiller2verdi, String vinner){
        System.out.println("----------------------------\n"+teller+" Runde: Premiekort har verdi "+premiekort+" ** Spiller 1 kort: "+spiller1verdi+" Spiller 2 kort: "+spiller2verdi+
                        "\n"+vinner+"");
    }
    public void skrivSpillInfo(){
        System.out.println("Premiebunken er av typen "+premiebunketype+"\nSpiller 1 fikk bunken med "+spiller1.korttype+"\nSpiller 2 fikk bunken med "+spiller2.korttype+"\nVi legger bort bunken med "+korttyper.get(0)+" for denne gang\n");
    }
    public int spiller1strategi(int premiekort){
        /* Spiller 1 skal alltid velge samme verdi som premiekortet*/
        int spiller1verdi=premiekort;
        for(Iterator<Integer> iter = spiller1.kort.iterator(); iter.hasNext();) {
            if(iter.next().equals(premiekort)) {
                iter.remove();
            }
        }

        return spiller1verdi;
    }
    public int spiller2strategi(int premiekort){
        /* Spiller 1 skal alltid ha et tilfeldig kort*/
        Random random_method = new Random();
        //spiller2.kort.forEach(i-> System.out.println(i));
        int randomkort= random_method.nextInt(spiller2.kort.size());
        int spiller2verdi=spiller2.getKort().get(randomkort);
        for(Iterator<Integer> iter = spiller2.kort.iterator(); iter.hasNext();) {
            if(iter.next().equals(spiller2verdi)) {
                iter.remove();
            }
        }

        return spiller2verdi;
    }
}
