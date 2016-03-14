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
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

public class GUI {

	static Shell shlMeadn;
	static Display display;
	static HashMap<Integer, Canvas> spielfiguren = new HashMap<Integer, Canvas>();

	public static void setzeSpielfigur(int spielernummer, int figurnummer, int feldnummer) {
		Canvas spielfigur = spielfiguren.get(spielernummer * 10 + figurnummer);
		switch (feldnummer) {
		case -11:
			spielfigur.setLocation(50, 610);
			break;
		case -12:
			spielfigur.setLocation(118, 610);
			break;
		case -13:
			spielfigur.setLocation(50, 680);
			break;
		case -14:
			spielfigur.setLocation(118, 680);
			break;

		case -21:
			spielfigur.setLocation(50, 10);
			break;
		case -22:
			spielfigur.setLocation(118, 10);
			break;
		case -23:
			spielfigur.setLocation(50, 80);
			break;
		case -24:
			spielfigur.setLocation(118, 80);
			break;
			
		case -31:
			spielfigur.setLocation(650, 10);
			break;
		case -32:
			spielfigur.setLocation(718, 10);
			break;
		case -33:
			spielfigur.setLocation(650, 80);
			break;
		case -34:
			spielfigur.setLocation(718, 80);
			break;
			
		case -41:
			spielfigur.setLocation(650, 610);
			break;
		case -42:
			spielfigur.setLocation(718, 610);
			break;
		case -43:
			spielfigur.setLocation(650, 680);
			break;
		case -44:
			spielfigur.setLocation(718, 680);
			break;
			
		case 10:
			spielfigur.setLocation(318, 680);
			break;
		case 11:
			spielfigur.setLocation(318, 610);
			break;
		case 12:
			spielfigur.setLocation(318, 547);
			break;
		case 13:
			spielfigur.setLocation(318, 479);
			break;
		case 14:
			spielfigur.setLocation(318, 420);
			break;
		case 15:
			spielfigur.setLocation(252, 420);
			break;
		case 16:
			spielfigur.setLocation(184, 420);
			break;
		case 17:
			spielfigur.setLocation(120, 420);
			break;
		case 18:
			spielfigur.setLocation(52, 420);
			break;
		case 19:
			spielfigur.setLocation(52, 350);
			break;
			
		case 20:
			spielfigur.setLocation(52, 284);
			break;
		case 21:
			spielfigur.setLocation(120, 284);
			break;
		case 22:
			spielfigur.setLocation(184, 284);
			break;
		case 23:
			spielfigur.setLocation(252, 284);
			break;
		case 24:
			spielfigur.setLocation(318, 284);
			break;
		case 25:
			spielfigur.setLocation(318, 219);
			break;
		case 26:
			spielfigur.setLocation(318, 149);
			break;
		case 27:
			spielfigur.setLocation(318, 83);
			break;
		case 28:
			spielfigur.setLocation(318, 18);
			break;
		case 29:
			spielfigur.setLocation(385, 18);
			break;
			
		case 30:
			spielfigur.setLocation(452, 18);
			break;
		case 31:
			spielfigur.setLocation(452, 83);
			break;
		case 32:
			spielfigur.setLocation(452, 149);
			break;
		case 33:
			spielfigur.setLocation(452, 219);
			break;
		case 34:
			spielfigur.setLocation(452, 284);
			break;
		case 35:
			spielfigur.setLocation(518, 284);
			break;
		case 36:
			spielfigur.setLocation(585, 284);
			break;
		case 37:
			spielfigur.setLocation(653, 284);
			break;
		case 38:
			spielfigur.setLocation(718, 284);
			break;
		case 39:
			spielfigur.setLocation(718, 350);
			break;
			
		case 40:
			spielfigur.setLocation(718, 420);
			break;
		case 41:
			spielfigur.setLocation(653, 420);
			break;
		case 42:
			spielfigur.setLocation(585, 420);
			break;
		case 43:
			spielfigur.setLocation(518, 420);
			break;
		case 44:
			spielfigur.setLocation(452, 420);
			break;
		case 45:
			spielfigur.setLocation(452, 479);
			break;
		case 46:
			spielfigur.setLocation(452, 547);
			break;
		case 47:
			spielfigur.setLocation(452, 610);
			break;
		case 48:
			spielfigur.setLocation(452, 680);
			break;
		case 49:
			spielfigur.setLocation(385, 680);
			break;
			
		case 111:
			spielfigur.setLocation(384, 618);
			break;
		case 112:
			spielfigur.setLocation(384, 550);
			break;
		case 113:
			spielfigur.setLocation(384, 486);
			break;
		case 114:
			spielfigur.setLocation(384, 418);
			break;
			
		case 121:
			spielfigur.setLocation(118, 350);
			break;
		case 122:
			spielfigur.setLocation(185, 350);
			break;
		case 123:
			spielfigur.setLocation(251, 350);
			break;
		case 124:
			spielfigur.setLocation(318, 350);
			break;
			
		case 131:
			spielfigur.setLocation(384, 82);
			break;
		case 132:
			spielfigur.setLocation(384, 150);
			break;
		case 133:
			spielfigur.setLocation(384, 218);
			break;
		case 134:
			spielfigur.setLocation(384, 282);
			break;
			
		case 141:
			spielfigur.setLocation(651, 350);
			break;
		case 142:
			spielfigur.setLocation(585, 350);
			break;
		case 143:
			spielfigur.setLocation(518, 350);
			break;
		case 144:
			spielfigur.setLocation(450, 350);
			break;
		}

	}
	
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

		Label lblNewLabel_1 = new Label(shlMeadn, SWT.NONE);
		lblNewLabel_1
				.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurSchwarz.png"));
		lblNewLabel_1.setBounds(452, 349, 31, 66);

		Label lblNewLabel = new Label(shlMeadn, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Spielfeld.png"));
		lblNewLabel.setBounds(0, 0, 800, 800);

		shlMeadn.open();
		shlMeadn.layout();
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
		Canvas spielfigur = new Canvas(shlMeadn, SWT.TRANSPARENT);
		spielfigur.setLocation(116, 180);
		spielfigur.setSize(127, 159);
		spielfigur.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				switch (spielernummer) {
				case 1:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurSchwarz.png"),
							0, 0);
					break;
				case 2:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurGelb.png"), 0,
							0);
					break;
				case 3:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurGruen.png"), 0,
							0);
					break;
				case 4:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurRot.png"), 0,
							0);
					break;
				}
			}
		});

		spielfiguren.put(spielernummer * 10 + figurnummer, spielfigur);

	}

	public static void rad() {
		while (!shlMeadn.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
