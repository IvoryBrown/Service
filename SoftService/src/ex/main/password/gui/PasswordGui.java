package ex.main.password.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex.main.setting.centerwindow.CenterWindow;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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
	private JLabel label;

	public PasswordGui() {
		super("Login");
		setComponentPassword();
	}

	private void setComponentPassword() {

		c = getContentPane();
		c.setBackground(Color.BLACK);
		lblPasswordUserName = new JLabel("Felhasználó név: ");
		lblPasswordUserName.setBackground(Color.WHITE);
		lblPasswordUserName.setForeground(new Color(153, 0, 0));
		lblPasswordUserName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswordUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordUserName.setBounds(10, 97, 272, 37);
		lblPassword = new JLabel("Jelszó:");
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setForeground(new Color(153, 0, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(10, 165, 272, 37);
		txtPasswordUserName = new JTextField(10);
		txtPasswordUserName.setForeground(new Color(51, 0, 0));
		txtPasswordUserName.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtPasswordUserName.setBounds(292, 97, 265, 42);
		jPwdPassword = new JPasswordField(10);
		jPwdPassword.setForeground(new Color(51, 0, 0));
		jPwdPassword.setFont(new Font("Tahoma", Font.BOLD, 23));
		jPwdPassword.setBounds(292, 167, 265, 42);
		btnPasswordLogin = new JButton("");
		btnPasswordLogin.setIcon(new ImageIcon(PasswordGui.class.getResource("/icon/tulliana/48x48/apps/kgpg.png")));
		btnPasswordLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPasswordLogin.setBounds(338, 227, 156, 45);

		getContentPane().setLayout(null);
		c.add(lblPasswordUserName);
		c.add(txtPasswordUserName);
		c.add(lblPassword);
		c.add(jPwdPassword);
		c.add(btnPasswordLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setForeground(new Color(153, 0, 0));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 21, 564, 54);
		getContentPane().add(lblLogin);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("v: 1.173");
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel.setForeground(Color.WHITE);
		lblNewJgoodiesLabel.setBounds(492, 346, 92, 14);
		getContentPane().add(lblNewJgoodiesLabel);

		label = new JLabel(
				new ImageIcon(((new ImageIcon("Image\\line_dark_white_light_obliquely_46641_1680x1050.jpg")).getImage())
						.getScaledInstance(594, 371, java.awt.Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 594, 371);
		getContentPane().add(label);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		new CenterWindow().centerWindow(this);

	}
}
