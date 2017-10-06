package ex.main.password;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import ex.main.gui.MainGuiSet;
import ex.main.password.config.PasswordDB;
import ex.main.password.gui.PasswordGui;

public class PasswordJDBCSet extends PasswordGui {
	protected PasswordDB db;

	public PasswordJDBCSet() {
		setActionPassword();
	}

	private void setActionPassword() {
		db = new PasswordDB();
		jPwdPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					char[] temp_pwd = jPwdPassword.getPassword();
					String pwd = null;
					pwd = String.copyValueOf(temp_pwd);
					if (db.checkLogin(txtPasswordUserName.getText(), pwd)) {
						new MainGuiSet().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nem meg felelő név vagy jelszó!", "Hiba!!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}

			}

		});
		txtPasswordUserName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					char[] temp_pwd = jPwdPassword.getPassword();
					String pwd = null;
					pwd = String.copyValueOf(temp_pwd);
					if (db.checkLogin(txtPasswordUserName.getText(), pwd)) {
						new MainGuiSet().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nem meg felelő név vagy jelszó!", "Hiba!!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}

			}

		});
		btnPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == btnPasswordLogin) {
					char[] temp_pwd = jPwdPassword.getPassword();
					String pwd = null;
					pwd = String.copyValueOf(temp_pwd);
					if (db.checkLogin(txtPasswordUserName.getText(), pwd)) {
						new MainGuiSet().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nem meg felelő név vagy jelszó!", "Hiba!!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			}
		});
	}
}
