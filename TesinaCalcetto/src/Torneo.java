import java.util.*;

public class Torneo{
    //Attributi
    private ArrayList<Squadra> listaSquadre = new ArrayList<Squadra>();
    private ArrayList<Partita> calendario = new ArrayList<Partita>();
    private ArrayList<Partita> listaQuartifinale = new ArrayList<Partita>();
    private ArrayList<int[]> risultatiQuartifinale = new ArrayList<int[]>();
    private ArrayList<Partita> listaSemifinale = new ArrayList<Partita>();
    private ArrayList<int[]> risultatiSemifinale = new ArrayList<int[]>();
    private ArrayList<Partita> finale = new ArrayList<Partita>();
    private ArrayList<int[]> risultatiFinale = new ArrayList<int[]>();
    private ArrayList<Partita> terzoquarto = new ArrayList<Partita>();
    private ArrayList<int[]> risultatiTerzoQuarto = new ArrayList<int[]>();
    private ArrayList<Partita> primaseconda = new ArrayList<Partita>();
    private Squadra prima;
    private Squadra seconda;
    private ArrayList<Partita> terzaquarta = new ArrayList<Partita>();
    private Squadra terza;
    private Squadra quarta;
    private String premi[];
    
    //Costruttore 
    public Torneo(ArrayList<Partita> partite, boolean b){
        if(b==false){
            this.premi=new String[] {"Premio1","Premio2","Premio3"};
        }else{
            this.premi=new String[] {"PremioGold1","PremioGold2","PremioGold3"};
        }
        double exp = (Math.log(partite.size())/Math.log(2));
        if(exp==(int)exp){
            for(int i=0; i<partite.size(); i++) {
                this.listaSquadre.add(partite.get(i).getSquadra1());
                this.listaSquadre.add(partite.get(i).getSquadra2());
                
            }
            switch(partite.size()){
                case 4: QuartiDiFinale(partite); return;
                case 2: SemiFinale(partite); return;
                case 1: Finale(partite); return;
                //default: girone(partite); break;  qui ci starebbe se iniziamo prima dei quarti
            }
        }else{
            System.out.println("Errore nel numero di squadre");
        }
    }
        
    //Metodi
    public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati, int c){
        //qui ci starebbe se iniziamo prima dei quarti
        switch (risultati.size()) {
            case 4:
                for(int j=0;j<risultati.size();j++){
                    int[] risultato =risultati.get(j);
                    this.listaQuartifinale.get(j).setRisultato(risultato[0],risultato[1]);
                }
                this.risultatiQuartifinale.addAll(risultati);
                autoSemiFinale();
                return this.listaSemifinale;
            case 2:
                for(int j=0;j<risultati.size();j++){
                    int[] risultato =risultati.get(j);
                    this.listaSemifinale.get(j).setRisultato(risultato[0],risultato[1]);
                }
                this.risultatiSemifinale.addAll(risultati);
                autoFinale();
                return this.finale;
            case 1:
                if(c==0){
                    int[] risultato =risultati.get(0);
                    this.finale.get(0).setRisultato(risultato[0],risultato[1]);
                    this.risultatiFinale.addAll(risultati);
                    return Vittoria();
                }else if(c==1){
                    int[] risultato =risultati.get(0);
                    this.terzoquarto.get(0).setRisultato(risultato[0],risultato[1]);
                    this.risultatiTerzoQuarto.addAll(risultati);
                    return Terzo();
                }
            default:
                
                System.out.println("Numero risultati errato "+risultati.size());
                break;
        }
        return null;
    }
        
    //public void girone(ArrayList <Partita> partite){
        
    //}
    
    public void QuartiDiFinale(ArrayList <Partita> partite){
	this.listaQuartifinale.addAll(partite);
        this.calendario.addAll(partite);
    } 
    
    public void SemiFinale(ArrayList <Partita> partite){
	this.listaSemifinale.addAll(partite);
        this.calendario.addAll(partite);
    } 
    
    public void Finale(ArrayList <Partita> partite){
	this.finale.addAll(partite);
        this.calendario.addAll(partite);
    }
    
    /*public void autoQuartiFinale(ArrayList<Partita> partite){
        for(int i=0;i<this.listaGirone.size();i+=2){
            this.listaQuartifinale.add(new Partita(this.listaGirone.get(i).getVincitrice(),this.listaGirone.get(i+1).getVincitrice()));
        }
        this.calendario.addAll(this.listaSemifinale);
    }*/
    
    public void autoSemiFinale(){
        for(int i=0;i<this.listaQuartifinale.size();i+=2){
            this.listaSemifinale.add(new Partita(this.listaQuartifinale.get(i).getVincitrice(),this.listaQuartifinale.get(i+1).getVincitrice()));
        }
        this.calendario.addAll(this.listaSemifinale);
    }
    
    public void autoFinale() {
        this.finale.add(new Partita(this.listaSemifinale.get(0).getVincitrice(),this.listaSemifinale.get(1).getVincitrice()));
        this.terzoquarto.add(new Partita(this.listaSemifinale.get(0).getPerdente(),this.listaSemifinale.get(1).getPerdente()));
        this.calendario.addAll(this.finale);
    }
    
    public ArrayList<Partita> Vittoria(){
        this.prima=this.finale.get(0).getVincitrice();
        this.prima.settorneiVinti();
        this.seconda=this.finale.get(0).getPerdente();
        this.primaseconda.add(new Partita(this.prima,this.seconda));
        return this.primaseconda;
    }
    
    public ArrayList<Partita> Terzo(){
        this.terza=this.terzoquarto.get(0).getVincitrice();
        this.quarta=this.finale.get(0).getPerdente();
        this.terzaquarta.add(new Partita(this.terza,this.quarta));
        return this.terzaquarta;
    }
    
    //public ArrayList<int[]> getRisultatiGirone(){
        //return this.risultatiGirone;
    //}
    
    public ArrayList<int[]> getRisultatiQuarti(){
        return this.risultatiQuartifinale;
    }
    
    public ArrayList<int[]> getRisultatiSemi(){
        return this.risultatiSemifinale;
    }
    
    public Squadra getPrimaTorneo(){
        return this.prima;
    }
    
    public Squadra getSecondaTorneo(){
        return this.seconda;
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
