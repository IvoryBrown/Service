package ex.main.password.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ex.main.setting.database.DataBaseConnect;

public class PasswordDB {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	static int jog;

	public PasswordDB() {
		getListClient();
	}

	public void getListClient() {

		try {
			con = DataBaseConnect.getConnection();
			pst = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Server hiba!\n" + e, "Hiba!!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public Boolean checkLogin(String uname, String pwd) {
		try {
			pst.setString(1, uname);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(PasswordDB.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	public Integer jog(Integer j) {
		return j;
	}
}
