package ex.main.sales.workprint;

import ex.main.sales.workprint.gui.WorkPrintGui;
import ex.main.setting.printing.SetPrinting;

public class WorkPrint extends WorkPrintGui  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2964327470005055114L;
	public WorkPrint() {
		
			setComp();
		
	}

	public void setComp(){
		
		btnWorkPrint.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnPrinting();
			
			}
		});
		
	}
	
	 
	public void btnPrinting() {
		SetPrinting print = new SetPrinting();
		print.setComponent(panel);
		print.print();
	}
	
	
}
