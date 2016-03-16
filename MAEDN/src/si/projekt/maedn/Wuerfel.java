package si.projekt.maedn;

public class Wuerfel {
	
	public static int einmalWuerfeln() {
		GUI.warteAufWuerfel();
		int zufall = (int) (6 * Math.random()) + 1;
		GUI.zeigeAugenzahl(zufall);
		return zufall;
	}
	public static boolean dreimalWuerfeln() {
		boolean sechsGewuerfelt = false;
		for (int i = 3; i>0; i--){
			int zufall = einmalWuerfeln();
			if (zufall==6){
				sechsGewuerfelt = true;
				break;
			}
		}
		return sechsGewuerfelt;
	}
}
