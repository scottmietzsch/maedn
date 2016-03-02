package si.projekt.maedn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
	public static String readString() {
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
