import java.util.ArrayList;

public class Semifinale implements StratiTorneo {
	//Attributi
	
    private ArrayList<int[]> risultatiSemifinale = new ArrayList<int[]>();
	private ArrayList<Partita> listaSemifinale = new ArrayList<Partita>();
	private ArrayList<Partita> finale = new ArrayList<Partita>();
    private ArrayList<Partita> calendario = new ArrayList<Partita>();
    
    
    //Costruttore
  	public Semifinale (ArrayList <Partita> listaPartite) {
  		this.listaSemifinale = listaPartite;
  		this.calendario.addAll(this.listaSemifinale);
  	}
  	
	public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati) {
		for(int j=0;j<risultati.size();j++){
            int[] risultato =risultati.get(j);
            this.listaSemifinale.get(j).setRisultato(risultato[0],risultato[1]);
        }
        this.risultatiSemifinale.addAll(risultati);
        autoPartite();
        return this.finale;
		
	}
	public void autoPartite() {
		this.finale.add(new Partita(this.listaSemifinale.get(0).getVincitrice(),this.listaSemifinale.get(1).getVincitrice()));
        this.finale.add(new Partita(this.listaSemifinale.get(0).getPerdente(),this.listaSemifinale.get(1).getPerdente()));
	}
	public ArrayList<Partita> getGirone(){
		return this.listaSemifinale;
	}
	public ArrayList<int[]> getRisultati(){
		return this.risultatiSemifinale;
	}

}
