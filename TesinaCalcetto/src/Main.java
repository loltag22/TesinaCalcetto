import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException{
        ArrayList<Squadra> squadre = new ArrayList<>();
        ArrayList<Partita> partite = new ArrayList<>();
        ArrayList<Partita> fine = new ArrayList<>();
        String[] premi;
        for(int i=0;i<8;i++){ //8 perchè parto dai quarti di finale  
            String nome = "Squadra"+(i+1);
            String citta = "Citta"+(i+1);
            Squadra s = new Squadra(nome,citta);
            squadre.add(s);
            for(int j=0;j<11;j++){
                int eta = generaValore(0);
                String giocatore = "Giocatore"+(j+1);
                String nomeg = "nome "+giocatore+" "+nome;
                String cognomeg = "cognome "+giocatore+" "+nome;
                Giocatore g = new Giocatore(nomeg,cognomeg,eta,s);
                s.aggiungiGiocatore(g);
                SchedaGiocatore scheda = new SchedaGiocatore(0,0,"-");
                g.setScheda(scheda);
            }
            if((i%2)==1){
                partite.add(new Partita(squadre.get(i-1),squadre.get(i)));
            }
        }
        Torneo torneo = new Torneo(partite);
        TorneoGold torneoGold = new TorneoGold(partite);
        fine=svolgiTorneo(new QuartiDiFinale(partite),torneo);
        premi=torneo.getPremi();
        System.out.println("Ha vinto il torneo la squadra "+fine.get(0).getVincitrice().getNome()+" e ha vinto il "+premi[0]+".\nLa seconda classificata è la squadra "+fine.get(0).getPerdente().getNome()+" e ha vinto il "+premi[1]+".\nLa terza classificata è la squadra "+fine.get(1).getVincitrice().getNome()+" e ha vinto "+premi[2]);
    }
    
    public static int generaValore(int i){
        Random random2 = new Random();
        int a = 0;
        int b = 0;
        switch(i){
            case 0: a=18; b=40; break;
            case 1: a=0; b=3; break;
        }
        int c = ((b-a)+1);
        int valore = random2.nextInt(c) + a;
        return valore;
    }
    
    public static ArrayList<int[]> generaRisultati(int i){
        ArrayList<int[]> listaRisultati = new ArrayList<>();
        for(int j=0;j<i;j++){
            int ris[]= new int[2];
            ris[0] = generaValore(1);
            ris[1] = generaValore(1);
            while(ris[0]==ris[1]){
                ris[1] = generaValore(1);
            }
            listaRisultati.add(ris);
        }
        return listaRisultati;
    }
    
    public static ArrayList<Partita> svolgiTorneo(StratiTorneo s, Torneo t){
        ArrayList<int[]> risultati = new ArrayList<>();
        ArrayList<Partita> prossimoGirone = new ArrayList<>();
        switch(s.getGirone().size()){
            case 4:         
                risultati=generaRisultati(s.getGirone().size());
                svolgiTorneo(new Semifinale(t.disputaPartite(risultati, s)),t);
            case 2:
            	  risultati=generaRisultati(s.getGirone().size());
                  svolgiTorneo(new Finale(t.disputaPartite(risultati, s)),t);
            case 1:
            	 risultati=generaRisultati(s.getGirone().size());
                 prossimoGirone.addAll(t.disputaPartite(risultati, s));
                return prossimoGirone;
            default: break;
        }
        return null;
    }
}