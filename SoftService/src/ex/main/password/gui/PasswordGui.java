package ex.main.password.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	protected JLabel l_name, l_pass;
	protected JTextField t_name;
	protected JPasswordField t_pass;
	protected JButton button;
	protected Container c;
	Handler handle;
	protected PasswordDB db;

	public PasswordGui() {

		setComponentPassword();
	}

	private void setComponentPassword() {

		c = getContentPane();
		db = new PasswordDB();
		handle = new Handler();
		l_name = new JLabel("Felhasználó név: ");
		l_name.setFont(new Font("Tahoma", Font.BOLD, 30));
		l_name.setHorizontalAlignment(SwingConstants.RIGHT);
		l_name.setBounds(10, 97, 272, 37);
		l_pass = new JLabel("Jelszó:");
		l_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		l_pass.setFont(new Font("Tahoma", Font.BOLD, 30));
		l_pass.setBounds(10, 165, 272, 37);
		t_name = new JTextField(10);
		t_name.setFont(new Font("Tahoma", Font.BOLD, 23));
		t_name.setBounds(292, 97, 265, 42);
		t_pass = new JPasswordField(10);
		t_pass.setFont(new Font("Tahoma", Font.BOLD, 23));
		t_pass.setBounds(292, 167, 265, 42);
		button = new JButton("Bejelenkezés");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(338, 227, 156, 45);
		button.addActionListener(handle);
		getContentPane().setLayout(null);
		c.add(l_name);
		c.add(t_name);
		c.add(l_pass);
		c.add(t_pass);
		c.add(button);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 564, 54);
		getContentPane().add(lblNewLabel);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		new CenterWindow().centerWindow(this);
	}

	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == button) {
				char[] temp_pwd = t_pass.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(temp_pwd);
				if (db.checkLogin(t_name.getText(), pwd)) {
					new MainGuiSet().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Nem meg felelő név vagy jelszó!", "Hiba!!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		}

	}
}
