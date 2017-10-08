package ex.main.sales.gui;

import javax.swing.JFrame;

import ex.main.setting.centerwindow.CenterWindow;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SalesGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel pnl, pnlSales, jpnlClient;
	protected JTabbedPane tbdPnSales;

	public SalesGui() {
		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		getContentPane().setLayout(null);

		pnlSales = new JPanel();
		pnlSales.setBounds(0, 0, 1244, 651);
		getContentPane().add(pnlSales);
		pnlSales.setLayout(null);

		tbdPnSales = new JTabbedPane(JTabbedPane.TOP);
		tbdPnSales.setBounds(0, 0, 1244, 651);
		pnlSales.add(tbdPnSales);

		pnl = new JPanel();
		tbdPnSales.addTab("New tab", null, pnl, null);

		jpnlClient = new JPanel();
		tbdPnSales.addTab("Ügyfél", null, jpnlClient, null);
		new CenterWindow().centerWindow(this);
	}
}
