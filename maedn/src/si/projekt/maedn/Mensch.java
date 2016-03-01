package si.projekt.maedn;


import java.io.*;

public class Mensch extends Spieler {

	static int spielerAnzahl = 1;

	static String readString() {
		String Eingabe = new String();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			Eingabe = in.readLine();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return Eingabe;
	}

	public Mensch() {
		super();
		System.out.println("Name Spieler " + spielerAnzahl
				+ " eingeben und Return-Taste druecken:");
		this.name = readString();
		System.out.println("Spieler " + spielerAnzahl + " heisst: " + name);
		spielerAnzahl++;
	}

	public void weiter() {
		System.out.println("weiter?");
		readString();
	}

	public int fragen() {
		System.out.println("Mit welcher Spielfigur willst du ziehen, " + name
				+ "? (Gib eine Zahl von 1-4 ein)");
		int i = 0;
		boolean ok = true;
		String x = "Ungueltige Figur! Zahl zwischen 1 und 4 eingeben!";

		do {
			ok = true;

			try {
				i = Integer.parseInt(readString());
			} catch (Exception ex) {
				ok = false;
			}

			if (i > 0 && i < 5) {
				ok = true;
			} else {
				ok = false;
				System.out.println(x);
			}

		} while (ok == false);

		return i;

	}
}
