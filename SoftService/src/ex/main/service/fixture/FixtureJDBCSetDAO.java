package ex.main.service.fixture;

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

import ex.main.sales.device.DeviceJDBCSetDAO;
import ex.main.service.fixture.config.FixtureConfig;
import ex.main.service.fixture.config.FixtureImplements;
import ex.main.service.fixture.gui.FixtureGui;
import ex.main.setting.database.DataBaseConnect;

public class FixtureJDBCSetDAO extends FixtureGui implements FixtureImplements {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1607088146574330251L;
	private String row[];

	public FixtureJDBCSetDAO() {
		setActionFixture();
		showProductsInJTableFixture();
	}

	private void setActionFixture() {
		row = new String[] { "ID", "azonosító", "típus", "gyártó", "serial" };
		tblFixture.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, row));
		tblFixture.getColumn("ID").setMinWidth(50);
		tblFixture.getColumn("ID").setMaxWidth(50);
		tblFixture.getColumn("azonosító").setMinWidth(100);
		tblFixture.getColumn("azonosító").setMaxWidth(100);
		tblFixture.getColumn("típus").setMinWidth(130);
		tblFixture.getColumn("típus").setMaxWidth(130);
		tblFixture.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedFixture(evt);
			}
		});
		btnFixtureNewFixture.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedFixture(evt);
			}
		});
		btnFixtureEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedFixture(evt);
			}
		});
		btnFixtureDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedFixture(evt);
				else
					return;
			}
		});
		btnFixtureNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformedFixture(evt);
			}
		});
		btnFixtureSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				showProductsInJTableFixture();
			}
		});
		txtFixtureSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					showProductsInJTableFixture();
				}
			}
		});
	}

	private boolean checkInputsFixture() {
		if (txtFixtureName.getText().trim().isEmpty() || txtFixtureSerial.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public ArrayList<FixtureConfig> getFixtureProductList() {
		ArrayList<FixtureConfig> productListFixture = new ArrayList<FixtureConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM `alkatresz` WHERE CONCAT (`gepadatok_ID_ga`) LIKE '%" + txtFixtureSearch.getText()
				+ "%'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			FixtureConfig product;
			while (rs.next()) {
				product = new FixtureConfig(rs.getInt("ID_a"), rs.getString("alkatresz_tipus"), rs.getString("gyarto"),
						rs.getString("alkatresz_serial"), rs.getString("megjegyzes_a"), rs.getInt("gepadatok_ID_ga"));
				productListFixture.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(FixtureJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		return productListFixture;
	}

	private void showProductsInJTableFixture() {
		ArrayList<FixtureConfig> list = getFixtureProductList();
		DefaultTableModel model = (DefaultTableModel) tblFixture.getModel();
		model.setRowCount(0);
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getFixtureId();
			row[1] = list.get(i).getFixtureDeviceId();
			row[2] = list.get(i).getFixtureName();
			row[3] = list.get(i).getFixtureManufacturer();
			row[4] = list.get(i).getFixtureSerial();
			model.addRow(row);
		}
	}

	private void ShowItemFixture(int index) {
		txtFixtureDeviceId.setText(Integer.toString(getFixtureProductList().get(index).getFixtureDeviceId()));
		txtFixtureManufacturer.setText(getFixtureProductList().get(index).getFixtureManufacturer());
		txtFixtureId.setText(Integer.toString(getFixtureProductList().get(index).getFixtureId()));
		txtFixtureName.setText(getFixtureProductList().get(index).getFixtureName());
		txtFixtureSerial.setText(getFixtureProductList().get(index).getFixtureSerial());
		txtAreaFixtureComment.setText(getFixtureProductList().get(index).getFixtureComment());

	}

	private void jBtnInsertActionPerformedFixture(java.awt.event.ActionEvent evt) {
		if (checkInputsFixture()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertInto = con.prepareStatement(
						"INSERT INTO alkatresz(alkatresz_tipus, gyarto, alkatresz_serial, megjegyzes_a, gepadatok_ID_ga)"
								+ "values(?,?,?,?,?) ");
				insertInto.setString(1, txtFixtureName.getText());
				insertInto.setString(2, txtFixtureManufacturer.getText());
				insertInto.setString(3, txtFixtureSerial.getText());
				insertInto.setString(4, txtAreaFixtureComment.getText());
				insertInto.setString(5, txtFixtureDeviceId.getText());
				insertInto.executeUpdate();
				showProductsInJTableFixture();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedFixture(java.awt.event.ActionEvent evt) {
		if (checkInputsFixture()) {
			String update = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				update = "UPDATE alkatresz SET alkatresz_tipus = ?, gyarto = ?, alkatresz_serial = ?, megjegyzes_a = ?"
						+ ", gepadatok_ID_ga = ? WHERE ID_a = ?";
				ps = con.prepareStatement(update);
				ps.setString(1, txtFixtureName.getText());
				ps.setString(2, txtFixtureManufacturer.getText());
				ps.setString(3, txtFixtureSerial.getText());
				ps.setString(4, txtAreaFixtureComment.getText());
				ps.setString(5, txtFixtureDeviceId.getText());
				ps.setInt(6, Integer.parseInt(txtFixtureId.getText()));
				ps.executeUpdate();
				showProductsInJTableFixture();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(FixtureJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedFixture(java.awt.event.ActionEvent evt) {
		if (!txtFixtureId.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement delete = con.prepareStatement("DELETE FROM alkatresz WHERE ID_a = ? ");
				int id = Integer.parseInt(txtFixtureId.getText());
				delete.setInt(1, id);
				delete.executeUpdate();
				showProductsInJTableFixture();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(FixtureJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void btnNullShowPerformedFixture(java.awt.event.ActionEvent evt) {
		txtFixtureDeviceId.setText(null);
		txtFixtureId.setText(null);
		txtFixtureName.setText(null);
		txtFixtureSerial.setText(null);
		txtAreaFixtureComment.setText(null);
		txtFixtureManufacturer.setText(null);
		txtFixtureSearch.setText(null);
		showProductsInJTableFixture();
	}

	private void JTable_ProductsMouseClickedFixture(java.awt.event.MouseEvent evt) {
		int index = tblFixture.getSelectedRow();
		ShowItemFixture(index);
	}
}
