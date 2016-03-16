package si.projekt.maedn;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

public class GUI {

	static Shell shlMaedn;
	static Display display;
	static int letzteAusgewaehlteFigur;
	static Label lblWelcome;
	static Label lblMaedn;
	static HashMap<Integer, Canvas> spielfiguren = new HashMap<Integer, Canvas>();
	private static Text textfeld;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void oeffneFenster() {

		display = Display.getDefault();
		shlMaedn = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );
		shlMaedn.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		shlMaedn.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\FigurRot.png"));
		shlMaedn.setSize(808, 851);
		shlMaedn.setText("MEADN");
		
		textfeld = new Text(shlMaedn, SWT.BORDER);
		textfeld.setBounds(0, 801, 802, 21);
		
		lblWelcome = new Label(shlMaedn, SWT.NONE);
		lblWelcome.setImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Maedn.png"));
		lblWelcome.setBounds(196, 72, 400, 284);
		
		lblMaedn = new Label(shlMaedn, SWT.NONE);
		lblMaedn.setFont(SWTResourceManager.getFont("Gabriola", 33, SWT.NORMAL));
		lblMaedn.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMaedn.setBounds(221, 0, 347, 81);
		lblMaedn.setText("Herzlich Willkommen bei");
		
		shlMaedn.open();
		shlMaedn.layout();
	}
	
	public static void zeigeText(String text) {
		textfeld.setText(text);
	}

	public static void zeigeSpielfeld() {
		lblWelcome.dispose();
		lblMaedn.dispose();
		
		for (int spielfigurnummer : spielfiguren.keySet()){
			Canvas spielfigur = spielfiguren.get(spielfigurnummer);
			spielfigur.setSize(33, 60);
		}
		
		shlMaedn.setBackgroundImage(
				SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Spielfeld.png"));
	}

	public static int holeSpielerAnzahl() {
		
		GUI.zeigeText("Wie viele Spieler?");

		Label label = new Label(shlMaedn, SWT.NONE);
		label.setBounds(293, 467, 18, 15);
		label.setText("1");

		Label label_1 = new Label(shlMaedn, SWT.NONE);
		label_1.setText("2");
		label_1.setBounds(342, 467, 18, 15);

		Label label_2 = new Label(shlMaedn, SWT.NONE);
		label_2.setText("3");
		label_2.setBounds(389, 467, 18, 15);

		Label label_3 = new Label(shlMaedn, SWT.NONE);
		label_3.setText("4");
		label_3.setBounds(437, 467, 18, 15);

		Scale spielerAnzahlScale = new Scale(shlMaedn, SWT.NONE);
		spielerAnzahlScale.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		spielerAnzahlScale.setPageIncrement(1);
		spielerAnzahlScale.setMaximum(4);
		spielerAnzahlScale.setMinimum(1);
		spielerAnzahlScale.setSelection(1);
		spielerAnzahlScale.setBounds(285, 488, 170, 42);

		Button btnOk = new Button(shlMaedn, SWT.NONE);
		btnOk.setBounds(478, 488, 28, 25);
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
		label.dispose();
		label_1.dispose();
		label_2.dispose();
		label_3.dispose();

		return spielerAnzahl;
	}

	public static String holeSpielerName(int spielernummer) {
		GUI.zeigeText("Spieler " + spielernummer + ": Trage deinen Namen ein!");

		String spielerName = "Spieler " + spielernummer;
		
		Button button = new Button(shlMaedn, SWT.NONE);
		button.setText("OK");
		button.setBounds(475, 434, 28, 25);
		
		Text nameSpielerText;
		nameSpielerText = new Text(shlMaedn, SWT.BORDER);
		nameSpielerText.setBounds(272, 436, 183, 21);

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

		return spielerName;

	}

	public static void erzeugeSpielfigur(int spielernummer, int figurnummer) {
		Canvas spielfigur = new Canvas(shlMaedn, SWT.TRANSPARENT);
		spielfigur.setSize(0, 0);
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

		case 110:
			spielfigur.setLocation(384, 618);
			break;
		case 111:
			spielfigur.setLocation(384, 550);
			break;
		case 112:
			spielfigur.setLocation(384, 486);
			break;
		case 113:
			spielfigur.setLocation(384, 418);
			break;

		case 120:
			spielfigur.setLocation(118, 350);
			break;
		case 121:
			spielfigur.setLocation(185, 350);
			break;
		case 122:
			spielfigur.setLocation(251, 350);
			break;
		case 123:
			spielfigur.setLocation(318, 350);
			break;

		case 130:
			spielfigur.setLocation(384, 82);
			break;
		case 131:
			spielfigur.setLocation(384, 150);
			break;
		case 132:
			spielfigur.setLocation(384, 218);
			break;
		case 133:
			spielfigur.setLocation(384, 282);
			break;

		case 140:
			spielfigur.setLocation(651, 350);
			break;
		case 141:
			spielfigur.setLocation(585, 350);
			break;
		case 142:
			spielfigur.setLocation(518, 350);
			break;
		case 143:
			spielfigur.setLocation(450, 350);
			break;
		}

	}
	
	public static void warteAufBeenden() {
		Canvas beenden = new Canvas(shlMaedn, SWT.TRANSPARENT);
		beenden.setBounds(350, 350, 100, 100);
		beenden.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Haken.png"), 0,
						0);
			}
		});

		beenden.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				beenden.dispose();
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
			}

		});

		while (!beenden.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void warteAufWuerfel() {
		Canvas wuerfel = new Canvas(shlMaedn, SWT.TRANSPARENT);
		wuerfel.setBounds(350, 350, 100, 100);
		wuerfel.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfelbecher.png"), 0,
						0);
			}
		});

		wuerfel.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				wuerfel.dispose();
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
			}

		});

		while (!wuerfel.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void zeigeAugenzahl(int augenzahl) {
		Canvas wuerfel = new Canvas(shlMaedn, SWT.TRANSPARENT);
		wuerfel.setBounds(375, 375, 50, 50);
		wuerfel.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				switch (augenzahl) {
				case 1:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel1.png"), 0,
							0);
					break;
				case 2:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel2.png"), 0,
							0);
					break;
				case 3:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel3.png"), 0,
							0);
					break;
				case 4:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel4.png"), 0,
							0);
					break;
				case 5:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel5.png"), 0,
							0);
					break;
				case 6:
					e.gc.drawImage(
							SWTResourceManager.getImage("C:\\Users\\philt\\git\\maedn\\MAEDN\\img\\Wuerfel6.png"), 0,
							0);
					break;
				}

			}
		});

		wuerfel.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				wuerfel.dispose();
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
			}

		});

		while (!wuerfel.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static int welcheSpielfigur(int spielernummer) {
		letzteAusgewaehlteFigur = 0;
		
		MouseListener mouseListener1 = new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
			@Override
			public void mouseDown(MouseEvent arg0) {
				letzteAusgewaehlteFigur = 1;
			}
			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		};
		MouseListener mouseListener2 = new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
			@Override
			public void mouseDown(MouseEvent arg0) {
				letzteAusgewaehlteFigur = 2;
			}
			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		};
		MouseListener mouseListener3 = new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
			@Override
			public void mouseDown(MouseEvent arg0) {
				letzteAusgewaehlteFigur = 3;
			}
			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		};
		MouseListener mouseListener4 = new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}
			@Override
			public void mouseDown(MouseEvent arg0) {
				letzteAusgewaehlteFigur = 4;
			}
			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		};
			
		spielfiguren.get(spielernummer * 10 + 1).addMouseListener(mouseListener1);
		spielfiguren.get(spielernummer * 10 + 2).addMouseListener(mouseListener2);
		spielfiguren.get(spielernummer * 10 + 3).addMouseListener(mouseListener3);
		spielfiguren.get(spielernummer * 10 + 4).addMouseListener(mouseListener4);
	
		while (letzteAusgewaehlteFigur == 0) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		spielfiguren.get(spielernummer * 10 + 1).removeMouseListener(mouseListener1);
		spielfiguren.get(spielernummer * 10 + 2).removeMouseListener(mouseListener2);
		spielfiguren.get(spielernummer * 10 + 3).removeMouseListener(mouseListener3);
		spielfiguren.get(spielernummer * 10 + 4).removeMouseListener(mouseListener4);
		
		return letzteAusgewaehlteFigur;
	}
}
