package ex.main.sales.device.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import ex.main.sales.client.ClientJDBCSetDAO;

public class DeviceGui extends ClientJDBCSetDAO {
	public DeviceGui() {
		jpnlDevice.setBackground(Color.DARK_GRAY);
		pnlSalesDevice.setBackground(Color.BLACK);

		setGuiDeviceClient();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1289447200090810218L;
	protected JTable jtblSalesDevice;
	protected JTextField txtSalesDevicePassword;
	protected JTextField txtSalesDeviceID;
	protected JTextField txtSalesdeviceType;
	protected JComboBox<Object> cmbSalesDeviceName, cmbSalesDeviceCondition, cmbSalesDevicePriority,
			cmbSalesDeviceSoftver, cmbSalesDeviceCleaning;
	protected JDateChooser dateSalesDeviceBuying, dateSalesDeviceEndDate, dateSalesDeviceAddDate;
	protected JTextArea txtSalesDeviceComment, txtSalesDeviceInjury, txtSalesDeviceAccesssory;

	private void setGuiDeviceClient() {
		jpnlDevice.setLayout(null);

		JScrollPane scrDevice = new JScrollPane();
		scrDevice.setBounds(10, 377, 1219, 235);
		jpnlDevice.add(scrDevice);

		jtblSalesDevice = new JTable();
		scrDevice.setViewportView(jtblSalesDevice);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setLayout(null);
		panel_2.setBounds(398, 11, 369, 355);
		jpnlDevice.add(panel_2);

		JLabel lblSalesDeviceSoftver = new JLabel("softwer telepítés:");
		lblSalesDeviceSoftver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceSoftver.setForeground(new Color(153, 0, 0));
		lblSalesDeviceSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceSoftver.setBounds(0, 0, 140, 35);
		panel_2.add(lblSalesDeviceSoftver);

		JLabel lblSalesDeviceCleaning = new JLabel("takarítás:");
		lblSalesDeviceCleaning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceCleaning.setForeground(new Color(153, 0, 0));
		lblSalesDeviceCleaning.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceCleaning.setBounds(0, 46, 140, 35);
		panel_2.add(lblSalesDeviceCleaning);

		JLabel lblSalesDevicePassword = new JLabel("jelszó:");
		lblSalesDevicePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDevicePassword.setForeground(new Color(153, 0, 0));
		lblSalesDevicePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDevicePassword.setBounds(0, 90, 140, 35);
		panel_2.add(lblSalesDevicePassword);

		JLabel lblSalesDeviceAccesssory = new JLabel("tartozékok:");
		lblSalesDeviceAccesssory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceAccesssory.setForeground(new Color(153, 0, 0));
		lblSalesDeviceAccesssory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceAccesssory.setBounds(0, 136, 140, 35);
		panel_2.add(lblSalesDeviceAccesssory);

		txtSalesDevicePassword = new JTextField();
		txtSalesDevicePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDevicePassword.setColumns(10);
		txtSalesDevicePassword.setBackground(new Color(245, 255, 250));
		txtSalesDevicePassword.setBounds(144, 90, 195, 35);
		panel_2.add(txtSalesDevicePassword);

		cmbSalesDeviceSoftver = new JComboBox<Object>(new Object[] {});
		cmbSalesDeviceSoftver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesDeviceSoftver.setBounds(144, 0, 195, 35);
		panel_2.add(cmbSalesDeviceSoftver);

		cmbSalesDeviceCleaning = new JComboBox<Object>(new Object[] {});
		cmbSalesDeviceCleaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesDeviceCleaning.setBounds(144, 44, 195, 35);
		panel_2.add(cmbSalesDeviceCleaning);

		JScrollPane scrSalesDeviceAccesssory = new JScrollPane();
		scrSalesDeviceAccesssory.setBounds(144, 137, 224, 60);
		panel_2.add(scrSalesDeviceAccesssory);

		txtSalesDeviceAccesssory = new JTextArea();
		scrSalesDeviceAccesssory.setViewportView(txtSalesDeviceAccesssory);
		txtSalesDeviceAccesssory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDeviceAccesssory.setBackground(new Color(245, 255, 250));

		JScrollPane scrSalesDeviceInjury = new JScrollPane();
		scrSalesDeviceInjury.setBounds(144, 208, 224, 60);
		panel_2.add(scrSalesDeviceInjury);

		txtSalesDeviceInjury = new JTextArea();
		txtSalesDeviceInjury.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDeviceInjury.setBackground(new Color(245, 255, 250));
		scrSalesDeviceInjury.setViewportView(txtSalesDeviceInjury);

		JScrollPane scrSalesDeviceComment = new JScrollPane();
		scrSalesDeviceComment.setBounds(144, 279, 224, 76);
		panel_2.add(scrSalesDeviceComment);

		txtSalesDeviceComment = new JTextArea();
		txtSalesDeviceComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDeviceComment.setBackground(new Color(245, 255, 250));
		scrSalesDeviceComment.setViewportView(txtSalesDeviceComment);

		JLabel lblSalesDeviceInjury = new JLabel("sérlülés:");
		lblSalesDeviceInjury.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceInjury.setForeground(new Color(153, 0, 0));
		lblSalesDeviceInjury.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceInjury.setBounds(0, 208, 140, 35);
		panel_2.add(lblSalesDeviceInjury);

		JLabel lblSalesDeviceComment = new JLabel("hiba leírása:");
		lblSalesDeviceComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceComment.setForeground(new Color(153, 0, 0));
		lblSalesDeviceComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceComment.setBounds(0, 279, 140, 35);
		panel_2.add(lblSalesDeviceComment);
		pnlSalesDevice.setLayout(null);

		JLabel lblSalesDevice = new JLabel("eszköz:");
		lblSalesDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDevice.setForeground(new Color(153, 0, 0));
		lblSalesDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDevice.setBounds(0, 43, 85, 35);
		pnlSalesDevice.add(lblSalesDevice);

		cmbSalesDeviceName = new JComboBox<Object>(new Object[] {});
		cmbSalesDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesDeviceName.setBounds(88, 43, 189, 35);
		pnlSalesDevice.add(cmbSalesDeviceName);

		txtSalesDeviceID = new JTextField();
		txtSalesDeviceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDeviceID.setEnabled(false);
		txtSalesDeviceID.setColumns(10);
		txtSalesDeviceID.setBackground(new Color(245, 255, 250));
		txtSalesDeviceID.setBounds(283, 43, 95, 35);
		pnlSalesDevice.add(txtSalesDeviceID);

		txtSalesdeviceType = new JTextField();
		txtSalesdeviceType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesdeviceType.setColumns(10);
		txtSalesdeviceType.setBackground(new Color(245, 255, 250));
		txtSalesdeviceType.setBounds(88, 90, 189, 35);
		pnlSalesDevice.add(txtSalesdeviceType);

		cmbSalesDeviceCondition = new JComboBox<Object>(new Object[] {});
		cmbSalesDeviceCondition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesDeviceCondition.setBounds(88, 136, 189, 35);
		pnlSalesDevice.add(cmbSalesDeviceCondition);

		cmbSalesDevicePriority = new JComboBox<Object>(new Object[] {});
		cmbSalesDevicePriority.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSalesDevicePriority.setBounds(88, 182, 189, 35);
		pnlSalesDevice.add(cmbSalesDevicePriority);

		dateSalesDeviceBuying = new JDateChooser();
		dateSalesDeviceBuying.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceBuying.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceBuying.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceBuying.setBackground(new Color(245, 255, 250));
		dateSalesDeviceBuying.setBounds(88, 228, 189, 35);
		pnlSalesDevice.add(dateSalesDeviceBuying);

		dateSalesDeviceAddDate = new JDateChooser();
		dateSalesDeviceAddDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceAddDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceAddDate.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceAddDate.setBackground(new Color(245, 255, 250));
		dateSalesDeviceAddDate.setBounds(88, 274, 189, 35);
		pnlSalesDevice.add(dateSalesDeviceAddDate);

		dateSalesDeviceEndDate = new JDateChooser();
		dateSalesDeviceEndDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceEndDate.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceEndDate.setBackground(new Color(245, 255, 250));
		dateSalesDeviceEndDate.setBounds(88, 320, 189, 35);
		pnlSalesDevice.add(dateSalesDeviceEndDate);

		JLabel lblSalesdeviceType = new JLabel("típus:");
		lblSalesdeviceType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesdeviceType.setForeground(new Color(153, 0, 0));
		lblSalesdeviceType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesdeviceType.setBounds(0, 89, 85, 35);
		pnlSalesDevice.add(lblSalesdeviceType);

		JLabel lblSalesDeviceCondition = new JLabel("állapot:");
		lblSalesDeviceCondition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceCondition.setForeground(new Color(153, 0, 0));
		lblSalesDeviceCondition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceCondition.setBounds(0, 136, 85, 35);
		pnlSalesDevice.add(lblSalesDeviceCondition);

		JLabel lblSalesDevicePriority = new JLabel("prioritás:");
		lblSalesDevicePriority.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDevicePriority.setForeground(new Color(153, 0, 0));
		lblSalesDevicePriority.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDevicePriority.setBounds(0, 182, 85, 35);
		pnlSalesDevice.add(lblSalesDevicePriority);

		JLabel lblSalesDeviceBuying = new JLabel("vásárlás:");
		lblSalesDeviceBuying.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceBuying.setForeground(new Color(153, 0, 0));
		lblSalesDeviceBuying.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceBuying.setBounds(0, 228, 85, 35);
		pnlSalesDevice.add(lblSalesDeviceBuying);

		JLabel lblSalesDeviceAddDate = new JLabel("rögzítés:");
		lblSalesDeviceAddDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceAddDate.setForeground(new Color(153, 0, 0));
		lblSalesDeviceAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceAddDate.setBounds(0, 274, 85, 35);
		pnlSalesDevice.add(lblSalesDeviceAddDate);

		JLabel lblSalesDeviceEndDate = new JLabel("határidő:");
		lblSalesDeviceEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceEndDate.setForeground(new Color(153, 0, 0));
		lblSalesDeviceEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceEndDate.setBounds(0, 320, 85, 35);
		pnlSalesDevice.add(lblSalesDeviceEndDate);

	}
}
