package si.projekt.maedn;

import java.util.HashMap;

public class Spiel {

	static int spielerAnzahl = 0;
	static HashMap<Integer, Spieler> spieler = new HashMap<Integer, Spieler>();
	static HashMap<Integer, String> plaetze = new HashMap<Integer, String>();

	//Spieleinstieg
	public static void main(String[] args) {

		GUI.oeffneFenster(); //Spielfenster öffnen
		erzeugeSpieler(); //Spieleranzahl und Namen holen, Spiel vorbereiten
		GUI.zeigeSpielfeld(); //Spielfeld mit Figuren Anzeigen
		spielAblauf(); //Ablauf des Spiels
	}

	private static void erzeugeSpieler() {

		spielerAnzahl = GUI.holeSpielerAnzahl();

		for (int i = 1; i <= spielerAnzahl; i++) {
			spieler.put(i, new Spieler(i));
		}

	}

	private static void spielAblauf() {
		int beendet = 0;
		while (beendet < spielerAnzahl) { //solange Spiel nicht beendet ist
			for (int spielernummer : spieler.keySet()) { //für jeden Spieler nacheinander durchgehen
				Spieler aktuellerSpieler = spieler.get(spielernummer);

				if (aktuellerSpieler.beendet == false) {

					int neuesFeld = 0;
					int augenzahl = 0;
					
					String endText = "Zug beendet! Bitte Bestätigen...";

					if (aktuellerSpieler.dreimalWuerfeln() == true) { //darf Spieler dreimal würfeln?
						GUI.zeigeText(aktuellerSpieler.name
								+ " ist dran und darf dreimal würfeln! Würfelbecher anklicken zum würfeln...");
						if (Wuerfel.dreimalWuerfeln() == true) { //wurde nach 3 mal würfeln eine 6 gewürfelt?
							augenzahl = 6;
						} else {
							endText= "Keine 6 gewürfelt - Zug beenden! Bitte Bestätigen...";
						}
					} else {
						GUI.zeigeText(aktuellerSpieler.name + " ist dran. Würfelbecher anklicken zum würfeln...");
						augenzahl = Wuerfel.einmalWuerfeln();
					}

					if (augenzahl > 0) {
						neuesFeld = aktuellerSpieler.rutschen(augenzahl); //Felder rutschen

						if (neuesFeld != -99) { // War Zug möglich?
							if (neuesFeld == aktuellerSpieler.spielernummer * 10) { //wurde eine Figur ausgerückt?

								rauswerfen(neuesFeld, aktuellerSpieler.spielernummer); //werfe Figur raus
								neuesFeld = aktuellerSpieler.nachausruecken(); //nochmal würfeln
							}
							if (rauswerfen(neuesFeld, aktuellerSpieler.spielernummer)) {
								endText = "Spieler rausgeworfen! Zug beendet! Bitte Bestätigen...";
							}
						} else {
							endText = "Zug nicht möglich - beenden! Bitte Bestätigen...";
						}

					}

					if (aktuellerSpieler.pruefeBeendet() == true) { //prüfe, ob Spieler im Ziel ist
						beendet++;
						plaetze.put(beendet, aktuellerSpieler.name);
						endText = aktuellerSpieler.name + " ist im Ziel!  Bitte Bestätigen...";
					}
					GUI.zeigeText(endText);
					GUI.warteAufBeenden(); //warte auf Bestätigung des Spielers
				}
			}
		}

		GUI.zeigeText("-----------Spiel beendet!--------------");
		GUI.ende(plaetze); //Zeige Plätze an
	}

	private static boolean rauswerfen(int neuesFeld, int spielerNummer) {
		for (int rspielerNummer : spieler.keySet()) { //gehe alle anderen Spielsteine durch; prüfe, ob jemand auf Feld stand
			if (rspielerNummer != spielerNummer) {
				Spieler rspieler = spieler.get(rspielerNummer);
				for (int spielFigurNummer : rspieler.holeSpielfiguren().keySet()) {
					Spielfigur spielFigur = rspieler.holeSpielfiguren().get(spielFigurNummer);
					if (spielFigur.feldnummer == neuesFeld) {
						spielFigur.rauswerfen();
						return true;
					}
				}
			}

		}
		return false;
	}
}
