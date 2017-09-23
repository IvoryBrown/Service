package ex.main.workhours.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ex.main.setting.DataBaseConnect;
import ex.main.workhours.config.WorkHoursConfig;
import ex.main.workhours.config.WorkHoursImplements;

public class WorkHoursJDBCSetDAO extends WorkHourGui implements WorkHoursImplements {
	public WorkHoursJDBCSetDAO() {
		setActionWorkHours();
		showProductsInJTableWorksHours();
	}

	private void setActionWorkHours() {
		jtblWorkingHours.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "serial", "rögzítés", "határidő" }));
		jtblWorkingHours.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedWorkHours(evt);
			}
		});
		btnWorkHoursNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedWorkHours(evt);
			}
		});
	}

	private boolean checkInputsWorkHours() {
		// TODO
		if (txtWorkHourAddDate.getCalendar() == null) {
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
	public ArrayList<WorkHoursConfig> getWorkHoursProductList() {
		ArrayList<WorkHoursConfig> productListWorkHours = new ArrayList<WorkHoursConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM munka_ido ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			WorkHoursConfig product;
			while (rs.next()) {
				product = new WorkHoursConfig(rs.getString("sorozatszam_g"), rs.getString("rogzites"),
						rs.getString("hatarido"), rs.getInt("ra_forditott_ido"), rs.getString("tenyleges_teljesites"),
						rs.getString("megjegyzes_i"), rs.getInt("gepadatok_ID_g"));
				productListWorkHours.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(WorkHoursJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListWorkHours;
	}

	private void showProductsInJTableWorksHours() {
		ArrayList<WorkHoursConfig> listDevice = getWorkHoursProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jtblWorkingHours.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[3];
		for (int i = 0; i < listDevice.size(); i++) {
			rowDevice[0] = listDevice.get(i).getSerialDevice();
			rowDevice[1] = listDevice.get(i).getAddDate();
			rowDevice[2] = listDevice.get(i).getExitDate();
			modelDevice.addRow(rowDevice);
		}
	}

	private void showProductsInJTableWorksHours(int index) {
		txtWorkingHoursDeviceName.setText(null);
		txtWorkingHoursDeviceSerial.setText(getWorkHoursProductList().get(index).getSerialDevice());
		try {
			Date addDate = null;
			Date endDate = null;
			Date spentDate = null;
			addDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getWorkHoursProductList().get(index).getAddDate());
			txtWorkHourAddDate.setDate(addDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getWorkHoursProductList().get(index).getExitDate());
			txtWorkHourEndDate.setDate(endDate);
			spentDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getWorkHoursProductList().get(index).getCompletedDate());
			txtWorkHourCompletedDate.setDate(spentDate);
			txtWorkHourSpentDate.setText(Integer.toString(getWorkHoursProductList().get(index).getSpentDate()));
			txtWorkHourComment.setText(getWorkHoursProductList().get(index).getCommentWorkHours());
		} catch (ParseException ex) {
			Logger.getLogger(WorkHoursJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void jBtnInsertActionPerformedWorkHours(java.awt.event.ActionEvent evt) {
		if (checkInputsWorkHours()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDevice = con.prepareStatement("INSERT INTO munka_ido(sorozatszam_g, rogzites,"
						+ "hatarido, ra_forditott_ido, tenyleges_teljesites, megjegyzes_i, gepadatok_ID_g)"
						+ "values(?,?,?,?,?,?,?) ");
				insertDevice.setString(1, txtWorkingHoursDeviceSerial.getText());
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txtWorkHourAddDate.getDate());
				insertDevice.setString(2, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(txtWorkHourEndDate.getDate());
				insertDevice.setString(3, endDate);
				insertDevice.setInt(4, Integer.parseInt(txtWorkHourSpentDate.getText()));
				SimpleDateFormat completedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String completedDate = completedDateFormat.format(txtWorkHourCompletedDate.getDate());
				insertDevice.setString(5, completedDate);
				insertDevice.setString(6, txtWorkHourComment.getText());
				insertDevice.setInt(7, Integer.parseInt(txtDeviceId.getText()));
				insertDevice.executeUpdate();
				showProductsInJTableWorksHours();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void JTable_ProductsMouseClickedWorkHours(java.awt.event.MouseEvent evt) {
		int index = jtblWorkingHours.getSelectedRow();
		showProductsInJTableWorksHours(index);
	}
}
