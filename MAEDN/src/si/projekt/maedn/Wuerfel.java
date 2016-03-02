package si.projekt.maedn;

public class Wuerfel {
	public static int einmalWuerfeln() {
		int zufall = (int) (6 * Math.random()) + 1;
		System.out.println("Es wurde " + zufall + " gewuerfelt!");
		return zufall;
	}
	public static boolean dreimalWuerfeln() {
		boolean sechsGewuerfelt = false;
		for (int i = 3; i>0; i--){
			int zufall = (int) (6 * Math.random()) + 1;
			System.out.println("Es wurde " + zufall + " gewuerfelt!");
			if (zufall==6){
				sechsGewuerfelt = true;
				break;
			}
		}
		return sechsGewuerfelt;
	}
}
