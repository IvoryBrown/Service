package ex.main.device.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex.main.client.gui.ClientJDBCSetDAO;

public class DeviceGui extends ClientJDBCSetDAO {
	protected JTextField txtSearchDevice;
	protected JTable jTableDevice;
	protected JTextField txtDevice;
	protected JTextField txtSerialDevice;
	protected JTextField txtDeviceId;
	protected JTextField txtCommentDevice;
	protected JButton btnNewDevice, btnNullDevice;
	protected JComboBox cmBoxStatusdevice, cmBoxPriorityDevice;

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

		btnNewDevice = new JButton("új eszköz");
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

		btnNullDevice = new JButton("null");
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

		cmBoxStatusdevice = new JComboBox(
				new Object[] { "Bevizsgálás alatt", "Alkatrészre vár", "Garanciális", "Bevizsgálva" });
		cmBoxStatusdevice.setBounds(153, 151, 189, 35);
		pnlDevice.add(cmBoxStatusdevice);
		cmBoxStatusdevice.setSelectedItem(null);

		cmBoxPriorityDevice = new JComboBox(new Object[] { "Alap", "Szerződött", "Sűrgős" });
		cmBoxPriorityDevice.setBounds(153, 197, 189, 35);
		pnlDevice.add(cmBoxPriorityDevice);
		cmBoxPriorityDevice.setSelectedItem(null);

		txtCommentDevice = new JTextField();
		txtCommentDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCommentDevice.setColumns(10);
		txtCommentDevice.setBackground(new Color(245, 255, 250));
		txtCommentDevice.setBounds(153, 243, 189, 131);
		pnlDevice.add(txtCommentDevice);

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

		JLabel lblCommentDevice = new JLabel("megjegyzés: ");
		lblCommentDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommentDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCommentDevice.setBounds(10, 243, 140, 35);
		pnlDevice.add(lblCommentDevice);
	}
}
