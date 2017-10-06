package ex.main.service.fixture;

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

import ex.main.service.fixture.config.FixtureConfig;
import ex.main.service.fixture.config.FixtureImplements;
import ex.main.service.fixture.gui.FixtureGui;
import ex.main.service.softver.SoftverJDBCSetDao;
import ex.main.setting.database.DataBaseConnect;

public class FixtureJDBCSetDAO extends FixtureGui implements FixtureImplements {
	String columns[];

	public FixtureJDBCSetDAO() {
		setActionFixture();
		showProductsInJTableFixture();
	}

	private void setActionFixture() {
		columns = new String[] { "eszköz", "típus", "serial" };
		tblFixture.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columns));
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
		String query = "SELECT * FROM alkatresz ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			FixtureConfig product;
			while (rs.next()) {
				product = new FixtureConfig(rs.getInt("ID_a"), rs.getString("eszkoz_nev_a"),
						rs.getString("eszkoz_serial_a"), rs.getString("alkatresz_tipus"),
						rs.getString("alkatresz_serial"), rs.getString("megjegyzes_a"), rs.getInt("gepadatok_ID_ga"));
				productListFixture.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(FixtureJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListFixture;
	}

	private void showProductsInJTableFixture() {
		ArrayList<FixtureConfig> list = getFixtureProductList();
		DefaultTableModel model = (DefaultTableModel) tblFixture.getModel();
		model.setRowCount(0);
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getFixtureDeviceName();
			row[1] = list.get(i).getFixtureName();
			row[2] = list.get(i).getFixtureSerial();
			model.addRow(row);
		}
	}

	private void ShowItemFixture(int index) {
		txtFixtureDeviceName.setText(getFixtureProductList().get(index).getFixtureDeviceName());
		txtFixtureDeviceId.setText(Integer.toString(getFixtureProductList().get(index).getFixtureDeviceId()));
		txtFixtureDeviceSerial.setText(getFixtureProductList().get(index).getFixtureDeviceSerial());
		txtFixtureId.setText(Integer.toString(getFixtureProductList().get(index).getFixtureId()));
		txtFixtureName.setText(getFixtureProductList().get(index).getFixtureName());
		txtFixtureSerial.setText(getFixtureProductList().get(index).getFixtureSerial());
		txtAreaFixtureComment.setText(getFixtureProductList().get(index).getFixtureComment());

	}

	private void jBtnInsertActionPerformedFixture(java.awt.event.ActionEvent evt) {
		if (checkInputsFixture()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertInto = con
						.prepareStatement("INSERT INTO alkatresz(eszkoz_nev_a, eszkoz_serial_a,"
								+ "alkatresz_tipus, alkatresz_serial, megjegyzes_a,gepadatok_ID_ga)"
								+ "values(?,?,?,?,?,?) ");
				insertInto.setString(1, txtFixtureDeviceName.getText());
				insertInto.setString(2, txtFixtureDeviceSerial.getText());
				insertInto.setString(3, txtFixtureName.getText());
				insertInto.setString(4, txtFixtureSerial.getText());
				insertInto.setString(5, txtAreaFixtureComment.getText());
				insertInto.setString(6, txtFixtureDeviceId.getText());
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
				update = "UPDATE alkatresz SET eszkoz_nev_a = ?, eszkoz_serial_a = ?"
						+ ", alkatresz_tipus = ?, alkatresz_serial = ?, megjegyzes_a = ?, gepadatok_ID_ga = ? WHERE ID_a = ?";
				ps = con.prepareStatement(update);
				ps.setString(1, txtFixtureDeviceName.getText());
				ps.setString(2, txtFixtureDeviceSerial.getText());
				ps.setString(3, txtFixtureName.getText());
				ps.setString(4, txtFixtureSerial.getText());
				ps.setString(5, txtAreaFixtureComment.getText());
				ps.setString(6, txtFixtureDeviceId.getText());
				ps.setInt(7, Integer.parseInt(txtFixtureId.getText()));
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
		txtFixtureDeviceName.setText(null);
		txtFixtureDeviceId.setText(null);
		txtFixtureDeviceSerial.setText(null);
		txtFixtureId.setText(null);
		txtFixtureName.setText(null);
		txtFixtureSerial.setText(null);
		txtAreaFixtureComment.setText(null);
	}

	private void JTable_ProductsMouseClickedFixture(java.awt.event.MouseEvent evt) {
		int index = tblFixture.getSelectedRow();
		ShowItemFixture(index);
	}
}
