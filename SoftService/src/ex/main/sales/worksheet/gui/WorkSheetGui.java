package ex.main.sales.worksheet.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ex.main.sales.client.gui.ClientGui;
import ex.main.sales.device.DeviceJDBCSetDAO;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;

public class WorkSheetGui extends DeviceJDBCSetDAO {
	protected JButton btnBack, btnWorkPrint, btnWorkSearch;
	protected JPanel pnlOrderList, panel_1;
	protected JTabbedPane tbdPanel;
	protected JComboBox<?> cmbWorkSearch;

	public WorkSheetGui() {
		setActivity();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544483758378225794L;
	private JTextField txtWorkSearch;

	private void setActivity() {
		tbdPanel = new JTabbedPane(JTabbedPane.TOP);
		tbdPanel.setBounds(10, 59, 1219, 545);
		pnl.add(tbdPanel);

		panel_1 = new JPanel();
		tbdPanel.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/function/22x22/table.png")), panel_1,
				null);
		panel_1.setLayout(null);

		pnlOrderList = new JPanel();
		tbdPanel.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/general/22/partners.png")),
				pnlOrderList, null);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/arrow_left_green.png")));
		btnBack.setBounds(10, 11, 60, 37);
		pnl.add(btnBack);

		btnWorkPrint = new JButton("");
		btnWorkPrint.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/printer.png")));
		btnWorkPrint.setBounds(80, 11, 60, 37);
		pnl.add(btnWorkPrint);

		btnWorkSearch = new JButton("");
		btnWorkSearch.setBounds(1169, 11, 60, 37);
		pnl.add(btnWorkSearch);
		btnWorkSearch.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/search.png")));

		String boxDeviceSoftwer[] = { "Név", "Azonosító" };
		cmbWorkSearch = new JComboBox<Object>(boxDeviceSoftwer);
		cmbWorkSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbWorkSearch.setBounds(1024, 11, 135, 37);
		pnl.add(cmbWorkSearch);

		txtWorkSearch = new JTextField();
		txtWorkSearch.setBounds(836, 11, 178, 37);
		pnl.add(txtWorkSearch);
		txtWorkSearch.setColumns(10);

	}
}
