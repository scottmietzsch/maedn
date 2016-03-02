package si.projekt.maedn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Start {

	static int spielerAnzahl;
	static boolean beendet = false;
	static HashMap<Integer, String> spieler = new HashMap<Integer, String>();
	static ArrayList<Spielfigur> spielfiguren = new ArrayList<Spielfigur>();

	public static void main(String[] args) {
		erzeugeSpieler();
		spielAblauf();
	}

	private static void spielAblauf() {
		while (beendet == false) {
			for (int spielernummer : spieler.keySet()) {
				System.out.println("Spieler " + spielernummer + " ist dran.");
				
				boolean dreimalWuerfeln = dreimalWuerfeln(spielernummer);
				if (dreimalWuerfeln == true && Wuerfel.dreimalWuerfeln() == true) {
					ausruecken(spielernummer);
				} else {
					rutschen(spielernummer);
				}

			}
			System.out.println("----------aktueller Stand-----------");
			for (Spielfigur spielfigur : spielfiguren) {
				System.out.println("Spieler - " + spielfigur.spielernummer + " - Figur: " + spielfigur.figurnummer
						+ " - Feld: " + spielfigur.feldnummer);
			}
		}
	}

	private static void rutschen(int spielernummer) {
		int augenzahl = Wuerfel.einmalWuerfeln();

		System.out.println("Welche Spielfigur rutschen?");
		int figurnummer = Integer.parseInt(readString());

		for (Spielfigur spielfigur : spielfiguren) {
			if (spielfigur.spielernummer == spielernummer && spielfigur.figurnummer == figurnummer) {
				spielfigur.rutschen(augenzahl);
			}
		}
	}

	private static void ausruecken(int spielernummer) {
		System.out.println("Welche Spielfigur ausrücken?");
		int figurnummer = Integer.parseInt(readString());
		for (Spielfigur spielfigur : spielfiguren) {
			if (spielfigur.spielernummer == spielernummer && spielfigur.figurnummer == figurnummer) {
				spielfigur.ausRuecken();
				break;
			}
		}
	}

	private static boolean dreimalWuerfeln(int spielernummer) {
		for (Spielfigur spielfigur : spielfiguren) {
			if (spielernummer == spielfigur.spielernummer && spielfigur.darfRutschen() == true) {
				return false;
			}
		}
		return true;
	}

	private static void erzeugeSpieler() {
		System.out.println("Wieviele Spieler?");
		spielerAnzahl = Integer.parseInt(readString());
		for (int i = 1; i <= spielerAnzahl; i++) {
			System.out.println("Name Spieler " + i + "?");
			spieler.put(i, readString());
			erzeugeSpielfiguren(i);
		}
	}

	private static void erzeugeSpielfiguren(int spielernummer) {
		for (int k = 1; k <= 4; k++) {
			Spielfigur spielfigur = new Spielfigur(spielernummer, k);
			spielfiguren.add(spielfigur);
		}
	}

	static String readString() {
		String Eingabe = new String();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Eingabe = in.readLine();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return Eingabe;
	}

}
