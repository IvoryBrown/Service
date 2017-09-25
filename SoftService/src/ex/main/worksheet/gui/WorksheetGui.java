package ex.main.worksheet.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ex.main.gui.Gui;

public class WorksheetGui extends Gui {
	protected JTable tblWorksheet;
	protected JButton btnUpdate;
	protected JScrollPane scrollPane;
	

	public WorksheetGui() {
		setComponent();

	}

	private void setComponent() {

		jplWorksheet.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1239, 534);
		jplWorksheet.add(scrollPane, BorderLayout.CENTER);

		tblWorksheet = new JTable();
		scrollPane.setViewportView(tblWorksheet);
		btnUpdate = new JButton("frissités");
		btnUpdate.setBounds(1120, 545, 109, 37);
		jplWorksheet.add(btnUpdate);
	}

	 
}
