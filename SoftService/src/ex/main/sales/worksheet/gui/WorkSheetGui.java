package ex.main.sales.worksheet.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ex.main.sales.device.DeviceJDBCSetDAO;

public class WorkSheetGui extends DeviceJDBCSetDAO {
	protected JButton btnBack;
	public WorkSheetGui() {
		setActivity();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544483758378225794L;

	private void setActivity() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 59, 1219, 545);
		pnl.add(tabbedPane); 
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/function/22x22/table.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("", new ImageIcon(WorkSheetGui.class.getResource("/icon/general/22/partners.png")), panel_2, null);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/arrow_left_green.png")));
		btnBack.setBounds(10, 11, 60, 37);
		pnl.add(btnBack);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(WorkSheetGui.class.getResource("/icon/function/24x24/printer.png")));
		button.setBounds(80, 11, 60, 37);
		pnl.add(button);
		
	}
}
