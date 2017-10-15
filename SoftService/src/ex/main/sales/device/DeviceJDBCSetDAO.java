package ex.main.sales.device;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import ex.main.sales.device.config.DeviceConfig;
import ex.main.sales.device.config.DeviceImplements;
import ex.main.sales.device.gui.DeviceGui;
import ex.main.setting.database.DataBaseConnect;

public class DeviceJDBCSetDAO extends DeviceGui implements DeviceImplements {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141182053175284873L;
	private String[] rows;
	private Object columns[][];

	public DeviceJDBCSetDAO() {
		setActionDevice();
		showProductsInJTableDevice();
	}

	private void setActionDevice() {
		rows = new String[] { "ügyfél", "eszköz", "típus", "állapot", "prioritás", "vásárlás", "rögzítés", "határidő",
				"softver", "takarítás", "jelszó", "tartozékok", "sérülés", "hiba" };
		jtblSalesDevice.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblSalesDevice.getColumn("ügyfél").setMinWidth(160);
		jtblSalesDevice.getColumn("ügyfél").setMaxWidth(160);
		jtblSalesDevice.getColumn("eszköz").setMinWidth(90);
		jtblSalesDevice.getColumn("eszköz").setMaxWidth(90);
		jtblSalesDevice.getColumn("típus").setMinWidth(190);
		jtblSalesDevice.getColumn("típus").setMaxWidth(190);
		jtblSalesDevice.getColumn("állapot").setMinWidth(120);
		jtblSalesDevice.getColumn("állapot").setMaxWidth(120);
		jtblSalesDevice.getColumn("prioritás").setMinWidth(90);
		jtblSalesDevice.getColumn("prioritás").setMaxWidth(90);
		jtblSalesDevice.getColumn("vásárlás").setMinWidth(90);
		jtblSalesDevice.getColumn("vásárlás").setMaxWidth(90);
		jtblSalesDevice.getColumn("rögzítés").setMinWidth(90);
		jtblSalesDevice.getColumn("rögzítés").setMaxWidth(90);
		jtblSalesDevice.getColumn("határidő").setMinWidth(90);
		jtblSalesDevice.getColumn("határidő").setMaxWidth(90);
		jtblSalesDevice.getColumn("softver").setMinWidth(50);
		jtblSalesDevice.getColumn("softver").setMaxWidth(50);
		jtblSalesDevice.getColumn("takarítás").setMinWidth(60);
		jtblSalesDevice.getColumn("takarítás").setMaxWidth(60);
		jtblSalesDevice.getColumn("jelszó").setMinWidth(120);
		jtblSalesDevice.getColumn("jelszó").setMaxWidth(120);
		jtblSalesDevice.getColumn("tartozékok").setMinWidth(250);
		jtblSalesDevice.getColumn("tartozékok").setMaxWidth(250);
		jtblSalesDevice.getColumn("sérülés").setMinWidth(300);
		jtblSalesDevice.getColumn("sérülés").setMaxWidth(300);
		jtblSalesDevice.getColumn("hiba").setMinWidth(400);
		jtblSalesDevice.getColumn("hiba").setMaxWidth(400);
		jtblSalesDevice.getTableHeader().setReorderingAllowed(false);
		jtblSalesDevice.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableProductsMouseClickedDevice(evt);

			}
		});
	}

	@Override
	public ArrayList<DeviceConfig> getSalesDeviceProductList() {
		ArrayList<DeviceConfig> productListDevice = new ArrayList<DeviceConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM gepadatok ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			DeviceConfig product;
			while (rs.next()) {
				product = new DeviceConfig(rs.getInt("ID_g"), rs.getString("ugyfel_nev"), rs.getString("eszkoz_g"),
						rs.getString("tipus"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("vasarlas_ido"), rs.getString("rogzites"), rs.getString("hatarido"),
						rs.getString("softwer"), rs.getString("takaritas"), rs.getString("jelszo"),
						rs.getString("tartozekok"), rs.getString("serules"), rs.getString("hiba_leiras"),
						rs.getInt("megrendelo_ID_m"));
				productListDevice.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListDevice;
	}

	@Override
	public ArrayList<DeviceConfig> getListDevice() {
		// TODO Automatikusan előállított metóduscsonk
		return null;
	}

	private void showProductsInJTableDevice() {
		ArrayList<DeviceConfig> listDevice = getSalesDeviceProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jtblSalesDevice.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[14];
		for (int i = 0; i < listDevice.size(); i++) {
			rowDevice[0] = listDevice.get(i).getSalesDeviceClientName();
			rowDevice[1] = listDevice.get(i).getSalesDeviceName();
			rowDevice[2] = listDevice.get(i).getSalesDevicdetType();
			rowDevice[3] = listDevice.get(i).getSalesDeviceStatus();
			rowDevice[4] = listDevice.get(i).getSalesDevicePriorit();
			rowDevice[5] = listDevice.get(i).getSalesDeviceBuyingDate();
			rowDevice[6] = listDevice.get(i).getSalesDeviceAddDate();
			rowDevice[7] = listDevice.get(i).getSalesDeviceExitDate();
			rowDevice[8] = listDevice.get(i).getSalesDeviceSoftwer();
			rowDevice[9] = listDevice.get(i).getSalesDeviceCleaning();
			rowDevice[10] = listDevice.get(i).getSalesDevicePassword();
			rowDevice[11] = listDevice.get(i).getSalesDeviceAccesssory();
			rowDevice[12] = listDevice.get(i).getSalesDeviceInjury();
			rowDevice[13] = listDevice.get(i).getComment();
			modelDevice.addRow(rowDevice);
		}
	}

	public void showItemDevice(int index) {
		txtSalesDeviceAccesssory.setText(getSalesDeviceProductList().get(index).getSalesDeviceAccesssory());
		txtSalesDeviceClientName.setText(getSalesDeviceProductList().get(index).getSalesDeviceClientName());
		try {
			Date buyingDate = null;

			if (getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate() != null) {
				buyingDate = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate());
			}
			dateSalesDeviceBuying.setDate(buyingDate);

		} catch (ParseException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void jTableProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jtblSalesDevice.getSelectedRow();
		showItemDevice(index);

	}
}
