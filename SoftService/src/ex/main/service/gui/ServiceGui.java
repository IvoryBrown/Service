package ex.main.service.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ex.main.setting.centerwindow.CenterWindow;

public class ServiceGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -902277029378989079L;
	protected JPanel jplMainPanel;
	protected JTabbedPane jTbdPane;
	protected JPanel jplWorksheet, jplClients, jplDevice;
	protected FlowLayout fl_jplClients;
	protected JPanel jplDeviceImage;
	protected  JPanel jplSoftver;
	protected JPanel jplFixture;

	public ServiceGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ServiceGui.class.getResource("/icon/function/48x48/world-blocks.png")));

		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		getContentPane().setLayout(null);
		new CenterWindow().centerWindow(this);

		jplMainPanel = new JPanel();
		jplMainPanel.setBounds(0, 0, 1244, 651);
		getContentPane().add(jplMainPanel);
		jplMainPanel.setLayout(null);

		jTbdPane = new JTabbedPane(JTabbedPane.TOP);
		jTbdPane.setBounds(0, 0, 1244, 617);
		jplMainPanel.add(jTbdPane);

		jplWorksheet = new JPanel();
		jTbdPane.addTab("Munkalap", null, jplWorksheet, null);

		jplClients = new JPanel();
		fl_jplClients = (FlowLayout) jplClients.getLayout();
		jTbdPane.addTab("Ügyfelek", (Icon) null, jplClients, null);
		jTbdPane.setForegroundAt(1, new Color(0, 0, 0));

		jplDevice = new JPanel();
		jTbdPane.addTab("Eszköz", null, jplDevice, null);

		jplDeviceImage = new JPanel();
		jTbdPane.addTab("Eszköz képek", null, jplDeviceImage, null);
		jplDeviceImage.setLayout(null);
		
		jplSoftver = new JPanel();
		jTbdPane.addTab("Softver", null, jplSoftver, null);
		
		jplFixture = new JPanel();
		jTbdPane.addTab("Alkatrész", null, jplFixture, null);
		

	}
}
