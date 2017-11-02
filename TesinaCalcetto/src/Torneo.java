import java.util.*;

public class Torneo{
    //Attributi
    protected ArrayList<Squadra> listaSquadre = new ArrayList<Squadra>();
    private ArrayList<Partita> calendario = new ArrayList<Partita>();
    protected String premi[];
    private StratiTorneo s;
    
    //Costruttore 
    public Torneo(ArrayList<Partita> partite){
    	this.premi=new String[] {"Premio1","Premio2","Premio3"};
        double exp = (Math.log(partite.size())/Math.log(2));
        if(exp==(int)exp){
            for(int i=0; i<partite.size(); i++) {
                this.listaSquadre.add(partite.get(i).getSquadra1());
                this.listaSquadre.add(partite.get(i).getSquadra2());  
            }
        }else{
            System.out.println("Errore nel numero di squadre");
        }
    }
        
    //Metodi
    public ArrayList<Partita> getGirone() {
    	return s.getGirone();
    }
    public ArrayList<int[]> getRisultati() {
    	return s.getRisultati();
    }
    public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati, StratiTorneo s){
    	return s.disputaPartite(risultati);	
    }
    public ArrayList<Partita> getCalendario(){
        return this.calendario;
    }
    
    public ArrayList<Squadra> getSquadre(){
        return this.listaSquadre;
    }
    
    public String[] getPremi(){  
        return this.premi;
    }
}
