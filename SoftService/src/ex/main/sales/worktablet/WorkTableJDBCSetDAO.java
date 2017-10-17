package ex.main.sales.worktablet;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		tableRows();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7705930576442305488L;

	private void setComponent() {
		rows = new String[] { "azonosító", "ügyfél", "kapcsolat", "lakcím", "e. azonosító", "eszköz", "állapot",
				"prioritás", "vásárlás", "rögzítés", "határidő", "teljesítve" };
		jtblSalesWorkTable.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblSalesWorkTable.getColumn("azonosító").setMinWidth(100);
		jtblSalesWorkTable.getColumn("azonosító").setMaxWidth(100);
		jtblSalesWorkTable.getColumn("ügyfél").setMinWidth(160);
		jtblSalesWorkTable.getColumn("ügyfél").setMaxWidth(160);
		jtblSalesWorkTable.getColumn("kapcsolat").setMinWidth(130);
		jtblSalesWorkTable.getColumn("kapcsolat").setMaxWidth(130);
		jtblSalesWorkTable.getColumn("lakcím").setMinWidth(260);
		jtblSalesWorkTable.getColumn("lakcím").setMaxWidth(260);
		jtblSalesWorkTable.getColumn("e. azonosító").setMinWidth(120);
		jtblSalesWorkTable.getColumn("e. azonosító").setMaxWidth(120);
		jtblSalesWorkTable.getColumn("eszköz").setMinWidth(120);
		jtblSalesWorkTable.getColumn("eszköz").setMaxWidth(120);
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
		jtblSalesWorkTable.getTableHeader().setReorderingAllowed(false);
		jtblSalesWorkTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableProductsMouseClickedDevice(evt);

			}
		});
		btnWorkUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTableProductsMouseClicked(evt);
			}
		});
		btnWorkSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableWorkSearch();
			}
		});
		txtWorkSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					jTableWorkSearch();
				}
			}
		});
	}

	private void tableRows() {
		TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(jtblSalesWorkTable.getModel());
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
		jtblSalesWorkTable.setRowSorter(tableRowSorter);
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
		ArrayList<WorkTableConfig> listSearch = new ArrayList<WorkTableConfig>();
		ResultSet rs;
		Statement insertWork;
		try {

			Connection con = DataBaseConnect.getConnection();
			insertWork = con.createStatement();
			String searchQuery = "SELECT * FROM `megrendelo` JOIN gepadatok ON megrendelo_ID_m = ID_m  WHERE CONCAT (`"
					+ cmbWorkSearch.getItemAt(cmbWorkSearch.getSelectedIndex()) + "`) LIKE '%" + txtWorkSearch.getText()
					+ "%'";
			rs = insertWork.executeQuery(searchQuery);
			WorkTableConfig workSearch;
			while (rs.next()) {
				workSearch = new WorkTableConfig(rs.getString("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"),
						rs.getInt("ID_g"), rs.getString("eszkoz_g"), rs.getString("tipus"),
						rs.getString("sorozatszam_g"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("vasarlas_ido"), rs.getString("rogzites"), rs.getString("hatarido"),
						rs.getString("teljesitve"), rs.getString("softwer"), rs.getString("hardwer"),
						rs.getString("takaritas"), rs.getString("jelszo"), rs.getString("tartozekok"),
						rs.getString("serules"), rs.getString("hiba_leiras"), rs.getString("valos_hiba"));
				listSearch.add(workSearch);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sikertelen Keresés: " + ex.getMessage());
		}
		return listSearch;
	}

	public void searchProductsInJTable() {
		ArrayList<WorkTableConfig> list = getWorktableSearchProductList();
		DefaultTableModel model = (DefaultTableModel) jtblSalesWorkTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[23];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getWorkTableClientNumber();
			row[1] = list.get(i).getWorkTableClientName();
			row[2] = list.get(i).getWorkTableClientMobil();
			row[3] = list.get(i).getWorkTableClientHomeAddress();
			row[4] = list.get(i).getWorkTableDeviceID();
			row[5] = list.get(i).getWorkTableDeviceName();
			row[6] = list.get(i).getWorkTableDeviceStatus();
			row[7] = list.get(i).getWorkTableDevicePriorit();
			row[8] = list.get(i).getWorkTableDeviceBuyingDate();
			row[9] = list.get(i).getWorkTableDeviceAddDate();
			row[10] = list.get(i).getWorkTableDeviceExitDate();
			row[11] = list.get(i).getWorkTableDeviceCompletedDate();

			model.addRow(row);
		}
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
			row[4] = list.get(i).getWorkTableDeviceID();
			row[5] = list.get(i).getWorkTableDeviceName();
			row[6] = list.get(i).getWorkTableDeviceStatus();
			row[7] = list.get(i).getWorkTableDevicePriorit();
			row[8] = list.get(i).getWorkTableDeviceBuyingDate();
			row[9] = list.get(i).getWorkTableDeviceAddDate();
			row[10] = list.get(i).getWorkTableDeviceExitDate();
			row[11] = list.get(i).getWorkTableDeviceCompletedDate();

			model.addRow(row);
		}
	}

	private void showItemWorkTabel(int index) {
		lblOrderListClientID.setText(getWorktableProductList().get(index).getWorkTableClientNumber());
		lblOrderListClientName.setText(getWorktableProductList().get(index).getWorkTableClientName());
		lblOrderListClientMobil.setText(getWorktableProductList().get(index).getWorkTableClientMobil());
		lblOrderListHomeAndress.setText(getWorktableProductList().get(index).getWorkTableClientHomeAddress());
		lblOrderListClientComment.setText(getWorktableProductList().get(index).getWorkTableClientComment());
		// eszköz
		lblOrderClientDeviceID.setText(Integer.toString(getWorktableProductList().get(index).getWorkTableDeviceID()));
		lblOrderListDeviceName.setText(getWorktableProductList().get(index).getWorkTableDeviceName());
		lblOrderListDeviceType.setText(getWorktableProductList().get(index).getWorkTableDeviceType());
		lblOrderListDeviceSerialNumber.setText(getWorktableProductList().get(index).getWorkTableDeviceSerial());
		lblOrderListDeviceStatus.setText(getWorktableProductList().get(index).getWorkTableDeviceStatus());
		lblOrderListDevicePriorit.setText(getWorktableProductList().get(index).getWorkTableDevicePriorit());
		lblOrderListDeviceBuyDate.setText(getWorktableProductList().get(index).getWorkTableDeviceBuyingDate());
		lblOrderListDeviceAddDate.setText(getWorktableProductList().get(index).getWorkTableDeviceAddDate());
		lblOrderListDeviceEndDate.setText(getWorktableProductList().get(index).getWorkTableDeviceExitDate());
		lblOrderListDeviceCompletDate.setText(getWorktableProductList().get(index).getWorkTableDeviceCompletedDate());
		lblOrderListDeviceSoftver.setText(getWorktableProductList().get(index).getWorkTableDeviceSoftwer());
		lblOrderListDeviceHardver.setText(getWorktableProductList().get(index).getWorkTableDeviceHardver());
		lblOrderListDeviceCliening.setText(getWorktableProductList().get(index).getWorkTableDeviceCleaning());
		lblOrderListDevicePassword.setText(getWorktableProductList().get(index).getWorkTableDevicePassword());
		lblOrderListDeviceAccessories.setText(getWorktableProductList().get(index).getWorkTableDeviceAccesssory());
		lblOrderListDeviceInjury.setText(getWorktableProductList().get(index).getWorkTableDeviceInjury());
		lblOrderListDeviceFault.setText(getWorktableProductList().get(index).getWorkTableDeviceFault());
		lblOrderListDeviceError.setText(getWorktableProductList().get(index).getWorkTableDeviceError());
	}

	private void searchItemWorkTabel(int index) {
		lblOrderListClientID.setText(getWorktableProductList().get(index).getWorkTableClientNumber());
		lblOrderListClientName.setText(getWorktableProductList().get(index).getWorkTableClientName());
		lblOrderListClientMobil.setText(getWorktableProductList().get(index).getWorkTableClientMobil());
		lblOrderListHomeAndress.setText(getWorktableProductList().get(index).getWorkTableClientHomeAddress());
		lblOrderListClientComment.setText(getWorktableProductList().get(index).getWorkTableClientComment());
		// eszköz
		lblOrderClientDeviceID.setText(Integer.toString(getWorktableProductList().get(index).getWorkTableDeviceID()));
		lblOrderListDeviceName.setText(getWorktableProductList().get(index).getWorkTableDeviceName());
		lblOrderListDeviceType.setText(getWorktableProductList().get(index).getWorkTableDeviceType());
		lblOrderListDeviceSerialNumber.setText(getWorktableProductList().get(index).getWorkTableDeviceSerial());
		lblOrderListDeviceStatus.setText(getWorktableProductList().get(index).getWorkTableDeviceStatus());
		lblOrderListDevicePriorit.setText(getWorktableProductList().get(index).getWorkTableDevicePriorit());
		lblOrderListDeviceBuyDate.setText(getWorktableProductList().get(index).getWorkTableDeviceBuyingDate());
		lblOrderListDeviceAddDate.setText(getWorktableProductList().get(index).getWorkTableDeviceAddDate());
		lblOrderListDeviceEndDate.setText(getWorktableProductList().get(index).getWorkTableDeviceExitDate());
		lblOrderListDeviceCompletDate.setText(getWorktableProductList().get(index).getWorkTableDeviceCompletedDate());
		lblOrderListDeviceSoftver.setText(getWorktableProductList().get(index).getWorkTableDeviceSoftwer());
		lblOrderListDeviceHardver.setText(getWorktableProductList().get(index).getWorkTableDeviceHardver());
		lblOrderListDeviceCliening.setText(getWorktableProductList().get(index).getWorkTableDeviceCleaning());
		lblOrderListDevicePassword.setText(getWorktableProductList().get(index).getWorkTableDevicePassword());
		lblOrderListDeviceAccessories.setText(getWorktableProductList().get(index).getWorkTableDeviceAccesssory());
		lblOrderListDeviceInjury.setText(getWorktableProductList().get(index).getWorkTableDeviceInjury());
		lblOrderListDeviceFault.setText(getWorktableProductList().get(index).getWorkTableDeviceFault());
		lblOrderListDeviceError.setText(getWorktableProductList().get(index).getWorkTableDeviceError());
	}

	private void jTableProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jtblSalesWorkTable.getSelectedRow();
		showItemWorkTabel(index);
		searchItemWorkTabel(index);
	}

	private void JTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
		showProductsInJTable();
	}

	private void jTableWorkSearch() {
		searchProductsInJTable();
	}
}
