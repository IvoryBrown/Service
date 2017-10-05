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

import ex.main.client.ClientJDBCSetDAO;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DeviceGui extends ClientJDBCSetDAO {
	protected JTextField txtSearchDevice;
	protected JTable jTableDevice;
	protected JTextField txtSerialDevice;
	protected JTextField txtDeviceId;
	protected JButton btnNewDevice, btnNullDevice, btnEditDevice, jbtnDeleteDevice;
	protected JComboBox cmBoxStatusdevice, cmBoxPriorityDevice, cmBoxDeviceInterchange, cmBoxDeviceSoftwer,
			cmBoxCleaning, cmBoxDevice;
	protected JTextField txtDeviceImageClientName;
	protected JTextField txtDeviceImageNameDevice;
	protected JTextField txtDeviceImageSerialDevice;
	protected JTextField txtDeviceImageDeviceId;
	protected JPanel pnlWorkingHoursSetting;
	private JLabel lblWorkingHoursDeviceName;
	protected JTextField txtWorkingHoursDeviceName;
	protected JTextField txtWorkingHoursDeviceSerial;
	protected JDateChooser txtDeviceBuyingDate, txtWorkHourCompletedDate, txtWorkHourAddDate, txtWorkHourEndDate;
	protected JTextField txtDeviceImageIDDevice;
	protected JTextField txtDeviceImageID;
	protected JTextArea txtAreaComment, txtAreaDeviceErrors, txtAreaDeviceAccessory, txtAreaInjury;
	private JLabel lbDevicelnterchange;
	private JLabel lblSoftwerTelepts;
	protected JTextField txtTypeDevice;
	protected JTextField txtDevicePassword;

	public DeviceGui() {
		lblClientDeviceName.setBounds(10, 11, 95, 35);
		txtClientDeviceId.setBounds(302, 13, 95, 35);
		txtClientDeviceName.setBounds(103, 13, 189, 35);
		pnlDevice.setSize(404, 493);
		pnlDevice.setLocation(376, 85);

		setComponent();
	}

	private void setComponent() {
		jplDevice.setLayout(null);

		JPanel pnlDeviceListener = new JPanel();
		pnlDeviceListener.setBounds(782, 85, 447, 493);
		jplDevice.add(pnlDeviceListener);
		pnlDeviceListener.setLayout(null);

		JLabel lblErrors = new JLabel("valós hiba:");
		lblErrors.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrors.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrors.setBounds(0, 419, 137, 35);
		pnlDeviceListener.add(lblErrors);

		JScrollPane scrlDeviceErrors = new JScrollPane();
		scrlDeviceErrors.setBounds(139, 419, 294, 63);
		pnlDeviceListener.add(scrlDeviceErrors);

		txtAreaDeviceErrors = new JTextArea();
		txtAreaDeviceErrors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaDeviceErrors.setBackground(new Color(245, 255, 250));
		scrlDeviceErrors.setViewportView(txtAreaDeviceErrors);

		lbDevicelnterchange = new JLabel("hardwer csere:");
		lbDevicelnterchange.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDevicelnterchange.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDevicelnterchange.setBounds(0, 55, 137, 35);
		pnlDeviceListener.add(lbDevicelnterchange);

		String boxInterchane[] = { "Igen", "Nem" };
		cmBoxDeviceInterchange = new JComboBox(boxInterchane);
		cmBoxDeviceInterchange.setBounds(139, 57, 189, 35);
		pnlDeviceListener.add(cmBoxDeviceInterchange);
		cmBoxDeviceInterchange.setSelectedItem(null);

		lblSoftwerTelepts = new JLabel("softwer telepítés:");
		lblSoftwerTelepts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoftwerTelepts.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoftwerTelepts.setBounds(0, 11, 137, 35);
		pnlDeviceListener.add(lblSoftwerTelepts);

		String boxDeviceSoftwer[] = { "Igen", "Nem" };
		cmBoxDeviceSoftwer = new JComboBox(boxDeviceSoftwer);
		cmBoxDeviceSoftwer.setBounds(139, 13, 189, 35);
		pnlDeviceListener.add(cmBoxDeviceSoftwer);
		cmBoxDeviceSoftwer.setSelectedItem(null);

		JScrollPane scrDeviceComment = new JScrollPane();
		scrDeviceComment.setBounds(139, 345, 294, 63);
		pnlDeviceListener.add(scrDeviceComment);

		txtAreaComment = new JTextArea();
		txtAreaComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrDeviceComment.setViewportView(txtAreaComment);
		txtAreaComment.setBackground(new Color(245, 255, 250));

		JLabel lblComment = new JLabel("hiba leírás:");
		lblComment.setBounds(0, 345, 137, 35);
		pnlDeviceListener.add(lblComment);
		lblComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));

		String BoxCleaning[] = { "Igen", "Nem" };
		cmBoxCleaning = new JComboBox(BoxCleaning);
		cmBoxCleaning.setBounds(139, 103, 189, 35);
		pnlDeviceListener.add(cmBoxCleaning);
		cmBoxCleaning.setSelectedItem(null);

		JLabel lblCleaning = new JLabel("takarítás:");
		lblCleaning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCleaning.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCleaning.setBounds(0, 101, 137, 35);
		pnlDeviceListener.add(lblCleaning);

		JScrollPane scrDeviceInjury = new JScrollPane();
		scrDeviceInjury.setBounds(139, 271, 294, 63);
		pnlDeviceListener.add(scrDeviceInjury);

		txtAreaInjury = new JTextArea();
		txtAreaInjury.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaInjury.setBackground(new Color(245, 255, 250));
		scrDeviceInjury.setViewportView(txtAreaInjury);

		JLabel lblInjury = new JLabel("sérlülés:");
		lblInjury.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInjury.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInjury.setBounds(0, 271, 137, 35);
		pnlDeviceListener.add(lblInjury);

		JScrollPane scrAccessory = new JScrollPane();
		scrAccessory.setBounds(139, 197, 294, 63);
		pnlDeviceListener.add(scrAccessory);

		txtAreaDeviceAccessory = new JTextArea();
		txtAreaDeviceAccessory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaDeviceAccessory.setBackground(new Color(245, 255, 250));
		scrAccessory.setViewportView(txtAreaDeviceAccessory);

		JLabel lblAccesssory = new JLabel("tartozékok:");
		lblAccesssory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccesssory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccesssory.setBounds(0, 197, 137, 35);
		pnlDeviceListener.add(lblAccesssory);

		txtDevicePassword = new JTextField();
		txtDevicePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDevicePassword.setColumns(10);
		txtDevicePassword.setBackground(new Color(245, 255, 250));
		txtDevicePassword.setBounds(139, 151, 189, 35);
		pnlDeviceListener.add(txtDevicePassword);

		JLabel lblPassword = new JLabel("jelszó:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(0, 149, 137, 35);
		pnlDeviceListener.add(lblPassword);

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

		String boxStatus[] = { "Bevizsgálás alatt", "Alkatrészre vár", "Garanciális", "Bevizsgálva" };
		cmBoxStatusdevice = new JComboBox(boxStatus);
		cmBoxStatusdevice.setBounds(103, 199, 189, 35);
		cmBoxStatusdevice.setSelectedItem(null);

		String boxPriority[] = { "Alap", "Szerződött", "Sűrgős" };
		cmBoxPriorityDevice = new JComboBox(boxPriority);
		cmBoxPriorityDevice.setBounds(103, 245, 189, 35);
		cmBoxPriorityDevice.setSelectedItem(null);

		JLabel lblSerialDevice = new JLabel("serial: ");
		lblSerialDevice.setBounds(10, 153, 95, 35);
		lblSerialDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerialDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblConditionDevice = new JLabel("állapot: ");
		lblConditionDevice.setBounds(10, 199, 95, 35);
		lblConditionDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConditionDevice.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtWorkHourAddDate = new JDateChooser();
		txtWorkHourAddDate.setBounds(103, 340, 189, 35);
		txtWorkHourAddDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourAddDate.setBackground(new Color(245, 255, 250));

		txtWorkHourEndDate = new JDateChooser();
		txtWorkHourEndDate.setBounds(103, 386, 189, 35);
		txtWorkHourEndDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourEndDate.setBackground(new Color(245, 255, 250));

		txtWorkHourCompletedDate = new JDateChooser();
		txtWorkHourCompletedDate.setBounds(103, 432, 189, 35);
		txtWorkHourCompletedDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourCompletedDate.setBackground(new Color(245, 255, 250));

		pnlDevice.setLayout(null);

		JLabel lblDevice = new JLabel("eszköz:  ");
		lblDevice.setBounds(10, 59, 95, 35);
		lblDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblDevice);

		JLabel lblTips = new JLabel("típus: ");
		lblTips.setBounds(10, 105, 95, 35);
		pnlDevice.add(lblTips);
		lblTips.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTips.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblSerialDevice);
		pnlDevice.add(lblConditionDevice);

		JLabel lblPriorityDevice = new JLabel("prioritás: ");
		lblPriorityDevice.setBounds(10, 245, 95, 35);
		lblPriorityDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriorityDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblPriorityDevice);

		JLabel lblDeviceGuiBuying = new JLabel("vásárlás:");
		lblDeviceGuiBuying.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceGuiBuying.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceGuiBuying.setBounds(10, 291, 95, 35);
		pnlDevice.add(lblDeviceGuiBuying);

		JLabel lblAddDate = new JLabel("rögzítés: ");
		lblAddDate.setBounds(10, 340, 95, 35);
		lblAddDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblAddDate);

		JLabel lblEndDate = new JLabel("határidő: ");
		lblEndDate.setBounds(10, 386, 95, 35);
		lblEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblEndDate);

		JLabel lblCompletedDate = new JLabel("elkészült: ");
		lblCompletedDate.setBounds(10, 432, 95, 35);
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompletedDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDevice.add(lblCompletedDate);

		String boxDevice[] = { "Számítógép", "Notebook", "Nyomtató", "Monitor", "Projektor", "Egyéb" };
		cmBoxDevice = new JComboBox(boxDevice);
		cmBoxDevice.setBounds(103, 59, 189, 35);
		pnlDevice.add(cmBoxDevice);
		cmBoxDevice.setSelectedItem(null);

		txtDeviceId = new JTextField();
		txtDeviceId.setBounds(302, 59, 95, 35);
		txtDeviceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceId.setEnabled(false);
		txtDeviceId.setColumns(10);
		txtDeviceId.setBackground(new Color(245, 255, 250));
		pnlDevice.add(txtDeviceId);

		txtTypeDevice = new JTextField();
		txtTypeDevice.setBounds(103, 105, 189, 35);
		pnlDevice.add(txtTypeDevice);
		txtTypeDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTypeDevice.setColumns(10);
		txtTypeDevice.setBackground(new Color(245, 255, 250));

		txtSerialDevice = new JTextField();
		txtSerialDevice.setBounds(103, 153, 189, 35);
		pnlDevice.add(txtSerialDevice);
		txtSerialDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialDevice.setColumns(10);
		txtSerialDevice.setBackground(new Color(245, 255, 250));
		pnlDevice.add(cmBoxStatusdevice);
		pnlDevice.add(cmBoxPriorityDevice);

		txtDeviceBuyingDate = new JDateChooser();
		txtDeviceBuyingDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceBuyingDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeviceBuyingDate.setDateFormatString("yyyy-MM-dd");
		txtDeviceBuyingDate.setBackground(new Color(245, 255, 250));
		txtDeviceBuyingDate.setBounds(103, 291, 189, 35);

		pnlDevice.add(txtDeviceBuyingDate);
		pnlDevice.add(txtWorkHourAddDate);
		pnlDevice.add(txtWorkHourEndDate);
		pnlDevice.add(txtWorkHourCompletedDate);

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
