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
		showProductsInJTableClient();
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

		btnEditClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformed(evt);
			}
		});
		btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformed(evt);
				else
					return;
			}
		});
		btnNullClient.addActionListener(new java.awt.event.ActionListener() {
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
	public ArrayList<ClientConfig> getClientProductList() {
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
				product = new ClientConfig(rs.getInt("ID_m"), rs.getInt("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	public void showProductsInJTableClient() {
		ArrayList<ClientConfig> list = getClientProductList();
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
		txtIdClient.setText(Integer.toString(getClientProductList().get(index).getiDm()));
		txtClientDeviceId.setText(Integer.toString(getClientProductList().get(index).getiDm()));
		txtIDClient.setText(Integer.toString(getClientProductList().get(index).getiD()));
		txtNameClient.setText(getClientProductList().get(index).getName());
		txtClientDeviceName.setText(getClientProductList().get(index).getName());
		txtMobilClient.setText(getClientProductList().get(index).getMobil());
		txtHomeAddressClient.setText(getClientProductList().get(index).getHomeAddress());
		txtCommentClient.setText(getClientProductList().get(index).getComment());
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
				showProductsInJTableClient();
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
				updateClient = "UPDATE megrendelo SET azonosito_m = ?, nev = ?"
						+ ", kapcsolat = ?, lakcim = ?, megjegyzes_m = ? WHERE ID_m = ?";
				ps = con.prepareStatement(updateClient);
				ps.setInt(1, Integer.parseInt(txtIDClient.getText()));
				ps.setString(2, txtNameClient.getText());
				ps.setString(3, txtMobilClient.getText());
				ps.setString(4, txtHomeAddressClient.getText());
				ps.setString(5, txtCommentClient.getText());
				ps.setInt(6, Integer.parseInt(txtIdClient.getText()));
				ps.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		if (!txtIdClient.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteWorkingDocuments = con
						.prepareStatement("DELETE FROM megrendelo WHERE ID_m = ? ");
				int idWorkingDocuments = Integer.parseInt(txtIdClient.getText());
				deleteWorkingDocuments.setInt(1, idWorkingDocuments);
				deleteWorkingDocuments.executeUpdate();
				showProductsInJTableClient();
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
