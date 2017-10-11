package ex.main.sales.client.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex.main.sales.gui.SalesGui;

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
	protected JPanel panel;

	private void setComponentClientGui() {
		jpnlClient.setLayout(null);

		JScrollPane scrSalesClient = new JScrollPane();
		scrSalesClient.setBounds(10, 377, 1219, 235);
		jpnlClient.add(scrSalesClient);

		jtblSalesClient = new JTable();
		jtblSalesClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtblSalesClient.setRowHeight(30);
		scrSalesClient.setViewportView(jtblSalesClient);

		panel = new JPanel();
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
		txtSalesClientNumber.setEnabled(false);
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
		panel_1.setBounds(483, 73, 83, 205);
		jpnlClient.add(panel_1);
		panel_1.setLayout(null);

		btnSalesClientDelete = new JButton("");
		btnSalesClientDelete.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/cross.png")));
		btnSalesClientDelete.setBounds(10, 107, 60, 37);
		panel_1.add(btnSalesClientDelete);

		btnSalesClientEdit = new JButton("");
		btnSalesClientEdit.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/refresh.png")));
		btnSalesClientEdit.setBounds(10, 59, 60, 37);
		btnSalesClientEdit.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnSalesClientEdit);

		btnSalesClientNewClient = new JButton("");
		btnSalesClientNewClient.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/add.png")));
		btnSalesClientNewClient.setBounds(10, 11, 60, 37);
		panel_1.add(btnSalesClientNewClient);

		btnSalesClientNull = new JButton("");
		btnSalesClientNull.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/home.png")));
		btnSalesClientNull.setBounds(10, 155, 60, 37);
		panel_1.add(btnSalesClientNull);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(483, 11, 350, 56);
		jpnlClient.add(panel_2);
		panel_2.setLayout(null);

		txtSalesClientSearch = new JTextField();
		txtSalesClientSearch.setForeground(Color.WHITE);
		txtSalesClientSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientSearch.setBounds(10, 11, 152, 35);
		panel_2.add(txtSalesClientSearch);
		txtSalesClientSearch.setColumns(10);
		txtSalesClientSearch.setBackground(new Color(204, 51, 204));

		btnSalesClientSearch = new JButton("");
		btnSalesClientSearch.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/search.png")));
		btnSalesClientSearch.setBounds(162, 11, 51, 35);
		panel_2.add(btnSalesClientSearch);

		String clientShearch[] = { "nev", "azonosito_m", "kapcsolat", "lakcim" };
		cmbSalesClientSearch = new JComboBox<Object>(clientShearch);
		cmbSalesClientSearch.setBounds(217, 11, 123, 35);
		panel_2.add(cmbSalesClientSearch);
		cmbSalesClientSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
