package ex.main.sales.worktablet;

import ex.main.sales.worktablet.gui.WorkTableGui;

public class WorkTableJDBCSetDAO extends WorkTableGui {
	private String[] rows;
	private Object columns[][];

	public WorkTableJDBCSetDAO() {
		setComponent();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7705930576442305488L;

	private void setComponent() {
		rows = new String[] { "azonosító", "ügyfél", "kapcsolat", "lakcím", "eszköz", "típus", "sorozatszám", "állapot",
				"prioritás", "vásárlás", "rögzítés", "határidő", "teljesítve", "softver", "hardver","takarítás", "jelszó",
				"tartozékok", "sérülés", "hiba leírás","valós hiba" };
		jtblSalesWorkTable.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblSalesWorkTable.getColumn("azonosító").setMinWidth(100);
		jtblSalesWorkTable.getColumn("azonosító").setMaxWidth(100);
		jtblSalesWorkTable.getColumn("ügyfél").setMinWidth(160);
		jtblSalesWorkTable.getColumn("ügyfél").setMaxWidth(160);
		jtblSalesWorkTable.getColumn("kapcsolat").setMinWidth(160);
		jtblSalesWorkTable.getColumn("kapcsolat").setMaxWidth(160);
		jtblSalesWorkTable.getColumn("lakcím").setMinWidth(260);
		jtblSalesWorkTable.getColumn("lakcím").setMaxWidth(260);
		jtblSalesWorkTable.getColumn("eszköz").setMinWidth(90);
		jtblSalesWorkTable.getColumn("eszköz").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("típus").setMinWidth(90);
		jtblSalesWorkTable.getColumn("típus").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("sorozatszám").setMinWidth(90);
		jtblSalesWorkTable.getColumn("sorozatszám").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("típus").setMinWidth(190);
		jtblSalesWorkTable.getColumn("típus").setMaxWidth(190);
		jtblSalesWorkTable.getColumn("állapot").setMinWidth(120);
		jtblSalesWorkTable.getColumn("állapot").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("prioritás").setMinWidth(90);
		jtblSalesWorkTable.getColumn("prioritás").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("vásárlás").setMinWidth(90);
		jtblSalesWorkTable.getColumn("vásárlás").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("rögzítés").setMinWidth(90);
		jtblSalesWorkTable.getColumn("rögzítés").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("határidő").setMinWidth(90);
		jtblSalesWorkTable.getColumn("határidő").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("teljesítve").setMinWidth(90);
		jtblSalesWorkTable.getColumn("teljesítve").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("softver").setMinWidth(50);
		jtblSalesWorkTable.getColumn("softver").setMaxWidth(50);
		jtblSalesWorkTable.getColumn("hardver").setMinWidth(50);
		jtblSalesWorkTable.getColumn("hardver").setMaxWidth(50);
		jtblSalesWorkTable.getColumn("takarítás").setMinWidth(60);
		jtblSalesWorkTable.getColumn("takarítás").setMaxWidth(60);
		jtblSalesWorkTable.getColumn("jelszó").setMinWidth(120);
		jtblSalesWorkTable.getColumn("jelszó").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("tartozékok").setMinWidth(250);
		jtblSalesWorkTable.getColumn("tartozékok").setMaxWidth(250);
		jtblSalesWorkTable.getColumn("sérülés").setMinWidth(300);
		jtblSalesWorkTable.getColumn("sérülés").setMaxWidth(300);
		jtblSalesWorkTable.getColumn("hiba leírás").setMinWidth(400);
		jtblSalesWorkTable.getColumn("hiba leírás").setMaxWidth(400);
		jtblSalesWorkTable.getColumn("valós hiba").setMinWidth(400);
		jtblSalesWorkTable.getColumn("valós hiba").setMaxWidth(400);
		jtblSalesWorkTable.getTableHeader().setReorderingAllowed(false);
	}
}
