package ex.main.service.worksheet;

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

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ex.main.gui.MainGuiSet;
import ex.main.service.client.ClientJDBCSetDAO;
import ex.main.service.worksheet.config.WorkSheetConfig;
import ex.main.service.worksheet.config.WorkSheetImplements;
import ex.main.service.worksheet.gui.WorksheetGui;
import ex.main.setting.database.DataBaseConnect;

public class WorkSheetJDBCSetDao extends WorksheetGui implements WorkSheetImplements {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] row;
	private static final int ENDDATE_COL = 9;
	private static final int PRIORYT_COL = 5;

	public WorkSheetJDBCSetDao() {
		setComponentJdbc();
		showProductsInJTableWorkSheet();
		getNewRenderedTable(tblWorksheet);
	}

	private void setComponentJdbc() {

		row = new String[] { " ","azonosító", "ügyfél", "e. azonosító", "eszköz", "állapot", "prioritás", "rögzítés",
				"határidő", "lezárva" };
		tblWorksheet.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, row));
		tblWorksheet.getColumn(" ").setMinWidth(36);
		tblWorksheet.getColumn(" ").setMaxWidth(36);
		// oszlop méretezés
		// tblWorksheet.getColumn("ID").setMaxWidth(36);
		// oszlopok rendezés letíltás
		tblWorksheet.getTableHeader().setReorderingAllowed(false);

		btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTableProductsMouseClicked(evt);
			}
		});
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new MainGuiSet().setVisible(true);
				dispose();
			}
		});
		btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				showProductsInJTableWorkSheet();
			}
		});
		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					showProductsInJTableWorkSheet();
				}
			}
		});
	}

	@Override
	public ArrayList<WorkSheetConfig> getWorkShettProductList() {
		ArrayList<WorkSheetConfig> productList = new ArrayList<WorkSheetConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM megrendelo " + " JOIN gepadatok ON megrendelo_ID_m = ID_m WHERE CONCAT (`"
				+ cmbSearch.getSelectedItem() + "`) LIKE '%" + txtSearch.getText() + "%'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			WorkSheetConfig product;
			while (rs.next()) {
				product = new WorkSheetConfig(rs.getString("azonosito_m"), rs.getString("ugyfel_nev"),
						rs.getInt("ID_g"), rs.getString("eszkoz_g"), rs.getString("allapot"), rs.getString("prioritas"),
						rs.getString("rogzites"), rs.getString("hatarido"), rs.getString("teljesitve"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(WorkSheetJDBCSetDao.class.getName()).log(Level.SEVERE, null, ex);
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
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return productList;
	}

	private void showProductsInJTableWorkSheet() {
		ArrayList<WorkSheetConfig> list = getWorkShettProductList();
		DefaultTableModel model = (DefaultTableModel) tblWorksheet.getModel();
		model.setRowCount(0);
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = i+1;
			row[1] = list.get(i).getClientNameNumber();
			row[2] = list.get(i).getClientNameWorkSheet();
			row[3] = list.get(i).getDeviceId();
			row[4] = list.get(i).getDeviceNameWorkSheet();
			row[5] = list.get(i).getStatusWorkSheet();
			row[6] = list.get(i).getPrioritWorkSheet();
			row[7] = list.get(i).getAddDateWorkSheet();
			row[8] = list.get(i).getEndDateWorkSheet();
			row[9] = list.get(i).getCompleteDateWorkSheet();
			model.addRow(row);
		}
	}

	@SuppressWarnings("serial")
	private JTable getNewRenderedTable(JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
				String endDate = (String) table.getModel().getValueAt(row, ENDDATE_COL);
				String pryorit = (String) table.getModel().getValueAt(row, PRIORYT_COL);
				if ("Új gép".equals(pryorit) && endDate == null) {
					setForeground(Color.WHITE);
				} else if ("Bevizsgálás alatt".equals(pryorit) && endDate == null) {
					setForeground(Color.WHITE);
				} else if ("Alkatrészre vár".equals(pryorit) && endDate == null) {
					setForeground(Color.WHITE);
				} else if ("Garanciális".equals(pryorit) && endDate == null) {
					setForeground(Color.WHITE);
				} else if ("Továbbküldve".equals(pryorit) && endDate == null) {
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

	private void JTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
		txtSearch.setText(null);
		showProductsInJTableWorkSheet();
	}
}
