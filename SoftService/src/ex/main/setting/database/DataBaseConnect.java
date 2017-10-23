package ex.main.setting.database;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;

import ex.main.MainProgram;

public class DataBaseConnect {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/service";
	static final String USER = "root";
	static final String PASS = "12345";
	private JLabel subtitle;

	public DataBaseConnect() {
		Connection conn = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.close();
			subtitle = new JLabel();
			subtitle.setText("Online....");
			subtitle.setForeground(new Color(0, 128, 0));
		} catch (SQLException se) {
			subtitle.setText("Sikertelen Kapcsolodás!!!");
			subtitle.setForeground(Color.RED);
		} catch (Exception ex) {
		} finally {
			try {
				if (conn != null)
					conn.close();
				new MainProgram();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseConnect.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} 
	}

	public JLabel getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(JLabel subtitle) {
		this.subtitle = subtitle;
	}

}
