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

import ex.main.deviceimage.gui.DeviceImageJDBCSetDAO;
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
		btnWorkHoursEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedWorkHour(evt);
			}
		});
		btnWorkHoursDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jDeleteActionPerformedWorkHour(evt);
				else
					return;
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
						rs.getString("hatarido"), rs.getString("tenyleges_teljesites"), rs.getString("megjegyzes_i"),
						rs.getInt("gepadatok_ID_g"));
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
		txtDeviceId.setText(Integer.toString(getWorkHoursProductList().get(index).getDeviceId()));
		try {
			Date addDate = null;
			Date endDate = null;
			Date completed = null;
			addDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getWorkHoursProductList().get(index).getAddDate());
			txtWorkHourAddDate.setDate(addDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse((String) getWorkHoursProductList().get(index).getExitDate());
			txtWorkHourEndDate.setDate(endDate);
			if (getWorkHoursProductList().get(index).getCompletedDate() != null) {
				completed = new SimpleDateFormat("yyyy-MM-dd")
						.parse((String) getWorkHoursProductList().get(index).getCompletedDate());
			}
			txtWorkHourCompletedDate.setDate(completed);
			txtWorkHourComment.setText(getWorkHoursProductList().get(index).getCommentWorkHours());
		} catch (ParseException ex) {
			Logger.getLogger(WorkHoursJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void jBtnInsertActionPerformedWorkHours(java.awt.event.ActionEvent evt) {
		String completedDate = null;
		if (checkInputsWorkHours()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDevice = con.prepareStatement("INSERT INTO munka_ido(sorozatszam_g, rogzites,"
						+ "hatarido, tenyleges_teljesites, megjegyzes_i, gepadatok_ID_g)" + "values(?,?,?,?,?,?) ");
				insertDevice.setString(1, txtWorkingHoursDeviceSerial.getText());
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txtWorkHourAddDate.getDate());
				insertDevice.setString(2, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(txtWorkHourEndDate.getDate());
				insertDevice.setString(3, endDate);
				SimpleDateFormat completedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					completedDateFormat.setLenient(false);
					completedDate = completedDateFormat.format(txtWorkHourCompletedDate.getDate());
				} catch (Exception e) {
				}
				insertDevice.setString(4, completedDate);
				insertDevice.setString(5, txtWorkHourComment.getText());
				insertDevice.setInt(6, Integer.parseInt(txtDeviceId.getText()));
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

	private void jBtnUpdateActionPerformedWorkHour(java.awt.event.ActionEvent evt) {
		String completedDate = null;
		if (checkInputsWorkHours()) {
			String updateDevice = null;
			PreparedStatement updateWorkHour = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateDevice = "UPDATE munka_ido SET sorozatszam_g = ?, rogzites = ?"
						+ ", hatarido = ?, tenyleges_teljesites = ?, megjegyzes_i = ? WHERE gepadatok_ID_g = ?";
				updateWorkHour = con.prepareStatement(updateDevice);
				updateWorkHour.setString(1, txtWorkingHoursDeviceSerial.getText());
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txtWorkHourAddDate.getDate());
				updateWorkHour.setString(2, addDate);
				SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String endDate = endDateFormat.format(txtWorkHourEndDate.getDate());
				updateWorkHour.setString(3, endDate);
				SimpleDateFormat completedDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					completedDateFormat.setLenient(false);
					completedDate = completedDateFormat.format(txtWorkHourCompletedDate.getDate());
				} catch (Exception e) {
				}
				updateWorkHour.setString(4, completedDate);
				updateWorkHour.setString(5, txtWorkHourComment.getText());
				updateWorkHour.setInt(6, Integer.parseInt(txtDeviceId.getText()));
				updateWorkHour.executeUpdate();
				showProductsInJTableWorksHours();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(WorkHoursJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jDeleteActionPerformedWorkHour(java.awt.event.ActionEvent evt) {
		if (!txtWorkingHoursDeviceSerial.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement DELETE = con.prepareStatement("DELETE FROM munka_ido WHERE gepadatok_ID_g = ?");
				String id = txtWorkingHoursDeviceSerial.getText();

				DELETE.setString(1, id);

				DELETE.executeUpdate();
				showProductsInJTableWorksHours();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(DeviceImageJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void JTable_ProductsMouseClickedWorkHours(java.awt.event.MouseEvent evt) {
		int index = jtblWorkingHours.getSelectedRow();
		showProductsInJTableWorksHours(index);
	}
}
