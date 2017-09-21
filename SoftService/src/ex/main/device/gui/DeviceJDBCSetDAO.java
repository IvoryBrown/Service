package ex.main.device.gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import ex.main.device.config.DeviceConfig;
import ex.main.device.config.DeviceImplements;
import ex.main.setting.DataBaseConnect;

public class DeviceJDBCSetDAO extends DeviceGui implements DeviceImplements {

	public DeviceJDBCSetDAO() {
		setActionDevice();
		showProductsInJTableDevice();
	}

	private void setActionDevice() {
		jTableDevice.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ügyfél", "eszköz", "sorozatszám" }));
		jTableDevice.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedDevice(evt);
			}
		});
	}

	@Override
	public ArrayList<DeviceConfig> getDeviceProductList() {
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
				product = new DeviceConfig(rs.getInt("ID_g"),rs.getString("ugyfel_nev"),  rs.getString("eszkoz_g"), rs.getString("sorozatszam_g"),
						rs.getString("allapot"), rs.getString("prioritas"), rs.getString("megjegyzes_g"),rs.getInt("megrendelo_ID_m"));
				productListDevice.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListDevice;
	}

	public void showProductsInJTableDevice() {
		ArrayList<DeviceConfig> listDevice = getDeviceProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jTableDevice.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[3];
		for (int i = 0; i < listDevice.size(); i++) {
			rowDevice[0] = listDevice.get(i).getClientName();
			rowDevice[1] = listDevice.get(i).getDeviceName();
			rowDevice[2] = listDevice.get(i).getSerial();
			modelDevice.addRow(rowDevice);
		}
	}

	public void ShowItemDevice(int index) {
		txtClientDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getClientId()));
		txtClientDeviceName.setText(getDeviceProductList().get(index).getClientName());
	}

	private void JTable_ProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jTableDevice.getSelectedRow();
		ShowItemDevice(index);
	}
}
