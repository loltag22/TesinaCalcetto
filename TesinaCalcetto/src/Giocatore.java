
public class Giocatore {
//Attributi
	private SchedaGiocatore scheda;
	private String nome;
	private String cognome;
	private int eta;
	private Squadra squadra;
//Costruttore
	public Giocatore(String nome, String cognome, int eta, Squadra squadra) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.scheda = new SchedaGiocatore("",0,"");
		this.squadra = squadra;
	}
	
}
