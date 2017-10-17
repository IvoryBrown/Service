package ex.main.sales.device;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ex.main.sales.device.config.DeviceConfig;
import ex.main.sales.device.config.DeviceImplements;
import ex.main.sales.device.gui.DeviceGui;
import ex.main.setting.database.DataBaseConnect;
import ex.main.setting.identification.DeviceIdentificationGenereator;

public class DeviceJDBCSetDAO extends DeviceGui implements DeviceImplements {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141182053175284873L;
	private String[] rows;
	private Object columns[][];
	String addDate;

	public DeviceJDBCSetDAO() {
		setActionDevice();
		showProductsInJTableDevice();
		tableRowsDevice();
	}

	private void setActionDevice() {
		rows = new String[] { "ügyfél", "e. azonosító", "eszköz", "típus", "állapot", "prioritás", "vásárlás",
				"rögzítés", "határidő", "softver", "takarítás", "jelszó", "tartozékok", "sérülés", "hiba" };
		jtblSalesDevice.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblSalesDevice.getColumn("ügyfél").setMinWidth(160);
		jtblSalesDevice.getColumn("ügyfél").setMaxWidth(160);
		jtblSalesDevice.getColumn("e. azonosító").setMinWidth(90);
		jtblSalesDevice.getColumn("e. azonosító").setMaxWidth(90);
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
		btnSalesDeviceNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedDevice(evt);
			}
		});
		btnSalesDeviceEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedDevice(evt);
			}
		});
		btnSalesDeviceDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedDevice(evt);
				else
					return;
			}
		});
		btnSalesDeviceNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformed();
			}
		});
		btnSalesDeviceSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableClientSearch();
			}
		});
	}

	private boolean checkInputsDevice() {
		if (cmbSalesDeviceName.getSelectedItem() == null) {
			cmbSalesDeviceName.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDeviceName.setBackground(Color.BLACK);
		}
		if (cmbSalesDeviceCondition.getSelectedItem() == null) {
			cmbSalesDeviceCondition.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDeviceCondition.setBackground(Color.BLACK);
		}
		if (cmbSalesDevicePriority.getSelectedItem() == null) {
			cmbSalesDevicePriority.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDevicePriority.setBackground(Color.BLACK);
		}
		if (cmbSalesDeviceSoftver.getSelectedItem() == null) {
			cmbSalesDeviceSoftver.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDeviceSoftver.setBackground(Color.BLACK);
		}
		if (cmbSalesDeviceCleaning.getSelectedItem() == null) {
			cmbSalesDeviceCleaning.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDeviceCleaning.setBackground(Color.BLACK);
		}
		if (cmbSalesDeviceCleaning.getSelectedItem() == null) {
			cmbSalesDeviceCleaning.setBackground(new Color(255, 0, 0));
		} else {
			cmbSalesDeviceCleaning.setBackground(Color.BLACK);
		}
		if (txtSalesdeviceType.getText().trim().isEmpty()) {
			txtSalesdeviceType.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesdeviceType.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesDevicePassword.getText().trim().isEmpty()) {
			txtSalesDevicePassword.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesDevicePassword.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesDeviceAccesssory.getText().trim().isEmpty()) {
			txtSalesDeviceAccesssory.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesDeviceAccesssory.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesDeviceInjury.getText().trim().isEmpty()) {
			txtSalesDeviceInjury.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesDeviceInjury.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesDeviceComment.getText().trim().isEmpty()) {
			txtSalesDeviceComment.setBackground(new Color(255, 0, 0));
		} else {
			txtSalesDeviceComment.setBackground(new Color(245, 255, 250));
		}
		if (dateSalesDeviceEndDate.getDate() == null) {
			dateSalesDeviceEndDate.setBackground(new Color(255, 0, 0));
		} else {
			dateSalesDeviceEndDate.setBackground(Color.LIGHT_GRAY);
		}
		if (dateSalesDeviceAddDate.getDate() == null) {
			dateSalesDeviceAddDate.setBackground(new Color(255, 0, 0));
		} else {
			dateSalesDeviceAddDate.setBackground(Color.LIGHT_GRAY);
		}
		if (txtSalesdeviceType.getText().trim().isEmpty() || txtSalesDevicePassword.getText().trim().isEmpty()
				|| txtSalesDeviceAccesssory.getText().trim().isEmpty()
				|| txtSalesDeviceInjury.getText().trim().isEmpty() || txtSalesDeviceComment.getText().trim().isEmpty()
				|| dateSalesDeviceAddDate.getDate() == null || dateSalesDeviceEndDate.getDate() == null
				|| cmbSalesDeviceName.getSelectedItem() == null || cmbSalesDeviceCondition.getSelectedItem() == null
				|| cmbSalesDevicePriority.getSelectedItem() == null || cmbSalesDeviceSoftver.getSelectedItem() == null
				|| cmbSalesDeviceCleaning.getSelectedItem() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ArrayList<DeviceConfig> getSalesDeviceProductList() {
		ArrayList<DeviceConfig> productListDevice = new ArrayList<DeviceConfig>();
		String query = "SELECT * FROM gepadatok ";
		Statement st;
		ResultSet rs;
		try {
			Connection con = DataBaseConnect.getConnection();
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
		ArrayList<DeviceConfig> listSearch = new ArrayList<DeviceConfig>();
		ResultSet rs;
		Statement insertDevice;
		try {
			Connection con = DataBaseConnect.getConnection();
			insertDevice = con.createStatement();
			String searchQuery = "SELECT * FROM `gepadatok` WHERE CONCAT (`"
					+ cmbSalesDeviceSearch.getItemAt(cmbSalesDeviceSearch.getSelectedIndex()) + "`) LIKE '%"
					+ txtSalesDeviceSearch.getText() + "%'";
			rs = insertDevice.executeQuery(searchQuery);
			DeviceConfig deviceSearch;
			while (rs.next()) {
				deviceSearch = new DeviceConfig(rs.getInt("ID_g"), rs.getString("ugyfel_nev"), rs.getString("eszkoz_g"),
						rs.getString("tipus"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("vasarlas_ido"), rs.getString("rogzites"), rs.getString("hatarido"),
						rs.getString("softwer"), rs.getString("takaritas"), rs.getString("jelszo"),
						rs.getString("tartozekok"), rs.getString("serules"), rs.getString("hiba_leiras"),
						rs.getInt("megrendelo_ID_m"));
				listSearch.add(deviceSearch);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sikertelen Keresés: " + ex.getMessage());
		}
		return listSearch;
	}

	private void showProductsInJTableDevice() {
		ArrayList<DeviceConfig> listDevice = getSalesDeviceProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jtblSalesDevice.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[15];
		for (int i = 0; i < listDevice.size(); i++) {
			rowDevice[0] = listDevice.get(i).getSalesDeviceClientName();
			rowDevice[1] = listDevice.get(i).getSalesDeviceID();
			rowDevice[2] = listDevice.get(i).getSalesDeviceName();
			rowDevice[3] = listDevice.get(i).getSalesDevicdetType();
			rowDevice[4] = listDevice.get(i).getSalesDeviceStatus();
			rowDevice[5] = listDevice.get(i).getSalesDevicePriorit();
			rowDevice[6] = listDevice.get(i).getSalesDeviceBuyingDate();
			rowDevice[7] = listDevice.get(i).getSalesDeviceAddDate();
			rowDevice[8] = listDevice.get(i).getSalesDeviceExitDate();
			rowDevice[9] = listDevice.get(i).getSalesDeviceSoftwer();
			rowDevice[10] = listDevice.get(i).getSalesDeviceCleaning();
			rowDevice[11] = listDevice.get(i).getSalesDevicePassword();
			rowDevice[12] = listDevice.get(i).getSalesDeviceAccesssory();
			rowDevice[13] = listDevice.get(i).getSalesDeviceInjury();
			rowDevice[14] = listDevice.get(i).getComment();
			modelDevice.addRow(rowDevice);
		}
	}

	private void findDeviceSearch() {
		ArrayList<DeviceConfig> listDevice = getListDevice();
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

	private void showItemDevice(int index) {
		txtSalesDeviceClientID.setText(Integer.toString(getSalesDeviceProductList().get(index).getClientId()));
		txtSalesDeviceClientName.setText(getSalesDeviceProductList().get(index).getSalesDeviceClientName());
		cmbSalesDeviceName.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceName());
		txtSalesDeviceID.setText(Integer.toString(getSalesDeviceProductList().get(index).getSalesDeviceID()));
		txtSalesdeviceType.setText(getSalesDeviceProductList().get(index).getSalesDevicdetType());
		cmbSalesDeviceCondition.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceStatus());
		cmbSalesDevicePriority.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDevicePriorit());
		try {
			Date buyingDate = null;
			Date addDate = null;
			Date endDate = null;
			if (getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate() != null) {
				buyingDate = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate());
			}
			dateSalesDeviceBuying.setDate(buyingDate);
			addDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceAddDate());
			dateSalesDeviceAddDate.setDate(addDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceExitDate());
			dateSalesDeviceEndDate.setDate(endDate);
		} catch (ParseException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		cmbSalesDeviceSoftver.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceSoftwer());
		cmbSalesDeviceCleaning.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceCleaning());
		txtSalesDevicePassword.setText(getSalesDeviceProductList().get(index).getSalesDevicePassword());
		txtSalesDeviceAccesssory.setText(getSalesDeviceProductList().get(index).getSalesDeviceAccesssory());
		txtSalesDeviceInjury.setText(getSalesDeviceProductList().get(index).getSalesDeviceInjury());
		txtSalesDeviceComment.setText(getSalesDeviceProductList().get(index).getComment());
	}

	private void showItemDeviceSearch(int index) {
		txtSalesDeviceClientID.setText(Integer.toString(getSalesDeviceProductList().get(index).getClientId()));
		txtSalesDeviceClientName.setText(getSalesDeviceProductList().get(index).getSalesDeviceClientName());
		cmbSalesDeviceName.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceName());
		txtSalesDeviceID.setText(Integer.toString(getSalesDeviceProductList().get(index).getSalesDeviceID()));
		txtSalesdeviceType.setText(getSalesDeviceProductList().get(index).getSalesDevicdetType());
		cmbSalesDeviceCondition.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceStatus());
		cmbSalesDevicePriority.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDevicePriorit());
		try {
			Date buyingDate = null;
			Date addDate = null;
			Date endDate = null;
			if (getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate() != null) {
				buyingDate = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceBuyingDate());
			}
			dateSalesDeviceBuying.setDate(buyingDate);
			addDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceAddDate());
			dateSalesDeviceAddDate.setDate(addDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getSalesDeviceProductList().get(index).getSalesDeviceExitDate());
			dateSalesDeviceEndDate.setDate(endDate);
		} catch (ParseException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		cmbSalesDeviceSoftver.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceSoftwer());
		cmbSalesDeviceCleaning.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceCleaning());
		txtSalesDevicePassword.setText(getSalesDeviceProductList().get(index).getSalesDevicePassword());
		txtSalesDeviceAccesssory.setText(getSalesDeviceProductList().get(index).getSalesDeviceAccesssory());
		txtSalesDeviceInjury.setText(getSalesDeviceProductList().get(index).getSalesDeviceInjury());
		txtSalesDeviceComment.setText(getSalesDeviceProductList().get(index).getComment());
	}

	private void jBtnInsertActionPerformedDevice(java.awt.event.ActionEvent evt) {
		String buyingDate = null;
		if (checkInputsDevice()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDevice = con
						.prepareStatement("INSERT INTO gepadatok(ID_g, ugyfel_nev, eszkoz_g, tipus,"
								+ "allapot, prioritas, vasarlas_ido, rogzites,"
								+ "hatarido, softwer, takaritas, jelszo, tartozekok, serules, hiba_leiras,"
								+ " megrendelo_ID_m)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
				txtSalesDeviceID.setText(DeviceIdentificationGenereator.random());
				insertDevice.setString(1, txtSalesDeviceID.getText());
				insertDevice.setString(2, txtSalesDeviceClientName.getText());
				insertDevice.setString(3, (String) cmbSalesDeviceName.getItemAt(cmbSalesDeviceName.getSelectedIndex()));
				insertDevice.setString(4, txtSalesdeviceType.getText());
				insertDevice.setString(5,
						(String) cmbSalesDeviceCondition.getItemAt(cmbSalesDeviceCondition.getSelectedIndex()));
				insertDevice.setString(6,
						(String) cmbSalesDevicePriority.getItemAt(cmbSalesDevicePriority.getSelectedIndex()));
				SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					buyingDateFormat.setLenient(false);
					buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
				} catch (Exception e) {
				}
				insertDevice.setString(7, buyingDate);
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
				insertDevice.setString(8, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
				insertDevice.setString(9, endDate);
				insertDevice.setString(10,
						(String) cmbSalesDeviceSoftver.getItemAt(cmbSalesDeviceSoftver.getSelectedIndex()));
				insertDevice.setString(11,
						(String) cmbSalesDeviceCleaning.getItemAt(cmbSalesDeviceCleaning.getSelectedIndex()));
				insertDevice.setString(12, txtSalesDevicePassword.getText());
				insertDevice.setString(13, txtSalesDeviceAccesssory.getText());
				insertDevice.setString(14, txtSalesDeviceInjury.getText());
				insertDevice.setString(15, txtSalesDeviceComment.getText());
				insertDevice.setString(16, txtSalesDeviceClientID.getText());
				insertDevice.executeUpdate();
				PreparedStatement insertDeviceImage = con
						.prepareStatement("INSERT INTO image_gep(gepadatok_ID_g)" + "values(?)");
				insertDeviceImage.setString(1, txtSalesDeviceID.getText());
				insertDeviceImage.executeUpdate();
				PreparedStatement insertDeviceSoftver = con
						.prepareStatement("INSERT INTO software(gepadatok_ID_gs)" + "values(?)");
				insertDeviceSoftver.setString(1, txtSalesDeviceID.getText());
				insertDeviceSoftver.executeUpdate();
				PreparedStatement insertDeviceHardver = con
						.prepareStatement("INSERT INTO alkatresz(gepadatok_ID_ga)" + "values(?)");
				insertDeviceHardver.setString(1, txtSalesDeviceID.getText());
				insertDeviceHardver.executeUpdate();
				showProductsInJTableDevice();
				txtSalesDeviceClientID.setText(null);
				txtSalesDeviceClientName.setText(null);
				cmbSalesDeviceName.setSelectedItem(null);
				txtSalesDeviceID.setText(null);
				txtSalesdeviceType.setText(null);
				cmbSalesDeviceCondition.setSelectedItem(null);
				cmbSalesDevicePriority.setSelectedItem(null);
				dateSalesDeviceBuying.setDate(null);
				dateSalesDeviceAddDate.setDate(null);
				dateSalesDeviceEndDate.setDate(null);
				cmbSalesDeviceSoftver.setSelectedItem(null);
				cmbSalesDeviceCleaning.setSelectedItem(null);
				txtSalesDevicePassword.setText("-");
				txtSalesDeviceAccesssory.setText("-");
				txtSalesDeviceInjury.setText("-");
				txtSalesDeviceComment.setText(null);
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
		if (checkInputsDevice()) {
			String updateDevice = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateDevice = "UPDATE gepadatok SET ugyfel_nev = ?, eszkoz_g = ?, tipus = ?"
						+ ", allapot = ?, prioritas = ?, vasarlas_ido = ?, rogzites = ?"
						+ ", hatarido = ?, softwer = ?, takaritas = ?" + ", jelszo = ?, tartozekok = ?, serules = ?"
						+ ", hiba_leiras = ?, megrendelo_ID_m = ? WHERE ID_g = ?";
				ps = con.prepareStatement(updateDevice);
				ps.setString(1, txtSalesDeviceClientName.getText());
				ps.setString(2, (String) cmbSalesDeviceName.getItemAt(cmbSalesDeviceName.getSelectedIndex()));
				ps.setString(3, txtSalesdeviceType.getText());
				ps.setString(4, (String) cmbSalesDeviceCondition.getItemAt(cmbSalesDeviceCondition.getSelectedIndex()));
				ps.setString(5, (String) cmbSalesDevicePriority.getItemAt(cmbSalesDevicePriority.getSelectedIndex()));
				SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					buyingDateFormat.setLenient(false);
					buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
				} catch (Exception e) {
				}
				ps.setString(6, buyingDate);
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
				ps.setString(7, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
				ps.setString(8, endDate);
				ps.setString(9, (String) cmbSalesDeviceSoftver.getItemAt(cmbSalesDeviceSoftver.getSelectedIndex()));
				ps.setString(10, (String) cmbSalesDeviceCleaning.getItemAt(cmbSalesDeviceCleaning.getSelectedIndex()));
				ps.setString(11, txtSalesDevicePassword.getText());
				ps.setString(12, txtSalesDeviceAccesssory.getText());
				ps.setString(13, txtSalesDeviceInjury.getText());
				ps.setString(14, txtSalesDeviceComment.getText());
				ps.setString(15, txtSalesDeviceClientID.getText());
				ps.setInt(16, Integer.parseInt(txtSalesDeviceID.getText()));
				ps.executeUpdate();
				showProductsInJTableDevice();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				txtSalesDeviceClientID.setText(null);
				txtSalesDeviceClientName.setText(null);
				cmbSalesDeviceName.setSelectedItem(null);
				txtSalesDeviceID.setText(null);
				txtSalesdeviceType.setText(null);
				cmbSalesDeviceCondition.setSelectedItem(null);
				cmbSalesDevicePriority.setSelectedItem(null);
				dateSalesDeviceBuying.setDate(null);
				dateSalesDeviceAddDate.setDate(null);
				dateSalesDeviceEndDate.setDate(null);
				cmbSalesDeviceSoftver.setSelectedItem(null);
				cmbSalesDeviceCleaning.setSelectedItem(null);
				txtSalesDevicePassword.setText("-");
				txtSalesDeviceAccesssory.setText("-");
				txtSalesDeviceInjury.setText("-");
				txtSalesDeviceComment.setText(null);
			} catch (SQLException ex) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedDevice(java.awt.event.ActionEvent evt) {
		if (!txtSalesDeviceID.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteDevice = con.prepareStatement("DELETE FROM gepadatok WHERE ID_g = ? ");
				int idDevice = Integer.parseInt(txtSalesDeviceID.getText());
				deleteDevice.setInt(1, idDevice);
				deleteDevice.executeUpdate();
				showProductsInJTableDevice();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
				txtSalesDeviceClientID.setText(null);
				txtSalesDeviceClientName.setText(null);
				cmbSalesDeviceName.setSelectedItem(null);
				txtSalesDeviceID.setText(null);
				txtSalesdeviceType.setText(null);
				cmbSalesDeviceCondition.setSelectedItem(null);
				cmbSalesDevicePriority.setSelectedItem(null);
				dateSalesDeviceBuying.setDate(null);
				dateSalesDeviceAddDate.setDate(null);
				dateSalesDeviceEndDate.setDate(null);
				cmbSalesDeviceSoftver.setSelectedItem(null);
				cmbSalesDeviceCleaning.setSelectedItem(null);
				txtSalesDevicePassword.setText("-");
				txtSalesDeviceAccesssory.setText("-");
				txtSalesDeviceInjury.setText("-");
				txtSalesDeviceComment.setText(null);
			} catch (SQLException ex) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void btnNullShowPerformed() {
		txtSalesDeviceClientID.setText(null);
		txtSalesDeviceClientName.setText(null);
		cmbSalesDeviceName.setSelectedItem(null);
		txtSalesDeviceID.setText(null);
		txtSalesdeviceType.setText(null);
		cmbSalesDeviceCondition.setSelectedItem(null);
		cmbSalesDevicePriority.setSelectedItem(null);
		dateSalesDeviceBuying.setDate(null);
		dateSalesDeviceAddDate.setDate(null);
		dateSalesDeviceEndDate.setDate(null);
		cmbSalesDeviceSoftver.setSelectedItem(null);
		cmbSalesDeviceCleaning.setSelectedItem(null);
		txtSalesDevicePassword.setText("-");
		txtSalesDeviceAccesssory.setText("-");
		txtSalesDeviceInjury.setText("-");
		txtSalesDeviceComment.setText(null);
		showProductsInJTableDevice();
	}

	private void tableRowsDevice() {
		TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(jtblSalesDevice.getModel());
		tableRowSorter.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.isEmpty() && s2.isEmpty()) {
					return 0;
				} else if (s1.isEmpty() && !s2.isEmpty()) {
					return 1;
				} else if (!s1.isEmpty() && s2.isEmpty()) {
					return -1;
				}
				return s1.compareTo(s2);
			}
		});
		jtblSalesDevice.setRowSorter(tableRowSorter);
	}

	private void jTableClientSearch() {
		findDeviceSearch();
	}

	private void jTableProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jtblSalesDevice.getSelectedRow();
		showItemDevice(index);
		showItemDeviceSearch(index);

	}
}
