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
	protected JPanel pnlClientSetting;
	private JLabel lblSalesClientImage;
	private JLabel lblSalesClientSettingImage;
	private JLabel lblSalesClientButtonImage;
	private JLabel lblSalesClientSearchImage;

	private void setComponentClientGui() {

		JScrollPane scrSalesClient = new JScrollPane();
		scrSalesClient.setBackground(new Color(51, 0, 0));
		scrSalesClient.setBounds(10, 377, 1219, 235);
		jpnlClient.add(scrSalesClient);

		jtblSalesClient = new JTable();
		jtblSalesClient.setBackground(new Color(0, 0, 0));
		jtblSalesClient.setForeground(new Color(153, 0, 0));
		jtblSalesClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtblSalesClient.setRowHeight(30);
		scrSalesClient.setViewportView(jtblSalesClient);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(483, 11, 350, 56);
		jpnlClient.add(panel_2);
		panel_2.setLayout(null);

		String clientShearch[] = { "nev", "azonosito_m", "kapcsolat", "lakcim" };

		pnlClientSetting = new JPanel();
		panel_2.add(pnlClientSetting);
		pnlClientSetting.setBackground(new Color(0, 255, 255));
		pnlClientSetting.setLayout(null);
		pnlClientSetting.setBounds(10, 11, 468, 355);

		JLabel lblSalesClientID = new JLabel("azonosító: ");
		lblSalesClientID.setForeground(new Color(153, 0, 0));
		lblSalesClientID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientID.setBounds(10, 11, 140, 35);
		pnlClientSetting.add(lblSalesClientID);

		JLabel lblSalesClientName = new JLabel("név: ");
		lblSalesClientName.setForeground(new Color(153, 0, 0));
		lblSalesClientName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientName.setBounds(10, 55, 140, 35);
		pnlClientSetting.add(lblSalesClientName);

		JLabel lblSalesClientMobil = new JLabel("telefon: ");
		lblSalesClientMobil.setForeground(new Color(153, 0, 0));
		lblSalesClientMobil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientMobil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientMobil.setBounds(10, 99, 140, 35);
		pnlClientSetting.add(lblSalesClientMobil);

		JLabel lblSalesClientHomeAddress = new JLabel("lakcím: ");
		lblSalesClientHomeAddress.setForeground(new Color(153, 0, 0));
		lblSalesClientHomeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientHomeAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientHomeAddress.setBounds(10, 143, 140, 35);
		pnlClientSetting.add(lblSalesClientHomeAddress);

		JLabel lblSalesClientComment = new JLabel("megjegyzés: ");
		lblSalesClientComment.setForeground(new Color(153, 0, 0));
		lblSalesClientComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesClientComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesClientComment.setBounds(10, 187, 140, 35);
		pnlClientSetting.add(lblSalesClientComment);

		txtSalesClientNumber = new JTextField();
		txtSalesClientNumber.setEnabled(false);
		txtSalesClientNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientNumber.setColumns(10);
		txtSalesClientNumber.setBackground(Color.WHITE);
		txtSalesClientNumber.setBounds(153, 13, 189, 35);
		pnlClientSetting.add(txtSalesClientNumber);

		txtSalesClientName = new JTextField();
		txtSalesClientName.setForeground(new Color(51, 0, 0));
		txtSalesClientName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientName.setColumns(10);
		txtSalesClientName.setBounds(153, 57, 294, 35);
		pnlClientSetting.add(txtSalesClientName);

		txtSalesClientMobil = new JTextField();
		txtSalesClientMobil.setForeground(new Color(51, 0, 0));
		txtSalesClientMobil.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientMobil.setColumns(10);

		txtSalesClientMobil.setBounds(153, 101, 294, 35);
		pnlClientSetting.add(txtSalesClientMobil);

		txtSalesClientHomeAddress = new JTextField();
		txtSalesClientHomeAddress.setForeground(new Color(51, 0, 0));
		txtSalesClientHomeAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientHomeAddress.setColumns(10);
		txtSalesClientHomeAddress.setBackground(Color.WHITE);
		txtSalesClientHomeAddress.setBounds(153, 152, 294, 35);
		pnlClientSetting.add(txtSalesClientHomeAddress);

		txtSalesClientID = new JTextField();
		txtSalesClientID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesClientID.setEnabled(false);
		txtSalesClientID.setColumns(10);
		txtSalesClientID.setBackground(Color.WHITE);
		txtSalesClientID.setBounds(352, 13, 95, 35);
		pnlClientSetting.add(txtSalesClientID);

		JScrollPane scrPSalesClientComment = new JScrollPane();
		scrPSalesClientComment.setBounds(153, 198, 294, 146);
		pnlClientSetting.add(scrPSalesClientComment);

		txtSalesClientComment = new JTextArea();
		txtSalesClientComment.setForeground(new Color(51, 0, 0));
		txtSalesClientComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientComment.setBackground(Color.WHITE);
		scrPSalesClientComment.setViewportView(txtSalesClientComment);

		lblSalesClientSettingImage = new JLabel(new ImageIcon(((new ImageIcon(
				"F:\\Programozás\\Vállalat#\\Exicom\\Képek\\587cede4029fa159a80142ab.jpg"))
				.getImage()).getScaledInstance(468, 355, java.awt.Image.SCALE_SMOOTH)));
		lblSalesClientSettingImage.setBounds(0, 0, 468, 355);
		pnlClientSetting.add(lblSalesClientSettingImage);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(481, 11, 251, 147);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		cmbSalesClientSearch = new JComboBox<Object>(clientShearch);
		cmbSalesClientSearch.setBackground(new Color(0, 0, 0));
		cmbSalesClientSearch.setForeground(Color.WHITE);
		cmbSalesClientSearch.setBounds(10, 57, 231, 35);
		panel_3.add(cmbSalesClientSearch);
		cmbSalesClientSearch.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnSalesClientSearch = new JButton("");
		btnSalesClientSearch.setBackground(new Color(51, 0, 0));
		btnSalesClientSearch.setBounds(184, 11, 57, 35);
		panel_3.add(btnSalesClientSearch);
		btnSalesClientSearch.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/search.png")));

		txtSalesClientSearch = new JTextField();
		txtSalesClientSearch.setBounds(10, 11, 173, 35);
		panel_3.add(txtSalesClientSearch);
		txtSalesClientSearch.setForeground(Color.WHITE);
		txtSalesClientSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesClientSearch.setColumns(10);
		txtSalesClientSearch.setBackground(new Color(153, 0, 0));

		lblSalesClientSearchImage = new JLabel(new ImageIcon(((new ImageIcon(
				"F:\\Programozás\\Vállalat#\\Exicom\\Képek\\images.jpg"))
				.getImage()).getScaledInstance(252, 147, java.awt.Image.SCALE_SMOOTH)));
	lblSalesClientSearchImage.setBounds(0, 0, 252, 147);
		panel_3.add(lblSalesClientSearchImage);

		JPanel pnlButton = new JPanel();
		panel_2.add(pnlButton);
		pnlButton.setBounds(481, 161, 83, 205);
		pnlButton.setLayout(null);

		btnSalesClientDelete = new JButton("");
		btnSalesClientDelete.setBackground(new Color(51, 0, 0));
		btnSalesClientDelete.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/cross.png")));
		btnSalesClientDelete.setBounds(10, 107, 60, 37);
		pnlButton.add(btnSalesClientDelete);

		btnSalesClientEdit = new JButton("");
		btnSalesClientEdit.setBackground(new Color(51, 0, 0));
		btnSalesClientEdit.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/refresh.png")));
		btnSalesClientEdit.setBounds(10, 59, 60, 37);
		btnSalesClientEdit.setHorizontalAlignment(SwingConstants.LEADING);
		pnlButton.add(btnSalesClientEdit);

		btnSalesClientNewClient = new JButton("");
		btnSalesClientNewClient.setBackground(new Color(51, 0, 0));
		btnSalesClientNewClient.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/add.png")));
		btnSalesClientNewClient.setBounds(10, 11, 60, 37);
		pnlButton.add(btnSalesClientNewClient);

		btnSalesClientNull = new JButton("");
		btnSalesClientNull.setBackground(new Color(51, 0, 0));
		btnSalesClientNull.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/home.png")));
		btnSalesClientNull.setBounds(10, 155, 60, 37);
		pnlButton.add(btnSalesClientNull);

		lblSalesClientButtonImage = new JLabel(new ImageIcon(((new ImageIcon(
				"F:\\Programozás\\Vállalat#\\Exicom\\Képek\\lava1.jpg"))
						.getImage()).getScaledInstance(83, 205, java.awt.Image.SCALE_SMOOTH)));
		lblSalesClientButtonImage.setBounds(0, 0, 83, 205);
		pnlButton.add(lblSalesClientButtonImage);

		lblSalesClientImage = new JLabel((new ImageIcon(((new ImageIcon(
				"F:\\Programozás\\Vállalat#\\Exicom\\Képek\\Red-And-Black-Abstract-Wallpaper-3.jpg"))
						.getImage()).getScaledInstance(1239, 634, java.awt.Image.SCALE_SMOOTH))));
		lblSalesClientImage.setBounds(0, 0, 1239, 615);
		panel_2.add(lblSalesClientImage);
	}
}
