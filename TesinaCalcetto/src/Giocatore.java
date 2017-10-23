
public class Giocatore {
    //Attributi
    private String nome;
    private String cognome;
    private int eta;
    private Squadra squadra;
    private SchedaGiocatore scheda;
    
    //Costruttore
    public Giocatore(String nome, String cognome, int eta, Squadra squadra){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.scheda = new SchedaGiocatore(0,0,"");
        this.squadra=squadra;
    }	
    
    //Metodi
    public void setScheda(SchedaGiocatore scheda){
        this.scheda=scheda;
    }
    
    public void setGol(){
        this.scheda.setGolGiocatore();
        System.out.println("E' stato registrato un nuovo gol al giocatore di " + this.nome);
    }
    
    public void setPartiteVinte(){
        this.scheda.setPartiteVinte();
    }
    
    public void setPartiteGiocate(){
        this.scheda.setPatiteGiocate();
    }
    
    public void setCartelliniGiocatore(String s){
        this.scheda.setCartelliniGiocatore(s);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public int getEta(){
        return this.eta;
    }
    
    public Squadra getSquadra(){
        return this.squadra;
    }
    
    public SchedaGiocatore getScheda(){
        return this.scheda;
    }
}
