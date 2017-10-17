import java.util.*;
public class Torneo {
	
//Attributi
	
	private ArrayList<Squadra> listaSquadre = new ArrayList<Squadra>();
	private ArrayList<Partita> listaQuartifinale = new ArrayList<Partita>();
	private ArrayList<Partita> listaSemifinale = new ArrayList<Partita>();
	private ArrayList<String> risultatiQuartifinale = new ArrayList<String>(); 
	private ArrayList<String> risultatiSemifinale = new ArrayList<String>(); 
	private ArrayList<String> risultatiFinale = new ArrayList<String>(); 
	private Partita finale;
	private ArrayList<Partita> calendario = new ArrayList<Partita>(); 
	
	
//Metodi
	public void quartiDiFinale(ArrayList <Partita> partite) {
		for(int i=0; i<partite.size(); i++) {
			listaSquadre.add(partite.get(i).getSquadra1());
			listaSquadre.add(partite.get(i).getSquadra2());
		}
		this.listaQuartifinale = partite;
		this.calendario = partite;
	}
	public void semiFinale() {
		this.listaSemifinale = partite;
		calendario.addAll(partite);
	}
	public void finale(Partita partita) {
		this.finale = partita;
		calendario.add(partita);
	}
	public void risultatiQuartiFinale(){
		for(int i =0; i<listaQuartifinale.size();i++) {
			risultatiQuartifinale.add(i,listaQuartifinale.get(i).getGol1() + " - " + listaQuartifinale.get(i).getGol2());
		}
	}
	public void risultatiSemifinale(){
		for(int i =0; i<listaSemifinale.size();i++) {
			risultatiQuartifinale.add(i,listaQuartifinale.get(i).getGol1() + " - " + listaQuartifinale.get(i).getGol2());
		}	
	
	}
	
}
