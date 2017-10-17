package ex.main.setting.printing;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.RepaintManager;

public class SetPrinting implements Printable {
	private Component component;

	public void setComponent(Component component) {
		this.component = component;
	}

	public void print() {
		try {
			tryPrint();
		} catch (PrinterException e) {
			System.err.println("Hiba a nyomtatás során!");
		}
	}

	public void tryPrint() throws PrinterException {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setPrintable(this);
		boolean enablePrint = printerJob.printDialog();
		if (enablePrint) {
			printerJob.print();
		}
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0) {
			return (NO_SUCH_PAGE);
		} else {
			Graphics2D g2d = (Graphics2D) g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

			disableDoubleBuffering(this.component);
			this.component.paint(g2d);
			enableDoubleBuffering(this.component);
			return (PAGE_EXISTS);
		}
	}

	public static void enableDoubleBuffering(Component component) {
		RepaintManager repaintManager = RepaintManager.currentManager(component);
		repaintManager.setDoubleBufferingEnabled(true);
	}

	public static void disableDoubleBuffering(Component component) {
		RepaintManager repaintManager = RepaintManager.currentManager(component);
		repaintManager.setDoubleBufferingEnabled(false);
	}
}