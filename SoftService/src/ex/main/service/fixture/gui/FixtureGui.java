package ex.main.service.fixture.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ex.main.service.softver.SoftverJDBCSetDao;

public class FixtureGui extends SoftverJDBCSetDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3328000482934381440L;
	protected JTextField txtFixtureSearch, txtFixtureManufacturer, txtFixtureId, txtFixtureName, txtFixtureSerial;
	protected JTable tblFixture;
	protected JTextArea txtAreaFixtureComment;
	protected JButton btnFixtureDelete, btnFixtureEdit, btnFixtureNewFixture, btnFixtureSearch, btnFixtureNull;

	public FixtureGui() {
		txtFixtureDeviceId.setBounds(120, 11, 185, 35);

		JPanel pnlFixtureSetting = new JPanel();
		pnlFixtureSetting.setLayout(null);
		pnlFixtureSetting.setBounds(10, 11, 815, 63);
		jplFixture.add(pnlFixtureSetting);

		btnFixtureDelete = new JButton("törlés");
		btnFixtureDelete.setBounds(565, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureDelete);

		btnFixtureEdit = new JButton("szerkesztés");
		btnFixtureEdit.setBounds(446, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureEdit);

		btnFixtureNewFixture = new JButton("új alkatrész");
		btnFixtureNewFixture.setBounds(327, 11, 109, 37);
		pnlFixtureSetting.add(btnFixtureNewFixture);

		txtFixtureSearch = new JTextField();
		txtFixtureSearch.setColumns(10);
		txtFixtureSearch.setBackground(new Color(127, 255, 212));
		txtFixtureSearch.setBounds(10, 13, 185, 35);
		pnlFixtureSetting.add(txtFixtureSearch);

		btnFixtureSearch = new JButton("keresés");
		btnFixtureSearch.setBounds(208, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureSearch);

		btnFixtureNull = new JButton("null");
		btnFixtureNull.setBounds(684, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureNull);

		JScrollPane scrFixtureTable = new JScrollPane();
		scrFixtureTable.setBounds(10, 85, 618, 493);
		jplFixture.add(scrFixtureTable);

		tblFixture = new JTable();
		scrFixtureTable.setViewportView(tblFixture);

		txtFixtureId = new JTextField();
		txtFixtureId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFixtureId.setEnabled(false);
		txtFixtureId.setColumns(10);
		txtFixtureId.setBackground(new Color(245, 255, 250));
		txtFixtureId.setBounds(315, 11, 95, 35);
		pnlFixture.add(txtFixtureId);

		txtFixtureName = new JTextField();
		txtFixtureName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFixtureName.setColumns(10);
		txtFixtureName.setBackground(new Color(245, 255, 250));
		txtFixtureName.setBounds(120, 57, 290, 35);
		pnlFixture.add(txtFixtureName);

		txtFixtureManufacturer = new JTextField();
		txtFixtureManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFixtureManufacturer.setColumns(10);
		txtFixtureManufacturer.setBackground(new Color(245, 255, 250));
		txtFixtureManufacturer.setBounds(120, 103, 290, 35);
		pnlFixture.add(txtFixtureManufacturer);

		txtFixtureSerial = new JTextField();
		txtFixtureSerial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFixtureSerial.setColumns(10);
		txtFixtureSerial.setBackground(new Color(245, 255, 250));
		txtFixtureSerial.setBounds(120, 149, 290, 35);
		pnlFixture.add(txtFixtureSerial);

		JScrollPane scrComment = new JScrollPane();
		scrComment.setBounds(120, 195, 290, 63);
		pnlFixture.add(scrComment);

		txtAreaFixtureComment = new JTextArea();
		txtAreaFixtureComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaFixtureComment.setBackground(new Color(245, 255, 250));
		scrComment.setViewportView(txtAreaFixtureComment);

		JLabel lblFixtureName = new JLabel("típus:");
		lblFixtureName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFixtureName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFixtureName.setBounds(10, 57, 105, 35);
		pnlFixture.add(lblFixtureName);

		JLabel lblFixtureSerial = new JLabel("serial:");
		lblFixtureSerial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFixtureSerial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFixtureSerial.setBounds(10, 149, 105, 35);
		pnlFixture.add(lblFixtureSerial);

		JLabel lblFixtureComent = new JLabel("megjegyzés:");
		lblFixtureComent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFixtureComent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFixtureComent.setBounds(10, 195, 105, 35);
		pnlFixture.add(lblFixtureComent);

		JLabel lblFixtureManufacturer = new JLabel("gyártó:");
		lblFixtureManufacturer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFixtureManufacturer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFixtureManufacturer.setBounds(10, 103, 105, 35);
		pnlFixture.add(lblFixtureManufacturer);

	}
}
