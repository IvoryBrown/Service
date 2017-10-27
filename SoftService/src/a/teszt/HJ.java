package a.teszt;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HJ {
	public HJ() {
		setComponent();
	}

	void setComponent() {
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(900, 700);
		jFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 845, 600);
		jFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 422, 600);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Írisz Holding Kft.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel.setBounds(0, 11, 421, 11);
		panel_1.add(lblNewLabel);

		JLabel lblSzkhelylevcmSzeged = new JLabel("Székhely: 1044, Budapest Óradna utca 5.");
		lblSzkhelylevcmSzeged.setHorizontalAlignment(SwingConstants.CENTER);
		lblSzkhelylevcmSzeged.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSzkhelylevcmSzeged.setBounds(0, 29, 421, 11);
		panel_1.add(lblSzkhelylevcmSzeged);

		JLabel lblAdszm = new JLabel("Adószám: 24313698-2- 41 Bankszámlaszám: 10402805-50526766- 87491031");
		lblAdszm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdszm.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAdszm.setBounds(0, 74, 421, 11);
		panel_1.add(lblAdszm);

		JLabel lbltvteliElismervny = new JLabel("ÁTVÉTELI ELISMERVÉNY");
		lbltvteliElismervny.setHorizontalAlignment(SwingConstants.CENTER);
		lbltvteliElismervny.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltvteliElismervny.setBounds(0, 93, 421, 16);
		panel_1.add(lbltvteliElismervny);

		JLabel label = new JLabel("");
		label.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Megrendel\u0151 Adatai", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label.setBounds(10, 112, 402, 77);
		panel_1.add(label);

		JLabel lblMegrendelNeve = new JLabel("Megrendelő neve: ");
		lblMegrendelNeve.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMegrendelNeve.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMegrendelNeve.setBounds(21, 125, 97, 11);
		panel_1.add(lblMegrendelNeve);

		JLabel lblCme = new JLabel("Címe: ");
		lblCme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCme.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCme.setBounds(21, 140, 97, 11);
		panel_1.add(lblCme);

		JLabel lblTelefonszm = new JLabel("Telefonszám: ");
		lblTelefonszm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonszm.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTelefonszm.setBounds(21, 155, 97, 11);
		panel_1.add(lblTelefonszm);

		JLabel lblAzonost = new JLabel("Azonosító: ");
		lblAzonost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAzonost.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAzonost.setBounds(21, 170, 97, 11);
		panel_1.add(lblAzonost);

		JLabel lblWorkPrintClientName = new JLabel("");
		lblWorkPrintClientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientName.setBounds(123, 125, 280, 11);
		panel_1.add(lblWorkPrintClientName);

		JLabel lblWorkPrintClientHomeAndress = new JLabel("");
		lblWorkPrintClientHomeAndress.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientHomeAndress.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientHomeAndress.setBounds(123, 140, 280, 11);
		panel_1.add(lblWorkPrintClientHomeAndress);

		JLabel lblWorkPrintClientMobil = new JLabel("");
		lblWorkPrintClientMobil.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientMobil.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientMobil.setBounds(123, 155, 280, 11);
		panel_1.add(lblWorkPrintClientMobil);

		JLabel lblWorkPrintClientIdentification = new JLabel("");
		lblWorkPrintClientIdentification.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientIdentification.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientIdentification.setBounds(123, 170, 280, 11);
		panel_1.add(lblWorkPrintClientIdentification);

		JLabel label_4 = new JLabel("");
		label_4.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Munkalap Adatai", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_4.setBounds(10, 197, 402, 270);
		panel_1.add(label_4);

		JLabel lblMegnevezs = new JLabel("Megnevezés: ");
		lblMegnevezs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMegnevezs.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMegnevezs.setBounds(21, 209, 97, 11);
		panel_1.add(lblMegnevezs);

		JLabel lblWorkPrintDeviceName = new JLabel("");
		lblWorkPrintDeviceName.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceName.setBounds(123, 209, 280, 11);
		panel_1.add(lblWorkPrintDeviceName);
		
		JLabel lblSorozatszm = new JLabel("Sorozatszám: ");
		lblSorozatszm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSorozatszm.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSorozatszm.setBounds(21, 224, 97, 11);
		panel_1.add(lblSorozatszm);
		
		JLabel lblVsrlsDtuma = new JLabel("Vásárlás dátuma: ");
		lblVsrlsDtuma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVsrlsDtuma.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblVsrlsDtuma.setBounds(21, 239, 97, 11);
		panel_1.add(lblVsrlsDtuma);
		
		JLabel lblFelvtelDtuma = new JLabel("Felvétel dátuma: ");
		lblFelvtelDtuma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFelvtelDtuma.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblFelvtelDtuma.setBounds(21, 254, 97, 11);
		panel_1.add(lblFelvtelDtuma);
		
		JLabel lblVllalsiHatrid = new JLabel("Vállalási határidő: ");
		lblVllalsiHatrid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVllalsiHatrid.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblVllalsiHatrid.setBounds(21, 269, 97, 11);
		panel_1.add(lblVllalsiHatrid);
		
		JLabel lblTartozkok = new JLabel("Tartozékok: ");
		lblTartozkok.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTartozkok.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTartozkok.setBounds(21, 284, 97, 11);
		panel_1.add(lblTartozkok);
		
		JLabel lblJelsz = new JLabel("Jelszó: ");
		lblJelsz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJelsz.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblJelsz.setBounds(21, 299, 97, 11);
		panel_1.add(lblJelsz);
		
		JLabel lblSrls = new JLabel("Sérülés: ");
		lblSrls.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSrls.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSrls.setBounds(21, 314, 97, 11);
		panel_1.add(lblSrls);
		
		JLabel lblLers = new JLabel("Leírás: ");
		lblLers.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLers.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblLers.setBounds(21, 347, 97, 11);
		panel_1.add(lblLers);
		
		JLabel lblFelvette = new JLabel("Ügyintéző: ");
		lblFelvette.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFelvette.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblFelvette.setBounds(21, 448, 97, 11);
		panel_1.add(lblFelvette);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(10, 478, 402, 31);
		panel_1.add(label_6);
		label_6.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblriszHoldingKft = new JLabel("Írisz Holding Kft.");
		lblriszHoldingKft.setHorizontalAlignment(SwingConstants.CENTER);
		lblriszHoldingKft.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblriszHoldingKft.setBounds(10, 510, 200, 11);
		panel_1.add(lblriszHoldingKft);
		
		JLabel lblgyflAlrs = new JLabel("Ügyfél aláírás");
		lblgyflAlrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblgyflAlrs.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblgyflAlrs.setBounds(212, 510, 200, 11);
		panel_1.add(lblgyflAlrs);
		
		JLabel lblEztAzElismervnyt = new JLabel("Ezt az elismervényt kérjük őrizze meg,");
		lblEztAzElismervnyt.setHorizontalAlignment(SwingConstants.CENTER);
		lblEztAzElismervnyt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEztAzElismervnyt.setBounds(0, 532, 421, 11);
		panel_1.add(lblEztAzElismervnyt);
		
		JLabel lblCsakEnnekEllenben = new JLabel("csak ennek ellenében áll módunkban a javított készüléket kiadni!");
		lblCsakEnnekEllenben.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsakEnnekEllenben.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCsakEnnekEllenben.setBounds(0, 547, 421, 11);
		panel_1.add(lblCsakEnnekEllenben);
		
		JLabel lblAMerevlemezenLv = new JLabel("A merevlemezen lévő adatok tartalmáért, adatvesztésekért az Ügyfél vállalja a felelősséget!");
		lblAMerevlemezenLv.setHorizontalAlignment(SwingConstants.CENTER);
		lblAMerevlemezenLv.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAMerevlemezenLv.setBounds(0, 562, 421, 11);
		panel_1.add(lblAMerevlemezenLv);
		
		JLabel lblKrjkMindigKsztsen = new JLabel("Kérjük mindig készítsen biztonsági másolatot adatairól.");
		lblKrjkMindigKsztsen.setHorizontalAlignment(SwingConstants.CENTER);
		lblKrjkMindigKsztsen.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblKrjkMindigKsztsen.setBounds(0, 577, 421, 11);
		panel_1.add(lblKrjkMindigKsztsen);
		
		JLabel lblWorkPrintDeviceSerial = new JLabel("");
		lblWorkPrintDeviceSerial.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceSerial.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceSerial.setBounds(123, 224, 280, 11);
		panel_1.add(lblWorkPrintDeviceSerial);
		
		JLabel lblWorkPrintDeviceBuys = new JLabel("");
		lblWorkPrintDeviceBuys.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceBuys.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceBuys.setBounds(123, 239, 280, 11);
		panel_1.add(lblWorkPrintDeviceBuys);
		
		JLabel lblWorkPrintDeviceAddDate = new JLabel("");
		lblWorkPrintDeviceAddDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceAddDate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceAddDate.setBounds(123, 254, 280, 11);
		panel_1.add(lblWorkPrintDeviceAddDate);
		
		JLabel lblWorkPrintEndDate = new JLabel("");
		lblWorkPrintEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintEndDate.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintEndDate.setBounds(123, 269, 280, 11);
		panel_1.add(lblWorkPrintEndDate);
		
		JLabel lblWorkPrintDeviceAccessory = new JLabel("");
		lblWorkPrintDeviceAccessory.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceAccessory.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceAccessory.setBounds(123, 284, 280, 11);
		panel_1.add(lblWorkPrintDeviceAccessory);
		
		JLabel lblWorkPrintDevicePassword = new JLabel("");
		lblWorkPrintDevicePassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDevicePassword.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDevicePassword.setBounds(123, 299, 280, 11);
		panel_1.add(lblWorkPrintDevicePassword);
		
		JLabel lblWorkPrintDeviceInjury = new JLabel("");
		lblWorkPrintDeviceInjury.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceInjury.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceInjury.setBounds(123, 314, 280, 22);
		panel_1.add(lblWorkPrintDeviceInjury);
		
		JLabel lblWorkPrintDeviceFault = new JLabel("");
		lblWorkPrintDeviceFault.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceFault.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceFault.setBounds(123, 347, 280, 77);
		panel_1.add(lblWorkPrintDeviceFault);
		
		JLabel lblWorkPrintSalesName = new JLabel("");
		lblWorkPrintSalesName.setBackground(Color.WHITE);
		lblWorkPrintSalesName.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintSalesName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintSalesName.setBounds(123, 448, 280, 11);
		panel_1.add(lblWorkPrintSalesName);
		
		JLabel lblTelephelySzeged = new JLabel("Telephely: 6722, Szeged Tisza L. krt. 47");
		lblTelephelySzeged.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephelySzeged.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTelephelySzeged.setBounds(0, 44, 421, 11);
		panel_1.add(lblTelephelySzeged);
		
		JLabel lblEmail = new JLabel("E-mail: uzletszeged@iriszholding.hu, Tel: 62/541-651");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEmail.setBounds(0, 59, 421, 11);
		panel_1.add(lblEmail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(423, 0, 422, 600);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Írisz Holding Kft.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_1.setBounds(0, 11, 421, 11);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Székhely: 1044, Budapest Óradna utca 5.");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(0, 29, 421, 11);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Adószám: 24313698-2- 41 Bankszámlaszám: 10402805-50526766- 87491031");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_3.setBounds(0, 74, 421, 11);
		panel_2.add(label_3);
		
		JLabel label_5 = new JLabel("ÁTVÉTELI ELISMERVÉNY");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(0, 93, 421, 16);
		panel_2.add(label_5);
		
		JLabel label_7 = new JLabel("");
		label_7.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Megrendel\u0151 Adatai", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_7.setBounds(10, 112, 402, 77);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Megrendelő neve: ");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_8.setBounds(21, 125, 97, 11);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Címe: ");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_9.setBounds(21, 140, 97, 11);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Telefonszám: ");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_10.setBounds(21, 155, 97, 11);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Azonosító: ");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_11.setBounds(21, 170, 97, 11);
		panel_2.add(label_11);
		
		JLabel lblWorkPrintClientName0 = new JLabel("");
		lblWorkPrintClientName0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientName0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientName0.setBounds(123, 125, 280, 11);
		panel_2.add(lblWorkPrintClientName0);
		
		JLabel lblWorkPrintClientHomeAndress0 = new JLabel("");
		lblWorkPrintClientHomeAndress0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientHomeAndress0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientHomeAndress0.setBounds(123, 140, 280, 11);
		panel_2.add(lblWorkPrintClientHomeAndress0);
		
		JLabel lblWorkPrintClientMobil0 = new JLabel("");
		lblWorkPrintClientMobil0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientMobil0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientMobil0.setBounds(123, 155, 280, 11);
		panel_2.add(lblWorkPrintClientMobil0);
		
		JLabel lblWorkPrintClientIdentification0 = new JLabel("");
		lblWorkPrintClientIdentification0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintClientIdentification0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintClientIdentification0.setBounds(123, 170, 280, 11);
		panel_2.add(lblWorkPrintClientIdentification0);
		
		JLabel label_16 = new JLabel("");
		label_16.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Munkalap Adatai", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_16.setBounds(10, 197, 402, 270);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Megnevezés: ");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_17.setBounds(21, 209, 97, 11);
		panel_2.add(label_17);
		
		JLabel lblWorkPrintDeviceName0 = new JLabel("");
		lblWorkPrintDeviceName0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceName0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceName0.setBounds(123, 209, 280, 11);
		panel_2.add(lblWorkPrintDeviceName0);
		
		JLabel label_19 = new JLabel("Sorozatszám: ");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_19.setBounds(21, 224, 97, 11);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("Vásárlás dátuma: ");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_20.setBounds(21, 239, 97, 11);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("Felvétel dátuma: ");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_21.setBounds(21, 254, 97, 11);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("Vállalási határidő: ");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_22.setBounds(21, 269, 97, 11);
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("Tartozékok: ");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_23.setBounds(21, 284, 97, 11);
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("Jelszó: ");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_24.setBounds(21, 299, 97, 11);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel("Sérülés: ");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_25.setBounds(21, 314, 97, 11);
		panel_2.add(label_25);
		
		JLabel label_26 = new JLabel("Leírás: ");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_26.setBounds(21, 347, 97, 11);
		panel_2.add(label_26);
		
		JLabel label_27 = new JLabel("Ügyintéző: ");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_27.setBounds(21, 448, 97, 11);
		panel_2.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_28.setBounds(10, 478, 402, 31);
		panel_2.add(label_28);
		
		JLabel label_29 = new JLabel("Írisz Holding Kft.");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_29.setBounds(10, 510, 200, 11);
		panel_2.add(label_29);
		
		JLabel label_30 = new JLabel("Ügyfél aláírás");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 9));
		label_30.setBounds(212, 510, 200, 11);
		panel_2.add(label_30);
		
		JLabel label_31 = new JLabel("Ezt az elismervényt kérjük őrizze meg,");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_31.setBounds(0, 532, 421, 11);
		panel_2.add(label_31);
		
		JLabel label_32 = new JLabel("csak ennek ellenében áll módunkban a javított készüléket kiadni!");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_32.setBounds(0, 547, 421, 11);
		panel_2.add(label_32);
		
		JLabel label_33 = new JLabel("A merevlemezen lévő adatok tartalmáért, adatvesztésekért az Ügyfél vállalja a felelősséget!");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_33.setBounds(0, 562, 421, 11);
		panel_2.add(label_33);
		
		JLabel label_34 = new JLabel("Kérjük mindig készítsen biztonsági másolatot adatairól.");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_34.setBounds(0, 577, 421, 11);
		panel_2.add(label_34);
		
		JLabel lblWorkPrintDeviceSerial0 = new JLabel("");
		lblWorkPrintDeviceSerial0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceSerial0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceSerial0.setBounds(123, 224, 280, 11);
		panel_2.add(lblWorkPrintDeviceSerial0);
		
		JLabel lblWorkPrintDeviceBuys0 = new JLabel("");
		lblWorkPrintDeviceBuys0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceBuys0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceBuys0.setBounds(123, 239, 280, 11);
		panel_2.add(lblWorkPrintDeviceBuys0);
		
		JLabel lblWorkPrintDeviceAddDate0 = new JLabel("");
		lblWorkPrintDeviceAddDate0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceAddDate0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceAddDate0.setBounds(123, 254, 280, 11);
		panel_2.add(lblWorkPrintDeviceAddDate0);
		
		JLabel lblWorkPrintEndDate0 = new JLabel("");
		lblWorkPrintEndDate0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintEndDate0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintEndDate0.setBounds(123, 269, 280, 11);
		panel_2.add(lblWorkPrintEndDate0);
		
		JLabel lblWorkPrintDeviceAccessory0 = new JLabel("");
		lblWorkPrintDeviceAccessory0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceAccessory0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceAccessory0.setBounds(123, 284, 280, 11);
		panel_2.add(lblWorkPrintDeviceAccessory0);
		
		JLabel lblWorkPrintDevicePassword0 = new JLabel("");
		lblWorkPrintDevicePassword0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDevicePassword0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDevicePassword0.setBounds(123, 299, 280, 11);
		panel_2.add(lblWorkPrintDevicePassword0);
		
		JLabel lblWorkPrintDeviceInjury0 = new JLabel("");
		lblWorkPrintDeviceInjury0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceInjury0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceInjury0.setBounds(123, 314, 280, 22);
		panel_2.add(lblWorkPrintDeviceInjury0);
		
		JLabel lblWorkPrintDeviceFault0 = new JLabel("");
		lblWorkPrintDeviceFault0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintDeviceFault0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintDeviceFault0.setBounds(123, 347, 280, 77);
		panel_2.add(lblWorkPrintDeviceFault0);
		
		JLabel lblWorkPrintSalesName0 = new JLabel("");
		lblWorkPrintSalesName0.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkPrintSalesName0.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWorkPrintSalesName0.setBackground(Color.WHITE);
		lblWorkPrintSalesName0.setBounds(123, 448, 280, 11);
		panel_2.add(lblWorkPrintSalesName0);
		
		JLabel label_44 = new JLabel("Telephely: 6722, Szeged Tisza L. krt. 47");
		label_44.setHorizontalAlignment(SwingConstants.CENTER);
		label_44.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_44.setBounds(0, 44, 421, 11);
		panel_2.add(label_44);
		
		JLabel label_45 = new JLabel("E-mail: uzletszeged@iriszholding.hu, Tel: 62/541-651");
		label_45.setHorizontalAlignment(SwingConstants.CENTER);
		label_45.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_45.setBounds(0, 59, 421, 11);
		panel_2.add(label_45);
	}
}
