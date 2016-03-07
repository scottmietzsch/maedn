package si.projekt.maedn;

import java.util.HashMap;

public class Spieler {

	int spielernummer = 0;
	String name = "Spieler";
	boolean beendet = false;
	HashMap<Integer, Spielfigur> spielfiguren = new HashMap<Integer, Spielfigur>();

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

	public int rutschen(int augenzahl) {

		HashMap<Integer, Integer> figurenStatus = pruefeFiguren(augenzahl);

		if (augenzahl == 6) {
			for (int rfigurnummer : figurenStatus.keySet()) {
				if (figurenStatus.get(rfigurnummer) == -1)
					return ausruecken();
			}
		}

		boolean figuren = false;
		for (int rfigurnummer : figurenStatus.keySet()) {
			if (figurenStatus.get(rfigurnummer) == 1) {
				figuren = true;
				break;
			}
		}

		int neuesFeld = -99;
		if (figuren == true) {
			do {
				System.out.println("Welche Spielfigur rutschen?");
				int figurnummer = Integer.parseInt(Utils.readString());

				int figurStatus = pruefeFiguren(augenzahl).get(figurnummer);
				switch (figurStatus) {
				case 1:
					neuesFeld = setzeFigur(augenzahl, figurnummer);
					break;
				case -1:
					System.out.println("Spielfigur steht im Startbereich!");
					break;
				case 9:
					System.out.println("Auf dem Feld steht bereits ein eigener Spielstein");
					break;
				case 99:
					System.out.println("Im Ziel kann nicht überholt werden!");
					break;
				case 999:
					System.out.println("Augenzahl ist zu groß!");
					break;
				}
			} while (neuesFeld == -99);
		}

		return neuesFeld;

	}
	
	private int ausruecken() {

		int neuesFeld = -99;
		int figurnummer = 0;

		do {

			System.out.println("Welche Spielfigur ausrücken?");
			figurnummer = Integer.parseInt(Utils.readString());
			Spielfigur spielfigur = spielfiguren.get(figurnummer);

			if (pruefeFigur(spielernummer * 10, figurnummer) != -1) {
				System.out.println("Spielfigur steht nicht im Startbereich!");
			} else {
				neuesFeld = spielfigur.ausRuecken();
			}

		} while (neuesFeld == -99);

		System.out.println("Nochmal würfeln und gleiche Figur rutschen.");
		int augenzahl = Wuerfel.einmalWuerfeln();

		if (pruefeFigur(augenzahl, figurnummer) != 1) {
			System.out.println("Figur rutschen nicht möglich!");
			neuesFeld = rutschen(augenzahl);
		} else {
			neuesFeld = setzeFigur(augenzahl, figurnummer);
		}

		return neuesFeld;

	}


	private int setzeFigur(int augenzahl, int figurnummer) {
		Spielfigur spielfigur = spielfiguren.get(figurnummer);
		int neuesFeld = spielfigur.berechneNeuesFeld(augenzahl);
		spielfigur.setzeNeuesFeld(neuesFeld);
		return neuesFeld;
	}

	private HashMap<Integer, Integer> pruefeFiguren(int augenzahl) {
		HashMap<Integer, Integer> figurenStatus = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 4; i++) {
			figurenStatus.put(i, pruefeFigur(augenzahl, i));
		}
		return figurenStatus;
	}

	private int pruefeFigur(int augenzahl, int figurnummer) {

		Spielfigur spielfigur = spielfiguren.get(figurnummer);
		if (spielfigur.feldnummer < 0) {
			return -1;
		}

		int neuesFeld = spielfigur.berechneNeuesFeld(augenzahl);

		for (int spielFigurNummer : spielfiguren.keySet()) {
			if (spielFigurNummer != figurnummer) {
				Spielfigur rspielfigur = spielfiguren.get(spielFigurNummer);
				if (rspielfigur.feldnummer == spielfigur.feldnummer) {
					return 9;
				}
				if (rspielfigur.feldnummer > 100 && rspielfigur.feldnummer < spielfigur.feldnummer) {
					System.out.println("Im Ziel kann nicht überholt werden!");
					return 99;
				}
			}
		}

		if (neuesFeld > 104 + this.spielernummer * 10) {
			return 999;
		} else {
			return 1;
		}

	}

	public boolean dreimalWuerfeln() {
		int zielFeld = 104 + spielernummer*100;
		int imZiel = 0;
		int imStart = 0;
		for (Integer spielernummer : spielfiguren.keySet()) {
			int figurFeldnummer = spielfiguren.get(spielernummer).feldnummer;
			if (figurFeldnummer == zielFeld) {
				zielFeld--;
				imZiel++;
			} else if (figurFeldnummer < 0) {
				imStart++;
			}
		}
		if (imZiel + imStart == 4){
			return true;
		} else {
			return false;
		}
	}

	public boolean pruefeBeendet() {
		System.out.println("----------aktueller Stand-----------");
		for (Integer spielernummer : spielfiguren.keySet()) {
			Spielfigur spielfigur = spielfiguren.get(spielernummer);
			System.out.println("Spieler: " + spielfigur.spielernummer + " - Figur: " + spielfigur.figurnummer
					+ " - Feld: " + spielfigur.feldnummer);
		}
		int figurenImZiel = 0;
		for (int spielFigurNummer : spielfiguren.keySet()) {
			Spielfigur spielfigur = spielfiguren.get(spielFigurNummer);
			if (spielfigur.feldnummer > 100) {
				figurenImZiel++;
			}
		}
		if (figurenImZiel == 4) {
			beendet = true;
			return true;
		} else {
			return false;
		}
	}

	public HashMap<Integer, Spielfigur> holeSpielfiguren() {
		return spielfiguren;
	}

}
