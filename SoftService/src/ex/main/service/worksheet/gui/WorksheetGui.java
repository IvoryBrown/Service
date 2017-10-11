package ex.main.service.worksheet.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ex.main.service.fixture.FixtureJDBCSetDAO;

public class WorksheetGui extends FixtureJDBCSetDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5056968578211729049L;
	protected JTable tblWorksheet;
	protected JButton btnUpdate;
	protected JScrollPane scrollPane;
	protected JButton btnBack;
	

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
		btnUpdate.setIcon(new ImageIcon(WorksheetGui.class.getResource("/icon/tango/22x22/actions/view-refresh.png")));
		btnUpdate.setBounds(1120, 545, 109, 37);
		jplWorksheet.add(btnUpdate);
		
		btnBack = new JButton("Vissza");
		btnBack.setBounds(1001, 545, 109, 37);
		jplWorksheet.add(btnBack);
	}

	 
}
