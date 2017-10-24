package ex.main.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ex.main.setting.centerwindow.CenterWindow;
import java.awt.Color;
import javax.swing.JLabel;

public class MainGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnService, btnSales;
	private JLabel label;

	public MainGui() {
		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JPanel pnl = new JPanel();
		pnl.setBackground(Color.BLACK);
		pnl.setBounds(0, 0, 1244, 651);
		getContentPane().add(pnl);
		pnl.setLayout(null);

		btnSales = new JButton(new ImageIcon(((new ImageIcon("Image/ertekesites.png")).getImage())
				.getScaledInstance(400, 629, java.awt.Image.SCALE_SMOOTH)));
		btnSales.setBackground(Color.BLACK);
		btnSales.setBounds(10, 11, 400, 629);
		pnl.add(btnSales);

		btnService = new JButton(new ImageIcon(((new ImageIcon("Image/pcszerviz.png")).getImage())
				.getScaledInstance(400, 629, java.awt.Image.SCALE_SMOOTH)));
		btnService.setBackground(Color.BLACK);
		btnService.setBounds(420, 11, 400, 629);
		pnl.add(btnService);

		JButton button = new JButton(new ImageIcon(
				((new ImageIcon("Image/pc.png")).getImage()).getScaledInstance(400, 629, java.awt.Image.SCALE_SMOOTH)));
		button.setBackground(Color.BLACK);
		button.setBounds(830, 11, 400, 629);
		pnl.add(button);

		label = new JLabel(new ImageIcon(((new ImageIcon("Image\\Red-And-Black-Abstract-Wallpaper-3.jpg")).getImage())
				.getScaledInstance(1244, 651, java.awt.Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 1244, 651);
		pnl.add(label);

		new CenterWindow().centerWindow(this);
	}
}
