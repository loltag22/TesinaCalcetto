import java.util.ArrayList;

public class QuartiDiFinale implements StratiTorneo{
	
	//Attributi
	private ArrayList<Partita> listaQuartifinale = new ArrayList<Partita>();
    private ArrayList<int[]> risultatiQuartifinale = new ArrayList<int[]>();
    private ArrayList<Partita> listaSemifinale = new ArrayList<Partita>();
    private ArrayList<Partita> calendario = new ArrayList<Partita>();
    
	//Costruttore
	public QuartiDiFinale (ArrayList <Partita> listaPartite) {
		this.listaQuartifinale = listaPartite;
		this.calendario.addAll(this.listaSemifinale);
	}
	
	//Metodi
	public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati){
		for(int j=0;j<risultati.size();j++){
			int[] risultato =risultati.get(j);
			this.listaQuartifinale.get(j).setRisultato(risultato[0],risultato[1]);
		}
		this.risultatiQuartifinale.addAll(risultati);
		autoPartite();
		return this.listaSemifinale;
	}
	
	public void autoPartite() {
		 for(int i=0;i<this.listaQuartifinale.size();i+=2){
	            this.listaSemifinale.add(new Partita(this.listaQuartifinale.get(i).getVincitrice(),this.listaQuartifinale.get(i+1).getVincitrice()));
	        }
	}
	public ArrayList<Partita> getGirone(){
		return this.listaQuartifinale;
	}
	public ArrayList<int[]> getRisultati(){
		return this.risultatiQuartifinale;
	}
}
