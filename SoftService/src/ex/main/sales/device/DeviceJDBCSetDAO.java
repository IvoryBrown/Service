package ex.main.sales.device;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.DefaultComboBoxModel;
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
		String[] desktopPc = { "Acer", "Alza", "Apple", "ASBIS", "ASRock", "ASUS", "CHS", "Dell", "DigitalWeb", "Elo",
				"EXOZA", "Expert", "Foramax", "Fujitsu", "GABA", "GIGABYTE", "Golden PC", "HP", "iggual", "InFocus",
				"Intel", "Intensa", "Iris", "JTC", "Kiano", "Leadtek", "Lenovo", "LG", "MeLE", "Mentor", "Microsoft",
				"MINIX", "MODECOM", "MSI", "NComputing", "PC FACTORY", "PCX", "PEAQ", "RADIUM", "Raspberry",
				"Rikomagic", "Royal Hardwer", "SAPPHIRE", "Serioux", "Shuttle", "SmartPC", "X-X", "ZOTAC", "NO NAME",
				"Egyéb" };

		String[] notebook = { "Acer", "Alcor", "Allview", "Apple", "ASUS", "Dell", "Fujitsu", "Getac", "GIGABYTE",
				"GOCLEVER", "HP", "Kiano", "Lenovo", "Microsoft", "MSI", "Navon", "Packard Bell", "PEAQ",
				"Porsche Desing", "Samsung", "Teclast", "Toshiba", "UMAX", "NO NAME", "Egyéb" };

		String[] printer = { "Argox", "Bolle", "Brother", "Canon", "Citizen", "CoLiDo", "CraftUnique", "Datamax-O'Neil",
				"Develop", "DNP", "Epson", "Evolis", "Fomei", "Fujifilm", "Fujitsu", "Gembird", "HiTi", "HP", "I.R.I.S",
				"INFINUM", "Konica Minolta", "Kyocera", "Leapfrog", "Lexmark", "MakerBot", "Mitsubishi", "Monkeyfab",
				"OKI", "Polaroid", "Prusa", "Ricoh", "ROBO 3D", "Samsung", "Sharp", "SUNEN", "Tally", "TEVO",
				"Velleman", "Xerox", "XYZprinting", "Zebra", "NO NAME", "Egyéb" };

		String[] monitor = { "3M", "Acer", "AG Neovo", "AOC", "ASUS", "BenQ", "Canon", "Computar", "Dell", "EIZO",
				"Elo", "Fujitsu", "Fujitsu-Siemens", "GABA", "Grundig", "Hannspree", "Hikvision", "HP", "Hyundai",
				"liyama", "Lenovo", "LG", "MSI", "NEC", "Orava", "Panasonic", "Philips", "Samsung", "SMART", "Sony",
				"V7", "ViewSonic", "Vortex", "NO NAME", "Egyéb" };

		String[] projector = { "Acer", "AIPTEK", "ASUS", "Auna", "BenQ", "Canon", "Cheerlux", "Dell", "DreamVision",
				"Epson", "GOCLEVER", "Hitachi", "InFocus", "JVC", "LG", "LuxCine", "NEC", "Optoma", "Overmax",
				"Panasonic", "Philips", "Ricoh", "Rigal Electronics", "Rikomagic", "Safako", "Skytronic", "Sony",
				"ViewSonic", "Vivitek", "XGIMI", "NO NAME", "Egyéb" };

		cmbSalesDeviceName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSalesdeviceType.setEditable(false);
				String strngSalesDeviceName = (String) cmbSalesDeviceName.getSelectedItem();
				if (strngSalesDeviceName == "Asztali PC") {
					DefaultComboBoxModel<Object> cbm = new DefaultComboBoxModel<Object>(desktopPc);
					txtSalesdeviceType.setModel(cbm);
					txtSalesdeviceType.setSelectedItem(null);
				} else if (strngSalesDeviceName == "Notebook") {
					DefaultComboBoxModel<Object> cbm = new DefaultComboBoxModel<Object>(notebook);
					txtSalesdeviceType.setModel(cbm);
					txtSalesdeviceType.setSelectedItem(null);
				} else if (strngSalesDeviceName == "Nyomtató") {
					DefaultComboBoxModel<Object> cbm = new DefaultComboBoxModel<Object>(printer);
					txtSalesdeviceType.setModel(cbm);
					txtSalesdeviceType.setSelectedItem(null);
				} else if (strngSalesDeviceName == "Monitor") {
					DefaultComboBoxModel<Object> cbm = new DefaultComboBoxModel<Object>(monitor);
					txtSalesdeviceType.setModel(cbm);
					txtSalesdeviceType.setSelectedItem(null);
				} else if (strngSalesDeviceName == "Projektor") {
					DefaultComboBoxModel<Object> cbm = new DefaultComboBoxModel<Object>(projector);
					txtSalesdeviceType.setModel(cbm);
					txtSalesdeviceType.setSelectedItem(null);
				} else if (strngSalesDeviceName == "Egyéb") {
					txtSalesdeviceType.setSelectedItem(null);
					txtSalesdeviceType.setEditable(true);
					System.out.println("3");
				}
			}
		});
		txtSalesdeviceType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtSalesdeviceTyp = (String) txtSalesdeviceType.getSelectedItem();
				if (txtSalesdeviceTyp == "Egyéb") {
					txtSalesdeviceType.setSelectedItem(null);
					txtSalesdeviceType.setEditable(true);
				}
			}
		});

		cmbSalesDeviceCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				String newDevice = (String) cmbSalesDeviceCondition.getSelectedItem();
				if (newDevice == "Új gép") {
					panel_2.setVisible(false);
				}
			}
		});

	}

	private boolean checkInputsNewDevice() {
		colorSetText();
		String newDevice = (String) cmbSalesDeviceCondition.getSelectedItem();
		if (newDevice == "Új gép") {
			if (cmbSalesDeviceName.getSelectedItem() == null) {
				cmbSalesDeviceName.setBackground(new Color(255, 0, 0));
			} else {
				cmbSalesDeviceName.setBackground(Color.BLACK);
			}
			if (cmbSalesDeviceHardver.getSelectedItem() == null) {
				cmbSalesDeviceHardver.setBackground(new Color(255, 0, 0));
			} else {
				cmbSalesDeviceHardver.setBackground(Color.BLACK);
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
			if (txtSalesdeviceType.getSelectedItem() == null) {
				txtSalesdeviceType.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesdeviceType.setBackground(Color.BLACK);
			}
			if (txtSalesDeviceSerialNumber.getText().trim().isEmpty()) {
				txtSalesDeviceSerialNumber.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDeviceSerialNumber.setBackground(Color.WHITE);
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
			if (txtSalesdeviceType.getSelectedItem() == null || txtSalesDeviceSerialNumber.getText().trim().isEmpty()
					|| dateSalesDeviceAddDate.getDate() == null || dateSalesDeviceEndDate.getDate() == null
					|| cmbSalesDeviceName.getSelectedItem() == null || cmbSalesDeviceCondition.getSelectedItem() == null
					|| cmbSalesDevicePriority.getSelectedItem() == null
					|| cmbSalesDeviceSoftver.getSelectedItem() == null) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	private boolean checkInputsDevice() {
		colorSetText();
		String newDevice = (String) cmbSalesDeviceCondition.getSelectedItem();
		if (newDevice != "Új gép") {

			if (cmbSalesDeviceName.getSelectedItem() == null) {
				cmbSalesDeviceName.setBackground(new Color(255, 0, 0));
			} else {
				cmbSalesDeviceName.setBackground(Color.BLACK);
			}
			if (cmbSalesDeviceHardver.getSelectedItem() == null) {
				cmbSalesDeviceHardver.setBackground(new Color(255, 0, 0));
			} else {
				cmbSalesDeviceHardver.setBackground(Color.BLACK);
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
			if (txtSalesdeviceType.getSelectedItem() == null) {
				txtSalesdeviceType.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesdeviceType.setBackground(Color.BLACK);
			}
			if (txtSalesDevicePassword.getText().trim().isEmpty()) {
				txtSalesDevicePassword.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDevicePassword.setBackground(Color.WHITE);
			}
			if (txtSalesDeviceAccesssory.getText().trim().isEmpty()) {
				txtSalesDeviceAccesssory.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDeviceAccesssory.setBackground(Color.WHITE);
			}
			if (txtSalesDeviceSerialNumber.getText().trim().isEmpty()) {
				txtSalesDeviceSerialNumber.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDeviceSerialNumber.setBackground(Color.WHITE);
			}
			if (txtSalesDeviceInjury.getText().trim().isEmpty()) {
				txtSalesDeviceInjury.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDeviceInjury.setBackground(Color.WHITE);
			}
			if (txtSalesDeviceComment.getText().trim().isEmpty()) {
				txtSalesDeviceComment.setBackground(new Color(255, 0, 0));
			} else {
				txtSalesDeviceComment.setBackground(Color.WHITE);
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
			if (txtSalesdeviceType.getSelectedItem() == null || txtSalesDevicePassword.getText().trim().isEmpty()
					|| txtSalesDeviceAccesssory.getText().trim().isEmpty()
					|| txtSalesDeviceSerialNumber.getText().trim().isEmpty()
					|| txtSalesDeviceInjury.getText().trim().isEmpty()
					|| txtSalesDeviceComment.getText().trim().isEmpty() || dateSalesDeviceAddDate.getDate() == null
					|| dateSalesDeviceEndDate.getDate() == null || cmbSalesDeviceName.getSelectedItem() == null
					|| cmbSalesDeviceCondition.getSelectedItem() == null
					|| cmbSalesDevicePriority.getSelectedItem() == null
					|| cmbSalesDeviceSoftver.getSelectedItem() == null
					|| cmbSalesDeviceCleaning.getSelectedItem() == null) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	@Override
	public ArrayList<DeviceConfig> getSalesDeviceProductList() {
		ArrayList<DeviceConfig> productListDevice = new ArrayList<DeviceConfig>();
		String query = "SELECT * FROM gepadatok ";
		Statement st = null;
		ResultSet rs = null;
		Connection con = DataBaseConnect.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			DeviceConfig product;
			while (rs.next()) {
				product = new DeviceConfig(rs.getInt("ID_g"), rs.getString("ugyfel_nev"), rs.getString("eszkoz_g"),
						rs.getString("tipus"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("vasarlas_ido"), rs.getString("rogzites"), rs.getString("hatarido"),
						rs.getString("softwer"), rs.getString("hardwer"), rs.getString("takaritas"),
						rs.getString("jelszo"), rs.getString("tartozekok"), rs.getString("serules"),
						rs.getString("hiba_leiras"), rs.getInt("megrendelo_ID_m"));
				productListDevice.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return productListDevice;
	}

	@Override
	public ArrayList<DeviceConfig> getListDevice() {
		ArrayList<DeviceConfig> listSearch = new ArrayList<DeviceConfig>();
		ResultSet rs = null;
		Statement insertDevice = null;
		Connection con = DataBaseConnect.getConnection();
		try {
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
						rs.getString("softwer"), rs.getString("hardwer"), rs.getString("takaritas"),
						rs.getString("jelszo"), rs.getString("tartozekok"), rs.getString("serules"),
						rs.getString("hiba_leiras"), rs.getInt("megrendelo_ID_m"));
				listSearch.add(deviceSearch);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sikertelen Keresés: " + ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (insertDevice != null) {
					insertDevice.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
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
		txtSalesdeviceType.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDevicdetType());
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
		cmbSalesDeviceHardver.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceHardver());
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
		txtSalesdeviceType.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDevicdetType());
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
		cmbSalesDeviceHardver.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceHardver());
		cmbSalesDeviceCleaning.setSelectedItem(getSalesDeviceProductList().get(index).getSalesDeviceCleaning());
		txtSalesDevicePassword.setText(getSalesDeviceProductList().get(index).getSalesDevicePassword());
		txtSalesDeviceAccesssory.setText(getSalesDeviceProductList().get(index).getSalesDeviceAccesssory());
		txtSalesDeviceInjury.setText(getSalesDeviceProductList().get(index).getSalesDeviceInjury());
		txtSalesDeviceComment.setText(getSalesDeviceProductList().get(index).getComment());
	}

	private void jBtnInsertActionPerformedDevice(java.awt.event.ActionEvent evt) {
		String buyingDate = null;
		String newDevice = (String) cmbSalesDeviceCondition.getSelectedItem();
		if (newDevice != "Új gép") {
			if (checkInputsDevice()) {
				try {
					Connection con = DataBaseConnect.getConnection();
					PreparedStatement insertDevice = con
							.prepareStatement("INSERT INTO gepadatok(ID_g, ugyfel_nev, eszkoz_g, tipus, sorozatszam_g,"
									+ "allapot, prioritas, vasarlas_ido, rogzites,"
									+ "hatarido, softwer, hardwer, takaritas, jelszo, tartozekok, serules, hiba_leiras,"
									+ " megrendelo_ID_m)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					txtSalesDeviceID.setText(DeviceIdentificationGenereator.random());
					insertDevice.setString(1, txtSalesDeviceID.getText());
					insertDevice.setString(2, txtSalesDeviceClientName.getText());
					insertDevice.setString(3, (String) cmbSalesDeviceName.getSelectedItem());
					insertDevice.setString(4, (String) txtSalesdeviceType.getSelectedItem());
					insertDevice.setString(5, txtSalesDeviceSerialNumber.getText());
					insertDevice.setString(6, (String) cmbSalesDeviceCondition.getSelectedItem());
					insertDevice.setString(7, (String) cmbSalesDevicePriority.getSelectedItem());
					SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						buyingDateFormat.setLenient(false);
						buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
					} catch (Exception e) {
					}
					insertDevice.setString(8, buyingDate);
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
					insertDevice.setString(9, addDate);
					SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
					insertDevice.setString(10, endDate);
					insertDevice.setString(11, (String) cmbSalesDeviceSoftver.getSelectedItem());
					insertDevice.setString(12, (String) cmbSalesDeviceHardver.getSelectedItem());
					insertDevice.setString(13, (String) cmbSalesDeviceCleaning.getSelectedItem());
					insertDevice.setString(14, txtSalesDevicePassword.getText());
					insertDevice.setString(15, txtSalesDeviceAccesssory.getText());
					insertDevice.setString(16, txtSalesDeviceInjury.getText());
					insertDevice.setString(17, txtSalesDeviceComment.getText());
					insertDevice.setString(18, txtSalesDeviceClientID.getText());
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
					JOptionPane.showMessageDialog(null, "Adatok beillesztve");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
			}
		} else if (newDevice == "Új gép") {
			if (checkInputsNewDevice()) {
				try {
					Connection con = DataBaseConnect.getConnection();
					PreparedStatement insertDevice = con
							.prepareStatement("INSERT INTO gepadatok(ID_g, ugyfel_nev, eszkoz_g, tipus, sorozatszam_g,"
									+ "allapot, prioritas, vasarlas_ido, rogzites," + "hatarido, softwer, hardwer,"
									+ " megrendelo_ID_m)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					txtSalesDeviceID.setText(DeviceIdentificationGenereator.random());
					insertDevice.setString(1, txtSalesDeviceID.getText());
					insertDevice.setString(2, txtSalesDeviceClientName.getText());
					insertDevice.setString(3, (String) cmbSalesDeviceName.getSelectedItem());
					insertDevice.setString(4, (String) txtSalesdeviceType.getSelectedItem());
					insertDevice.setString(5, txtSalesDeviceSerialNumber.getText());
					insertDevice.setString(6, (String) cmbSalesDeviceCondition.getSelectedItem());
					insertDevice.setString(7, (String) cmbSalesDevicePriority.getSelectedItem());
					SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						buyingDateFormat.setLenient(false);
						buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
					} catch (Exception e) {
					}
					insertDevice.setString(8, buyingDate);
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
					insertDevice.setString(9, addDate);
					SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
					insertDevice.setString(10, endDate);
					insertDevice.setString(11, (String) cmbSalesDeviceSoftver.getSelectedItem());
					insertDevice.setString(12, (String) cmbSalesDeviceHardver.getSelectedItem());
					insertDevice.setString(13, txtSalesDeviceClientID.getText());
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
					JOptionPane.showMessageDialog(null, "Adatok beillesztve");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
			}
		}
	}

	private void jBtnUpdateActionPerformedDevice(java.awt.event.ActionEvent evt) {
		String buyingDate = null;
		String newDevice = (String) cmbSalesDeviceCondition.getSelectedItem();
		if (newDevice != "Új gép") {
			if (checkInputsDevice()) {
				String updateDevice = null;
				PreparedStatement ps = null;
				Connection con = DataBaseConnect.getConnection();
				try {
					updateDevice = "UPDATE gepadatok SET ugyfel_nev = ?, eszkoz_g = ?, tipus = ?, sorozatszam_g = ?"
							+ ", allapot = ?, prioritas = ?, vasarlas_ido = ?, rogzites = ?"
							+ ", hatarido = ?, softwer = ?, hardwer = ?, takaritas = ?"
							+ ", jelszo = ?, tartozekok = ?, serules = ?"
							+ ", hiba_leiras = ?, megrendelo_ID_m = ? WHERE ID_g = ?";
					ps = con.prepareStatement(updateDevice);
					ps.setString(1, txtSalesDeviceClientName.getText());
					ps.setString(2, (String) cmbSalesDeviceName.getSelectedItem());
					ps.setString(3, (String) txtSalesdeviceType.getSelectedItem());
					ps.setString(4, txtSalesDeviceSerialNumber.getText());
					ps.setString(5, (String) cmbSalesDeviceCondition.getSelectedItem());
					ps.setString(6, (String) cmbSalesDevicePriority.getSelectedItem());
					SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						buyingDateFormat.setLenient(false);
						buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
					} catch (Exception e) {
					}
					ps.setString(7, buyingDate);
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
					ps.setString(8, addDate);
					SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
					ps.setString(9, endDate);
					ps.setString(10, (String) cmbSalesDeviceSoftver.getSelectedItem());
					ps.setString(11, (String) cmbSalesDeviceHardver.getSelectedItem());
					ps.setString(12, (String) cmbSalesDeviceCleaning.getSelectedItem());
					ps.setString(13, txtSalesDevicePassword.getText());
					ps.setString(14, txtSalesDeviceAccesssory.getText());
					ps.setString(15, txtSalesDeviceInjury.getText());
					ps.setString(16, txtSalesDeviceComment.getText());
					ps.setString(17, txtSalesDeviceClientID.getText());
					ps.setInt(18, Integer.parseInt(txtSalesDeviceID.getText()));
					ps.executeUpdate();
					showProductsInJTableDevice();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (SQLException ex) {
					Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
			}
		} else if (newDevice == "Új gép") {
			if (checkInputsNewDevice()) {
				String updateDevice = null;
				PreparedStatement ps = null;
				Connection con = DataBaseConnect.getConnection();
				try {
					updateDevice = "UPDATE gepadatok SET ugyfel_nev = ?, eszkoz_g = ?, tipus = ?, sorozatszam_g = ?,"
							+ "allapot = ?, prioritas = ?, vasarlas_ido = ?, rogzites = ?,"
							+ "hatarido = ?, softwer = ?, hardwer = ?," + " megrendelo_ID_m = ? WHERE ID_g = ?";
					ps = con.prepareStatement(updateDevice);
					ps.setString(1, txtSalesDeviceClientName.getText());
					ps.setString(2, (String) cmbSalesDeviceName.getSelectedItem());
					ps.setString(3, (String) txtSalesdeviceType.getSelectedItem());
					ps.setString(4, txtSalesDeviceSerialNumber.getText());
					ps.setString(5, (String) cmbSalesDeviceCondition.getSelectedItem());
					ps.setString(6, (String) cmbSalesDevicePriority.getSelectedItem());
					SimpleDateFormat buyingDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						buyingDateFormat.setLenient(false);
						buyingDate = buyingDateFormat.format(dateSalesDeviceBuying.getDate());
					} catch (Exception e) {
					}
					ps.setString(7, buyingDate);
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					addDate = addDateFormat.format(dateSalesDeviceAddDate.getDate());
					ps.setString(8, addDate);
					SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String endDate = endDateFormat.format(dateSalesDeviceEndDate.getDate());
					ps.setString(9, endDate);
					ps.setString(10, (String) cmbSalesDeviceSoftver.getSelectedItem());
					ps.setString(11, (String) cmbSalesDeviceHardver.getSelectedItem());
					ps.setString(12, txtSalesDeviceClientID.getText());
					ps.setInt(13, Integer.parseInt(txtSalesDeviceID.getText()));
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
			} catch (SQLException ex) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void colorSetText() {
		txtSalesdeviceType.setBackground(Color.BLACK);
		cmbSalesDeviceName.setBackground(Color.BLACK);
		cmbSalesDeviceCondition.setBackground(Color.BLACK);
		cmbSalesDevicePriority.setBackground(Color.BLACK);
		dateSalesDeviceBuying.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceAddDate.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceEndDate.setBackground(Color.LIGHT_GRAY);
		cmbSalesDeviceSoftver.setBackground(Color.BLACK);
		cmbSalesDeviceCleaning.setBackground(Color.BLACK);
		txtSalesDevicePassword.setBackground(Color.WHITE);
		txtSalesDeviceAccesssory.setBackground(Color.WHITE);
		txtSalesDeviceInjury.setBackground(Color.WHITE);
		txtSalesDeviceComment.setBackground(Color.WHITE);
	}

	private void btnNullShowPerformed() {
		txtSalesdeviceType.setSelectedItem(null);
		txtSalesdeviceType.setBackground(Color.BLACK);
		txtSalesDeviceClientID.setText(null); // fix
		txtSalesDeviceClientName.setText(null); // fix
		txtSalesDeviceSerialNumber.setText("Nincs");
		cmbSalesDeviceName.setSelectedIndex(-1);
		cmbSalesDeviceName.setBackground(Color.BLACK);
		txtSalesDeviceID.setText(null); // fix
		cmbSalesDeviceCondition.setSelectedItem(null);
		cmbSalesDeviceCondition.setBackground(Color.BLACK);
		cmbSalesDevicePriority.setSelectedItem(null);
		cmbSalesDevicePriority.setBackground(Color.BLACK);
		dateSalesDeviceBuying.setDate(null);
		dateSalesDeviceBuying.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceAddDate.setDate(null);
		dateSalesDeviceAddDate.setBackground(Color.LIGHT_GRAY);
		dateSalesDeviceEndDate.setDate(null);
		dateSalesDeviceEndDate.setBackground(Color.LIGHT_GRAY);
		cmbSalesDeviceSoftver.setSelectedItem(null);
		cmbSalesDeviceSoftver.setBackground(Color.BLACK);
		cmbSalesDeviceHardver.setSelectedItem(null);
		cmbSalesDeviceHardver.setBackground(Color.BLACK);
		cmbSalesDeviceCleaning.setSelectedItem(null);
		cmbSalesDeviceCleaning.setBackground(Color.BLACK);
		txtSalesDevicePassword.setText("-");
		txtSalesDevicePassword.setBackground(Color.WHITE);
		txtSalesDeviceAccesssory.setText("-");
		txtSalesDeviceAccesssory.setBackground(Color.WHITE);
		txtSalesDeviceInjury.setText("-");
		txtSalesDeviceInjury.setBackground(Color.WHITE);
		txtSalesDeviceComment.setText(null);
		txtSalesDeviceComment.setBackground(Color.WHITE);
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
