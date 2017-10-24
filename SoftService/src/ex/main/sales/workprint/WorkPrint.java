package ex.main.sales.workprint;

import java.awt.Color;

import javax.swing.JOptionPane;

import ex.main.sales.workprint.gui.WorkPrintGui;
import ex.main.setting.printing.SetPrinting;

public class WorkPrint extends WorkPrintGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2964327470005055114L;

	public WorkPrint() {

		setComp();

	}

	public void setComp() {

		btnWorkPrint.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (checkInputsWorkPrint()) {
					lblWorkPrintSalesName.setText(txtWorkPrintSalesName.getText());
					lblWorkPrintSalesName0.setText(txtWorkPrintSalesName.getText());
					btnPrinting();

				}
			}
		});

	}

	private boolean checkInputsWorkPrint() {
		if (txtWorkPrintSalesName.getText().trim().isEmpty()) {
			txtWorkPrintSalesName.setBackground(new Color(255, 0, 0));
			JOptionPane.showMessageDialog(null, "nincs ügyintéző neve!");
		} else {
			txtWorkPrintSalesName.setBackground(Color.WHITE);
		}
		if (lblWorkPrintClientName.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nincs munkalap kiválasztva!");
			jpnlWorkPrintTakeover0.setBackground(new Color(255, 0, 0));
			jpnlWorkPrintTakeover.setBackground(new Color(255, 0, 0));
		}else{
			jpnlWorkPrintTakeover0.setBackground(Color.WHITE);
			jpnlWorkPrintTakeover.setBackground(Color.WHITE);
		}
		if (txtWorkPrintSalesName.getText().trim().isEmpty() || lblWorkPrintClientName.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public void btnPrinting() {
		SetPrinting print = new SetPrinting();
		// panel.setBackground(Color.WHITE); ez még kell
		print.setComponent(jpnlWorkPrint);
		print.print();
	}

}
