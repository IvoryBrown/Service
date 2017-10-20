package ex.main.sales.worktablet.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import ex.main.sales.workprint.WorkPrint;

public class WorkTableGui extends WorkPrint {
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
		jtblSalesWorkTable.setForeground(new Color(153, 0, 0));
		jtblSalesWorkTable.setBackground(Color.BLACK);
		jtblSalesWorkTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		jtblSalesWorkTable.setRowHeight(30);
		
		scrSalesWorkTable = new JScrollPane(jtblSalesWorkTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrSalesWorkTable.setBounds(0, 0, 1214, 509);
		pnlWorkTable.add(scrSalesWorkTable);
		jtblSalesWorkTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	}
	
}
