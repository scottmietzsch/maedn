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
						GUI.zeigeText(aktuellerSpieler.name + " ist dran und darf dreimal w�rfeln! W�rfelbecher anklicken zum w�rfeln...");
						if (Wuerfel.dreimalWuerfeln() == true) {
							augenzahl = 6;
						} else {
							GUI.zeigeText("Keine 6 gew�rfelt - Zug beenden! Bitte Best�tigen...");
						}
					} else {

						GUI.zeigeText(aktuellerSpieler.name + " ist dran. W�rfelbecher anklicken zum w�rfeln...");
						augenzahl = Wuerfel.einmalWuerfeln();
					}
					
					String endText = "Zug beendet! Bitte Best�tigen...";

					if (augenzahl > 0) {
						neuesFeld = aktuellerSpieler.rutschen(augenzahl);

						if (neuesFeld != -99) {
							if (neuesFeld == aktuellerSpieler.spielernummer *10){
								rauswerfen(neuesFeld, aktuellerSpieler.spielernummer);
								aktuellerSpieler.nachausruecken();
							}
							if(rauswerfen(neuesFeld, aktuellerSpieler.spielernummer)){
								endText = "Spieler rausgeworfen! Zug beendet! Bitte Best�tigen...";
							}
						} else {
							endText = "Zug nicht m�glich - beenden! Bitte Best�tigen...";
						}
						
					}

					if (aktuellerSpieler.pruefeBeendet() == true) {
						beendet++;
						plaetze.put(beendet, aktuellerSpieler.name);
						endText = aktuellerSpieler.name + " ist im Ziel!  Bitte Best�tigen...";
					}
					GUI.zeigeText(endText);
					GUI.warteAufBeenden();
				}
			}
		}
		

		GUI.zeigeText("-----------Spiel beendet!--------------");
		GUI.ende(plaetze);
	}

	private static boolean rauswerfen(int neuesFeld, int spielerNummer) {
		for (int rspielerNummer : spieler.keySet()) {
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
