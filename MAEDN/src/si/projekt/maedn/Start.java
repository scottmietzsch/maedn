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

	private static void spielAblauf() {
		while (beendet == false) {
			for (int spielernummer : spieler.keySet()) {

				Spieler aktuellerSpieler = spieler.get(spielernummer);
				System.out.println(aktuellerSpieler.name + " ist dran.");

				if (aktuellerSpieler.dreimalWuerfeln() == true) {
					if (Wuerfel.dreimalWuerfeln() == true){
						aktuellerSpieler.ausruecken();
					} else {
						System.out.println("Keine 6 gewürfelt!");
					}
				} else {
					aktuellerSpieler.rutschen();
				}
				aktuellerSpieler.druckSpielstand();
			}

		}
	}

	private static void erzeugeSpieler() {
		System.out.println("Wieviele Spieler?");
		spielerAnzahl = Integer.parseInt(Utils.readString());
		for (int i = 1; i <= spielerAnzahl; i++) {
			spieler.put(i, new Spieler(i));
		}
	}

}
