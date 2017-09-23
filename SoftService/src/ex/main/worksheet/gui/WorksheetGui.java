package ex.main.worksheet.gui;

import ex.main.gui.Gui;
import javax.swing.JTextField;

public class WorksheetGui extends Gui{
	private JTextField textField;
	
	public WorksheetGui() {
		
		textField = new JTextField();
		jplWorksheet.add(textField);
		textField.setColumns(10);
		
	}

}
