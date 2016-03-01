package si.projekt.maedn;

public class Spiel {

	public static void main(String[] args) {
		System.out.println("Spiel gestartet");

		Spielbrett sb = new Spielbrett();

		Spieler s1 = new Mensch();
		Spieler s2 = new Mensch();

		if(s2.name.equals(s1.name)){ 
		do{ 
		
		System.out.println("Gleicher Name geht nicht! Bitte anderen Namen nennen:");	
		Mensch.spielerAnzahl = 2;
		s2 = new Mensch();
		}while(s2.name.equals(s1.name));
				
		}
		
		sb.startBoxArray[0][0] = new Figur(s1.name, 1);
		sb.startBoxArray[0][1] = new Figur(s1.name, 2);
		sb.startBoxArray[0][2] = new Figur(s1.name, 3);
		sb.startBoxArray[0][3] = new Figur(s1.name, 4);
		sb.startBoxArray[1][0] = new Figur(s2.name, 1);
		sb.startBoxArray[1][1] = new Figur(s2.name, 2);
		sb.startBoxArray[1][2] = new Figur(s2.name, 3);
		sb.startBoxArray[1][3] = new Figur(s2.name, 4);

		boolean cont = true;
		do {

			System.out.println(s1.name + " ist dran");

			sb.anzeigen();
			int zahl = s1.wuerfeln();
			int id = s1.fragen();
			sb.bewegen(s1.name, id, zahl);
			sb.anzeigen();
			s1.weiter();

			int x = 0;
			for (int p = 0; p < 8; p++) {
				if (sb.zielBoxArray[p] != null
						&& s1.name.equals(sb.zielBoxArray[p].figurSpielerName)) {
					x++;
				}
			}
			if (x > 3) {
				System.out.println(s1.name + " hat gewonnen!");
				cont = false;
				return;
			}

			System.out.println(s2.name + " ist dran");

			sb.anzeigen();
			zahl = s2.wuerfeln();
			id = s2.fragen();
			sb.bewegen(s2.name, id, zahl);
			sb.anzeigen();
			s2.weiter();

			int y = 0;
			for (int p = 0; p < 8; p++) {
				if (sb.zielBoxArray[p] != null
						&& s2.name.equals(sb.zielBoxArray[p].figurSpielerName)) {
					y++;
				}
			}
			if (y > 3) {
				System.out.println(s2.name + " hat gewonnen!");
				cont = false;
				return;
			}

		} while (cont == true);

	}

}
