package ex.main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ex.main.service.worksheet.WorkSheetJDBCSetDao;

public class MainGuiSet extends MainGui implements ActionListener {
	public MainGuiSet() {
		setComponent();
	}

	private void setComponent() {
		btnService.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnService)
			new WorkSheetJDBCSetDao().setVisible(true);
		dispose();

	}
}
