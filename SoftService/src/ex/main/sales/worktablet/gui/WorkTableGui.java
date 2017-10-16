package ex.main.sales.worktablet.gui;

import ex.main.sales.orderlist.OrderListJDBCSetDAO;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WorkTableGui extends OrderListJDBCSetDAO {
	protected JTable jtblSalesWorkTable;
	protected JScrollPane scrSalesWorkTable;

	public WorkTableGui() {
		setComponet();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2361487273596837856L;

	private void setComponet() {
		jtblSalesWorkTable = new JTable();
		
		scrSalesWorkTable = new JScrollPane(jtblSalesWorkTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrSalesWorkTable.setBounds(0, 0, 1214, 509);
		panel_1.add(scrSalesWorkTable);
		jtblSalesWorkTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	}
}
