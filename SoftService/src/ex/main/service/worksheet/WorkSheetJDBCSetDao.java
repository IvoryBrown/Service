package ex.main.service.worksheet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ex.main.service.worksheet.config.WorkSheetConfig;
import ex.main.service.worksheet.config.WorkSheetImplements;
import ex.main.service.worksheet.gui.WorksheetGui;
import ex.main.setting.DataBaseConnect;

public class WorkSheetJDBCSetDao extends WorksheetGui implements WorkSheetImplements {
	protected String[] columns;

	public WorkSheetJDBCSetDao() {
		setComponentJdbc();
		showProductsInJTableWorkSheet();
		tablerows();

	}

	private void setComponentJdbc() {

		columns = new String[] { "ügyfél", "eszköz", "állapot", "prioritás", "rögzítés", "határidő", "lezárva" };
		tblWorksheet.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columns));
		// oszlop méretezés
		// tblWorksheet.getColumn("ID").setMaxWidth(36);
		// oszlopok rendezés letíltás
		tblWorksheet.getTableHeader().setReorderingAllowed(false);

		btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTableProductsMouseClicked(evt);
			}
		});

	}

	@Override
	public ArrayList<WorkSheetConfig> getWorkShettProductList() {
		ArrayList<WorkSheetConfig> productList = new ArrayList<WorkSheetConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM gepadatok ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			WorkSheetConfig product;
			while (rs.next()) {
				product = new WorkSheetConfig(rs.getString("ugyfel_nev"), rs.getString("eszkoz_g"),
						rs.getString("allapot"), rs.getString("prioritas"), rs.getString("rogzites"),
						rs.getString("hatarido"), rs.getString("teljesitve"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(WorkSheetJDBCSetDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	private void showProductsInJTableWorkSheet() {
		ArrayList<WorkSheetConfig> list = getWorkShettProductList();
		DefaultTableModel model = (DefaultTableModel) tblWorksheet.getModel();
		model.setRowCount(0);
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getClientNameWorkSheet();
			row[1] = list.get(i).getDeviceNameWorkSheet();
			row[2] = list.get(i).getStatusWorkSheet();
			row[3] = list.get(i).getPrioritWorkSheet();
			row[4] = list.get(i).getAddDateWorkSheet();
			row[5] = list.get(i).getEndDateWorkSheet();
			row[6] = list.get(i).getCompleteDateWorkSheet();
			model.addRow(row);
		}
	}

	private void tablerows() {
		TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(tblWorksheet.getModel());
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
		tblWorksheet.setRowSorter(tableRowSorter);

	}

	private void JTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
		showProductsInJTableWorkSheet();
	}
}
