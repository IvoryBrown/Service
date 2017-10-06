package ex.main.service.device;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ex.main.service.device.config.DeviceConfig;
import ex.main.service.device.config.DeviceImplements;
import ex.main.service.device.gui.DeviceGui;
import ex.main.setting.database.DataBaseConnect;

public class DeviceJDBCSetDAO extends DeviceGui implements DeviceImplements {
	private String[] columns;

	public DeviceJDBCSetDAO() {
		setActionDevice();
		showProductsInJTableDevice();
	}

	private void setActionDevice() {
		columns = new String[] { "ügyfél", "eszköz", "sorozatszám" };
		jTableDevice.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columns));
		jTableDevice.getColumn("ügyfél").setMinWidth(120);
		jTableDevice.getColumn("ügyfél").setMaxWidth(120);
		jTableDevice.getColumn("eszköz").setMinWidth(80);
		jTableDevice.getColumn("eszköz").setMaxWidth(80);
		jTableDevice.getTableHeader().setReorderingAllowed(false);

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

		if (cmBoxStatusdevice.getFocusTraversalKeysEnabled()) {
			cmBoxStatusdevice.getEditor().getEditorComponent().setBackground(new Color(255, 250, 240));

		} else {

		}
		if (txtSerialDevice.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
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
						rs.getString("tipus"), rs.getString("sorozatszam_g"), rs.getString("allapot"),
						rs.getString("prioritas"), rs.getString("vasarlas_ido"), rs.getString("rogzites"),
						rs.getString("hatarido"), rs.getString("teljesitve"), rs.getString("softwer"),
						rs.getString("hardwer"), rs.getString("takaritas"), rs.getString("jelszo"),
						rs.getString("tartozekok"), rs.getString("serules"), rs.getString("hiba_leiras"),
						rs.getString("valos_hiba"), rs.getInt("megrendelo_ID_m"));
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
		txtClientDeviceName.setText(getDeviceProductList().get(index).getClientName());
		txtClientDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getClientId()));
		cmBoxDevice.setSelectedItem(getDeviceProductList().get(index).getDeviceName());
		txtTypeDevice.setText(getDeviceProductList().get(index).getType());
		txtDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		txtSerialDevice.setText(getDeviceProductList().get(index).getSerial());
		cmBoxStatusdevice.setSelectedItem(getDeviceProductList().get(index).getStatus());
		cmBoxPriorityDevice.setSelectedItem(getDeviceProductList().get(index).getPriorit());
		cmBoxDeviceSoftwer.setSelectedItem(getDeviceProductList().get(index).getSoftwer());
		cmBoxDeviceInterchange.setSelectedItem(getDeviceProductList().get(index).getHardver());
		cmBoxCleaning.setSelectedItem(getDeviceProductList().get(index).getCleaning());
		txtAreaDeviceErrors.setText(getDeviceProductList().get(index).getComment());
		txtAreaComment.setText(getDeviceProductList().get(index).getFault());
		txtDevicePassword.setText(getDeviceProductList().get(index).getPassword());
		txtAreaDeviceAccessory.setText(getDeviceProductList().get(index).getAccesssory());
		txtAreaInjury.setText(getDeviceProductList().get(index).getInjury());
		try {
			Date buyingDate = null;
			Date addDate = null;
			Date endDate = null;
			Date completed = null;

			if (getDeviceProductList().get(index).getBuyingDate() != null) {
				buyingDate = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getDeviceProductList().get(index).getBuyingDate());
			}
			txtDeviceBuyingDate.setDate(buyingDate);
			addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) getDeviceProductList().get(index).getAddDate());
			txtWorkHourAddDate.setDate(addDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getDeviceProductList().get(index).getExitDate());
			txtWorkHourEndDate.setDate(endDate);
			if (getDeviceProductList().get(index).getCompletedDate() != null) {
				completed = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getDeviceProductList().get(index).getCompletedDate());
			}
			txtWorkHourCompletedDate.setDate(completed);
		} catch (ParseException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Image Set!!!
		txtDeviceImageClientName.setText(getDeviceProductList().get(index).getClientName());
		txtDeviceImageNameDevice.setText(getDeviceProductList().get(index).getDeviceName());
		txtDeviceImageSerialDevice.setText(getDeviceProductList().get(index).getSerial());
		txtDeviceImageIDDevice.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		txtDeviceImageID.setText(null);
		// Softver set!!!
		txtSoftverDeviceName.setText(getDeviceProductList().get(index).getDeviceName());
		txtSoftverserial.setText(getDeviceProductList().get(index).getSerial());
		txtSoftverDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		// Hardver set!!
		txtFixtureDeviceId.setText(Integer.toString(getDeviceProductList().get(index).getIdg()));
		txtFixtureDeviceName.setText(getDeviceProductList().get(index).getDeviceName());
		txtFixtureDeviceSerial.setText(getDeviceProductList().get(index).getSerial());
	}

	private void jBtnInsertActionPerformedDevice(java.awt.event.ActionEvent evt) {
		String buyingDate = null;
		String completedDate = null;
		if (checkInputsDevice()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDevice = con
						.prepareStatement("INSERT INTO gepadatok(ugyfel_nev, eszkoz_g, tipus,"
								+ "sorozatszam_g, allapot, prioritas, vasarlas_ido, rogzites,"
								+ "hatarido, teljesitve, softwer, hardwer, takaritas, jelszo,"
								+ "tartozekok, serules, hiba_leiras," + "valos_hiba, megrendelo_ID_m)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
				insertDevice.setString(1, txtClientDeviceName.getText());
				insertDevice.setString(2, (String) cmBoxDevice.getItemAt(cmBoxDevice.getSelectedIndex()));
				insertDevice.setString(3, txtTypeDevice.getText());
				insertDevice.setString(4, txtSerialDevice.getText());
				insertDevice.setString(5, (String) cmBoxStatusdevice.getItemAt(cmBoxStatusdevice.getSelectedIndex()));
				insertDevice.setString(6,
						(String) cmBoxPriorityDevice.getItemAt(cmBoxPriorityDevice.getSelectedIndex()));
				SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					buyingDateFormat.setLenient(false);
					buyingDate = buyingDateFormat.format(txtDeviceBuyingDate.getDate());
				} catch (Exception e) {
				}
				insertDevice.setString(7, buyingDate);
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txtWorkHourAddDate.getDate());
				insertDevice.setString(8, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(txtWorkHourEndDate.getDate());
				insertDevice.setString(9, endDate);
				SimpleDateFormat completedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					completedDateFormat.setLenient(false);
					completedDate = completedDateFormat.format(txtWorkHourCompletedDate.getDate());
				} catch (Exception e) {
				}
				insertDevice.setString(10, completedDate);
				insertDevice.setString(11,
						(String) cmBoxDeviceSoftwer.getItemAt(cmBoxDeviceSoftwer.getSelectedIndex()));
				insertDevice.setString(12,
						(String) cmBoxDeviceInterchange.getItemAt(cmBoxDeviceInterchange.getSelectedIndex()));
				insertDevice.setString(13, (String) cmBoxCleaning.getItemAt(cmBoxCleaning.getSelectedIndex()));
				insertDevice.setString(14, txtDevicePassword.getText());
				insertDevice.setString(15, txtAreaDeviceAccessory.getText());
				insertDevice.setString(16, txtAreaInjury.getText());
				insertDevice.setString(17, txtAreaComment.getText());
				insertDevice.setString(18, txtAreaDeviceErrors.getText());
				insertDevice.setString(19, txtClientDeviceId.getText());
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
		String buyingDate = null;
		String completedDate = null;
		if (checkInputsDevice()) {
			String updateDevice = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateDevice = "UPDATE gepadatok SET ugyfel_nev = ?, eszkoz_g = ?, tipus = ?"
						+ ", sorozatszam_g = ?, allapot = ?, prioritas = ?, vasarlas_ido = ?, rogzites = ?"
						+ ", hatarido = ?, teljesitve = ?, softwer = ?, hardwer = ?, takaritas = ?"
						+ ", jelszo = ?, tartozekok = ?, serules = ?"
						+ ", hiba_leiras = ?, valos_hiba = ?, megrendelo_ID_m = ? WHERE ID_g = ?";
				ps = con.prepareStatement(updateDevice);
				ps.setString(1, txtClientDeviceName.getText());
				ps.setString(2, (String) cmBoxDevice.getItemAt(cmBoxDevice.getSelectedIndex()));
				ps.setString(3, txtTypeDevice.getText());
				ps.setString(4, txtSerialDevice.getText());
				ps.setString(5, (String) cmBoxStatusdevice.getItemAt(cmBoxStatusdevice.getSelectedIndex()));
				ps.setString(6, (String) cmBoxPriorityDevice.getItemAt(cmBoxPriorityDevice.getSelectedIndex()));
				SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					buyingDateFormat.setLenient(false);
					buyingDate = buyingDateFormat.format(txtDeviceBuyingDate.getDate());
				} catch (Exception e) {
				}
				ps.setString(7, buyingDate);
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
				String addDate = addDateFormat.format(txtWorkHourAddDate.getDate());
				ps.setString(8, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(txtWorkHourEndDate.getDate());
				ps.setString(9, endDate);
				SimpleDateFormat completedDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
				try {
					completedDateFormat.setLenient(false);
					completedDate = completedDateFormat.format(txtWorkHourCompletedDate.getDate());
				} catch (Exception e) {
				}
				ps.setString(10, completedDate);
				ps.setString(11, (String) cmBoxDeviceSoftwer.getItemAt(cmBoxDeviceSoftwer.getSelectedIndex()));
				ps.setString(12, (String) cmBoxDeviceInterchange.getItemAt(cmBoxDeviceInterchange.getSelectedIndex()));
				ps.setString(13, (String) cmBoxCleaning.getItemAt(cmBoxCleaning.getSelectedIndex()));
				ps.setString(14, txtDevicePassword.getText());
				ps.setString(15, txtAreaDeviceAccessory.getText());
				ps.setString(16, txtAreaInjury.getText());
				ps.setString(17, txtAreaComment.getText());
				ps.setString(18, txtAreaDeviceErrors.getText());
				ps.setString(19, txtClientDeviceId.getText());
				ps.setInt(20, Integer.parseInt(txtDeviceId.getText()));
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
		txtClientDeviceName.setText(null);
		txtClientDeviceId.setText(null);
		cmBoxDevice.setSelectedItem(null);
		txtTypeDevice.setText(null);
		txtDeviceId.setText(null);
		txtSerialDevice.setText(null);
		cmBoxStatusdevice.setSelectedItem(null);
		cmBoxPriorityDevice.setSelectedItem(null);
		cmBoxDeviceSoftwer.setSelectedItem(null);
		cmBoxDeviceInterchange.setSelectedItem(null);
		cmBoxCleaning.setSelectedItem(null);
		txtDeviceBuyingDate.setDate(null);
		txtWorkHourAddDate.setDate(null);
		txtWorkHourEndDate.setDate(null);
		txtWorkHourCompletedDate.setDate(null);
		txtAreaComment.setText(null);
		txtAreaDeviceErrors.setText(null);
		txtDevicePassword.setText(null);
		txtAreaDeviceAccessory.setText(null);
		txtAreaInjury.setText(null);
	}

	private void JTable_ProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jTableDevice.getSelectedRow();
		ShowItemDevice(index);
	}
}
