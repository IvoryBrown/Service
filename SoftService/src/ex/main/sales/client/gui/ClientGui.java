package ex.main.sales.client.gui;

import ex.main.sales.gui.SalesGui;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ClientGui extends SalesGui {
	public ClientGui() {
		setComponentClientGui();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable jtblSalesClient;

	private void setComponentClientGui() {
		jpnlClient.setLayout(null);
		
		JScrollPane scrSalesClient = new JScrollPane();
		scrSalesClient.setBounds(10, 377, 1219, 235);
		jpnlClient.add(scrSalesClient);
		
		jtblSalesClient = new JTable();
		scrSalesClient.setViewportView(jtblSalesClient);
	}
}
