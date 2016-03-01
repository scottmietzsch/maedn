package si.projekt.maedn;

public class wuerfel {

	public int wuerfeln() {
		int zufall = (int) (6 * Math.random()) + 1;
		System.out.println("Es wurde " + zufall + " gewuerfelt!");
		return zufall;
	}
}
