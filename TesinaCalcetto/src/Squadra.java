import java.util.*;
public class Squadra {
    //Attributi
    private String nome;
    private String citta;
    private ArrayList<Giocatore> listaGiocatori = new ArrayList <Giocatore>();
    private int numPartite;
    private int partiteVinte;
    private int torneiVinti;
    private int gol;
    
    //Costruttore
    public Squadra(String nome, String citta) {
        this.nome=nome;
        this.citta=citta;
    }
    //Metodi
    public void aggiungiGiocatore(Giocatore g) {
	listaGiocatori.add(g);
    }
    
    public void cancellaGiocatore(Giocatore g){
        listaGiocatori.remove(g);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCitta(){
        return this.citta;
    }
    public ArrayList<Giocatore> getGiocatori(){
        return this.listaGiocatori;
    }
    
    public void setGol(int gol){
        this.gol=gol;
    }
    
    public int getGol(){
        return this.gol;
    }
    
    public void setnumPartite(){
        this.numPartite++;
    }
    
    public int getnumPartite(){
        return this.numPartite;
    }
    
    public void setpartiteVinte(){
        this.partiteVinte++;
    }
    
    public int getpartiteVinte(){
        return this.partiteVinte;
    }
    
    public void settorneiVinti(){
        this.torneiVinti++;
    }
    
    public int gettorneiVinti(){
        return this.torneiVinti;
    }
}
