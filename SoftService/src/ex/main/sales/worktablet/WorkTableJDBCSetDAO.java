package ex.main.sales.worktablet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import ex.main.sales.worktablet.config.WorkTableConfig;
import ex.main.sales.worktablet.config.WorkTableImplements;
import ex.main.sales.worktablet.gui.WorkTableGui;
import ex.main.setting.database.DataBaseConnect;

public class WorkTableJDBCSetDAO extends WorkTableGui implements WorkTableImplements {
	private String[] rows;
	private Object columns[][];

	public WorkTableJDBCSetDAO() {
		setComponent();
		showProductsInJTable();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7705930576442305488L;

	private void setComponent() {
		rows = new String[] { "azonosító", "ügyfél", "kapcsolat", "lakcím", "megjegyzés", "e. azonosító", "eszköz",
				"típus", "sorozatszám", "állapot", "prioritás", "vásárlás", "rögzítés", "határidő", "teljesítve",
				"softver", "hardver", "takarítás", "jelszó", "tartozékok", "sérülés", "hiba leírás", "valós hiba" };
		jtblSalesWorkTable.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblSalesWorkTable.getColumn("azonosító").setMinWidth(100);
		jtblSalesWorkTable.getColumn("azonosító").setMaxWidth(100);
		jtblSalesWorkTable.getColumn("ügyfél").setMinWidth(160);
		jtblSalesWorkTable.getColumn("ügyfél").setMaxWidth(160);
		jtblSalesWorkTable.getColumn("kapcsolat").setMinWidth(130);
		jtblSalesWorkTable.getColumn("kapcsolat").setMaxWidth(130);
		jtblSalesWorkTable.getColumn("lakcím").setMinWidth(260);
		jtblSalesWorkTable.getColumn("lakcím").setMaxWidth(260);
		jtblSalesWorkTable.getColumn("megjegyzés").setMinWidth(260);
		jtblSalesWorkTable.getColumn("megjegyzés").setMaxWidth(260);
		jtblSalesWorkTable.getColumn("eszköz").setMinWidth(120);
		jtblSalesWorkTable.getColumn("eszköz").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("e. azonosító").setMinWidth(120);
		jtblSalesWorkTable.getColumn("e. azonosító").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("típus").setMinWidth(130);
		jtblSalesWorkTable.getColumn("típus").setMaxWidth(130);
		jtblSalesWorkTable.getColumn("sorozatszám").setMinWidth(90);
		jtblSalesWorkTable.getColumn("sorozatszám").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("típus").setMinWidth(190);
		jtblSalesWorkTable.getColumn("típus").setMaxWidth(190);
		jtblSalesWorkTable.getColumn("állapot").setMinWidth(150);
		jtblSalesWorkTable.getColumn("állapot").setMaxWidth(150);
		jtblSalesWorkTable.getColumn("prioritás").setMinWidth(90);
		jtblSalesWorkTable.getColumn("prioritás").setMaxWidth(90);
		jtblSalesWorkTable.getColumn("vásárlás").setMinWidth(120);
		jtblSalesWorkTable.getColumn("vásárlás").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("rögzítés").setMinWidth(120);
		jtblSalesWorkTable.getColumn("rögzítés").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("határidő").setMinWidth(120);
		jtblSalesWorkTable.getColumn("határidő").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("teljesítve").setMinWidth(120);
		jtblSalesWorkTable.getColumn("teljesítve").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("softver").setMinWidth(50);
		jtblSalesWorkTable.getColumn("softver").setMaxWidth(50);
		jtblSalesWorkTable.getColumn("hardver").setMinWidth(60);
		jtblSalesWorkTable.getColumn("hardver").setMaxWidth(60);
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

	@Override
	public ArrayList<WorkTableConfig> getWorktableProductList() {
		ArrayList<WorkTableConfig> productListDevice = new ArrayList<WorkTableConfig>();
		String query = "SELECT * FROM megrendelo " + " JOIN gepadatok ON megrendelo_ID_m = ID_m";
		Statement st;
		ResultSet rs;
		try {
			Connection con = DataBaseConnect.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			WorkTableConfig product;
			while (rs.next()) {
				product = new WorkTableConfig(rs.getString("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"),
						rs.getInt("ID_g"), rs.getString("eszkoz_g"), rs.getString("tipus"),
						rs.getString("sorozatszam_g"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("vasarlas_ido"), rs.getString("rogzites"), rs.getString("hatarido"),
						rs.getString("teljesitve"), rs.getString("softwer"), rs.getString("hardwer"),
						rs.getString("takaritas"), rs.getString("jelszo"), rs.getString("tartozekok"),
						rs.getString("serules"), rs.getString("hiba_leiras"), rs.getString("valos_hiba"));
				productListDevice.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(WorkTableJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListDevice;
	}

	@Override
	public ArrayList<WorkTableConfig> getWorktableSearchProductList() {
		// TODO Automatikusan előállított metóduscsonk
		return null;
	}

	public void showProductsInJTable() {
		ArrayList<WorkTableConfig> list = getWorktableProductList();
		DefaultTableModel model = (DefaultTableModel) jtblSalesWorkTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[23];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getWorkTableClientNumber();
			row[1] = list.get(i).getWorkTableClientName();
			row[2] = list.get(i).getWorkTableClientMobil();
			row[3] = list.get(i).getWorkTableClientHomeAddress();
			row[4] = list.get(i).getWorkTableClientComment();
			row[5] = list.get(i).getWorkTableDeviceID();
			row[6] = list.get(i).getWorkTableDeviceName();
			row[7] = list.get(i).getWorkTableDeviceType();
			row[8] = list.get(i).getWorkTableDeviceSerial();
			row[9] = list.get(i).getWorkTableDeviceStatus();
			row[10] = list.get(i).getWorkTableDevicePriorit();
			row[11] = list.get(i).getWorkTableDeviceBuyingDate();
			row[12] = list.get(i).getWorkTableDeviceAddDate();
			row[13] = list.get(i).getWorkTableDeviceExitDate();
			row[14] = list.get(i).getWorkTableDeviceCompletedDate();
			row[15] = list.get(i).getWorkTableDeviceSoftwer();
			row[16] = list.get(i).getWorkTableDeviceHardver();
			row[17] = list.get(i).getWorkTableDeviceCleaning();
			row[18] = list.get(i).getWorkTableDevicePassword();
			row[19] = list.get(i).getWorkTableDeviceAccesssory();
			row[20] = list.get(i).getWorkTableDeviceInjury();
			row[21] = list.get(i).getWorkTableDeviceFault();
			row[22] = list.get(i).getWorkTableDeviceError();
			model.addRow(row);
		}
	}
}
