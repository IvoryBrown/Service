package ex.main.sales.workprint.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ex.main.sales.worktablet.WorkTableJDBCSetDAO;

public class WorkPrintGui extends WorkTableJDBCSetDAO{
	protected JPanel panel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2472629924570153454L;
	public WorkPrintGui() {
		pnlWorkPrint.setLayout(null);
		
		
		
		 panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		panel.setPreferredSize(new Dimension(845, 600));
		
		
		
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

		JLabel lblSzkhelylevcmSzeged = new JLabel("Székhely/lev.cím: 6722, Szeged Tisza L. krt. 47");
		lblSzkhelylevcmSzeged.setHorizontalAlignment(SwingConstants.CENTER);
		lblSzkhelylevcmSzeged.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSzkhelylevcmSzeged.setBounds(0, 26, 421, 11);
		panel_1.add(lblSzkhelylevcmSzeged);

		JLabel lblAdszm = new JLabel("Adószám: 24313698-2- 41 Bankszámlaszám: 10402805-50526766- 87491031");
		lblAdszm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdszm.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAdszm.setBounds(0, 41, 421, 11);
		panel_1.add(lblAdszm);

		JLabel lbltvteliElismervny = new JLabel("ÁTVÉTELI ELISMERVÉNY");
		lbltvteliElismervny.setHorizontalAlignment(SwingConstants.CENTER);
		lbltvteliElismervny.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltvteliElismervny.setBounds(0, 59, 421, 16);
		panel_1.add(lbltvteliElismervny);

		JLabel label = new JLabel("");
		label.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Megrendel\u0151 Adatai",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label.setBounds(10, 77, 402, 80);
		panel_1.add(label);

		JLabel lblMegrendelNeve = new JLabel("Megrendelő neve: ");
		lblMegrendelNeve.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMegrendelNeve.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMegrendelNeve.setBounds(21, 92, 97, 11);
		panel_1.add(lblMegrendelNeve);

		JLabel lblCme = new JLabel("Címe: ");
		lblCme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCme.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCme.setBounds(21, 107, 97, 11);
		panel_1.add(lblCme);

		JLabel lblTelefonszm = new JLabel("Telefonszám: ");
		lblTelefonszm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonszm.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTelefonszm.setBounds(21, 122, 97, 11);
		panel_1.add(lblTelefonszm);

		JLabel lblAzonost = new JLabel("Azonosító: ");
		lblAzonost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAzonost.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAzonost.setBounds(21, 137, 97, 11);
		panel_1.add(lblAzonost);

		JLabel label1 = new JLabel("Megrendelő neve: ");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label1.setBounds(123, 92, 280, 11);
		panel_1.add(label1);

		JLabel label_1 = new JLabel("Megrendelő neve: ");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(123, 107, 280, 11);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Megrendelő neve: ");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(123, 122, 280, 11);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Megrendelő neve: ");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_3.setBounds(123, 137, 280, 11);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "Munkalap Adatai",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		label_4.setBounds(10, 168, 402, 220);
		panel_1.add(label_4);

		JLabel lblMegnevezs = new JLabel("Megnevezés: ");
		lblMegnevezs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMegnevezs.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMegnevezs.setBounds(21, 182, 97, 11);
		panel_1.add(lblMegnevezs);

		JLabel label_5 = new JLabel("Megrendelő neve: ");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_5.setBounds(123, 182, 280, 11);
		panel_1.add(label_5);
		
		JLabel lblSorozatszm = new JLabel("Sorozatszám: ");
		lblSorozatszm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSorozatszm.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSorozatszm.setBounds(21, 197, 97, 11);
		panel_1.add(lblSorozatszm);
		
		JLabel lblVsrlsDtuma = new JLabel("Vásárlás dátuma: ");
		lblVsrlsDtuma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVsrlsDtuma.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblVsrlsDtuma.setBounds(21, 212, 97, 11);
		panel_1.add(lblVsrlsDtuma);
		
		JLabel lblFelvtelDtuma = new JLabel("Felvétel dátuma: ");
		lblFelvtelDtuma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFelvtelDtuma.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblFelvtelDtuma.setBounds(21, 227, 97, 11);
		panel_1.add(lblFelvtelDtuma);
		
		JLabel lblVllalsiHatrid = new JLabel("Vállalási határidő: ");
		lblVllalsiHatrid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVllalsiHatrid.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblVllalsiHatrid.setBounds(21, 242, 97, 11);
		panel_1.add(lblVllalsiHatrid);
		
		JLabel lblTartozkok = new JLabel("Tartozékok: ");
		lblTartozkok.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTartozkok.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTartozkok.setBounds(21, 257, 97, 11);
		panel_1.add(lblTartozkok);
		
		JLabel lblJelsz = new JLabel("Jelszó: ");
		lblJelsz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJelsz.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblJelsz.setBounds(21, 272, 97, 11);
		panel_1.add(lblJelsz);
		
		JLabel lblSrls = new JLabel("Sérülés: ");
		lblSrls.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSrls.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSrls.setBounds(21, 287, 97, 11);
		panel_1.add(lblSrls);
		
		JLabel lblLers = new JLabel("Leírás: ");
		lblLers.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLers.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblLers.setBounds(21, 317, 97, 11);
		panel_1.add(lblLers);
		
		JLabel lblFelvette = new JLabel("Felvette: ");
		lblFelvette.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFelvette.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblFelvette.setBounds(21, 362, 97, 11);
		panel_1.add(lblFelvette);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(10, 399, 402, 31);
		panel_1.add(label_6);
		label_6.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 2), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblriszHoldingKft = new JLabel("Írisz Holding Kft.");
		lblriszHoldingKft.setHorizontalAlignment(SwingConstants.CENTER);
		lblriszHoldingKft.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblriszHoldingKft.setBounds(10, 435, 200, 11);
		panel_1.add(lblriszHoldingKft);
		
		JLabel lblgyflAlrs = new JLabel("Ügyfél Aláírás");
		lblgyflAlrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblgyflAlrs.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblgyflAlrs.setBounds(212, 435, 200, 11);
		panel_1.add(lblgyflAlrs);
		
		JLabel lblEztAzElismervnyt = new JLabel("Ezt az elismervényt kérjük őrizze meg!");
		lblEztAzElismervnyt.setHorizontalAlignment(SwingConstants.CENTER);
		lblEztAzElismervnyt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEztAzElismervnyt.setBounds(0, 472, 421, 11);
		panel_1.add(lblEztAzElismervnyt);
		
		JLabel lblCsakEnnekEllenben = new JLabel("Csak ennek ellenében áll módunkban a javított készüléket kiadni.");
		lblCsakEnnekEllenben.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsakEnnekEllenben.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCsakEnnekEllenben.setBounds(0, 494, 421, 11);
		panel_1.add(lblCsakEnnekEllenben);
		
		JLabel lblAMerevlemezenLv = new JLabel("A merevlemezen lévő adatok tartalmáért, adatvesztésekért az Ügyfél vállalja a felelősséget!");
		lblAMerevlemezenLv.setHorizontalAlignment(SwingConstants.CENTER);
		lblAMerevlemezenLv.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAMerevlemezenLv.setBounds(0, 516, 421, 11);
		panel_1.add(lblAMerevlemezenLv);
		
		JLabel lblKrjkMindigKsztsen = new JLabel("Kérjük mindig készítsen biztonsági másolatot adatairól.");
		lblKrjkMindigKsztsen.setHorizontalAlignment(SwingConstants.CENTER);
		lblKrjkMindigKsztsen.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblKrjkMindigKsztsen.setBounds(0, 538, 421, 11);
		panel_1.add(lblKrjkMindigKsztsen);
		
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(48, 29, 957, 469);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlWorkPrint.add(scrollPane);
		
		
	}
}
