package ex.main.sales.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ex.main.setting.centerwindow.CenterWindow;

public class SalesGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel pnl, pnlSales, jpnlClient, jpnlDevice;
	protected JTabbedPane tbdPnSales;
	private JLabel lblNewLabel;

	public SalesGui() {
		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		getContentPane().setLayout(null);

		pnlSales = new JPanel();
		pnlSales.setBackground(Color.BLACK);
		pnlSales.setBounds(0, 0, 1244, 651);
		getContentPane().add(pnlSales);
		pnlSales.setLayout(null);

		tbdPnSales = new JTabbedPane(JTabbedPane.TOP);
		tbdPnSales.setBounds(0, 0, 1244, 651);
		pnlSales.add(tbdPnSales);

		pnl = new JPanel();
		pnl.setBackground(Color.BLACK);
		tbdPnSales.addTab("", new ImageIcon(SalesGui.class.getResource("/icon/tulliana/22x22/actions/text_block.png")),
				pnl, null);
		tbdPnSales.setForegroundAt(0, new Color(51, 0, 0));
		tbdPnSales.setBackgroundAt(0, new Color(102, 0, 0));
		pnl.setLayout(null);

		jpnlClient = new JPanel(new BorderLayout());
		jpnlClient.setForeground(new Color(153, 0, 0));
		tbdPnSales.addTab("", new ImageIcon(SalesGui.class.getResource("/icon/tulliana/22x22/apps/kdmconfig.png")),
				jpnlClient, null);
		tbdPnSales.setBackgroundAt(1, new Color(153, 0, 0));
		tbdPnSales.setForegroundAt(1, new Color(153, 0, 0));

		jpnlDevice = new JPanel();
		jpnlDevice.setBackground(Color.BLACK);
		tbdPnSales.addTab("", new ImageIcon(SalesGui.class.getResource("/icon/tulliana/22x22/apps/systemtray.png")),
				jpnlDevice, null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Image\\Red-And-Black-Abstract-Wallpaper-3.jpg"));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(0, 0, 1244, 62);
		pnlSales.add(lblNewLabel);

		new CenterWindow().centerWindow(this);
	}
}
