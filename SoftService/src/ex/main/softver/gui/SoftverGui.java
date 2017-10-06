package ex.main.softver.gui;

import ex.main.deviceimage.DeviceImageJDBCSetDAO;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class SoftverGui extends DeviceImageJDBCSetDAO {
	protected JTextField txtSoftverID;
	protected JComboBox cmbSoftverName;
	protected JPanel pnlSoftverSetting;
	protected JButton btnSoftverDelete;
	protected JButton btnSoftverEdit;
	protected JButton btnSoftverNewSoftver;
	protected JTextField txtSoftverSearch;
	protected JButton btnSoftverSearch;
	protected JButton btnSoftverNull;
	protected JScrollPane scrSoftver;
	protected JTable tblSoftver;
	protected JScrollPane scrSoftverComment;
	protected JTextArea txtAreaSoftverComment;

	public SoftverGui() {

		setSoftverComponent();
	}

	private void setSoftverComponent() {
		jplSoftver.setLayout(null);

		String softverName[] = { "Win Pro 7 32Bit Hungarian", "Win Pro 7 64Bit Hungarian", "Win 8.1 32Bit Hungarian",
				"Win 8.1 64Bit Hungarian", "Win 10 32Bit Hungarian", "Win 10 64Bit Hungarian",
				"Office 2017 32Bit Hungarian", "Office 2017 64Bit Hungarian", "Office 2016 32Bit Hungarian",
				"Office 2016 64Bit Hungarian", "Egyéb" };
		cmbSoftverName = new JComboBox(softverName);
		cmbSoftverName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbSoftverName.setBounds(116, 103, 294, 35);
		cmbSoftverName.setSelectedItem(null);
		pnlSoftver.add(cmbSoftverName);

		txtSoftverID = new JTextField();
		txtSoftverID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoftverID.setEnabled(false);
		txtSoftverID.setColumns(10);
		txtSoftverID.setBackground(new Color(245, 255, 250));
		txtSoftverID.setBounds(315, 11, 95, 35);
		pnlSoftver.add(txtSoftverID);

		JLabel lblSoftverComment = new JLabel("megjegyzés: ");
		lblSoftverComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoftverComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoftverComment.setBounds(10, 149, 102, 35);
		pnlSoftver.add(lblSoftverComment);

		JLabel lblSoftver = new JLabel("softver:");
		lblSoftver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoftver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoftver.setBounds(4, 103, 102, 35);
		pnlSoftver.add(lblSoftver);

		scrSoftverComment = new JScrollPane();
		scrSoftverComment.setBounds(116, 149, 294, 63);
		pnlSoftver.add(scrSoftverComment);

		txtAreaSoftverComment = new JTextArea();
		txtAreaSoftverComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaSoftverComment.setBackground(new Color(245, 255, 250));
		scrSoftverComment.setViewportView(txtAreaSoftverComment);

		pnlSoftverSetting = new JPanel();
		pnlSoftverSetting.setLayout(null);
		pnlSoftverSetting.setBounds(10, 11, 815, 63);
		jplSoftver.add(pnlSoftverSetting);

		btnSoftverDelete = new JButton("törlés");
		btnSoftverDelete.setBounds(565, 12, 109, 37);
		pnlSoftverSetting.add(btnSoftverDelete);

		btnSoftverEdit = new JButton("szerkesztés");
		btnSoftverEdit.setBounds(446, 12, 109, 37);
		pnlSoftverSetting.add(btnSoftverEdit);

		btnSoftverNewSoftver = new JButton("új eszköz");
		btnSoftverNewSoftver.setBounds(327, 11, 109, 37);
		pnlSoftverSetting.add(btnSoftverNewSoftver);

		txtSoftverSearch = new JTextField();
		txtSoftverSearch.setColumns(10);
		txtSoftverSearch.setBackground(new Color(127, 255, 212));
		txtSoftverSearch.setBounds(10, 13, 185, 35);
		pnlSoftverSetting.add(txtSoftverSearch);

		btnSoftverSearch = new JButton("keresés");
		btnSoftverSearch.setBounds(208, 12, 109, 37);
		pnlSoftverSetting.add(btnSoftverSearch);

		btnSoftverNull = new JButton("null");
		btnSoftverNull.setBounds(684, 12, 109, 37);
		pnlSoftverSetting.add(btnSoftverNull);

		scrSoftver = new JScrollPane();
		scrSoftver.setBounds(10, 85, 618, 493);
		jplSoftver.add(scrSoftver);

		tblSoftver = new JTable();
		scrSoftver.setViewportView(tblSoftver);
	}
}
