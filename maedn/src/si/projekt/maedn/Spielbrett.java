package si.projekt.maedn;

public class Spielbrett {
	Figur[] spielbrettArray;

	Figur[][] startBoxArray;

	Figur[] zielBoxArray;

	public Spielbrett() {
		spielbrettArray = new Figur[40];
		startBoxArray = new Figur[2][4];
		zielBoxArray = new Figur[8];
	}

	public void anzeigen() {
		String feld;
		int i;

		System.out.println("Startboxen:");
		for (i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (startBoxArray[i][j] == null)
					feld = ".";
				else
					feld = startBoxArray[i][j].toString();
				System.out.print(feld + " ");
			}
			System.out.println();
		}

		System.out.println("Spielfeld:");
		for (i = 0; i < spielbrettArray.length; i++) {
			if (spielbrettArray[i] == null)
				feld = ".";
			else
				feld = spielbrettArray[i].toString();
			System.out.print(feld + " ");
		}
		System.out.println();

		System.out.println("Ziel:");
		for (i = 0; i < zielBoxArray.length; i++) {
			if (zielBoxArray[i] == null)
				feld = ".";
			else
				feld = zielBoxArray[i].toString();
			System.out.print(feld + " ");
		}
		System.out.println();

	}

	public boolean bewegen(String figurSpielerName, int figurID, int zahl) {
		Figur inDerHand = null;

		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (startBoxArray[i][j] != null
						&& figurSpielerName
								.equals(startBoxArray[i][j].figurSpielerName)
						&& figurID == startBoxArray[i][j].figurID) {
					if (zahl == 6) {
						inDerHand = startBoxArray[i][j];
						startBoxArray[i][j] = null;
						zahl = 0;
					} else {
						System.out
								.println("Geht nicht! Nur bei 6 hinausfahren!");
					}
				}
			}
		}
		int position = 0; 
		for (int p = 0; p < 40; p++) {
			if (spielbrettArray[p] != null
					&& figurSpielerName
							.equals(spielbrettArray[p].figurSpielerName)
					&& figurID == spielbrettArray[p].figurID) {
				position = p;
				inDerHand = spielbrettArray[p];
				spielbrettArray[p] = null;
			}
		}

		if (inDerHand != null) {

			
			if (position + zahl < 40) {

				if (spielbrettArray[position + zahl] == null) {
					spielbrettArray[position + zahl] = inDerHand;
					inDerHand = null;
					return true;
				} else {
					for (int y = 0; y < 2; y++) {
						for (int x = 0; x < 4; x++) {
							if (startBoxArray[y][x] == null) {
								startBoxArray[y][x] = spielbrettArray[position
										+ zahl];
								System.out.println("Figur hinausgeworfen!");
								spielbrettArray[position + zahl] = inDerHand;
								inDerHand = null;
								return true;
							}
						}
					}

				}
			} else {

				for (int p = 0; p < 40; p++) {
					if (zielBoxArray[p] == null) {
						zielBoxArray[p] = inDerHand;
						inDerHand = null;
						return true;
					}

				}

			}

		}
		return true;
	}
}
