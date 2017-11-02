import java.util.ArrayList;

public class Finale implements StratiTorneo {
	 private ArrayList<int[]> risultatiFinale = new ArrayList<int[]>();
	 private ArrayList<Partita> listaFinale = new ArrayList<Partita>();
	 private ArrayList<int[]> risultatiPodio = new ArrayList<int[]>();
	 private ArrayList<Partita> listaPodio = new ArrayList<Partita>();
	 
	//Costruttore
  	public Finale (ArrayList <Partita> listaPartite) {
  		this.listaFinale = listaPartite;
  	}
	public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati) {
		this.risultatiFinale.addAll(risultati);
		for(int i = 0; i<risultati.size();i++) {
			this.listaFinale.get(i).setRisultato(risultati.get(i)[0],risultati.get(0)[1]);
			if(risultatiFinale.get(i)[0]<risultatiFinale.get(i)[1]) {
				int temp = risultatiFinale.get(i)[0];
				risultati.get(i)[0] = risultati.get(i)[1];
				risultati.get(i)[1] = temp;
			}
		}
		this.risultatiPodio.addAll(risultati);
		autoPartite();
		return listaPodio;
	}
	
	public void autoPartite() {
		this.listaPodio.add(new Partita(this.listaFinale.get(0).getVincitrice(),this.listaFinale.get(0).getPerdente()));
        this.listaPodio.add(new Partita(this.listaFinale.get(1).getVincitrice(),this.listaFinale.get(1).getPerdente()));
 
	}
	public ArrayList<Partita> getGirone(){
		return this.listaPodio;
	}
	public ArrayList<int[]> getRisultati(){
		return this.risultatiPodio;
	}

}
