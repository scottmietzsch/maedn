package si.projekt.maedn;



public class Figur {
	String figurSpielerName;
	int figurID;

	public Figur(String name, int id) {
		this.figurID = id;
		this.figurSpielerName = name;
	}

	public String toString() {
		return(figurSpielerName + "-" + figurID);
	}
	
}
