package si.projekt.maedn;

public class Spielfigur {
	int spielernummer;
	int figurnummer;
	int feldnummer;
	boolean start = true;
	boolean ziel = false;
	
	public Spielfigur(int spielernummer, int figurnummer){
		this.spielernummer = spielernummer;
		this.figurnummer = figurnummer;
		this.feldnummer = (spielernummer * 10 + figurnummer) * -1;
	}
	
	public boolean darfRutschen(){
		boolean darfRutschen = true;
		if(this.feldnummer<0) darfRutschen = false;
		return darfRutschen;
	}
	
	public boolean ausRuecken(){
		this.feldnummer = this.spielernummer * 10;
		return true;
	}
	
	public boolean rutschen(int augenzahl){
		int neuesFeld = this.feldnummer + augenzahl;
		if (neuesFeld>49) neuesFeld = neuesFeld-40;
		this.feldnummer = neuesFeld;
		return true;
	}
	
}
