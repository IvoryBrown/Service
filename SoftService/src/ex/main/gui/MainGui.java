package ex.main.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ex.main.setting.centerwindow.CenterWindow;

public class MainGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnService, btnSales;

	public MainGui() {
		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JPanel pnl = new JPanel();
		pnl.setBounds(0, 0, 1244, 651);
		getContentPane().add(pnl);
		pnl.setLayout(null);

		btnSales = new JButton(new ImageIcon(((new ImageIcon("Image/ertekesites.png")).getImage()).getScaledInstance(400,
				629, java.awt.Image.SCALE_SMOOTH)));
		btnSales.setBounds(10, 11, 400, 629);
		pnl.add(btnSales);

		btnService = new JButton(new ImageIcon(((new ImageIcon("Image/pcszerviz.png")).getImage()).getScaledInstance(400,
				629, java.awt.Image.SCALE_SMOOTH)));
		btnService.setBounds(420, 11, 400, 629);
		pnl.add(btnService);

		JButton button = new JButton(new ImageIcon(((new ImageIcon("Image/pc.png")).getImage()).getScaledInstance(400,
				629, java.awt.Image.SCALE_SMOOTH)));
		button.setBounds(830, 11, 400, 629);
		pnl.add(button);

		new CenterWindow().centerWindow(this);
	}
}
