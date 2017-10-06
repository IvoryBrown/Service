package ex.main.fixture.gui;

import ex.main.softver.SoftverJDBCSetDao;
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

public class FixtureGui extends SoftverJDBCSetDao{
	private JTextField txtFixtureSearch;
	protected JTable table;
	private JTextField txtFixtureId;
	private JTextField textField;
	private JTextField textField_1;
	
	public FixtureGui() {
		
		JPanel pnlFixtureSetting = new JPanel();
		pnlFixtureSetting.setLayout(null);
		pnlFixtureSetting.setBounds(10, 11, 815, 63);
		jplFixture.add(pnlFixtureSetting);
		
		JButton btnFixtureDelete = new JButton("törlés");
		btnFixtureDelete.setBounds(565, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureDelete);
		
		JButton btnFixtureEdit = new JButton("szerkesztés");
		btnFixtureEdit.setBounds(446, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureEdit);
		
		JButton btnFixtureNewFixture = new JButton("új eszköz");
		btnFixtureNewFixture.setBounds(327, 11, 109, 37);
		pnlFixtureSetting.add(btnFixtureNewFixture);
		
		txtFixtureSearch = new JTextField();
		txtFixtureSearch.setColumns(10);
		txtFixtureSearch.setBackground(new Color(127, 255, 212));
		txtFixtureSearch.setBounds(10, 13, 185, 35);
		pnlFixtureSetting.add(txtFixtureSearch);
		
		JButton btnFixtureSearch = new JButton("keresés");
		btnFixtureSearch.setBounds(208, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureSearch);
		
		JButton btnFixtureNull = new JButton("null");
		btnFixtureNull.setBounds(684, 12, 109, 37);
		pnlFixtureSetting.add(btnFixtureNull);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 618, 493);
		jplFixture.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtFixtureId = new JTextField();
		txtFixtureId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFixtureId.setEnabled(false);
		txtFixtureId.setColumns(10);
		txtFixtureId.setBackground(new Color(245, 255, 250));
		txtFixtureId.setBounds(315, 11, 95, 35);
		pnlFixture.add(txtFixtureId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBackground(new Color(245, 255, 250));
		textField.setBounds(116, 103, 189, 35);
		pnlFixture.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(245, 255, 250));
		textField_1.setBounds(116, 149, 189, 35);
		pnlFixture.add(textField_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(116, 195, 294, 63);
		pnlFixture.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setBackground(new Color(245, 255, 250));
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblTipus = new JLabel("típus:");
		lblTipus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipus.setBounds(10, 103, 105, 35);
		pnlFixture.add(lblTipus);
		
		JLabel lblSerial = new JLabel("serial:");
		lblSerial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSerial.setBounds(10, 149, 105, 35);
		pnlFixture.add(lblSerial);
		
		JLabel lblMegjegyzs = new JLabel("megjegyzés:");
		lblMegjegyzs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMegjegyzs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMegjegyzs.setBounds(10, 195, 105, 35);
		pnlFixture.add(lblMegjegyzs);
		
	}
}
