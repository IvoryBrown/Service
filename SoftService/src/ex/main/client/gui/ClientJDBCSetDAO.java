package ex.main.client.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ex.main.client.config.ClientConfig;
import ex.main.client.config.ClientImplements;
import ex.main.setting.DataBaseConnect;

public class ClientJDBCSetDAO extends ClientGui implements ClientImplements {

	public ClientJDBCSetDAO() {

		setAction();
		Show_Products_In_JTable();
	}

	private void setAction() {
		jTblClient.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "sorszám", "név", "mobil" }));
		
		jTblClient.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});

		btnNewClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformed(evt);
			}
		});

		btnEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformed(evt);
			}
		});
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformed(evt);
				else
					return;
			}
		});
		btnNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformed(evt);
			}
		});
	}

	public boolean checkInputs() {
		if (txtIDClient.getText().trim().isEmpty() || txtNameClient.getText().trim().isEmpty()
				|| txtMobilClient.getText().trim().isEmpty()) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	@Override
	public ArrayList<ClientConfig> getProductList() {
		ArrayList<ClientConfig> productList = new ArrayList<ClientConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM megrendelo ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			ClientConfig product;
			while (rs.next()) {
				product = new ClientConfig(rs.getInt("azonosito_m"), rs.getString("nev"), rs.getString("kapcsolat"),
						rs.getString("lakcim"), rs.getString("megjegyzes_m"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	public void Show_Products_In_JTable() {
		ArrayList<ClientConfig> list = getProductList();
		DefaultTableModel model = (DefaultTableModel) jTblClient.getModel();
		model.setRowCount(0);
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getiD();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getMobil();
			model.addRow(row);
		}
	}

	public void ShowItem(int index) {
		txtIDClient.setText(Integer.toString(getProductList().get(index).getiD()));
		txtNameClient.setText(getProductList().get(index).getName());
		txtMobilClient.setText(getProductList().get(index).getMobil());
		txtHomeAddressClient.setText(getProductList().get(index).getHomeAddress());
		txtCommentClient.setText(getProductList().get(index).getComment());
	}

	private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertClient = con.prepareStatement("INSERT INTO megrendelo(azonosito_m, nev,"
						+ "kapcsolat, lakcim, megjegyzes_m)" + "values(?,?,?,?,?) ");
				insertClient.setString(1, txtIDClient.getText());
				insertClient.setString(2, txtNameClient.getText());
				insertClient.setString(3, txtMobilClient.getText());
				insertClient.setString(4, txtHomeAddressClient.getText());
				insertClient.setString(5, txtCommentClient.getText());
				insertClient.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen kép beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs()) {
			String updateClient = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateClient = "UPDATE megrendelo SET nev = ?"
						+ ", kapcsolat = ?, lakcim = ?, megjegyzes_m = ? WHERE azonosito_m = ?";
				ps = con.prepareStatement(updateClient);
				ps.setString(1, txtNameClient.getText());
				ps.setString(2, txtMobilClient.getText());
				ps.setString(3, txtHomeAddressClient.getText());
				ps.setString(4, txtCommentClient.getText());
				ps.setInt(5, Integer.parseInt(txtIDClient.getText()));
				ps.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		if (!txtIDClient.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteWorkingDocuments = con
						.prepareStatement("DELETE FROM megrendelo WHERE azonosito_m = ? ");
				int idWorkingDocuments = Integer.parseInt(txtIDClient.getText());
				deleteWorkingDocuments.setInt(1, idWorkingDocuments);
				deleteWorkingDocuments.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}
	private void btnNullShowPerformed(java.awt.event.ActionEvent evt) {
		txtIDClient.setText(null);
		txtNameClient.setText(null);
		txtHomeAddressClient.setText(null);
		txtMobilClient.setText(null);
		txtCommentClient.setText(null);
		
	}

	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = jTblClient.getSelectedRow();
		ShowItem(index);
	}
}
