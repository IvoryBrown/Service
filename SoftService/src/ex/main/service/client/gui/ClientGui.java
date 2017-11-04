package ex.main.service.client.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex.main.service.gui.ServiceGui;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ClientGui extends ServiceGui {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtSearchClient, txtIdClient, txtIDClient, txtNameClient, txtMobilClient, txtHomeAddressClient,
			txtCompanyNameClient;
	protected JTable jTblClient;
	protected JButton btnNewClient, btnDeleteClient, btnEditClient, btnNullClient, btnSearchClient;
	protected JPanel pnlDevice;
	protected JLabel lblClientDeviceName;
	protected JTextArea txtCommentClient;
	protected JComboBox<Object> cmbClientSearch;
	// device
	protected JTextField txtClientDeviceName, txtClientDeviceId;

	public ClientGui() {

		setComponent();
	}

	private void setComponent() {
		jTbdPane.setBounds(0, 0, 1244, 617);
		jplMainPanel.setBounds(0, 0, 1244, 651);
		jplClients.setLayout(null);

		JScrollPane jScPClient = new JScrollPane();
		jScPClient.setBounds(10, 10, 514, 569);
		jplClients.add(jScPClient);

		jTblClient = new JTable();
		jScPClient.setViewportView(jTblClient);
		jTblClient.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "sorszám", "név", "telefon" }));

		JPanel jpnSettingClient = new JPanel();
		jpnSettingClient.setBounds(534, 10, 555, 63);
		jplClients.add(jpnSettingClient);
		jpnSettingClient.setLayout(null);

		txtSearchClient = new JTextField();
		txtSearchClient.setBackground(new Color(127, 255, 212));
		txtSearchClient.setBounds(10, 13, 185, 35);
		jpnSettingClient.add(txtSearchClient);
		txtSearchClient.setColumns(10);

		btnSearchClient = new JButton("keresés");
		btnSearchClient.setBounds(208, 12, 109, 37);
		jpnSettingClient.add(btnSearchClient);

		String clientShearch[] = { "nev", "azonosito_m", "kapcsolat", "lakcim" };
		cmbClientSearch = new JComboBox<Object>(clientShearch);
		cmbClientSearch.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbClientSearch.setBounds(327, 13, 202, 35);
		jpnSettingClient.add(cmbClientSearch);

		JPanel jpnNewClient = new JPanel();
		jpnNewClient.setBounds(534, 84, 555, 425);
		jplClients.add(jpnNewClient);
		jpnNewClient.setLayout(null);

		JLabel lblIDClient = new JLabel("azonosító: ");
		lblIDClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIDClient.setBounds(10, 11, 140, 35);
		jpnNewClient.add(lblIDClient);

		JLabel lblNameClient = new JLabel("kapcsolattartó: ");
		lblNameClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameClient.setBounds(10, 99, 140, 35);
		jpnNewClient.add(lblNameClient);

		JLabel lblMobilClient = new JLabel("telefon: ");
		lblMobilClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobilClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobilClient.setBounds(10, 141, 140, 35);
		jpnNewClient.add(lblMobilClient);

		JLabel lblHomeAddressClient = new JLabel("lakcím: ");
		lblHomeAddressClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeAddressClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHomeAddressClient.setBounds(10, 187, 140, 35);
		jpnNewClient.add(lblHomeAddressClient);

		JLabel lblCommentClient = new JLabel("megjegyzés: ");
		lblCommentClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommentClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommentClient.setBounds(10, 235, 140, 35);
		jpnNewClient.add(lblCommentClient);

		txtIDClient = new JTextField();
		txtIDClient.setEnabled(false);
		txtIDClient.setBackground(new Color(245, 255, 250));
		txtIDClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDClient.setBounds(153, 13, 287, 35);
		jpnNewClient.add(txtIDClient);
		txtIDClient.setColumns(10);

		txtNameClient = new JTextField();
		txtNameClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNameClient.setColumns(10);
		txtNameClient.setBackground(new Color(245, 255, 250));
		txtNameClient.setBounds(153, 99, 392, 35);
		jpnNewClient.add(txtNameClient);

		txtMobilClient = new JTextField();
		txtMobilClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMobilClient.setColumns(10);
		txtMobilClient.setBackground(new Color(245, 255, 250));
		txtMobilClient.setBounds(153, 143, 392, 35);
		jpnNewClient.add(txtMobilClient);

		txtHomeAddressClient = new JTextField();
		txtHomeAddressClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHomeAddressClient.setColumns(10);
		txtHomeAddressClient.setBackground(new Color(245, 255, 250));
		txtHomeAddressClient.setBounds(153, 187, 392, 35);
		jpnNewClient.add(txtHomeAddressClient);

		txtIdClient = new JTextField();
		txtIdClient.setEnabled(false);
		txtIdClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdClient.setColumns(10);
		txtIdClient.setBackground(new Color(245, 255, 250));
		txtIdClient.setBounds(450, 13, 95, 35);
		jpnNewClient.add(txtIdClient);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 233, 392, 132);
		jpnNewClient.add(scrollPane);

		txtCommentClient = new JTextArea();
		txtCommentClient.setBackground(new Color(245, 255, 250));
		scrollPane.setViewportView(txtCommentClient);

		txtCompanyNameClient = new JTextField();
		txtCompanyNameClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCompanyNameClient.setColumns(10);
		txtCompanyNameClient.setBackground(new Color(245, 255, 250));
		txtCompanyNameClient.setBounds(153, 57, 392, 35);
		jpnNewClient.add(txtCompanyNameClient);

		JLabel lblCompanyNameClient = new JLabel("cég: ");
		lblCompanyNameClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompanyNameClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompanyNameClient.setBounds(10, 57, 140, 35);
		jpnNewClient.add(lblCompanyNameClient);

		JPanel panel = new JPanel();
		panel.setBounds(1099, 84, 130, 315);
		jplClients.add(panel);
		panel.setLayout(null);

		btnNewClient = new JButton("új ügyfél");
		btnNewClient.setBounds(10, 11, 109, 37);
		panel.add(btnNewClient);
		btnNewClient.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/22x22/database_add.png")));

		btnEditClient = new JButton("szerkesztés");
		btnEditClient.setBounds(10, 59, 109, 37);
		panel.add(btnEditClient);
		btnEditClient.setHorizontalAlignment(SwingConstants.LEADING);
		btnEditClient.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/22x22/database-star.png")));

		btnDeleteClient = new JButton("törlés");
		btnDeleteClient.setBounds(10, 107, 109, 37);
		panel.add(btnDeleteClient);

		btnNullClient = new JButton("null");
		btnNullClient.setBounds(10, 155, 109, 37);
		panel.add(btnNullClient);
		jplMainPanel.setLayout(null);
		getContentPane().setLayout(null);
		jplDevice.setLayout(null);

		pnlDevice = new JPanel();
		pnlDevice.setLayout(null);
		pnlDevice.setBounds(539, 62, 458, 493);
		jplDevice.add(pnlDevice);

		lblClientDeviceName = new JLabel("ügyfél név: ");
		lblClientDeviceName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientDeviceName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClientDeviceName.setBounds(10, 11, 140, 35);
		pnlDevice.add(lblClientDeviceName);

		txtClientDeviceName = new JTextField();
		txtClientDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtClientDeviceName.setEnabled(false);
		txtClientDeviceName.setColumns(10);
		txtClientDeviceName.setBackground(new Color(245, 255, 250));
		txtClientDeviceName.setBounds(153, 13, 189, 35);
		pnlDevice.add(txtClientDeviceName);

		txtClientDeviceId = new JTextField();
		txtClientDeviceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtClientDeviceId.setEnabled(false);
		txtClientDeviceId.setColumns(10);
		txtClientDeviceId.setBackground(new Color(245, 255, 250));
		txtClientDeviceId.setBounds(352, 13, 95, 35);
		pnlDevice.add(txtClientDeviceId);

	}
}
