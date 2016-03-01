package si.projekt.maedn;



public abstract class Spieler {

	String name;

	wuerfel a;

	public Spieler() {
		a = new wuerfel();
	}

	public int wuerfeln(){
		return(a.wuerfeln());
	}
	
	abstract public void weiter();
	abstract public int fragen();
	
}
