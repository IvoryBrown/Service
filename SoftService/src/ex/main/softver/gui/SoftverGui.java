package ex.main.softver.gui;

import ex.main.deviceimage.DeviceImageJDBCSetDAO;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class SoftverGui extends DeviceImageJDBCSetDAO {
	protected JTextField txtSoftverID;
	protected JComboBox cmbSoftverName;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextField textField;
	private JButton button_3;
	private JButton button_4;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;

	public SoftverGui() {

		setSoftverComponent();
	}

	private void setSoftverComponent() {
		jplSoftver.setLayout(null);

		String softverName[] = {"Win Pro 7 32Bit Hungarian", "Win Pro 7 64Bit Hungarian","Egyéb"};
		cmbSoftverName = new JComboBox(softverName);
		cmbSoftverName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSoftverName.setBounds(116, 103, 294, 35);
		pnlSoftver.add(cmbSoftverName);

		txtSoftverID = new JTextField();
		txtSoftverID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoftverID.setEnabled(false);
		txtSoftverID.setColumns(10);
		txtSoftverID.setBackground(new Color(245, 255, 250));
		txtSoftverID.setBounds(315, 11, 95, 35);
		pnlSoftver.add(txtSoftverID);

		JLabel lblSoftverComment = new JLabel("megjegyzés: ");
		lblSoftverComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoftverComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoftverComment.setBounds(10, 149, 102, 35);
		pnlSoftver.add(lblSoftverComment);

		JLabel lblSoftver = new JLabel("softver:");
		lblSoftver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoftver.setBounds(4, 103, 102, 35);
		pnlSoftver.add(lblSoftver);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(116, 149, 294, 63);
		pnlSoftver.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setBackground(new Color(245, 255, 250));
		scrollPane_1.setViewportView(textArea);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 815, 63);
		jplSoftver.add(panel);
		
		button = new JButton("törlés");
		button.setBounds(565, 12, 109, 37);
		panel.add(button);
		
		button_1 = new JButton("szerkesztés");
		button_1.setBounds(446, 12, 109, 37);
		panel.add(button_1);
		
		button_2 = new JButton("új eszköz");
		button_2.setBounds(327, 11, 109, 37);
		panel.add(button_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(127, 255, 212));
		textField.setBounds(10, 13, 185, 35);
		panel.add(textField);
		
		button_3 = new JButton("keresés");
		button_3.setBounds(208, 12, 109, 37);
		panel.add(button_3);
		
		button_4 = new JButton("null");
		button_4.setBounds(684, 12, 109, 37);
		panel.add(button_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 618, 493);
		jplSoftver.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
