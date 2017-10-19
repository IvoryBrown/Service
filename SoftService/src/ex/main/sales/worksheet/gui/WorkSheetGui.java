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
import java.awt.Color;

public class WorkSheetGui extends DeviceJDBCSetDAO {
	protected JButton btnBack, btnWorkPrint, btnWorkSearch, btnWorkUpdate;
	protected JPanel pnlOrderList, pnlWorkTable,pnlWorkPrint;
	protected JTabbedPane tbdPanel;
	protected JComboBox<?> cmbWorkSearch;
	protected JTextField txtWorkSearch;

	public WorkSheetGui() {
		setActivity();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544483758378225794L;
	

	private void setActivity() {
		tbdPanel = new JTabbedPane(JTabbedPane.TOP);
		tbdPanel.setBounds(10, 59, 1219, 545);
		pnl.add(tbdPanel);

		pnlWorkTable = new JPanel();
		tbdPanel.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/function/22x22/table.png")), pnlWorkTable,
				null);
		pnlWorkTable.setLayout(null);

		pnlOrderList = new JPanel();
		tbdPanel.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/general/22/partners.png")),
				pnlOrderList, null);
		
		pnlWorkPrint = new JPanel();
		tbdPanel.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/tango/22x22/actions/document-print.png")), pnlWorkPrint, null);

		btnBack = new JButton("");
		btnBack.setBackground(new Color(51, 0, 0));
		btnBack.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/arrow_left_green.png")));
		btnBack.setBounds(10, 11, 60, 37);
		pnl.add(btnBack);

		btnWorkPrint = new JButton("");
		btnWorkPrint.setBackground(new Color(51, 0, 0));
		btnWorkPrint.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/printer.png")));
		btnWorkPrint.setBounds(80, 11, 60, 37);
		pnl.add(btnWorkPrint);

		btnWorkSearch = new JButton("");
		btnWorkSearch.setBackground(new Color(51, 0, 0));
		btnWorkSearch.setBounds(1169, 11, 60, 37);
		pnl.add(btnWorkSearch);
		btnWorkSearch.setIcon(new ImageIcon(ClientGui.class.getResource("/icon/function/24x24/search.png")));

		String boxDeviceSoftwer[] = { "nev", "azonosito_m" };
		cmbWorkSearch = new JComboBox<Object>(boxDeviceSoftwer);
		cmbWorkSearch.setBackground(Color.BLACK);
		cmbWorkSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbWorkSearch.setBounds(1024, 11, 135, 37);
		pnl.add(cmbWorkSearch);

		txtWorkSearch = new JTextField();
		txtWorkSearch.setBackground(new Color(153, 0, 0));
		txtWorkSearch.setBounds(836, 11, 178, 37);
		pnl.add(txtWorkSearch);
		txtWorkSearch.setColumns(10);

		btnWorkUpdate = new JButton("");
		btnWorkUpdate.setBackground(new Color(51, 0, 0));
		btnWorkUpdate
				.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/tango/22x22/actions/view-refresh.png")));
		btnWorkUpdate.setBounds(766, 11, 60, 37);
		pnl.add(btnWorkUpdate);

	}
}
