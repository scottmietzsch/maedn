package si.projekt.maedn;

public class Spielfigur {
	int spielernummer;
	int figurnummer;
	int feldnummer;
	boolean start = true;
	boolean ziel = false;

	public Spielfigur(int spielernummer, int figurnummer) {
		this.spielernummer = spielernummer;
		this.figurnummer = figurnummer;
		this.feldnummer = (spielernummer * 10 + figurnummer) * -1;
	}

	public boolean darfRutschen() {
		boolean darfRutschen = true;
		if (this.feldnummer < 0)
			darfRutschen = false;
		return darfRutschen;
	}

	public int ausRuecken() {
		this.feldnummer = this.spielernummer * 10;
		this.start = false;
		return this.feldnummer;
	}
	
	public boolean rauswerfen(){
		this.feldnummer = (spielernummer * 10 + figurnummer) * -1;
		this.start = true;
		return true;
	}

	public int berechneNeuesFeld(int augenzahl) {

		int neuesFeld = this.feldnummer + augenzahl;

		if (neuesFeld > 49)
			neuesFeld = neuesFeld - 40;

		if (this.spielernummer == 10) {
			if (this.feldnummer > neuesFeld)
				neuesFeld = neuesFeld + 100;
		} else {
			if (this.feldnummer < this.spielernummer * 10 && neuesFeld >= this.spielernummer * 10)
				neuesFeld = neuesFeld + 100;
		}

		return neuesFeld;
	}

	public boolean setzeNeuesFeld(int neuesFeld) {

		if (neuesFeld > 104 + this.spielernummer * 10){
			System.out.println("Augenzahl ist zu groﬂ!");
			return false;
		}

		this.feldnummer = neuesFeld;
		return true;
	}

}
