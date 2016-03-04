package si.projekt.maedn;

import java.util.HashMap;

public class Start {

	static int spielerAnzahl;
	static boolean beendet = false;
	static HashMap<Integer, Spieler> spieler = new HashMap<Integer, Spieler>();

	public static void main(String[] args) {
		erzeugeSpieler();
		spielAblauf();
	}

	private static void erzeugeSpieler() {
		System.out.println("Wieviele Spieler?");
		spielerAnzahl = Integer.parseInt(Utils.readString());
		for (int i = 1; i <= spielerAnzahl; i++) {
			spieler.put(i, new Spieler(i));
		}
	}

	private static void spielAblauf() {
		while (beendet == false) {
			for (int spielernummer : spieler.keySet()) {

				Spieler aktuellerSpieler = spieler.get(spielernummer);
				System.out.println(aktuellerSpieler.name + " ist dran.");
				int neuesFeld = 0;
				
				if (aktuellerSpieler.dreimalWuerfeln() == true) {
					if (Wuerfel.dreimalWuerfeln() == true) {
						neuesFeld = aktuellerSpieler.ausruecken();
					} else {
						System.out.println("Keine 6 gewürfelt!");
					}
				} else {
					neuesFeld = aktuellerSpieler.rutschen();
					if (neuesFeld == -99) {
						System.out.println("Zug nicht möglich!");
					} else {
						rauswerfen(neuesFeld, aktuellerSpieler.spielernummer);
						System.out.println("Zug beendet!");
						
					}
				}
				aktuellerSpieler.druckSpielstand();
			}

		}
	}

	private static void rauswerfen(int neuesFeld, int spielerNummer) {
		for (int rspielerNummer : spieler.keySet()) {
			if (rspielerNummer != spielerNummer) {
				Spieler rspieler = spieler.get(rspielerNummer);
				for (int spielFigurNummer : rspieler.holeSpielfiguren().keySet()) {
					Spielfigur spielFigur = rspieler.holeSpielfiguren().get(spielFigurNummer);
					if (spielFigur.feldnummer == neuesFeld) {
						spielFigur.rauswerfen();
					}
				}
			}

		}
	}

}
