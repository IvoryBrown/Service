package ex.main.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

@SuppressWarnings({ "unused", "serial" })
public class Gui extends JFrame {
	private JPanel jplMainPanel;
	private SpringLayout springLayout;
	private SpringLayout sl_jplMainPanel;
	private JTabbedPane jTbdPane;
	private JPanel jplWorksheet, jplClients, jplDevice;
	private FlowLayout fl_jplClients;

	public Gui() {

		setComponent();
	}

	private void setComponent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1250, 680);
		this.setResizable(false);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		jplMainPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, jplMainPanel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, jplMainPanel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, jplMainPanel, 651, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, jplMainPanel, 1244, SpringLayout.WEST, getContentPane());
		getContentPane().add(jplMainPanel);
		sl_jplMainPanel = new SpringLayout();
		jplMainPanel.setLayout(sl_jplMainPanel);

		jTbdPane = new JTabbedPane(JTabbedPane.TOP);
		sl_jplMainPanel.putConstraint(SpringLayout.NORTH, jTbdPane, 0, SpringLayout.NORTH, jplMainPanel);
		sl_jplMainPanel.putConstraint(SpringLayout.WEST, jTbdPane, 0, SpringLayout.WEST, jplMainPanel);
		sl_jplMainPanel.putConstraint(SpringLayout.SOUTH, jTbdPane, 617, SpringLayout.NORTH, jplMainPanel);
		sl_jplMainPanel.putConstraint(SpringLayout.EAST, jTbdPane, 0, SpringLayout.EAST, jplMainPanel);
		jplMainPanel.add(jTbdPane);

		jplWorksheet = new JPanel();
		jTbdPane.addTab("Munkalap", null, jplWorksheet, null);

		jplClients = new JPanel();
		fl_jplClients = (FlowLayout) jplClients.getLayout();
		jTbdPane.addTab("Ügyfelek", (Icon) null, jplClients, null);
		jTbdPane.setForegroundAt(1, new Color(0, 0, 0));

		jplDevice = new JPanel();
		jTbdPane.addTab("Eszköz", null, jplDevice, null);

		JLabel lblNewLabel = new JLabel("Verzió: 1.0.0");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		sl_jplMainPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, jTbdPane);
		sl_jplMainPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, jplMainPanel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		jplMainPanel.add(lblNewLabel);

	}
}
