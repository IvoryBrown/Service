package ex.main.sales.worktablet;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ex.main.sales.worktablet.config.WorkTableConfig;
import ex.main.sales.worktablet.config.WorkTableImplements;
import ex.main.sales.worktablet.gui.WorkTableGui;
import ex.main.setting.database.DataBaseConnect;

public class WorkTableJDBCSetDAO extends WorkTableGui implements WorkTableImplements {
	private String[] rows;
	private Object columns[][];
	private static final int ENDDATE_COL = 11;
	private static final int PRIORYT_COL = 6;

	public WorkTableJDBCSetDAO() {
		setComponent();
		showProductsInJTable();
		getNewRenderedTable(jtblSalesWorkTable);
		// tableRows();
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
				showProductsInJTable();
			}
		});
		txtWorkSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					showProductsInJTable();
				}
			}
		});
	}

	// private void tableRows() {
	// TableRowSorter<TableModel> tableRowSorter = new
	// TableRowSorter<TableModel>(jtblSalesWorkTable.getModel());
	// tableRowSorter.setComparator(0, new Comparator<String>() {
	//
	// @Override
	// public int compare(String s1, String s2) {
	// if (s1.isEmpty() && s2.isEmpty()) {
	// return 0;
	// } else if (s1.isEmpty() && !s2.isEmpty()) {
	// return 1;
	// } else if (!s1.isEmpty() && s2.isEmpty()) {
	// return -1;
	// }
	// return s1.compareTo(s2);
	// }
	// });
	// jtblSalesWorkTable.setRowSorter(tableRowSorter);
	// }

	@SuppressWarnings("serial")
	private JTable getNewRenderedTable(JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
				String endDate = (String) table.getModel().getValueAt(row, ENDDATE_COL);
				String pryorit = (String) table.getModel().getValueAt(row, PRIORYT_COL);
				if (endDate == null && "Új gép".equals(pryorit)) {
					setForeground(Color.WHITE);
				} else if (endDate == null && "Bevizgálás alatt".equals(pryorit)) {
					setForeground(Color.WHITE);
				} else if (endDate == null && "Alkatrészre vár".equals(pryorit)) {
					setForeground(Color.WHITE);
				} else if (endDate == null && "Garanciális".equals(pryorit)) {
					setForeground(Color.WHITE);
				} else if (endDate == null && "Továbbküldve".equals(pryorit)) {
					setForeground(Color.WHITE);
				} else if ("Kiadva".equals(pryorit) && endDate != null) {
					setForeground(new Color(153, 0, 0));
				} else if ("Bevételezve".equals(pryorit) && endDate == null) {
					setForeground(Color.ORANGE);
				} else {
					setForeground(new Color(102, 153, 204));
				}
				return this;
			}
		});
		return table;
	}

	@Override
	public ArrayList<WorkTableConfig> getWorktableSearchProductList() {
		ArrayList<WorkTableConfig> listSearch = new ArrayList<WorkTableConfig>();
		ResultSet rs = null;
		Statement insertWork = null;
		Connection con = DataBaseConnect.getConnection();
		try {

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
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (insertWork != null) {
					insertWork.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(WorkTableJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return listSearch;
	}

	public void showProductsInJTable() {
		ArrayList<WorkTableConfig> list = getWorktableSearchProductList();
		DefaultTableModel model = (DefaultTableModel) jtblSalesWorkTable.getModel();
		model.setRowCount(0);
		Object[] row = new Object[12];
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
		lblOrderListClientID.setText(getWorktableSearchProductList().get(index).getWorkTableClientNumber());
		lblOrderListClientName.setText(getWorktableSearchProductList().get(index).getWorkTableClientName());
		lblOrderListClientMobil.setText(getWorktableSearchProductList().get(index).getWorkTableClientMobil());
		lblOrderListHomeAndress.setText(getWorktableSearchProductList().get(index).getWorkTableClientHomeAddress());
		lblOrderListClientComment.setText(getWorktableSearchProductList().get(index).getWorkTableClientComment());
		// eszköz
		lblOrderClientDeviceID
				.setText(Integer.toString(getWorktableSearchProductList().get(index).getWorkTableDeviceID()));
		lblOrderListDeviceName.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceName());
		lblOrderListDeviceType.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceType());
		lblOrderListDeviceSerialNumber.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceSerial());
		lblOrderListDeviceStatus.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceStatus());
		lblOrderListDevicePriorit.setText(getWorktableSearchProductList().get(index).getWorkTableDevicePriorit());
		lblOrderListDeviceBuyDate.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceBuyingDate());
		lblOrderListDeviceAddDate.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAddDate());
		lblOrderListDeviceEndDate.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceExitDate());
		lblOrderListDeviceCompletDate
				.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceCompletedDate());
		lblOrderListDeviceSoftver.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceSoftwer());
		lblOrderListDeviceHardver.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceHardver());
		lblOrderListDeviceCliening.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceCleaning());
		lblOrderListDevicePassword.setText(getWorktableSearchProductList().get(index).getWorkTableDevicePassword());
		lblOrderListDeviceAccessories
				.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAccesssory());
		lblOrderListDeviceInjury.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceInjury());
		lblOrderListDeviceFault.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceFault());
		lblOrderListDeviceError.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceError());
		// Nyomtatás
		lblWorkPrintClientName.setText(getWorktableSearchProductList().get(index).getWorkTableClientName());
		lblWorkPrintClientHomeAndress
				.setText(getWorktableSearchProductList().get(index).getWorkTableClientHomeAddress());
		lblWorkPrintClientMobil.setText(getWorktableSearchProductList().get(index).getWorkTableClientMobil());
		lblWorkPrintClientIdentification.setText(getWorktableSearchProductList().get(index).getWorkTableClientNumber());
		lblWorkPrintClientName0.setText(getWorktableSearchProductList().get(index).getWorkTableClientName());
		lblWorkPrintClientHomeAndress0
				.setText(getWorktableSearchProductList().get(index).getWorkTableClientHomeAddress());
		lblWorkPrintClientMobil0.setText(getWorktableSearchProductList().get(index).getWorkTableClientMobil());
		lblWorkPrintClientIdentification0
				.setText(getWorktableSearchProductList().get(index).getWorkTableClientNumber());
		lblWorkPrintDeviceName.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceName());
		lblWorkPrintDeviceSerial.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceType());
		lblWorkPrintDeviceBuys.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceBuyingDate());
		lblWorkPrintDeviceAddDate.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAddDate());
		lblWorkPrintDeviceAccessory.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAccesssory());
		lblWorkPrintDevicePassword.setText(getWorktableSearchProductList().get(index).getWorkTableDevicePassword());
		String sWorkPrintDeviceInjury = getWorktableSearchProductList().get(index).getWorkTableDeviceInjury();
		lblWorkPrintDeviceInjury.setText("<html>" + sWorkPrintDeviceInjury + "<br /> </html>");
		String sWorkPrintDeviceFault = getWorktableSearchProductList().get(index).getWorkTableDeviceFault();
		lblWorkPrintDeviceFault.setText("<html>" + sWorkPrintDeviceFault + "<br /> </html>");
		lblWorkPrintEndDate.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceExitDate());
		lblWorkPrintDeviceName0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceName());
		lblWorkPrintDeviceSerial0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceType());
		lblWorkPrintDeviceBuys0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceBuyingDate());
		lblWorkPrintDeviceAddDate0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAddDate());
		lblWorkPrintDeviceAccessory0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceAccesssory());
		lblWorkPrintDevicePassword0.setText(getWorktableSearchProductList().get(index).getWorkTableDevicePassword());
		String sWorkPrintDeviceInjury0 = getWorktableSearchProductList().get(index).getWorkTableDeviceInjury();
		lblWorkPrintDeviceInjury0.setText("<html>" + sWorkPrintDeviceInjury0 + "<br /> </html>");
		String sWorkPrintDeviceFault0 = getWorktableSearchProductList().get(index).getWorkTableDeviceFault();
		lblWorkPrintDeviceFault0.setText("<html>" + sWorkPrintDeviceFault0 + "<br /> </html>");
		lblWorkPrintEndDate0.setText(getWorktableSearchProductList().get(index).getWorkTableDeviceExitDate());
	}

	private void jTableProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = jtblSalesWorkTable.getSelectedRow();
		showItemWorkTabel(index);
	}

	private void JTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
		lblWorkPrintSalesName.setText(null);
		lblWorkPrintSalesName0.setText(null);
		txtWorkPrintSalesName.setText(null);
		txtWorkSearch.setText(null);
		showProductsInJTable();
	}

}
