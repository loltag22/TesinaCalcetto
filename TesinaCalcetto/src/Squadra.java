import java.util.*;
public class Squadra {
//Attributi
	private ArrayList<Giocatore> listaGiocatori = new ArrayList <Giocatore>();
//Costruttore
	public Squadra(ArrayList<Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}
//Metodi
	public void aggiungiGiocatore(Giocatore g) {
		listaGiocatori.add(g);
	}
}
