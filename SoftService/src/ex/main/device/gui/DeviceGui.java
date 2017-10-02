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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import com.toedter.calendar.JDateChooser;

import ex.main.client.gui.ClientJDBCSetDAO;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DeviceGui extends ClientJDBCSetDAO {
	protected JTextField txtSearchDevice;
	protected JTable jTableDevice;
	protected JTextField txtDevice;
	protected JTextField txtSerialDevice;
	protected JTextField txtDeviceId;
	protected JButton btnNewDevice, btnNullDevice, btnEditDevice, jbtnDeleteDevice;
	protected JComboBox cmBoxStatusdevice, cmBoxPriorityDevice;
	protected JTextField txtDeviceImageClientName;
	protected JTextField txtDeviceImageNameDevice;
	protected JTextField txtDeviceImageSerialDevice;
	protected JTextField txtDeviceImageDeviceId;
	protected JPanel pnlWorkingHoursSetting;
	private JLabel lblWorkingHoursDeviceName;
	protected JTextField txtWorkingHoursDeviceName;
	protected JTextField txtWorkingHoursDeviceSerial;
	protected JDateChooser txtWorkHourCompletedDate, txtWorkHourAddDate, txtWorkHourEndDate;
	protected JTextField txtDeviceImageIDDevice;
	protected JTextField txtDeviceImageID;
	protected JTextArea txtAreaComment;

	public DeviceGui() {
		txtClientDeviceId.setBounds(352, 13, 95, 35);
		txtClientDeviceName.setBounds(153, 13, 189, 35);
		pnlDevice.setSize(449, 493);
		pnlDevice.setLocation(376, 85);

		setComponent();
	}

	private void setComponent() {
		jplDevice.setLayout(null);

		JPanel jpnSettingDevice = new JPanel();
		jpnSettingDevice.setLayout(null);
		jpnSettingDevice.setBounds(10, 11, 815, 63);
		jplDevice.add(jpnSettingDevice);

		jbtnDeleteDevice = new JButton("törlés");
		jbtnDeleteDevice.setBounds(565, 12, 109, 37);
		jpnSettingDevice.add(jbtnDeleteDevice);

		btnEditDevice = new JButton("szerkesztés");
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
		jScpDevice.setBounds(10, 85, 356, 493);
		jplDevice.add(jScpDevice);

		jTableDevice = new JTable();
		jScpDevice.setViewportView(jTableDevice);

		txtDevice = new JTextField();
		txtDevice.setBounds(153, 59, 189, 35);
		txtDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDevice.setColumns(10);
		txtDevice.setBackground(new Color(245, 255, 250));

		txtDeviceId = new JTextField();
		txtDeviceId.setBounds(352, 59, 95, 35);
		txtDeviceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceId.setEnabled(false);
		txtDeviceId.setColumns(10);
		txtDeviceId.setBackground(new Color(245, 255, 250));

		txtSerialDevice = new JTextField();
		txtSerialDevice.setBounds(153, 105, 189, 35);
		txtSerialDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialDevice.setColumns(10);
		txtSerialDevice.setBackground(new Color(245, 255, 250));

		cmBoxStatusdevice = new JComboBox(
				new Object[] { "Bevizsgálás alatt", "Alkatrészre vár", "Garanciális", "Bevizsgálva" });
		cmBoxStatusdevice.setBounds(153, 151, 189, 35);
		cmBoxStatusdevice.setSelectedItem(null);

		cmBoxPriorityDevice = new JComboBox(new Object[] { "Alap", "Szerződött", "Sűrgős" });
		cmBoxPriorityDevice.setBounds(153, 197, 189, 35);
		cmBoxPriorityDevice.setSelectedItem(null);

		JLabel lblDevice = new JLabel("eszköz:  ");
		lblDevice.setBounds(10, 59, 140, 35);
		lblDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblSerialDevice = new JLabel("serial: ");
		lblSerialDevice.setBounds(10, 105, 140, 35);
		lblSerialDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerialDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblConditionDevice = new JLabel("állapot: ");
		lblConditionDevice.setBounds(10, 151, 140, 35);
		lblConditionDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConditionDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblPriorityDevice = new JLabel("prioritás: ");
		lblPriorityDevice.setBounds(10, 197, 140, 35);
		lblPriorityDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriorityDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtWorkHourAddDate = new JDateChooser();
		txtWorkHourAddDate.setBounds(153, 243, 189, 35);
		txtWorkHourAddDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourAddDate.setBackground(new Color(245, 255, 250));

		txtWorkHourEndDate = new JDateChooser();
		txtWorkHourEndDate.setBounds(153, 289, 189, 35);
		txtWorkHourEndDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourEndDate.setBackground(new Color(245, 255, 250));

		txtWorkHourCompletedDate = new JDateChooser();
		txtWorkHourCompletedDate.setBounds(153, 335, 189, 35);
		txtWorkHourCompletedDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourCompletedDate.setBackground(new Color(245, 255, 250));

		JLabel lblEndDate = new JLabel("határidő: ");
		lblEndDate.setBounds(10, 289, 140, 35);
		lblEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblComment = new JLabel("hiba leírás: ");
		lblComment.setBounds(10, 381, 140, 35);
		lblComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblAddDate = new JLabel("rögzítés: ");
		lblAddDate.setBounds(10, 243, 140, 35);
		lblAddDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblCompletedDate = new JLabel("elkészült: ");
		lblCompletedDate.setBounds(10, 335, 140, 35);
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompletedDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 381, 289, 101);
		
		 txtAreaComment = new JTextArea();
		 txtAreaComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(txtAreaComment);
		txtAreaComment.setBackground(new Color(245, 255, 250));
		pnlDevice.setLayout(null);
		pnlDevice.add(lblDevice);
		pnlDevice.add(txtDevice);
		pnlDevice.add(txtDeviceId);
		pnlDevice.add(lblSerialDevice);
		pnlDevice.add(txtSerialDevice);
		pnlDevice.add(lblConditionDevice);
		pnlDevice.add(cmBoxStatusdevice);
		pnlDevice.add(lblPriorityDevice);
		pnlDevice.add(cmBoxPriorityDevice);
		pnlDevice.add(txtWorkHourAddDate);
		pnlDevice.add(txtWorkHourEndDate);
		pnlDevice.add(txtWorkHourCompletedDate);
		pnlDevice.add(lblEndDate);
		pnlDevice.add(lblComment);
		pnlDevice.add(lblAddDate);
		pnlDevice.add(lblCompletedDate);
		pnlDevice.add(scrollPane);

		txtDeviceImageClientName = new JTextField();
		txtDeviceImageClientName.setEnabled(false);
		txtDeviceImageClientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceImageClientName.setColumns(10);
		txtDeviceImageClientName.setBackground(new Color(245, 255, 250));
		txtDeviceImageClientName.setBounds(318, 85, 189, 35);
		jplDeviceImage.add(txtDeviceImageClientName);

		txtDeviceImageNameDevice = new JTextField();
		txtDeviceImageNameDevice.setEnabled(false);
		txtDeviceImageNameDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceImageNameDevice.setColumns(10);
		txtDeviceImageNameDevice.setBackground(new Color(245, 255, 250));
		txtDeviceImageNameDevice.setBounds(517, 85, 189, 35);
		jplDeviceImage.add(txtDeviceImageNameDevice);

		txtDeviceImageSerialDevice = new JTextField();
		txtDeviceImageSerialDevice.setEnabled(false);
		txtDeviceImageSerialDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceImageSerialDevice.setColumns(10);
		txtDeviceImageSerialDevice.setBackground(new Color(245, 255, 250));
		txtDeviceImageSerialDevice.setBounds(716, 85, 189, 35);
		jplDeviceImage.add(txtDeviceImageSerialDevice);

		txtDeviceImageIDDevice = new JTextField();
		txtDeviceImageIDDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceImageIDDevice.setEnabled(false);
		txtDeviceImageIDDevice.setColumns(10);
		txtDeviceImageIDDevice.setBackground(new Color(245, 255, 250));
		txtDeviceImageIDDevice.setBounds(915, 85, 95, 35);
		jplDeviceImage.add(txtDeviceImageIDDevice);

		txtDeviceImageID = new JTextField();
		txtDeviceImageID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceImageID.setEnabled(false);
		txtDeviceImageID.setColumns(10);
		txtDeviceImageID.setBackground(new Color(245, 255, 250));
		txtDeviceImageID.setBounds(1020, 85, 95, 35);
		jplDeviceImage.add(txtDeviceImageID);

	}
}
