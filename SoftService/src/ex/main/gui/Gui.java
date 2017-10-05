package ex.main.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import ex.main.setting.CenterWindow;
import ex.main.setting.DataBaseConnect;
import java.awt.Toolkit;

public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -902277029378989079L;
	protected JPanel jplMainPanel;
	protected JTabbedPane jTbdPane;
	protected JPanel jplWorksheet, jplClients, jplDevice;
	protected FlowLayout fl_jplClients;
	DataBaseConnect connect = new DataBaseConnect();
	private JPanel panel;
	protected JPanel jplDeviceImage;
	private JPanel jplSoftver;

	public Gui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/icon/function/48x48/world-blocks.png")));

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

		JLabel lblNewLabel = new JLabel("Verzió: 1.0.0");
		lblNewLabel.setBounds(1152, 623, 82, 16);
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		jplMainPanel.add(lblNewLabel);

		panel = new JPanel();
		panel.setBounds(5, 623, 225, 23);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setForeground(new Color(0, 128, 0));
		jplMainPanel.add(panel);
		panel.add(connect.getSubtitle());

	}
}
