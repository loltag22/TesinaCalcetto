import java.util.*;
public class Partita {
//Attributi
	private Squadra squadra1;
	private Squadra squadra2;
	private Date data;
	private int gol1;
	private int gol2;
	
	public Partita(Squadra squadra1, Squadra squadra2, Date d) {
		this.squadra1 = squadra1;
		this.squadra2 = squadra2;
		this.data = data;
		
	}
	public Squadra getSquadra1(){
		return squadra1;
	}
	public Squadra getSquadra2(){
		return squadra2;
	}
	public Date getData(){
		return data;
	}
	public void setRisultato(int gol1, int gol2) {
		this.gol1 = gol1;
		this.gol2 = gol2;
	}
	public int getGol1() {
		return this.gol1;
	}
	public int getGol2() {
		return this.gol2;
	}
}
