import java.util.*;
public class Partita {
    //Attributi
    private Squadra squadra1;
    private Squadra squadra2;
    private Squadra vincitrice;
    private Squadra perdente;
    private Date data;
    private int gol1;
    private int gol2;
    private int golV;
    private int golP;
    
    //Costruttore
    public Partita(Squadra squadra1, Squadra squadra2) {
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
    }
    
    //Metodi
    public Squadra getSquadra1(){
	return squadra1;
    }
    
    public Squadra getSquadra2(){
    	return squadra2;
    }
    
    public void setData(Date data){
        this.data=data;
    }
    
    public Date getData(){
	return data;
    }
    
    public int getGol1(){
        return this.gol1;
    }
    
    public int getGol2(){
	return this.gol2;
    }
    
    public void setRisultato(int g1, int g2){
        this.gol1=g1;
        this.gol2=g2;
        this.squadra1.setGol(this.gol1);
        this.squadra1.setnumPartite();
        attribuisciGol(this.gol1,this.squadra1);
        this.squadra2.setGol(this.gol2);
        this.squadra2.setnumPartite();
        attribuisciGol(this.gol2,this.squadra2);
        if(gol1>gol2){
            this.vincitrice=this.squadra1;
            this.squadra1.setpartiteVinte();
            for(int i=0;i<11;i++){
                this.squadra1.getGiocatori().get(i).setPartiteGiocate();
                this.squadra1.getGiocatori().get(i).setPartiteVinte();
                this.squadra2.getGiocatori().get(i).setPartiteGiocate();
            }
            this.perdente=this.squadra2;
            this.golV=this.gol1;
            this.golP=this.gol2;
        }else if(gol2>gol1){
            this.vincitrice=this.squadra2;
            this.squadra2.setpartiteVinte();
            for(int i=0;i<11;i++){
                this.squadra2.getGiocatori().get(i).setPartiteGiocate();
                this.squadra2.getGiocatori().get(i).setPartiteVinte();
                this.squadra1.getGiocatori().get(i).setPartiteGiocate();
            }
            this.perdente=this.squadra1;
            this.golV=this.gol2;   
            this.golP=this.gol1;
        }
    }
    
    public Squadra getVincitrice(){
        return this.vincitrice;
    }
    
    public Squadra getPerdente(){
        return this.perdente;
    }
    
    public int getGolV(){
        return this.golV;
    }
    
    public int getGolP(){
        return this.golP;
    }
    
    public void attribuisciGol(int g, Squadra s){
        for(int i=0;i<g;i++){
            Random random = new Random();
            int a = 0;
            int b = 10;
            int c = ((b-a)+1);
            int valore = random.nextInt(c) + a;
            s.getGiocatori().get(valore).setGol();
        }
    }
}
