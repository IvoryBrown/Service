package ex.main.sales.client;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import ex.main.setting.identification.ClientIdentificationGenerator;

public class ClientJDBCSetDAO extends ClientGui implements ClientImplements {
	Object columns[][];
	String rows[];

	public ClientJDBCSetDAO() {
		jpnlClient.setBackground(Color.RED);
		setActionSalesClient();
		showProductsInJTableClient();
		tableRows();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void setActionSalesClient() {

		rows = new String[] { "ID", "azonosító", "név", "kapcsolat", "lakcím", "megjegyzés" };
		jtblSalesClient.setModel(new javax.swing.table.DefaultTableModel(columns, rows));

		jtblSalesClient.getColumn("ID").setMinWidth(50);
		jtblSalesClient.getColumn("ID").setMaxWidth(50);
		jtblSalesClient.getColumn("azonosító").setMinWidth(90);
		jtblSalesClient.getColumn("azonosító").setMaxWidth(90);
		jtblSalesClient.getColumn("név").setMinWidth(230);
		jtblSalesClient.getColumn("név").setMaxWidth(230);
		jtblSalesClient.getColumn("kapcsolat").setMinWidth(120);
		jtblSalesClient.getColumn("kapcsolat").setMaxWidth(120);
		jtblSalesClient.getColumn("lakcím").setMinWidth(280);
		jtblSalesClient.getColumn("lakcím").setMaxWidth(280);
		jtblSalesClient.getTableHeader().setReorderingAllowed(false);
		jtblSalesClient.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableProductsMouseClicked(evt);

			}
		});

		btnSalesClientNewClient.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedSalesClient();
			}
		});
		btnSalesClientEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedSalesClient();
			}
		});
		btnSalesClientDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jBtnDeleteActionPerformedSalesClient();
				else
					return;
			}
		});
		btnSalesClientNull.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNullShowPerformed();
			}
		});
		btnSalesClientSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableClientSearch();
			}
		});
		txtSalesClientSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					jTableClientSearch();
				}
			}
		});
	}

	private boolean checkInputsSalesClient() {
		if (txtSalesClientName.getText().trim().isEmpty()) {
			txtSalesClientName.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesClientName.setBackground(Color.WHITE);
		}
		if (txtSalesClientMobil.getText().trim().isEmpty()) {
			txtSalesClientMobil.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesClientMobil.setBackground(Color.WHITE);
		}
		if (txtSalesClientHomeAddress.getText().trim().isEmpty()) {
			txtSalesClientHomeAddress.setBackground(new Color(255, 0, 0));
			;
		} else {
			txtSalesClientHomeAddress.setBackground(Color.WHITE);
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
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			ClientConfig product;
			while (rs.next()) {
				product = new ClientConfig(rs.getInt("ID_m"), rs.getString("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
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

	@Override
	public ArrayList<ClientConfig> getListClient() {
		ArrayList<ClientConfig> listSearch = new ArrayList<ClientConfig>();
		ResultSet rs = null;
		Statement insertClient = null;
		Connection con = DataBaseConnect.getConnection();
		try {
			insertClient = con.createStatement();
			String searchQuery = "SELECT * FROM `megrendelo` WHERE CONCAT (`"
					+ cmbSalesClientSearch.getItemAt(cmbSalesClientSearch.getSelectedIndex()) + "`) LIKE '%"
					+ txtSalesClientSearch.getText() + "%'";
			rs = insertClient.executeQuery(searchQuery);
			ClientConfig clientSearch;
			while (rs.next()) {
				clientSearch = new ClientConfig(rs.getInt("ID_m"), rs.getString("azonosito_m"), rs.getString("nev"),
						rs.getString("kapcsolat"), rs.getString("lakcim"), rs.getString("megjegyzes_m"));
				listSearch.add(clientSearch);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Sikertelen Keresés: " + ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (insertClient != null) {
					insertClient.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return listSearch;
	}

	private void findClientSearch() {
		ArrayList<ClientConfig> client = getListClient();
		DefaultTableModel model = (DefaultTableModel) jtblSalesClient.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		for (int i = 0; i < client.size(); i++) {
			row[0] = client.get(i).getSalesClientID();
			row[1] = client.get(i).getSalesClientNumber();
			row[2] = client.get(i).getSalesClientName();
			row[3] = client.get(i).getSalesClientMobil();
			row[4] = client.get(i).getSalesClientHomeAddress();
			row[5] = client.get(i).getSalesClientComment();
			model.addRow(row);
		}

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

	}

	private void showItemClientSearch(int index) {
		txtSalesClientID.setText(Integer.toString(getListClient().get(index).getSalesClientID()));
		txtSalesClientNumber.setText(getListClient().get(index).getSalesClientNumber());
		txtSalesClientName.setText(getListClient().get(index).getSalesClientName());
		txtSalesClientMobil.setText(getListClient().get(index).getSalesClientMobil());
		txtSalesClientHomeAddress.setText(getListClient().get(index).getSalesClientHomeAddress());
		txtSalesClientComment.setText(getListClient().get(index).getSalesClientComment());
		// Device set
		txtSalesDeviceClientName.setText(getListClient().get(index).getSalesClientName());
		txtSalesDeviceClientID.setText(Integer.toString(getListClient().get(index).getSalesClientID()));
	}

	private void showItemClient(int index) {
		txtSalesClientID.setText(Integer.toString(getClientProductList().get(index).getSalesClientID()));
		txtSalesClientNumber.setText(getClientProductList().get(index).getSalesClientNumber());
		txtSalesClientName.setText(getClientProductList().get(index).getSalesClientName());
		txtSalesClientMobil.setText(getClientProductList().get(index).getSalesClientMobil());
		txtSalesClientHomeAddress.setText(getClientProductList().get(index).getSalesClientHomeAddress());
		txtSalesClientComment.setText(getClientProductList().get(index).getSalesClientComment());
		// device set
		txtSalesDeviceClientName.setText(getClientProductList().get(index).getSalesClientName());
		txtSalesDeviceClientID.setText(Integer.toString(getClientProductList().get(index).getSalesClientID()));

	}

	private void jBtnInsertActionPerformedSalesClient() {
		if (checkInputsSalesClient()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertClient = con.prepareStatement("INSERT INTO megrendelo(azonosito_m, nev,"
						+ "kapcsolat, lakcim, megjegyzes_m)" + "values(?,?,?,?,?) ");
				txtSalesClientNumber.setText(ClientIdentificationGenerator.random());
				insertClient.setString(1, txtSalesClientNumber.getText());
				insertClient.setString(2, txtSalesClientName.getText());
				insertClient.setString(3, txtSalesClientMobil.getText());
				insertClient.setString(4, txtSalesClientHomeAddress.getText());
				insertClient.setString(5, txtSalesClientComment.getText());
				insertClient.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
				btnNullShowPerformed();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedSalesClient() {
		if (checkInputsSalesClient()) {
			String updateClient = null;
			PreparedStatement ps = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateClient = "UPDATE megrendelo SET azonosito_m = ?, nev = ?"
						+ ", kapcsolat = ?, lakcim = ?, megjegyzes_m = ? WHERE ID_m = ?";
				ps = con.prepareStatement(updateClient);
				ps.setString(1, txtSalesClientNumber.getText());
				ps.setString(2, txtSalesClientName.getText());
				ps.setString(3, txtSalesClientMobil.getText());
				ps.setString(4, txtSalesClientHomeAddress.getText());
				ps.setString(5, txtSalesClientComment.getText());
				ps.setInt(6, Integer.parseInt(txtSalesClientID.getText()));
				ps.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				btnNullShowPerformed();
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jBtnDeleteActionPerformedSalesClient() {
		if (!txtSalesClientID.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement deleteClient = con.prepareStatement("DELETE FROM megrendelo WHERE ID_m = ? ");
				int idClient = Integer.parseInt(txtSalesClientID.getText());
				deleteClient.setInt(1, idClient);
				deleteClient.executeUpdate();
				showProductsInJTableClient();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
				btnNullShowPerformed();
			} catch (SQLException ex) {
				Logger.getLogger(ClientJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void btnNullShowPerformed() {
		txtSalesClientID.setText(null);
		txtSalesClientID.setBackground(Color.WHITE);
		txtSalesClientNumber.setText(null);
		txtSalesClientNumber.setBackground(Color.WHITE);
		txtSalesClientName.setText(null);
		txtSalesClientName.setBackground(Color.WHITE);
		txtSalesClientMobil.setText(null);
		txtSalesClientMobil.setBackground(Color.WHITE);
		txtSalesClientHomeAddress.setText(null);
		txtSalesClientHomeAddress.setBackground(Color.WHITE);
		txtSalesClientComment.setText(null);
		txtSalesClientComment.setBackground(Color.WHITE);
		txtSalesClientSearch.setText(null);
		cmbSalesClientSearch.setSelectedIndex(0);
		showProductsInJTableClient();
	}

	private void jTableClientSearch() {
		findClientSearch();
	}

	private void tableRows() {
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

	private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = jtblSalesClient.getSelectedRow();
		showItemClient(index);
		showItemClientSearch(index);

	}
}
