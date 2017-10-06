package ex.main.password.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex.main.gui.MainGuiSet;
import ex.main.password.config.PasswordDB;
import ex.main.setting.centerwindow.CenterWindow;

public class PasswordGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel lblPasswordUserName, lblPassword;
	protected JTextField txtPasswordUserName;
	protected JPasswordField jPwdPassword;
	protected JButton btnPasswordLogin;
	protected Container c;

	public PasswordGui() {
		super("Login");
		setComponentPassword();
	}

	private void setComponentPassword() {

		c = getContentPane();
		lblPasswordUserName = new JLabel("Felhasználó név: ");
		lblPasswordUserName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswordUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordUserName.setBounds(10, 97, 272, 37);
		lblPassword = new JLabel("Jelszó:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(10, 165, 272, 37);
		txtPasswordUserName = new JTextField(10);
		txtPasswordUserName.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtPasswordUserName.setBounds(292, 97, 265, 42);
		jPwdPassword = new JPasswordField(10);
		jPwdPassword.setFont(new Font("Tahoma", Font.BOLD, 23));
		jPwdPassword.setBounds(292, 167, 265, 42);
		btnPasswordLogin = new JButton("Bejelenkezés");
		btnPasswordLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPasswordLogin.setBounds(338, 227, 156, 45);

		getContentPane().setLayout(null);
		c.add(lblPasswordUserName);
		c.add(txtPasswordUserName);
		c.add(lblPassword);
		c.add(jPwdPassword);
		c.add(btnPasswordLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 21, 564, 54);
		getContentPane().add(lblLogin);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		new CenterWindow().centerWindow(this);

	}

}
