package ex.main.device.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ex.main.client.gui.ClientJDBCSetDAO;
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
		btnNewDevice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedDevice(evt);
			}
		});
		btnEditDevice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedDevice(evt);
			}
		});
		jbtnDeleteDevice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedDevice(evt);
				else
					return;
			}
		});
		btnNullDevice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformedDevice(evt);
			}
		});
	}

	private boolean checkInputsDevice() {
		if (txtDevice.getText().trim().isEmpty() || txtSerialDevice.getText().trim().isEmpty()) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
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
				product = new DeviceConfig(rs.getInt("ID_g"), rs.getString("ugyfel_nev"), rs.getString("eszkoz_g"),
						rs.getString("sorozatszam_g"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("megjegyzes_g"), rs.getInt("megrendelo_ID_m"));
				productListDevice.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListDevice;
	}

	private void showProductsInJTableDevice() {
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

	private void ShowItemDevice(int index) {
		txtClientDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getClientId()));
		txtClientDeviceName.setText(getDeviceProductList().get(index).getClientName());
		txtDeviceImageClientName.setText(getDeviceProductList().get(index).getClientName());
		txtDevice.setText(getDeviceProductList().get(index).getDeviceName());
		txtDeviceImageNameDevice.setText(getDeviceProductList().get(index).getDeviceName());
		txtWorkingHoursDeviceName.setText(getDeviceProductList().get(index).getDeviceName());
		txtDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		txtDeviceImageDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		txtSerialDevice.setText(getDeviceProductList().get(index).getSerial());
		txtWorkingHoursDeviceSerial.setText(getDeviceProductList().get(index).getSerial());
		txtDeviceImageSerialDevice.setText(getDeviceProductList().get(index).getSerial());
		cmBoxStatusdevice.setSelectedItem(getDeviceProductList().get(index).getStatus());
		cmBoxPriorityDevice.setSelectedItem(getDeviceProductList().get(index).getPriorit());
		txtCommentDevice.setText(getDeviceProductList().get(index).getComment());
	}

	private void jBtnInsertActionPerformedDevice(java.awt.event.ActionEvent evt) {
		if (checkInputsDevice()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDevice = con.prepareStatement("INSERT INTO gepadatok(ugyfel_nev, eszkoz_g,"
						+ "sorozatszam_g, allapot, prioritas, megjegyzes_g, megrendelo_ID_m)"
						+ "values(?,?,?,?,?,?,?) ");
				insertDevice.setString(1, txtClientDeviceName.getText());
				insertDevice.setString(2, txtDevice.getText());
				insertDevice.setString(3, txtSerialDevice.getText());
				insertDevice.setString(4, (String) cmBoxStatusdevice.getItemAt(cmBoxStatusdevice.getSelectedIndex()));
				insertDevice.setString(5,
						(String) cmBoxPriorityDevice.getItemAt(cmBoxPriorityDevice.getSelectedIndex()));
				insertDevice.setString(6, txtCommentDevice.getText());
				insertDevice.setString(7, txtClientDeviceId.getText());
				insertDevice.executeUpdate();
				showProductsInJTableDevice();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedDevice(java.awt.event.ActionEvent evt) {
		if (checkInputsDevice()) {
			String updateDevice = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateDevice = "UPDATE gepadatok SET ugyfel_nev = ?, eszkoz_g = ?"
						+ ", sorozatszam_g = ?, allapot = ?, prioritas = ?, megjegyzes_g = ?, megrendelo_ID_m = ? WHERE ID_g = ?";
				ps = con.prepareStatement(updateDevice);
				ps.setString(1, txtClientDeviceName.getText());
				ps.setString(2, txtDevice.getText());
				ps.setString(3, txtSerialDevice.getText());
				ps.setString(4, (String) cmBoxStatusdevice.getItemAt(cmBoxStatusdevice.getSelectedIndex()));
				ps.setString(5, (String) cmBoxPriorityDevice.getItemAt(cmBoxPriorityDevice.getSelectedIndex()));
				ps.setString(6, txtCommentDevice.getText());
				ps.setString(7, txtClientDeviceId.getText());
				ps.setInt(8, Integer.parseInt(txtDeviceId.getText()));
				ps.executeUpdate();
				showProductsInJTableDevice();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedDevice(java.awt.event.ActionEvent evt) {
		if (!txtDeviceId.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteDevice = con.prepareStatement("DELETE FROM gepadatok WHERE ID_g = ? ");
				int idDevice = Integer.parseInt(txtDeviceId.getText());
				deleteDevice.setInt(1, idDevice);
				deleteDevice.executeUpdate();
				showProductsInJTableDevice();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void btnNullShowPerformedDevice(java.awt.event.ActionEvent evt) {
		txtDeviceId.setText(null);
		txtDevice.setText(null);
		txtSerialDevice.setText(null);
		cmBoxStatusdevice.setSelectedItem(null);
		cmBoxPriorityDevice.setSelectedItem(null);
		txtCommentDevice.setText(null);

	}

	private void JTable_ProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jTableDevice.getSelectedRow();
		ShowItemDevice(index);
	}
}
