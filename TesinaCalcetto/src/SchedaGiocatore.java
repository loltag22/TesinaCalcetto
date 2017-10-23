
public class SchedaGiocatore {
    private int partiteGiocate;
    private int partiteVinte;
    private int gol;
    private String cartellino;  
    
    //Costruttore
    public SchedaGiocatore(int pg, int g, String c){
        this.partiteGiocate = pg;
        this.gol = g;
        this.cartellino = c;
    }
    
    //Metodi
    public void setGolGiocatore(){
        this.gol++;
    }
    
    public void setCartelliniGiocatore(String s){
        this.cartellino = s;
    }
    
    public void setPatiteGiocate(){
        this.partiteGiocate++;
    }
    
    public void setPartiteVinte(){
        this.partiteVinte++;
    }
    
    public int getGolGiocatore(){
        return this.gol;
    }
    
    public String getCartelliniGiocatore(){
        return this.cartellino;
    }
    
    public int getPartiteGiocate(){
        return this.partiteGiocate;
    }
    
    public int getPartiteVinte(){
        return this.partiteVinte;
    }
}
