package ex.main.sales.client;

import ex.main.sales.client.gui.ClientGui;

public class ClientJDBCSetDAO extends ClientGui {
	public ClientJDBCSetDAO() {
		setActionSalesClient();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void setActionSalesClient() {
		String columns[] = { "azonosító", "név", "telefon", "lakcím", "megjegyzés" };

		jtblSalesClient.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columns));
	}
}
