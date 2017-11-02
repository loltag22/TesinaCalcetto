import java.util.ArrayList;

public interface StratiTorneo {
	
	public ArrayList<Partita> disputaPartite(ArrayList<int[]> risultati);
	
	public void autoPartite();
	
	public ArrayList<Partita> getGirone();
	
	public ArrayList<int[]> getRisultati();
}
