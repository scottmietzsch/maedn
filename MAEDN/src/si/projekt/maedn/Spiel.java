package si.projekt.maedn;

import java.util.HashMap;

public class Spiel {

	static int spielerAnzahl = 0;
	static HashMap<Integer, Spieler> spieler = new HashMap<Integer, Spieler>();
	static HashMap<Integer, String> plaetze = new HashMap<Integer, String>();

	public static void main(String[] args) {

		GUI.oeffneFenster();
		erzeugeSpieler();
		GUI.zeigeSpielfeld();
		spielAblauf();
	}

	private static void erzeugeSpieler() {

		spielerAnzahl = GUI.holeSpielerAnzahl();

		for (int i = 1; i <= spielerAnzahl; i++) {
			spieler.put(i, new Spieler(i));
		}
		
		

	}

	private static void spielAblauf() {
		int beendet = 0;
		while (beendet < spielerAnzahl) {
			for (int spielernummer : spieler.keySet()) {
				Spieler aktuellerSpieler = spieler.get(spielernummer);

				if (aktuellerSpieler.beendet == false) {

					int neuesFeld = 0;
					int augenzahl = 0;

					if (aktuellerSpieler.dreimalWuerfeln() == true) {
						GUI.zeigeText(aktuellerSpieler.name + " ist dran und darf dreimal würfeln! Würfelbecher anklicken zum würfeln...");
						if (Wuerfel.dreimalWuerfeln() == true) {
							augenzahl = 6;
						} else {
							GUI.zeigeText("Keine 6 gewürfelt - Zug beenden! Bitte Bestätigen...");
						}
					} else {

						GUI.zeigeText(aktuellerSpieler.name + " ist dran. Würfelbecher anklicken zum würfeln...");
						augenzahl = Wuerfel.einmalWuerfeln();
					}

					if (augenzahl > 0) {
						neuesFeld = aktuellerSpieler.rutschen(augenzahl);

						if (neuesFeld != -99) {
							if (neuesFeld == aktuellerSpieler.spielernummer *10){
								rauswerfen(neuesFeld, aktuellerSpieler.spielernummer);
								aktuellerSpieler.nachausruecken();
							}
							rauswerfen(neuesFeld, aktuellerSpieler.spielernummer);
							GUI.zeigeText("Zug beenden! Bitte Bestätigen...");
						} else {
							GUI.zeigeText("Zug nicht möglich - beenden! Bitte Bestätigen...");
						}
						GUI.warteAufBeenden();
						
					}

					if (aktuellerSpieler.pruefeBeendet() == true) {
						GUI.zeigeText(aktuellerSpieler.name + " ist im Ziel!");
						beendet++;
						plaetze.put(beendet, aktuellerSpieler.name);
						GUI.warteAufBeenden();
					}
				}
			}
		}

		System.out.println("-----------Spiel beendet! Die Platzierungen sind:--------------");
		for (int platz : plaetze.keySet()) {
			System.out.println(platz + ". Platz: " + plaetze.get(platz));
		}
		System.out.println("---------------------------------------------------------------");
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
