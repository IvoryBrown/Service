package ex.main.password.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class PasswordDB {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public PasswordDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/service", "root", "12345");
			pst = con.prepareStatement("select * from user where username=? and password=?");
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
}
