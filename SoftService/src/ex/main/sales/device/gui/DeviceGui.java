package ex.main.sales.device.gui;

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

import com.toedter.calendar.JDateChooser;

import ex.main.sales.client.ClientJDBCSetDAO;
import ex.main.sales.client.gui.ClientGui;

public class DeviceGui extends ClientJDBCSetDAO {
	public DeviceGui() {
		pnlSalesDevice.setBounds(10, 11, 378, 362);
		jpnlDevice.setBackground(Color.DARK_GRAY);
		pnlSalesDevice.setBackground(Color.BLACK);
		setGuiDeviceClient();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1289447200090810218L;
	protected JTable jtblSalesDevice;
	protected JTextField txtSalesDevicePassword,txtSalesDeviceSerialNumber;
	protected JTextField txtSalesDeviceID;
	protected JComboBox<Object> cmbSalesDeviceName, txtSalesdeviceType, cmbSalesDeviceCondition, cmbSalesDevicePriority,
			cmbSalesDeviceSoftver, cmbSalesDeviceCleaning, cmbSalesDeviceSearch, cmbSalesDeviceHardver;
	protected JDateChooser dateSalesDeviceBuying, dateSalesDeviceEndDate, dateSalesDeviceAddDate;
	protected JTextArea txtSalesDeviceComment, txtSalesDeviceInjury, txtSalesDeviceAccesssory;
	protected JTextField txtSalesDeviceSearch;
	protected JButton btnSalesDeviceSearch, btnSalesDeviceNew, btnSalesDeviceEdit, btnSalesDeviceDelete,
			btnSalesDeviceNull;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	protected JPanel panel_2, panel;
	 

	private void setGuiDeviceClient() {
		jpnlDevice.setLayout(null);

		jtblSalesDevice = new JTable();
		jtblSalesDevice.setBackground(Color.BLACK);
		jtblSalesDevice.setForeground(new Color(153, 0, 0));
		jtblSalesDevice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtblSalesDevice.setRowHeight(30);

		JScrollPane scrDevice = new JScrollPane(jtblSalesDevice, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrDevice.setBounds(10, 377, 1219, 235);
		jpnlDevice.add(scrDevice);
		jtblSalesDevice.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		pnlSalesDevice.setLayout(null);

		JLabel lblSalesDevice = new JLabel("eszköz:");
		lblSalesDevice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDevice.setForeground(new Color(153, 0, 0));
		lblSalesDevice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDevice.setBounds(0, 43, 85, 35);
		pnlSalesDevice.add(lblSalesDevice);

		txtSalesdeviceType = new JComboBox<Object>();
		txtSalesdeviceType.setForeground(Color.BLACK);
		txtSalesdeviceType.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesdeviceType.setBackground(Color.BLACK);
		txtSalesdeviceType.setBounds(88, 90, 189, 35);
		txtSalesdeviceType.setEditable(false);
		pnlSalesDevice.add(txtSalesdeviceType);

		String boxDevice[] = { "Asztali PC", "Notebook", "Nyomtató", "Monitor", "Projektor", "Egyéb" };
		cmbSalesDeviceName = new JComboBox<Object>(boxDevice);
		cmbSalesDeviceName.setForeground(Color.BLACK);
		cmbSalesDeviceName.setBackground(Color.BLACK);
		cmbSalesDeviceName.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceName.setBounds(88, 43, 189, 35);
		cmbSalesDeviceName.setSelectedItem(null);
		pnlSalesDevice.add(cmbSalesDeviceName);

		txtSalesDeviceID = new JTextField();
		txtSalesDeviceID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSalesDeviceID.setEnabled(false);
		txtSalesDeviceID.setColumns(10);
		txtSalesDeviceID.setBackground(new Color(245, 255, 250));
		txtSalesDeviceID.setBounds(283, 43, 95, 35);
		pnlSalesDevice.add(txtSalesDeviceID);

		// txtSalesdeviceType1 = new JTextField();
		// txtSalesdeviceType1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// txtSalesdeviceType1.setColumns(10);
		// txtSalesdeviceType1.setBackground(new Color(245, 255, 250));
		// txtSalesdeviceType1.setBounds(88, 90, 189, 35);
		// pnlSalesDevice.add(txtSalesdeviceType1);

		String boxStatus[] = { "Bevételezve", "Kiadva" };
		cmbSalesDeviceCondition = new JComboBox<Object>(boxStatus);
		cmbSalesDeviceCondition.setBackground(Color.BLACK);
		cmbSalesDeviceCondition.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceCondition.setBounds(88, 136, 189, 35);
		cmbSalesDeviceCondition.setSelectedItem(null);
		pnlSalesDevice.add(cmbSalesDeviceCondition);

		String boxPriority[] = { "Alap", "Szerződött", "Sűrgős" };
		cmbSalesDevicePriority = new JComboBox<Object>(boxPriority);
		cmbSalesDevicePriority.setBackground(Color.BLACK);
		cmbSalesDevicePriority.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDevicePriority.setBounds(88, 182, 189, 35);
		cmbSalesDevicePriority.setSelectedItem(null);
		pnlSalesDevice.add(cmbSalesDevicePriority);

		dateSalesDeviceBuying = new JDateChooser();
		dateSalesDeviceBuying.setForeground(new Color(51, 0, 0));
		dateSalesDeviceBuying.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceBuying.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateSalesDeviceBuying.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceBuying.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceBuying.setBounds(88, 228, 189, 35);
		pnlSalesDevice.add(dateSalesDeviceBuying);

		dateSalesDeviceAddDate = new JDateChooser();
		dateSalesDeviceAddDate.setForeground(new Color(51, 0, 0));
		dateSalesDeviceAddDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceAddDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateSalesDeviceAddDate.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceAddDate.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceAddDate.setBounds(88, 274, 189, 35);
		pnlSalesDevice.add(dateSalesDeviceAddDate);

		dateSalesDeviceEndDate = new JDateChooser();
		dateSalesDeviceEndDate.setForeground(new Color(51, 0, 0));
		dateSalesDeviceEndDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateSalesDeviceEndDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateSalesDeviceEndDate.setDateFormatString("yyyy-MM-dd");
		dateSalesDeviceEndDate.setBackground(Color.LIGHT_GRAY);
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

		lblNewLabel_1 = new JLabel(new ImageIcon(((new ImageIcon("Image\\587cede4029fa159a80142ab.jpg")).getImage())
				.getScaledInstance(378, 362, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(0, 0, 378, 362);
		pnlSalesDevice.add(lblNewLabel_1);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setLayout(null);
		panel_2.setBounds(398, 11, 509, 362);
		jpnlDevice.add(panel_2);

		JLabel lblSalesDeviceCleaning = new JLabel("takarítás:");
		lblSalesDeviceCleaning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceCleaning.setForeground(new Color(153, 0, 0));
		lblSalesDeviceCleaning.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceCleaning.setBounds(0, 11, 140, 35);
		panel_2.add(lblSalesDeviceCleaning);

		JLabel lblSalesDevicePassword = new JLabel("jelszó:");
		lblSalesDevicePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDevicePassword.setForeground(new Color(153, 0, 0));
		lblSalesDevicePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDevicePassword.setBounds(0, 57, 140, 35);
		panel_2.add(lblSalesDevicePassword);

		JLabel lblSalesDeviceAccesssory = new JLabel("tartozékok:");
		lblSalesDeviceAccesssory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceAccesssory.setForeground(new Color(153, 0, 0));
		lblSalesDeviceAccesssory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceAccesssory.setBounds(0, 103, 140, 35);
		panel_2.add(lblSalesDeviceAccesssory);

		txtSalesDevicePassword = new JTextField("-");
		txtSalesDevicePassword.setForeground(new Color(51, 0, 0));
		txtSalesDevicePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDevicePassword.setColumns(10);
		txtSalesDevicePassword.setBackground(Color.WHITE);
		txtSalesDevicePassword.setBounds(144, 57, 195, 35);
		panel_2.add(txtSalesDevicePassword);

		String BoxCleaning[] = { "Igen", "Nem" };
		cmbSalesDeviceCleaning = new JComboBox<Object>(BoxCleaning);
		cmbSalesDeviceCleaning.setBackground(Color.BLACK);
		cmbSalesDeviceCleaning.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceCleaning.setBounds(144, 11, 195, 35);
		cmbSalesDeviceCleaning.setSelectedItem(null);
		panel_2.add(cmbSalesDeviceCleaning);

		JScrollPane scrSalesDeviceAccesssory = new JScrollPane();
		scrSalesDeviceAccesssory.setBounds(144, 103, 355, 60);
		panel_2.add(scrSalesDeviceAccesssory);

		txtSalesDeviceAccesssory = new JTextArea("-");
		txtSalesDeviceAccesssory.setForeground(new Color(51, 0, 0));
		scrSalesDeviceAccesssory.setViewportView(txtSalesDeviceAccesssory);
		txtSalesDeviceAccesssory.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDeviceAccesssory.setBackground(Color.WHITE);

		JScrollPane scrSalesDeviceInjury = new JScrollPane();
		scrSalesDeviceInjury.setBounds(144, 174, 355, 60);
		panel_2.add(scrSalesDeviceInjury);

		txtSalesDeviceInjury = new JTextArea("-");
		txtSalesDeviceInjury.setForeground(new Color(51, 0, 0));
		txtSalesDeviceInjury.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDeviceInjury.setBackground(Color.WHITE);
		scrSalesDeviceInjury.setViewportView(txtSalesDeviceInjury);

		JScrollPane scrSalesDeviceComment = new JScrollPane();
		scrSalesDeviceComment.setBounds(144, 245, 355, 106);
		panel_2.add(scrSalesDeviceComment);

		txtSalesDeviceComment = new JTextArea();
		txtSalesDeviceComment.setForeground(new Color(51, 0, 0));
		txtSalesDeviceComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDeviceComment.setBackground(Color.WHITE);
		scrSalesDeviceComment.setViewportView(txtSalesDeviceComment);

		JLabel lblSalesDeviceInjury = new JLabel("sérlülés:");
		lblSalesDeviceInjury.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceInjury.setForeground(new Color(153, 0, 0));
		lblSalesDeviceInjury.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceInjury.setBounds(0, 174, 140, 35);
		panel_2.add(lblSalesDeviceInjury);

		JLabel lblSalesDeviceComment = new JLabel("hiba leírása:");
		lblSalesDeviceComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceComment.setForeground(new Color(153, 0, 0));
		lblSalesDeviceComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceComment.setBounds(0, 245, 140, 35);
		panel_2.add(lblSalesDeviceComment);

		lblNewLabel_2 = new JLabel(new ImageIcon(((new ImageIcon("Image\\587cede4029fa159a80142ab.jpg")).getImage())
				.getScaledInstance(509, 362, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel_2.setBounds(0, 0, 509, 362);
		panel_2.add(lblNewLabel_2);

		txtSalesDeviceSearch = new JTextField();
		txtSalesDeviceSearch.setForeground(Color.WHITE);
		txtSalesDeviceSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDeviceSearch.setColumns(10);
		txtSalesDeviceSearch.setBackground(new Color(153, 0, 0));
		txtSalesDeviceSearch.setBounds(917, 11, 173, 35);
		jpnlDevice.add(txtSalesDeviceSearch);

		btnSalesDeviceSearch = new JButton("");
		btnSalesDeviceSearch.setBackground(new Color(51, 0, 0));
		btnSalesDeviceSearch.setBounds(1100, 11, 57, 35);
		jpnlDevice.add(btnSalesDeviceSearch);
		btnSalesDeviceSearch.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/search.png")));

		String salesDeviceSearch[] = { "ugyfel_nev", "tipus", "rogzites" };
		cmbSalesDeviceSearch = new JComboBox<Object>(salesDeviceSearch);
		cmbSalesDeviceSearch.setForeground(Color.WHITE);
		cmbSalesDeviceSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceSearch.setBackground(Color.BLACK);
		cmbSalesDeviceSearch.setBounds(917, 56, 234, 35);
		jpnlDevice.add(cmbSalesDeviceSearch);

		btnSalesDeviceNew = new JButton("");
		btnSalesDeviceNew.setBackground(new Color(51, 0, 0));
		btnSalesDeviceNew.setBounds(917, 335, 60, 37);
		btnSalesDeviceNew.setIcon(new ImageIcon(DeviceGui.class.getResource("/icon/function/24x24/add.png")));
		jpnlDevice.add(btnSalesDeviceNew);

		btnSalesDeviceEdit = new JButton("");
		btnSalesDeviceEdit.setHorizontalAlignment(SwingConstants.LEADING);
		btnSalesDeviceEdit.setBackground(new Color(51, 0, 0));
		btnSalesDeviceEdit.setBounds(987, 336, 60, 37);
		btnSalesDeviceEdit.setIcon(new ImageIcon(DeviceGui.class.getResource("/icon/function/24x24/refresh.png")));
		jpnlDevice.add(btnSalesDeviceEdit);

		btnSalesDeviceDelete = new JButton("");
		btnSalesDeviceDelete.setBackground(new Color(51, 0, 0));
		btnSalesDeviceDelete.setBounds(1057, 336, 60, 37);
		btnSalesDeviceDelete.setIcon(new ImageIcon(DeviceGui.class.getResource("/icon/function/24x24/cross.png")));
		jpnlDevice.add(btnSalesDeviceDelete);

		btnSalesDeviceNull = new JButton("");
		btnSalesDeviceNull.setBackground(new Color(51, 0, 0));
		btnSalesDeviceNull.setBounds(1127, 336, 60, 37);
		btnSalesDeviceNull.setIcon(new ImageIcon(DeviceGui.class.getResource("/icon/function/24x24/home.png")));
		jpnlDevice.add(btnSalesDeviceNull);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(917, 102, 312, 152);
		jpnlDevice.add(panel);
		panel.setLayout(null);

		String boxDeviceSoftwer[] = { "Igen", "Nem" };
		cmbSalesDeviceSoftver = new JComboBox<Object>(boxDeviceSoftwer);
		cmbSalesDeviceSoftver.setBounds(107, 57, 195, 35);
		panel.add(cmbSalesDeviceSoftver);
		cmbSalesDeviceSoftver.setBackground(Color.BLACK);
		cmbSalesDeviceSoftver.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceSoftver.setSelectedItem(null);

		JLabel lblSalesDeviceSoftver = new JLabel("softwer:");
		lblSalesDeviceSoftver.setBounds(10, 57, 87, 35);
		panel.add(lblSalesDeviceSoftver);
		lblSalesDeviceSoftver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceSoftver.setForeground(new Color(153, 0, 0));
		lblSalesDeviceSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));

		txtSalesDeviceSerialNumber = new JTextField("Nincs");
		txtSalesDeviceSerialNumber.setForeground(new Color(51, 0, 0));
		txtSalesDeviceSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesDeviceSerialNumber.setColumns(10);
		txtSalesDeviceSerialNumber.setBackground(Color.WHITE);
		txtSalesDeviceSerialNumber.setBounds(107, 11, 195, 35);
		panel.add(txtSalesDeviceSerialNumber);

		JLabel lblSalesDeviceSerialNumber = new JLabel("serial no.: ");
		lblSalesDeviceSerialNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceSerialNumber.setForeground(new Color(153, 0, 0));
		lblSalesDeviceSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceSerialNumber.setBounds(10, 11, 87, 35);
		panel.add(lblSalesDeviceSerialNumber);

		String boxSalesDeviceHardver[] = { "Igen", "Nem" };
		cmbSalesDeviceHardver = new JComboBox<Object>(boxSalesDeviceHardver);
		cmbSalesDeviceHardver.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbSalesDeviceHardver.setBackground(Color.BLACK);
		cmbSalesDeviceHardver.setBounds(107, 103, 195, 35);
		panel.add(cmbSalesDeviceHardver);
		cmbSalesDeviceHardver.setSelectedItem(null);

		JLabel lblSalesDeviceHardver = new JLabel("hardver:");
		lblSalesDeviceHardver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalesDeviceHardver.setForeground(new Color(153, 0, 0));
		lblSalesDeviceHardver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesDeviceHardver.setBounds(10, 103, 87, 35);
		panel.add(lblSalesDeviceHardver);

		JLabel lblNewLabel = new JLabel(
				new ImageIcon(((new ImageIcon("Image\\Red-And-Black-Abstract-Wallpaper-3.jpg")).getImage())
						.getScaledInstance(1239, 627, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(0, 0, 1239, 627);
		jpnlDevice.add(lblNewLabel);

	}
}
