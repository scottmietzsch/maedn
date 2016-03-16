package si.projekt.maedn;

public class Spielfigur {
	
	int spielernummer = 0;
	int figurnummer = 0;
	int feldnummer = 0;

	public Spielfigur(int spielernummer, int figurnummer) {
		this.spielernummer = spielernummer;
		this.figurnummer = figurnummer;
		this.feldnummer = (spielernummer * 10 + figurnummer) * -1;
		GUI.erzeugeSpielfigur(spielernummer, figurnummer);
		GUI.setzeSpielfigur(spielernummer, figurnummer, feldnummer);
	}

	public int ausRuecken() {
		this.feldnummer = this.spielernummer * 10;
		GUI.setzeSpielfigur(spielernummer, figurnummer, feldnummer);
		return this.feldnummer;
	}
	
	public boolean rauswerfen(){
		this.feldnummer = (spielernummer * 10 + figurnummer) * -1;
		GUI.setzeSpielfigur(spielernummer, figurnummer, feldnummer);
		return true;
	}

	public int berechneNeuesFeld(int augenzahl) {

		int neuesFeld = this.feldnummer + augenzahl;

		if (this.feldnummer<100){
			if (neuesFeld > 49)
				neuesFeld = neuesFeld - 40;

			if (this.spielernummer == 1) {
				if (this.feldnummer > neuesFeld)
					neuesFeld = neuesFeld + 100;
			} else {
				if (this.feldnummer < this.spielernummer * 10 && neuesFeld >= this.spielernummer * 10)
					neuesFeld = neuesFeld + 100;
			}
		}

		return neuesFeld;
	}

	public void setzeNeuesFeld(int neuesFeld) {
		this.feldnummer = neuesFeld;
		GUI.setzeSpielfigur(spielernummer, figurnummer, feldnummer);
	}

}
