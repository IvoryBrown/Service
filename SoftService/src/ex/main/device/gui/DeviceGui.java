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
	protected JTable jTableDevice;
	private JTextField txtDevice;
	private JTextField txtSerialDevice;
	private JTextField txtConditionDevice;
	private JTextField txtPriorityDevice;
	private JTextField txtDeviceId;
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
		
		JScrollPane jScpDevice = new JScrollPane();
		jScpDevice.setBounds(10, 85, 428, 493);
		jplDevice.add(jScpDevice);
		
		jTableDevice = new JTable();
		jScpDevice.setViewportView(jTableDevice);
		
		txtDevice = new JTextField();
		txtDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDevice.setColumns(10);
		txtDevice.setBackground(new Color(245, 255, 250));
		txtDevice.setBounds(153, 59, 189, 35);
		pnlDevice.add(txtDevice);
		
		txtDeviceId = new JTextField();
		txtDeviceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceId.setEnabled(false);
		txtDeviceId.setColumns(10);
		txtDeviceId.setBackground(new Color(245, 255, 250));
		txtDeviceId.setBounds(352, 59, 95, 35);
		pnlDevice.add(txtDeviceId);
		
		txtSerialDevice = new JTextField();
		txtSerialDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialDevice.setColumns(10);
		txtSerialDevice.setBackground(new Color(245, 255, 250));
		txtSerialDevice.setBounds(153, 105, 189, 35);
		pnlDevice.add(txtSerialDevice);
		
		txtConditionDevice = new JTextField();
		txtConditionDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtConditionDevice.setColumns(10);
		txtConditionDevice.setBackground(new Color(245, 255, 250));
		txtConditionDevice.setBounds(153, 151, 189, 35);
		pnlDevice.add(txtConditionDevice);
		
		txtPriorityDevice = new JTextField();
		txtPriorityDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPriorityDevice.setColumns(10);
		txtPriorityDevice.setBackground(new Color(245, 255, 250));
		txtPriorityDevice.setBounds(153, 197, 189, 35);
		pnlDevice.add(txtPriorityDevice);
		
		JLabel lblDevice = new JLabel("eszköz:  ");
		lblDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDevice.setBounds(10, 59, 140, 35);
		pnlDevice.add(lblDevice);
		
		JLabel lblSerialDevice = new JLabel("sorozatszám: ");
		lblSerialDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerialDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSerialDevice.setBounds(10, 105, 140, 35);
		pnlDevice.add(lblSerialDevice);
		
		JLabel lblConditionDevice = new JLabel("állapot: ");
		lblConditionDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConditionDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConditionDevice.setBounds(10, 151, 140, 35);
		pnlDevice.add(lblConditionDevice);
		
		JLabel lblPriorityDevice = new JLabel("prioritás: ");
		lblPriorityDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriorityDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPriorityDevice.setBounds(10, 197, 140, 35);
		pnlDevice.add(lblPriorityDevice);
	}
}
