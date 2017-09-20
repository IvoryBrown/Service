package ex.main.client.gui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import ex.main.gui.worksheet.WorksheetGui;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ClientGui extends WorksheetGui {
	protected JTextField txtSearchClient;
	protected JTextField txtIDClient;
	protected JTextField txtNameClient;
	protected JTextField txtMobilClient;
	protected JTextField txtHomeAddressClient;
	protected JTextField txtCommentClient;
	protected JTable jTblClient;
	protected JButton btnNewClient, btnDeleteClient, btnEditClient, btnNullClient;
	private JButton btnSearchClient;
	protected JTextField txtIdClient;

	public ClientGui() {

		setComponent();
	}

	private void setComponent() {
		jTbdPane.setBounds(0, 0, 1244, 617);
		jplMainPanel.setBounds(0, 0, 1244, 651);
		jplClients.setLayout(null);

		JScrollPane jScPClient = new JScrollPane();
		jScPClient.setBounds(10, 10, 286, 569);
		jplClients.add(jScPClient);

		jTblClient = new JTable();
		jScPClient.setViewportView(jTblClient);
		jTblClient.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "sorszám", "név", "telefon" }));

		JPanel jpnSettingClient = new JPanel();
		jpnSettingClient.setBounds(302, 10, 805, 63);
		jplClients.add(jpnSettingClient);
		jpnSettingClient.setLayout(null);

		btnDeleteClient = new JButton("törlés");
		btnDeleteClient.setBounds(565, 12, 109, 37);
		jpnSettingClient.add(btnDeleteClient);

		btnEditClient = new JButton("szerkesztés");
		btnEditClient.setBounds(446, 12, 109, 37);
		jpnSettingClient.add(btnEditClient);

		btnNewClient = new JButton("új ügyfél");
		btnNewClient.setIcon(
				new ImageIcon(ClientGui.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		btnNewClient.setBounds(327, 11, 109, 37);
		jpnSettingClient.add(btnNewClient);

		txtSearchClient = new JTextField();
		txtSearchClient.setBackground(new Color(127, 255, 212));
		txtSearchClient.setBounds(10, 13, 185, 35);
		jpnSettingClient.add(txtSearchClient);
		txtSearchClient.setColumns(10);

		btnSearchClient = new JButton("keresés");
		btnSearchClient.setBounds(208, 12, 109, 37);
		jpnSettingClient.add(btnSearchClient);

		btnNullClient = new JButton("null");
		btnNullClient.setBounds(684, 12, 109, 37);
		jpnSettingClient.add(btnNullClient);

		JPanel jpnNewClient = new JPanel();
		jpnNewClient.setBounds(302, 79, 555, 341);
		jplClients.add(jpnNewClient);
		jpnNewClient.setLayout(null);

		JLabel lblIDClient = new JLabel("azonosító: ");
		lblIDClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIDClient.setBounds(10, 11, 140, 35);
		jpnNewClient.add(lblIDClient);

		JLabel lblNameClient = new JLabel("név: ");
		lblNameClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameClient.setBounds(10, 55, 140, 35);
		jpnNewClient.add(lblNameClient);

		JLabel lblMobilClient = new JLabel("telefon: ");
		lblMobilClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobilClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobilClient.setBounds(10, 99, 140, 35);
		jpnNewClient.add(lblMobilClient);

		JLabel lblHomeAddressClient = new JLabel("lakcím: ");
		lblHomeAddressClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeAddressClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHomeAddressClient.setBounds(10, 143, 140, 35);
		jpnNewClient.add(lblHomeAddressClient);

		JLabel lblCommentClient = new JLabel("megjegyzés: ");
		lblCommentClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommentClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommentClient.setBounds(10, 187, 140, 35);
		jpnNewClient.add(lblCommentClient);

		txtIDClient = new JTextField();
		txtIDClient.setBackground(new Color(245, 255, 250));
		txtIDClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDClient.setBounds(153, 13, 189, 35);
		jpnNewClient.add(txtIDClient);
		txtIDClient.setColumns(10);

		txtNameClient = new JTextField();
		txtNameClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNameClient.setColumns(10);
		txtNameClient.setBackground(new Color(245, 255, 250));
		txtNameClient.setBounds(153, 57, 189, 35);
		jpnNewClient.add(txtNameClient);

		txtMobilClient = new JTextField();
		txtMobilClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMobilClient.setColumns(10);
		txtMobilClient.setBackground(new Color(245, 255, 250));
		txtMobilClient.setBounds(153, 101, 189, 35);
		jpnNewClient.add(txtMobilClient);

		txtHomeAddressClient = new JTextField();
		txtHomeAddressClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHomeAddressClient.setColumns(10);
		txtHomeAddressClient.setBackground(new Color(245, 255, 250));
		txtHomeAddressClient.setBounds(153, 152, 189, 35);
		jpnNewClient.add(txtHomeAddressClient);

		txtCommentClient = new JTextField();
		txtCommentClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCommentClient.setColumns(10);
		txtCommentClient.setBackground(new Color(245, 255, 250));
		txtCommentClient.setBounds(153, 196, 189, 131);
		jpnNewClient.add(txtCommentClient);
		
		txtIdClient = new JTextField();
		txtIdClient.setEnabled(false);
		txtIdClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdClient.setColumns(10);
		txtIdClient.setBackground(new Color(245, 255, 250));
		txtIdClient.setBounds(352, 11, 95, 35);
		jpnNewClient.add(txtIdClient);
		jplMainPanel.setLayout(null);
		getContentPane().setLayout(null);
	}
}
