package ex.main.gui;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ex.main.setting.centerwindow.CenterWindow;

public class MainGui extends JFrame {
	protected JButton btnSales, btnService;

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

		btnService = new JButton("Szervíz");
		btnService.setIcon(new ImageIcon("image/szerviz.jpg"));
		btnService.setBounds(24, 33, 298, 230);
		pnl.add(btnService);

		btnSales = new JButton("Értékesítés");
		btnSales.setBounds(24, 289, 298, 230);
		pnl.add(btnSales);
		
		new CenterWindow().centerWindow(this);
	}
}
