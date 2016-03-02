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

	public void ausruecken() {
		System.out.println("Welche Spielfigur ausrücken?");
		int figurnummer = Integer.parseInt(Utils.readString());
		spielfiguren.get(figurnummer).ausRuecken();
	}

	public void rutschen() {
		int augenzahl = Wuerfel.einmalWuerfeln();

		System.out.println("Welche Spielfigur rutschen?");
		int figurnummer = Integer.parseInt(Utils.readString());

		spielfiguren.get(figurnummer).rutschen(augenzahl);

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

}
