import java.util.ArrayList;

public class TorneoGold extends Torneo {

	public TorneoGold(ArrayList<Partita> partite) {
		super(partite);
		this.premi=new String[] {"Premio1Gold","Premio2Gold","Premio3Gold"};
        double exp = (Math.log(partite.size())/Math.log(2));
        if(exp==(int)exp){
            for(int i=0; i<partite.size(); i++) {
                this.listaSquadre.add(partite.get(i).getSquadra1());
                this.listaSquadre.add(partite.get(i).getSquadra2());
                
            }
        }else{
            System.out.println("Errore nel numero di squadre");
        }
	}
	
	

}
