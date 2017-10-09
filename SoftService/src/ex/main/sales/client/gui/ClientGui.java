package ex.main.sales.client.gui;

import ex.main.sales.gui.SalesGui;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ClientGui extends SalesGui {
	public ClientGui() {
		setComponentClientGui();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable jtblSalesClient;
	protected JTextField txtSalesClientNumber, txtSalesClientName, txtSalesClientMobil, txtSalesClientHomeAddress,
			txtSalesClientID, txtSalesClientSearch;
	protected JTextArea txtSalesClientComment;
	protected JButton btnSalesClientDelete, btnSalesClientNewClient, btnSalesClientEdit, btnSalesClientNull,
			btnSalesClientSearch;
	protected JComboBox<?> cmbSalesClientSearch;

	private void setComponentClientGui() {
		jpnlClient.setLayout(null);

		JScrollPane scrSalesClient = new JScrollPane();
		scrSalesClient.setBounds(10, 377, 1219, 235);
		jpnlClient.add(scrSalesClient);

		jtblSalesClient = new JTable();
		scrSalesClient.setViewportView(jtblSalesClient);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 468, 355);
		jpnlClient.add(panel);

		JLabel lblSalesClientID = new JLabel("azonosító: ");
		lblSalesClientID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientID.setBounds(10, 11, 140, 35);
		panel.add(lblSalesClientID);

		JLabel lblSalesClientName = new JLabel("név: ");
		lblSalesClientName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientName.setBounds(10, 55, 140, 35);
		panel.add(lblSalesClientName);

		JLabel lblSalesClientMobil = new JLabel("telefon: ");
		lblSalesClientMobil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientMobil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientMobil.setBounds(10, 99, 140, 35);
		panel.add(lblSalesClientMobil);

		JLabel lblSalesClientHomeAddress = new JLabel("lakcím: ");
		lblSalesClientHomeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientHomeAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientHomeAddress.setBounds(10, 143, 140, 35);
		panel.add(lblSalesClientHomeAddress);

		JLabel lblSalesClientComment = new JLabel("megjegyzés: ");
		lblSalesClientComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientComment.setBounds(10, 187, 140, 35);
		panel.add(lblSalesClientComment);

		txtSalesClientNumber = new JTextField();
		txtSalesClientNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientNumber.setColumns(10);
		txtSalesClientNumber.setBackground(new Color(245, 255, 250));
		txtSalesClientNumber.setBounds(153, 13, 189, 35);
		panel.add(txtSalesClientNumber);

		txtSalesClientName = new JTextField();
		txtSalesClientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientName.setColumns(10);
		txtSalesClientName.setBackground(new Color(245, 255, 250));
		txtSalesClientName.setBounds(153, 57, 294, 35);
		panel.add(txtSalesClientName);

		txtSalesClientMobil = new JTextField();
		txtSalesClientMobil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientMobil.setColumns(10);
		txtSalesClientMobil.setBackground(new Color(245, 255, 250));
		txtSalesClientMobil.setBounds(153, 101, 294, 35);
		panel.add(txtSalesClientMobil);

		txtSalesClientHomeAddress = new JTextField();
		txtSalesClientHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientHomeAddress.setColumns(10);
		txtSalesClientHomeAddress.setBackground(new Color(245, 255, 250));
		txtSalesClientHomeAddress.setBounds(153, 152, 294, 35);
		panel.add(txtSalesClientHomeAddress);

		txtSalesClientID = new JTextField();
		txtSalesClientID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientID.setEnabled(false);
		txtSalesClientID.setColumns(10);
		txtSalesClientID.setBackground(new Color(245, 255, 250));
		txtSalesClientID.setBounds(352, 11, 95, 35);
		panel.add(txtSalesClientID);

		JScrollPane scrPSalesClientComment = new JScrollPane();
		scrPSalesClientComment.setBounds(153, 198, 294, 146);
		panel.add(scrPSalesClientComment);

		txtSalesClientComment = new JTextArea();
		txtSalesClientComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientComment.setBackground(new Color(245, 255, 250));
		scrPSalesClientComment.setViewportView(txtSalesClientComment);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(488, 11, 228, 355);
		jpnlClient.add(panel_1);
		panel_1.setLayout(null);

		btnSalesClientDelete = new JButton("törlés");
		btnSalesClientDelete.setBounds(10, 259, 109, 37);
		panel_1.add(btnSalesClientDelete);

		btnSalesClientEdit = new JButton("szerkesztés");
		btnSalesClientEdit.setBounds(10, 211, 109, 37);
		btnSalesClientEdit.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnSalesClientEdit);

		btnSalesClientNewClient = new JButton("új ügyfél");
		btnSalesClientNewClient.setBounds(10, 163, 109, 37);
		panel_1.add(btnSalesClientNewClient);

		txtSalesClientSearch = new JTextField();
		txtSalesClientSearch.setBounds(10, 13, 206, 35);
		txtSalesClientSearch.setColumns(10);
		txtSalesClientSearch.setBackground(new Color(127, 255, 212));
		panel_1.add(txtSalesClientSearch);

		btnSalesClientSearch = new JButton("keresés");
		btnSalesClientSearch.setBounds(10, 115, 109, 37);
		panel_1.add(btnSalesClientSearch);

		btnSalesClientNull = new JButton("null");
		btnSalesClientNull.setBounds(10, 307, 109, 37);
		panel_1.add(btnSalesClientNull);

		String clientShearch[] = { "nev", "azonosito_m", "kapcsolat", "lakcím" };
		cmbSalesClientSearch = new JComboBox<Object>(clientShearch);
		cmbSalesClientSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesClientSearch.setBounds(10, 59, 189, 35);
		panel_1.add(cmbSalesClientSearch);
	}
}
