package si.projekt.maedn;

import java.util.HashMap;

public class Spieler {

	int spielernummer;
	String name;
	static HashMap<Integer, Spielfigur> spielfiguren = new HashMap<Integer, Spielfigur>();

	boolean ziel;

	public Spieler(int spielernummer) {
		this.spielernummer = spielernummer;
		System.out.println("Name Spieler " + spielernummer + "?");
		this.name = Utils.readString();
		erzeugeSpielfiguren();
	}

	public void erzeugeSpielfiguren() {
		for (int k = 1; k <= 4; k++) {
			Spielfigur spielfigur = new Spielfigur(this.spielernummer, k);
			spielfiguren.put(k, spielfigur);
		}
	}

	public int ausruecken() {
		System.out.println("Welche Spielfigur ausrücken?");
		int figurnummer = Integer.parseInt(Utils.readString());
		Spielfigur spielfigur = spielfiguren.get(figurnummer);
		if (spielfigur.feldnummer > 0) {
			System.out.println("Spielfigur steht nicht im Startbereich!");
			return -99;
		}
		return spielfigur.ausRuecken();
	}

	public int rutschen() {
		int augenzahl = Wuerfel.einmalWuerfeln();
		if (augenzahl == 6) {
			return ausruecken();
		}

		System.out.println("Welche Spielfigur rutschen?");
		int figurnummer = Integer.parseInt(Utils.readString());
		Spielfigur spielfigur = spielfiguren.get(figurnummer);
		if (spielfigur.feldnummer < 0) {
			System.out.println("Spielfigur steht im Startbereich!");
			return -99;
		}

		int neuesFeld = spielfigur.berechneNeuesFeld(augenzahl);

		for (int spielFigurNummer : spielfiguren.keySet()) {
			if (spielFigurNummer != figurnummer) {
				Spielfigur rspielfigur = spielfiguren.get(spielFigurNummer);
				if (rspielfigur.feldnummer == spielfigur.feldnummer) {
					System.out.println("Auf dem Feld steht bereits ein eigener Spielstein");
					return -99;
				}
				if (rspielfigur.feldnummer > 100 && rspielfigur.feldnummer < spielfigur.feldnummer) {
					System.out.println("Im Ziel kann nicht überholt werden!");
					return -99;
				}

			}
		}

		if (spielfigur.setzeNeuesFeld(neuesFeld) == false) {
			return -99;
		} else {
			return neuesFeld;
		}

	}

	public boolean dreimalWuerfeln() {
		for (Integer spielernummer : spielfiguren.keySet()) {
			if (spielfiguren.get(spielernummer).darfRutschen() == true) {
				return false;
			}
		}
		return true;
	}

	public void druckSpielstand() {
		System.out.println("----------aktueller Stand-----------");
		for (Integer spielernummer : spielfiguren.keySet()) {
			Spielfigur spielfigur = spielfiguren.get(spielernummer);
			System.out.println("Spieler - " + spielfigur.spielernummer + " - Figur: " + spielfigur.figurnummer
					+ " - Feld: " + spielfigur.feldnummer);
		}
	}

	public HashMap<Integer, Spielfigur> holeSpielfiguren() {
		return spielfiguren;
	}

}
