package ex.main.sales.worksheet;

import ex.main.gui.MainGuiSet;
import ex.main.sales.worksheet.gui.WorkSheetGui;

public class WorkSheetJDBCSetDAO extends WorkSheetGui {
	public WorkSheetJDBCSetDAO() {
		setComponent();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4447606588857813949L;

	private void setComponent() {
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new MainGuiSet().setVisible(true);
				dispose();
			}
		});
	}
}
