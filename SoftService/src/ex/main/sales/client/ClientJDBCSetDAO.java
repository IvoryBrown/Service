package ex.main.sales.client;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import ex.main.sales.client.config.ClientConfig;
import ex.main.sales.client.config.ClientImplements;
import ex.main.sales.client.gui.ClientGui;
import ex.main.setting.database.DataBaseConnect;

public class ClientJDBCSetDAO extends ClientGui implements ClientImplements {
	Object rows[][];
	String columns[];

	public ClientJDBCSetDAO() {
		setActionSalesClient();
		showProductsInJTableClient();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void setActionSalesClient() {

		columns = new String[] { "ID", "azonosító", "név", "telefon", "lakcím", "megjegyzés" };

		jtblSalesClient.setModel(new javax.swing.table.DefaultTableModel(rows, columns));
		jtblSalesClient.getColumn("ID").setMinWidth(30);
		jtblSalesClient.getColumn("ID").setMaxWidth(30);
		jtblSalesClient.getColumn("azonosító").setMinWidth(80);
		jtblSalesClient.getColumn("azonosító").setMaxWidth(80);
		jtblSalesClient.getColumn("név").setMinWidth(230);
		jtblSalesClient.getColumn("név").setMaxWidth(230);
		jtblSalesClient.getColumn("telefon").setMinWidth(100);
		jtblSalesClient.getColumn("telefon").setMaxWidth(100);
		jtblSalesClient.getColumn("lakcím").setMinWidth(270);
		jtblSalesClient.getColumn("lakcím").setMaxWidth(270);
		jtblSalesClient.getTableHeader().setReorderingAllowed(false);
		jtblSalesClient.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});

		btnSalesClientNewClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedSalesClient(evt);
			}
		});
		btnSalesClientEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedSalesClient(evt);
			}
		});
		btnSalesClientDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedSalesClient(evt);
				else
					return;
			}
		});
		btnSalesClientNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformed(evt);
			}
		});
		btnSalesClientSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickeds(evt);
			}
		});
		jtblSalesClient.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickeds(evt);
			}
		});
	}

	private boolean checkInputsSalesClient() {
		if (txtSalesClientNumber.getText().trim().isEmpty()) {
			txtSalesClientNumber.setBackground(new Color(255, 250, 240));
		} else {
			txtSalesClientNumber.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesClientName.getText().trim().isEmpty()) {
			txtSalesClientName.setBackground(new Color(255, 250, 240));
		} else {
			txtSalesClientName.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesClientMobil.getText().trim().isEmpty()) {
			txtSalesClientMobil.setBackground(new Color(255, 250, 240));
		} else {
			txtSalesClientMobil.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesClientHomeAddress.getText().trim().isEmpty()) {
			txtSalesClientHomeAddress.setBackground(new Color(255, 250, 240));
		} else {
			txtSalesClientHomeAddress.setBackground(new Color(245, 255, 250));
		}
		if (txtSalesClientName.getText().trim().isEmpty() || txtSalesClientMobil.getText().trim().isEmpty()
				|| txtSalesClientHomeAddress.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
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

	// public ArrayList<ClientConfig> ListUsers(String ValToSearch) {
	// ArrayList<ClientConfig> usersList = new ArrayList<ClientConfig>();
	// Statement st;
	// ResultSet rs;
	// try {
	// Connection con = DataBaseConnect.getConnection();
	// st = con.createStatement();
	// String searchQuery = "SELECT * FROM `megrendelo` WHERE CONCAT(`ID_m`,
	// `azonosito_m`, `nev`, `kapcsolat`) LIKE '%"
	// + ValToSearch + "%'";
	// rs = st.executeQuery(searchQuery);
	// ClientConfig user;
	// while (rs.next()) {
	// user = new ClientConfig(rs.getInt("ID_m"), rs.getInt("azonosito_m"),
	// rs.getString("nev"),
	// rs.getString("kapcsolat"), rs.getString("lakcim"),
	// rs.getString("megjegyzes_m"));
	// usersList.add(user);
	// }
	//
	// } catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
	//
	// return usersList;
	// }
	//
	// public void findUsers() {
	// ArrayList<ClientConfig> users =
	// ListUsers(txtSalesClientSearch.getText());
	// DefaultTableModel model = (DefaultTableModel) jtblSalesClient.getModel();
	// model.setRowCount(0);
	// Object[] row = new Object[6];
	//
	// for (int i = 0; i < users.size(); i++) {
	// row[0] = users.get(i).getSalesClientID();
	// row[1] = users.get(i).getSalesClientNumber();
	// row[2] = users.get(i).getSalesClientName();
	// row[3] = users.get(i).getSalesClientMobil();
	// row[4] = users.get(i).getSalesClientHomeAddress();
	// row[5] = users.get(i).getSalesClientComment();
	// model.addRow(row);
	// }
	//
	// }
	//
	// public void ShowItemS(int index) {
	//
	// }
	//
	@Override
	public ArrayList<ClientConfig> getListUsers() {
		ArrayList<ClientConfig> listSearch = new ArrayList<ClientConfig>();
		ResultSet rs;
		try {
			String query = "SELECT * FROM megrendelo WHERE "
					+ cmbSalesClientSearch.getItemAt(cmbSalesClientSearch.getSelectedIndex()) + " = ?";
			Connection con = DataBaseConnect.getConnection();
			PreparedStatement insertClient = con.prepareStatement(query);
			insertClient.setString(1, txtSalesClientSearch.getText());
			rs = insertClient.executeQuery();
			ClientConfig clientSearch;
			if (rs.next()) {
				clientSearch = new ClientConfig(rs.getInt("ID_m"), rs.getInt("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"));
				listSearch.add(clientSearch);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sikertelen Keresés: " + ex.getMessage());
		}
		return listSearch;

	}

	public void findUsers() {
		ArrayList<ClientConfig> users = getListUsers();
		DefaultTableModel model = (DefaultTableModel) jtblSalesClient.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];

		for (int i = 0; i < users.size(); i++) {
			row[0] = users.get(i).getSalesClientID();
			row[1] = users.get(i).getSalesClientNumber();
			row[2] = users.get(i).getSalesClientName();
			row[3] = users.get(i).getSalesClientMobil();
			row[4] = users.get(i).getSalesClientHomeAddress();
			row[5] = users.get(i).getSalesClientComment();
			model.addRow(row);
		}

	}

	public void ShowItemS(int index) {
		txtSalesClientID.setText(Integer.toString(getListUsers().get(index).getSalesClientID()));
		txtSalesClientNumber.setText(Integer.toString(getListUsers().get(index).getSalesClientNumber()));
		txtSalesClientName.setText(getListUsers().get(index).getSalesClientName());
		txtSalesClientMobil.setText(getListUsers().get(index).getSalesClientMobil());
		txtSalesClientHomeAddress.setText(getListUsers().get(index).getSalesClientHomeAddress());
		txtSalesClientComment.setText(getListUsers().get(index).getSalesClientComment());
	}

	
	private void JTable_ProductsMouseClickeds(java.awt.event.MouseEvent evt) {
		findUsers();
		int index = jtblSalesClient.getSelectedRow();
		ShowItemS(index);
	}

	private void showProductsInJTableClient() {
		ArrayList<ClientConfig> list = getClientProductList();
		DefaultTableModel model = (DefaultTableModel) jtblSalesClient.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSalesClientID();
			row[1] = list.get(i).getSalesClientNumber();
			row[2] = list.get(i).getSalesClientName();
			row[3] = list.get(i).getSalesClientMobil();
			row[4] = list.get(i).getSalesClientHomeAddress();
			row[5] = list.get(i).getSalesClientComment();
			model.addRow(row);
		}

		TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(jtblSalesClient.getModel());
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
		jtblSalesClient.setRowSorter(tableRowSorter);
	}

	public void ShowItem(int index) {
		txtSalesClientID.setText(Integer.toString(getClientProductList().get(index).getSalesClientID()));
		txtSalesClientNumber.setText(Integer.toString(getClientProductList().get(index).getSalesClientNumber()));
		txtSalesClientName.setText(getClientProductList().get(index).getSalesClientName());
		txtSalesClientMobil.setText(getClientProductList().get(index).getSalesClientMobil());
		txtSalesClientHomeAddress.setText(getClientProductList().get(index).getSalesClientHomeAddress());
		txtSalesClientComment.setText(getClientProductList().get(index).getSalesClientComment());
	}

	private void jBtnInsertActionPerformedSalesClient(java.awt.event.ActionEvent evt) {
		if (checkInputsSalesClient()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertClient = con.prepareStatement("INSERT INTO megrendelo(azonosito_m, nev,"
						+ "kapcsolat, lakcim, megjegyzes_m)" + "values(?,?,?,?,?) ");
				insertClient.setInt(1, Integer.parseInt(txtSalesClientNumber.getText()));
				insertClient.setString(2, txtSalesClientName.getText());
				insertClient.setString(3, txtSalesClientMobil.getText());
				insertClient.setString(4, txtSalesClientHomeAddress.getText());
				insertClient.setString(5, txtSalesClientComment.getText());
				insertClient.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
				txtSalesClientID.setText(null);
				txtSalesClientNumber.setText(null);
				txtSalesClientName.setText(null);
				txtSalesClientMobil.setText(null);
				txtSalesClientHomeAddress.setText(null);
				txtSalesClientComment.setText(null);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedSalesClient(java.awt.event.ActionEvent evt) {
		if (checkInputsSalesClient()) {
			String updateClient = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateClient = "UPDATE megrendelo SET azonosito_m = ?, nev = ?"
						+ ", kapcsolat = ?, lakcim = ?, megjegyzes_m = ? WHERE ID_m = ?";
				ps = con.prepareStatement(updateClient);
				ps.setInt(1, Integer.parseInt(txtSalesClientNumber.getText()));
				ps.setString(2, txtSalesClientName.getText());
				ps.setString(3, txtSalesClientMobil.getText());
				ps.setString(4, txtSalesClientHomeAddress.getText());
				ps.setString(5, txtSalesClientComment.getText());
				ps.setInt(6, Integer.parseInt(txtSalesClientID.getText()));
				ps.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				txtSalesClientID.setText(null);
				txtSalesClientNumber.setText(null);
				txtSalesClientName.setText(null);
				txtSalesClientMobil.setText(null);
				txtSalesClientHomeAddress.setText(null);
				txtSalesClientComment.setText(null);
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedSalesClient(java.awt.event.ActionEvent evt) {
		if (!txtSalesClientID.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteClient = con.prepareStatement("DELETE FROM megrendelo WHERE ID_m = ? ");
				int idClient = Integer.parseInt(txtSalesClientID.getText());
				deleteClient.setInt(1, idClient);
				deleteClient.executeUpdate();
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
		txtSalesClientID.setText(null);
		txtSalesClientID.setBackground(new Color(245, 255, 250));
		txtSalesClientNumber.setText(null);
		txtSalesClientNumber.setBackground(new Color(245, 255, 250));
		txtSalesClientName.setText(null);
		txtSalesClientName.setBackground(new Color(245, 255, 250));
		txtSalesClientMobil.setText(null);
		txtSalesClientMobil.setBackground(new Color(245, 255, 250));
		txtSalesClientHomeAddress.setText(null);
		txtSalesClientHomeAddress.setBackground(new Color(245, 255, 250));
		txtSalesClientComment.setText(null);
		txtSalesClientComment.setBackground(new Color(245, 255, 250));
		showProductsInJTableClient();
	}

	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = jtblSalesClient.getSelectedRow();
		ShowItem(index);
	}
}
