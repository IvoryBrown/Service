package ex.main.sales.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ex.main.gui.MainGuiSet;
import ex.main.setting.centerwindow.CenterWindow;
import java.awt.FlowLayout;

public class SalesGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel pnl, pnlSales, jpnlClient, jpnlDevice,panel;
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
		pnlSales.setBackground(new Color(102, 0, 153));
		pnlSales.setBounds(0, 0, 1244, 651);
		getContentPane().add(pnlSales);
		pnlSales.setLayout(null);

		tbdPnSales = new JTabbedPane(JTabbedPane.TOP);
		tbdPnSales.setBounds(0, 0, 1244, 651);
		pnlSales.add(tbdPnSales);

		pnl = new JPanel();
		pnl.setBackground(new Color(102, 0, 153));
		tbdPnSales.addTab("New tab", null, pnl, null);
		pnl.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 589, 89, 23);
		pnl.add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new MainGuiSet().setVisible(true);
				dispose();
			}
		});

		
		
		jpnlClient = new JPanel(new BorderLayout());
		tbdPnSales.addTab("Ügyfél", null, jpnlClient, null);
		
		
		jpnlDevice = new JPanel();
		jpnlDevice.setBackground(new Color(102, 0, 153));
		tbdPnSales.addTab("Eszköz", null, jpnlDevice, null);
		
		panel = new JPanel();
		
		tbdPnSales.addTab("New tab", null, panel, null);
		
		
		
	
		
		 
		new CenterWindow().centerWindow(this);
	}
}
