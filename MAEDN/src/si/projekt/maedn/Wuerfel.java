package si.projekt.maedn;

public class Wuerfel {

	public static int einmalWuerfeln() { //gib Zufalsszahl zw. 1 und 6 zurück
		GUI.warteAufWuerfel();
		int zufall = (int) (6 * Math.random()) + 1;
		GUI.zeigeAugenzahl(zufall);
		return zufall;
	}

	public static boolean dreimalWuerfeln() { //gib boolschen Wert zurück, ob nach 3 mal Würfeln eine 6 gewürfelt wurde
		boolean sechsGewuerfelt = false;
		for (int i = 3; i > 0; i--) {
			int zufall = einmalWuerfeln();
			if (zufall == 6) {
				sechsGewuerfelt = true;
				break;
			}
		}
		return sechsGewuerfelt;
	}
}
