package ex.main.service.softver;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import ex.main.service.client.ClientJDBCSetDAO;
import ex.main.service.softver.config.SoftverConfig;
import ex.main.service.softver.config.SoftverImplements;
import ex.main.service.softver.gui.SoftverGui;
import ex.main.setting.database.DataBaseConnect;

public class SoftverJDBCSetDao extends SoftverGui implements SoftverImplements {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columns;

	public SoftverJDBCSetDao() {
		setActionSoftver();
		showProductsInJTableSoftver();
	}

	private void setActionSoftver() {
		columns = new String[] { "ID", "azonosító", "softver" };
		tblSoftver.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columns));
		tblSoftver.getColumn("ID").setMinWidth(50);
		tblSoftver.getColumn("ID").setMaxWidth(50);
		tblSoftver.getColumn("azonosító").setMinWidth(80);
		tblSoftver.getColumn("azonosító").setMaxWidth(80);
		tblSoftver.getTableHeader().setReorderingAllowed(false);

		tblSoftver.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedDevice(evt);
			}
		});
		btnSoftverNewSoftver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedSoftver(evt);
			}
		});
		btnSoftverEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedSoftver(evt);
			}
		});
		btnSoftverDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedSoftver(evt);
				else
					return;
			}
		});
		btnSoftverNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformedSoftver(evt);
			}
		});
		btnSoftverSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				showProductsInJTableSoftver();
			}
		});
		txtSoftverSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					showProductsInJTableSoftver();
				}
			}
		});

	}

	private boolean checkInputsSoftver() {
		if (txtSoftverDeviceId.getText().trim().isEmpty() || cmbSoftverName.getSelectedItem() == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public ArrayList<SoftverConfig> getSoftverProductList() {
		ArrayList<SoftverConfig> productListSoftver = new ArrayList<SoftverConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM `software` WHERE CONCAT (`gepadatok_ID_gs`) LIKE '%" + txtSoftverSearch.getText()
				+ "%'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			SoftverConfig product;
			while (rs.next()) {
				product = new SoftverConfig(rs.getInt("ID_sofware"), rs.getString("software"),
						rs.getString("megjegyzes_s"), rs.getInt("gepadatok_ID_gs"));
				productListSoftver.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(SoftverJDBCSetDao.class.getName()).log(Level.SEVERE, null, ex);
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
		return productListSoftver;
	}

	private void showProductsInJTableSoftver() {
		ArrayList<SoftverConfig> list = getSoftverProductList();
		DefaultTableModel model = (DefaultTableModel) tblSoftver.getModel();
		model.setRowCount(0);
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSoftverId();
			row[1] = list.get(i).getSoftverDeviceId();
			row[2] = list.get(i).getSoftverName();
			model.addRow(row);
		}
	}

	private void ShowItemSoftver(int index) {
		txtSoftverDeviceId.setText(Integer.toString(getSoftverProductList().get(index).getSoftverDeviceId()));
		txtSoftverID.setText(Integer.toString(getSoftverProductList().get(index).getSoftverId()));
		txtAreaSoftverComment.setText(getSoftverProductList().get(index).getSoftverComment());
		cmbSoftverName.setSelectedItem(getSoftverProductList().get(index).getSoftverName());
	}

	private void jBtnInsertActionPerformedSoftver(java.awt.event.ActionEvent evt) {
		if (checkInputsSoftver()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertInto = con.prepareStatement(
						"INSERT INTO software(software, megjegyzes_s, gepadatok_ID_gs)" + "values(?,?,?) ");
				insertInto.setString(1, (String) cmbSoftverName.getSelectedItem());
				insertInto.setString(2, txtAreaSoftverComment.getText());
				insertInto.setString(3, txtSoftverDeviceId.getText());
				insertInto.executeUpdate();
				showProductsInJTableSoftver();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedSoftver(java.awt.event.ActionEvent evt) {
		if (checkInputsSoftver()) {
			String update = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				update = "UPDATE software SET  software = ?, megjegyzes_s = ?, gepadatok_ID_gs = ? WHERE ID_sofware = ?";
				ps = con.prepareStatement(update);
				ps.setString(1, (String) cmbSoftverName.getSelectedItem());
				ps.setString(2, txtAreaSoftverComment.getText());
				ps.setString(3, txtSoftverDeviceId.getText());
				ps.setInt(4, Integer.parseInt(txtSoftverID.getText()));
				ps.executeUpdate();
				showProductsInJTableSoftver();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(SoftverJDBCSetDao.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedSoftver(java.awt.event.ActionEvent evt) {
		if (!txtSoftverID.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement delete = con.prepareStatement("DELETE FROM software WHERE ID_sofware = ? ");
				int id = Integer.parseInt(txtSoftverID.getText());
				delete.setInt(1, id);
				delete.executeUpdate();
				showProductsInJTableSoftver();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(SoftverJDBCSetDao.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void btnNullShowPerformedSoftver(java.awt.event.ActionEvent evt) {
		txtSoftverDeviceId.setText(null);
		txtSoftverID.setText(null);
		txtAreaSoftverComment.setText(null);
		cmbSoftverName.setSelectedItem(null);
		txtSoftverSearch.setText(null);
		showProductsInJTableSoftver();
	}

	private void JTable_ProductsMouseClickedDevice(java.awt.event.MouseEvent evt) {
		int index = tblSoftver.getSelectedRow();
		ShowItemSoftver(index);
	}
}
