import java.util.*;
public class Squadra {
//Attributi
	private ArrayList<Giocatore> listaGiocatori = new ArrayList <Giocatore>();
	private String nome;
	private String citta;
//Costruttore
	public Squadra(ArrayList<Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}
//Metodi
	public void aggiungiGiocatore(Giocatore g) {
		listaGiocatori.add(g);
	}
	public void rimuoviGiocatore(Giocatore g) {
		listaGiocatori.remove(g);
	}
	public String getNome() {
		return this.nome;
	}
	public String getCitta() {
		return this.citta;
	}
}
