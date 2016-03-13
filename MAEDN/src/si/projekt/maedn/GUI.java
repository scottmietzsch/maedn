package si.projekt.maedn;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Canvas;

public class GUI {

	static Shell shlMeadn;
	static Display display;
	static HashMap<Integer, Label> spielfiguren = new HashMap<Integer, Label>();

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void oeffneFenster() {

		display = Display.getDefault();
		shlMeadn = new Shell();
		shlMeadn.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		shlMeadn.setMinimumSize(new Point(816, 839));
		shlMeadn.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurRot.png"));
		shlMeadn.setSize(816, 839);
		shlMeadn.setText("MEADN");
		
//		Label lblNewLabel = new Label(shlMeadn, SWT.NONE);
//		lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Spielfeld.png"));
//		lblNewLabel.setBounds(0, 0, 800, 800);
		
		shlMeadn.open();
		shlMeadn.layout();
	}
	

	public static void setzeSpielfigur(int spielernummer, int figurnummer, int feldnummer) {
		Label spielfigur = spielfiguren.get(spielernummer * 10 + figurnummer);
		switch (feldnummer) {
		case -11:
			spielfigur.setBounds(48, 616, 33, 60);
			break;
		case -12:
			spielfigur.setBounds(117, 617, 33, 60);
			break;
		case -13:
			spielfigur.setBounds(51, 681, 33, 60);
			break;
		case -14:
			spielfigur.setBounds(117, 682, 33, 60);
			break;
		}
	}

	public static void zeigeSpielfeld() {
		Label lblNewLabel = new Label(shlMeadn, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Spielfeld.png"));
		lblNewLabel.setBounds(0, 0, 800, 800);
	}

	public static int holeSpielerAnzahl() {

		Label lblSpieleranzahl = new Label(shlMeadn, SWT.NONE);
		lblSpieleranzahl.setBounds(10, 45, 75, 15);
		lblSpieleranzahl.setText("Spieleranzahl");

		Label label = new Label(shlMeadn, SWT.NONE);
		label.setBounds(116, 10, 18, 15);
		label.setText("1");

		Label label_1 = new Label(shlMeadn, SWT.NONE);
		label_1.setText("2");
		label_1.setBounds(165, 10, 18, 15);

		Label label_2 = new Label(shlMeadn, SWT.NONE);
		label_2.setText("3");
		label_2.setBounds(212, 10, 18, 15);

		Label label_3 = new Label(shlMeadn, SWT.NONE);
		label_3.setText("4");
		label_3.setBounds(260, 10, 18, 15);

		Scale spielerAnzahlScale = new Scale(shlMeadn, SWT.NONE);
		spielerAnzahlScale.setPageIncrement(1);
		spielerAnzahlScale.setMaximum(4);
		spielerAnzahlScale.setMinimum(1);
		spielerAnzahlScale.setSelection(1);
		spielerAnzahlScale.setBounds(107, 31, 170, 42);

		Button btnOk = new Button(shlMeadn, SWT.NONE);
		btnOk.setBounds(295, 40, 28, 25);
		btnOk.setText("OK");

		int spielerAnzahl = spielerAnzahlScale.getSelection();

		btnOk.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					btnOk.dispose();
					break;
				}
			}
		});

		while (!btnOk.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		spielerAnzahl = spielerAnzahlScale.getSelection();
		spielerAnzahlScale.dispose();
		lblSpieleranzahl.dispose();
		label.dispose();
		label_1.dispose();
		label_2.dispose();
		label_3.dispose();

		return spielerAnzahl;
	}

	public static String holeSpielerName(int spielernummer) {

		String spielerName = "Spieler " + spielernummer;

		Text nameSpielerText;
		nameSpielerText = new Text(shlMeadn, SWT.BORDER);
		nameSpielerText.setBounds(107, 103, 170, 21);

		Label lblNameSpieler = new Label(shlMeadn, SWT.NONE);
		lblNameSpieler.setBounds(10, 106, 91, 15);
		lblNameSpieler.setText("Name Spieler " + spielernummer);

		Button button = new Button(shlMeadn, SWT.NONE);
		button.setText("OK");
		button.setBounds(295, 101, 28, 25);

		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					button.dispose();
					break;
				}
			}
		});

		while (!button.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		spielerName = nameSpielerText.getText();
		nameSpielerText.dispose();
		lblNameSpieler.dispose();

		return spielerName;

	}

	public static void erzeugeSpielfigur(int spielernummer, int figurnummer) {
		Label label = new Label(shlMeadn, SWT.NONE);
		
		switch (spielernummer) {
		case 1:
			label.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurSchwarz.png"));
			break;
		case 2:
			label.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurGelb.png"));
			break;
		case 3:
			label.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurGruen.png"));
			break;
		case 4:
			label.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurRot.png"));
			break;
		}
		
		spielfiguren.put(spielernummer * 10 + figurnummer, label);
		
	}
	
	public static void rad(){
		while (!shlMeadn.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
