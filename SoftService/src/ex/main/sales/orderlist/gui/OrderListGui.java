package ex.main.sales.orderlist.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import ex.main.sales.worksheet.WorkSheetJDBCSetDAO;

public class OrderListGui extends WorkSheetJDBCSetDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4081536249718275538L;
	protected JLabel lblOrderListClientID, lblOrderListClientName, lblOrderListClientMobil, lblOrderListHomeAndress,
			lblOrderListClientComment;
	protected JLabel lblOrderClientDeviceID, lblOrderListDeviceName, lblOrderListDeviceType,
			lblOrderListDeviceSerialNumber, lblOrderListDeviceStatus, lblOrderListDevicePriorit,
			lblOrderListDeviceBuyDate, lblOrderListDeviceAddDate, lblOrderListDeviceEndDate,
			lblOrderListDeviceCompletDate, lblOrderListDeviceSoftver, lblOrderListDeviceHardver,
			lblOrderListDeviceCliening, lblOrderListDevicePassword, lblOrderListDeviceAccessories,
			lblOrderListDeviceInjury, lblOrderListDeviceFault, lblOrderListDeviceError;
	protected JPanel sss;
	protected JLabel lblClientMobil;
	public OrderListGui() {

		setComponent();
	}

	private void setComponent() {
		pnlOrderList.setLayout(null);

		 sss = new JPanel();
		// sss.setBackground(Color.BLACK);

		sss.setPreferredSize(new Dimension(1190, 5000));
		sss.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(sss);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 1214, 509);
		pnlOrderList.add(scrollPane);

		JLabel lblClientID = new JLabel("azonosító: ");
		lblClientID.setBounds(10, 57, 247, 35);
		lblClientID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientID.setForeground(new Color(153, 0, 0));
		lblClientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblClientID);

		lblOrderListClientID = new JLabel("-");
		lblOrderListClientID.setBounds(267, 57, 918, 35);
		lblOrderListClientID.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListClientID.setForeground(Color.WHITE);
		lblOrderListClientID.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblOrderListClientID);

		JLabel lblClientName = new JLabel("név: ");
		lblClientName.setBounds(10, 103, 247, 35);
		lblClientName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientName.setForeground(new Color(153, 0, 0));
		lblClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblClientName);

		lblOrderListClientName = new JLabel("-");
		lblOrderListClientName.setBounds(267, 103, 918, 35);
		lblOrderListClientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListClientName.setForeground(Color.WHITE);
		lblOrderListClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblOrderListClientName);

		 lblClientMobil = new JLabel("telefon: ");
		lblClientMobil.setBounds(10, 149, 247, 35);
		lblClientMobil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientMobil.setForeground(new Color(153, 0, 0));
		lblClientMobil.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblClientMobil);

		lblOrderListClientMobil = new JLabel("-");
		lblOrderListClientMobil.setBounds(267, 149, 918, 35);
		lblOrderListClientMobil.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListClientMobil.setForeground(Color.WHITE);
		lblOrderListClientMobil.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblOrderListClientMobil);

		JLabel lblHomeAndress = new JLabel("lakcím: ");
		lblHomeAndress.setBounds(10, 195, 247, 35);
		lblHomeAndress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeAndress.setForeground(new Color(153, 0, 0));
		lblHomeAndress.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblHomeAndress);

		lblOrderListHomeAndress = new JLabel("-");
		lblOrderListHomeAndress.setBackground(Color.WHITE);
		lblOrderListHomeAndress.setBounds(267, 195, 918, 35);
		lblOrderListHomeAndress.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListHomeAndress.setForeground(Color.WHITE);
		lblOrderListHomeAndress.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblOrderListHomeAndress);

		JLabel lblLblclientcomment = new JLabel("megjegyzés:");
		lblLblclientcomment.setBounds(10, 241, 247, 35);
		lblLblclientcomment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLblclientcomment.setForeground(new Color(153, 0, 0));
		lblLblclientcomment.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblLblclientcomment);

		lblOrderListClientComment = new JLabel("-");
		lblOrderListClientComment.setBounds(267, 241, 918, 35);
		lblOrderListClientComment.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListClientComment.setForeground(Color.WHITE);
		lblOrderListClientComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(lblOrderListClientComment);

		lblOrderClientDeviceID = new JLabel("-");
		lblOrderClientDeviceID.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderClientDeviceID.setForeground(Color.WHITE);
		lblOrderClientDeviceID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderClientDeviceID.setBounds(267, 333, 918, 35);
		sss.add(lblOrderClientDeviceID);

		JLabel lblDeviceID = new JLabel(" azonosító:");
		lblDeviceID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceID.setForeground(new Color(153, 0, 0));
		lblDeviceID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceID.setBounds(10, 333, 247, 35);
		sss.add(lblDeviceID);

		lblOrderListDeviceName = new JLabel("-");
		lblOrderListDeviceName.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceName.setForeground(Color.WHITE);
		lblOrderListDeviceName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceName.setBounds(267, 379, 918, 35);
		sss.add(lblOrderListDeviceName);

		JLabel lblDeviceName = new JLabel("eszköz:");
		lblDeviceName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceName.setForeground(new Color(153, 0, 0));
		lblDeviceName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceName.setBounds(10, 379, 247, 35);
		sss.add(lblDeviceName);

		JLabel lblKszlk = new JLabel("KÉSZÜLÉK");
		lblKszlk.setHorizontalAlignment(SwingConstants.CENTER);
		lblKszlk.setForeground(Color.BLUE);
		lblKszlk.setFont(new Font("Arial", Font.BOLD, 26));
		lblKszlk.setBounds(144, 287, 842, 35);
		sss.add(lblKszlk);

		JLabel lblMegrendel = new JLabel("MEGRENDELŐ");
		lblMegrendel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMegrendel.setForeground(Color.BLUE);
		lblMegrendel.setFont(new Font("Arial", Font.BOLD, 26));
		lblMegrendel.setBounds(144, 11, 842, 35);
		sss.add(lblMegrendel);

		JLabel lblDeviceType = new JLabel("típus:");
		lblDeviceType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceType.setForeground(new Color(153, 0, 0));
		lblDeviceType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceType.setBounds(10, 425, 247, 35);
		sss.add(lblDeviceType);

		lblOrderListDeviceType = new JLabel("-");
		lblOrderListDeviceType.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceType.setForeground(Color.WHITE);
		lblOrderListDeviceType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceType.setBounds(267, 425, 918, 35);
		sss.add(lblOrderListDeviceType);

		JLabel lblSerial = new JLabel("sorozatszám:");
		lblSerial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerial.setForeground(new Color(153, 0, 0));
		lblSerial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSerial.setBounds(10, 471, 247, 35);
		sss.add(lblSerial);

		lblOrderListDeviceSerialNumber = new JLabel("-");
		lblOrderListDeviceSerialNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceSerialNumber.setForeground(Color.WHITE);
		lblOrderListDeviceSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceSerialNumber.setBounds(267, 471, 918, 35);
		sss.add(lblOrderListDeviceSerialNumber);

		JLabel lblDeviceStatus = new JLabel("állapot:");
		lblDeviceStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceStatus.setForeground(new Color(153, 0, 0));
		lblDeviceStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceStatus.setBounds(10, 517, 247, 35);
		sss.add(lblDeviceStatus);

		JLabel lblDevicePriorit = new JLabel("prioritás:");
		lblDevicePriorit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevicePriorit.setForeground(new Color(153, 0, 0));
		lblDevicePriorit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDevicePriorit.setBounds(10, 563, 247, 35);
		sss.add(lblDevicePriorit);

		JLabel lblDeviceBuyDate = new JLabel("vásárlás: ");
		lblDeviceBuyDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceBuyDate.setForeground(new Color(153, 0, 0));
		lblDeviceBuyDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceBuyDate.setBounds(10, 609, 247, 35);
		sss.add(lblDeviceBuyDate);

		JLabel lblDeviceAddDate = new JLabel("rögzítés:");
		lblDeviceAddDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceAddDate.setForeground(new Color(153, 0, 0));
		lblDeviceAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceAddDate.setBounds(10, 655, 247, 35);
		sss.add(lblDeviceAddDate);

		JLabel lblDeviceEndDate = new JLabel("határidő:");
		lblDeviceEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceEndDate.setForeground(new Color(153, 0, 0));
		lblDeviceEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceEndDate.setBounds(10, 701, 247, 35);
		sss.add(lblDeviceEndDate);

		lblOrderListDeviceStatus = new JLabel("-");
		lblOrderListDeviceStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceStatus.setForeground(Color.WHITE);
		lblOrderListDeviceStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceStatus.setBounds(267, 517, 918, 35);
		sss.add(lblOrderListDeviceStatus);

		lblOrderListDevicePriorit = new JLabel("-");
		lblOrderListDevicePriorit.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDevicePriorit.setForeground(Color.WHITE);
		lblOrderListDevicePriorit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDevicePriorit.setBounds(267, 563, 918, 35);
		sss.add(lblOrderListDevicePriorit);

		lblOrderListDeviceBuyDate = new JLabel("-");
		lblOrderListDeviceBuyDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceBuyDate.setForeground(Color.WHITE);
		lblOrderListDeviceBuyDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceBuyDate.setBounds(267, 609, 918, 35);
		sss.add(lblOrderListDeviceBuyDate);

		lblOrderListDeviceAddDate = new JLabel("-");
		lblOrderListDeviceAddDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceAddDate.setForeground(Color.WHITE);
		lblOrderListDeviceAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceAddDate.setBounds(267, 655, 918, 35);
		sss.add(lblOrderListDeviceAddDate);

		lblOrderListDeviceEndDate = new JLabel("-");
		lblOrderListDeviceEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceEndDate.setForeground(Color.WHITE);
		lblOrderListDeviceEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceEndDate.setBounds(267, 701, 918, 35);
		sss.add(lblOrderListDeviceEndDate);

		JLabel lblDeviceCompletDate = new JLabel("teljesítve:");
		lblDeviceCompletDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceCompletDate.setForeground(new Color(153, 0, 0));
		lblDeviceCompletDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceCompletDate.setBounds(10, 747, 247, 35);
		sss.add(lblDeviceCompletDate);

		lblOrderListDeviceCompletDate = new JLabel("-");
		lblOrderListDeviceCompletDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceCompletDate.setForeground(Color.WHITE);
		lblOrderListDeviceCompletDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceCompletDate.setBounds(267, 747, 918, 35);
		sss.add(lblOrderListDeviceCompletDate);

		JLabel lblDeviceSoftver = new JLabel("softver:");
		lblDeviceSoftver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceSoftver.setForeground(new Color(153, 0, 0));
		lblDeviceSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceSoftver.setBounds(10, 793, 247, 35);
		sss.add(lblDeviceSoftver);

		lblOrderListDeviceSoftver = new JLabel("-");
		lblOrderListDeviceSoftver.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceSoftver.setForeground(Color.WHITE);
		lblOrderListDeviceSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceSoftver.setBounds(267, 793, 918, 35);
		sss.add(lblOrderListDeviceSoftver);

		JLabel lblDeviceHardver = new JLabel("hardver:");
		lblDeviceHardver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceHardver.setForeground(new Color(153, 0, 0));
		lblDeviceHardver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceHardver.setBounds(10, 839, 247, 35);
		sss.add(lblDeviceHardver);

		lblOrderListDeviceHardver = new JLabel("-");
		lblOrderListDeviceHardver.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceHardver.setForeground(Color.WHITE);
		lblOrderListDeviceHardver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceHardver.setBounds(267, 839, 918, 35);
		sss.add(lblOrderListDeviceHardver);

		JLabel lblDeviceCliening = new JLabel("takarítás:");
		lblDeviceCliening.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceCliening.setForeground(new Color(153, 0, 0));
		lblDeviceCliening.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceCliening.setBounds(10, 885, 247, 35);
		sss.add(lblDeviceCliening);

		lblOrderListDeviceCliening = new JLabel("-");
		lblOrderListDeviceCliening.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceCliening.setForeground(Color.WHITE);
		lblOrderListDeviceCliening.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceCliening.setBounds(267, 885, 918, 35);
		sss.add(lblOrderListDeviceCliening);

		JLabel lblDevicePassword = new JLabel("jelszó:");
		lblDevicePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDevicePassword.setForeground(new Color(153, 0, 0));
		lblDevicePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDevicePassword.setBounds(10, 931, 247, 35);
		sss.add(lblDevicePassword);

		lblOrderListDevicePassword = new JLabel("-");
		lblOrderListDevicePassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDevicePassword.setForeground(Color.WHITE);
		lblOrderListDevicePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDevicePassword.setBounds(267, 931, 918, 35);
		sss.add(lblOrderListDevicePassword);

		JLabel lblDeviceAccessories = new JLabel("tartozékok:");
		lblDeviceAccessories.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceAccessories.setForeground(new Color(153, 0, 0));
		lblDeviceAccessories.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceAccessories.setBounds(10, 977, 247, 35);
		sss.add(lblDeviceAccessories);

		lblOrderListDeviceAccessories = new JLabel("-");
		lblOrderListDeviceAccessories.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceAccessories.setForeground(Color.WHITE);
		lblOrderListDeviceAccessories.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceAccessories.setBounds(267, 977, 918, 35);
		sss.add(lblOrderListDeviceAccessories);

		JLabel lblDeviceInjury = new JLabel("sérülés:");
		lblDeviceInjury.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceInjury.setForeground(new Color(153, 0, 0));
		lblDeviceInjury.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceInjury.setBounds(10, 1023, 247, 35);
		sss.add(lblDeviceInjury);

		lblOrderListDeviceInjury = new JLabel("-");
		lblOrderListDeviceInjury.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceInjury.setForeground(Color.WHITE);
		lblOrderListDeviceInjury.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceInjury.setBounds(267, 1023, 918, 35);
		sss.add(lblOrderListDeviceInjury);

		JLabel lblDeviceFault = new JLabel("hiba leírás:");
		lblDeviceFault.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceFault.setForeground(new Color(153, 0, 0));
		lblDeviceFault.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceFault.setBounds(10, 1069, 247, 35);
		sss.add(lblDeviceFault);

		lblOrderListDeviceFault = new JLabel("-");
		lblOrderListDeviceFault.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceFault.setForeground(Color.WHITE);
		lblOrderListDeviceFault.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceFault.setBounds(267, 1069, 918, 35);
		sss.add(lblOrderListDeviceFault);

		JLabel lblDeviceError = new JLabel("valós leírás:");
		lblDeviceError.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeviceError.setForeground(new Color(153, 0, 0));
		lblDeviceError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeviceError.setBounds(10, 1115, 247, 35);
		sss.add(lblDeviceError);

		lblOrderListDeviceError = new JLabel("-");
		lblOrderListDeviceError.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderListDeviceError.setForeground(Color.WHITE);
		lblOrderListDeviceError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderListDeviceError.setBounds(267, 1115, 918, 35);
		sss.add(lblOrderListDeviceError);
	}
}
