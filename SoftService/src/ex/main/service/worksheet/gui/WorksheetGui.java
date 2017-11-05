package ex.main.service.worksheet.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ex.main.service.fixture.FixtureJDBCSetDAO;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class WorksheetGui extends FixtureJDBCSetDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5056968578211729049L;
	protected JTable tblWorksheet;
	protected JButton btnUpdate;
	protected JScrollPane scrollPane;
	protected JButton btnBack, btnSearch;
	protected JTextField txtSearch;
	protected JComboBox<Object> cmbSearch;

	public WorksheetGui() {
		setComponent();

	}

	private void setComponent() {

		jplWorksheet.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1239, 534);
		jplWorksheet.add(scrollPane, BorderLayout.CENTER);

		tblWorksheet = new JTable();
		tblWorksheet.setBackground(Color.BLACK);
		scrollPane.setViewportView(tblWorksheet);
		btnUpdate = new JButton("frissités");
		btnUpdate.setIcon(new ImageIcon(WorksheetGui.class.getResource("/icon/tango/22x22/actions/view-refresh.png")));
		btnUpdate.setBounds(1120, 545, 109, 37);
		jplWorksheet.add(btnUpdate);

		btnBack = new JButton("Vissza");
		btnBack.setBounds(1001, 545, 109, 37);
		jplWorksheet.add(btnBack);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearch.setColumns(10);
		txtSearch.setBackground(new Color(153, 204, 204));
		txtSearch.setBounds(10, 545, 173, 35);
		jplWorksheet.add(txtSearch);

		String shearch[] = { "nev", "azonosito_m", "ID_g" };
		cmbSearch = new JComboBox<Object>(shearch);
		cmbSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbSearch.setBounds(193, 545, 231, 35);
		jplWorksheet.add(cmbSearch);

		btnSearch = new JButton("keresés");
		btnSearch.setBounds(434, 545, 109, 37);
		jplWorksheet.add(btnSearch);
	}
}
