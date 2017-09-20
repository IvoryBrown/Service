package ex.main.device.gui;

import ex.main.client.gui.ClientJDBCSetDAO;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DeviceGui extends ClientJDBCSetDAO {
	protected JTextField txtSearchDevice;
	protected JTextField textClientDevice;
	protected JTextField txtSerialDevice;
	protected JTextField txtNameDevice;
	protected JTextField txtStatusDevice;
	protected JTextField txtPrioritDevice;
	protected JTextField txtCommentDevice;
	protected JTextField txtIdDevice;
	protected JTable jTableDevice;
	public DeviceGui() {
		
		setComponent();
	}

	private void setComponent() {
		jplDevice.setLayout(null);
		
		JPanel jpnSettingDevice = new JPanel();
		jpnSettingDevice.setLayout(null);
		jpnSettingDevice.setBounds(10, 11, 815, 63);
		jplDevice.add(jpnSettingDevice);
		
		JButton jbtnDeleteDevice = new JButton("törlés");
		jbtnDeleteDevice.setBounds(565, 12, 109, 37);
		jpnSettingDevice.add(jbtnDeleteDevice);
		
		JButton btnEditDevice = new JButton("szerkesztés");
		btnEditDevice.setBounds(446, 12, 109, 37);
		jpnSettingDevice.add(btnEditDevice); 
		
		JButton btnNewDevice = new JButton("új eszköz");
		btnNewDevice.setBounds(327, 11, 109, 37);
		jpnSettingDevice.add(btnNewDevice);
		
		txtSearchDevice = new JTextField();
		txtSearchDevice.setColumns(10);
		txtSearchDevice.setBackground(new Color(127, 255, 212));
		txtSearchDevice.setBounds(10, 13, 185, 35);
		jpnSettingDevice.add(txtSearchDevice);
		
		JButton btnSearchDevice = new JButton("keresés");
		btnSearchDevice.setBounds(208, 12, 109, 37);
		jpnSettingDevice.add(btnSearchDevice);
		
		JButton btnNullDevice = new JButton("null");
		btnNullDevice.setBounds(684, 12, 109, 37);
		jpnSettingDevice.add(btnNullDevice);
		
		JPanel jpnNewDevice = new JPanel();
		jpnNewDevice.setLayout(null);
		jpnNewDevice.setBounds(673, 85, 458, 493);
		jplDevice.add(jpnNewDevice);
		
		JLabel lblClientDevice = new JLabel("ügyfél név: ");
		lblClientDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClientDevice.setBounds(10, 11, 140, 35);
		jpnNewDevice.add(lblClientDevice);
		
		JLabel lblSerialDevice = new JLabel("sorozatszám: ");
		lblSerialDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerialDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSerialDevice.setBounds(10, 55, 140, 35);
		jpnNewDevice.add(lblSerialDevice);
		
		JLabel lblNameDevice = new JLabel("név: ");
		lblNameDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameDevice.setBounds(10, 99, 140, 35);
		jpnNewDevice.add(lblNameDevice);
		
		JLabel lblStatusDevice = new JLabel("állapot: ");
		lblStatusDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatusDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatusDevice.setBounds(10, 145, 140, 35);
		jpnNewDevice.add(lblStatusDevice);
		
		JLabel lblPrioritDevice = new JLabel("prioritás: ");
		lblPrioritDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioritDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrioritDevice.setBounds(10, 193, 140, 35);
		jpnNewDevice.add(lblPrioritDevice);
		
		JLabel lblCommentDevice = new JLabel("megjegyzés: ");
		lblCommentDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommentDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommentDevice.setBounds(10, 239, 140, 35);
		jpnNewDevice.add(lblCommentDevice);
		
		textClientDevice = new JTextField();
		textClientDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textClientDevice.setEnabled(false);
		textClientDevice.setColumns(10);
		textClientDevice.setBackground(new Color(245, 255, 250));
		textClientDevice.setBounds(153, 13, 189, 35);
		jpnNewDevice.add(textClientDevice);
		
		txtSerialDevice = new JTextField();
		txtSerialDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialDevice.setColumns(10);
		txtSerialDevice.setBackground(new Color(245, 255, 250));
		txtSerialDevice.setBounds(153, 57, 189, 35);
		jpnNewDevice.add(txtSerialDevice);
		
		txtNameDevice = new JTextField();
		txtNameDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNameDevice.setColumns(10);
		txtNameDevice.setBackground(new Color(245, 255, 250));
		txtNameDevice.setBounds(153, 101, 189, 35);
		jpnNewDevice.add(txtNameDevice);
		
		txtStatusDevice = new JTextField();
		txtStatusDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStatusDevice.setColumns(10);
		txtStatusDevice.setBackground(new Color(245, 255, 250));
		txtStatusDevice.setBounds(153, 147, 189, 35);
		jpnNewDevice.add(txtStatusDevice);
		
		txtPrioritDevice = new JTextField();
		txtPrioritDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrioritDevice.setColumns(10);
		txtPrioritDevice.setBackground(new Color(245, 255, 250));
		txtPrioritDevice.setBounds(153, 193, 189, 35);
		jpnNewDevice.add(txtPrioritDevice);
		
		txtCommentDevice = new JTextField();
		txtCommentDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCommentDevice.setColumns(10);
		txtCommentDevice.setBackground(new Color(245, 255, 250));
		txtCommentDevice.setBounds(153, 239, 189, 131);
		jpnNewDevice.add(txtCommentDevice);
		
		txtIdDevice = new JTextField();
		txtIdDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdDevice.setEnabled(false);
		txtIdDevice.setColumns(10);
		txtIdDevice.setBackground(new Color(245, 255, 250));
		txtIdDevice.setBounds(350, 57, 95, 35);
		jpnNewDevice.add(txtIdDevice);
		
		JScrollPane jScpDevice = new JScrollPane();
		jScpDevice.setBounds(10, 85, 428, 493);
		jplDevice.add(jScpDevice);
		
		jTableDevice = new JTable();
		jScpDevice.setViewportView(jTableDevice);
	}
}
