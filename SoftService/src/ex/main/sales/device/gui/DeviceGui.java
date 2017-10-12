package ex.main.sales.device.gui;

import ex.main.sales.client.ClientJDBCSetDAO;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DeviceGui extends ClientJDBCSetDAO {
	public DeviceGui() {
		
		setGuiDeviceClient();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1289447200090810218L;
	protected JTable jtblSalesDevice;
	protected JTextField textField;
	protected JButton button;
	private JPanel panel_1;
	private JTextField textField_1;
	private JTextField textField_2;

	private void setGuiDeviceClient() {
		jpnlDevice.setLayout(null);

		JScrollPane scrDevice = new JScrollPane();
		scrDevice.setBounds(10, 377, 1219, 235);
		jpnlDevice.add(scrDevice);

		jtblSalesDevice = new JTable();
		scrDevice.setViewportView(jtblSalesDevice);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(879, 11, 350, 56);
		jpnlDevice.add(panel);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBackground(new Color(204, 51, 204));
		textField.setBounds(10, 11, 152, 35);
		panel.add(textField);
		
		 button = new JButton("");
		button.setBounds(162, 11, 51, 35);
		panel.add(button);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(new Object[]{});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(217, 11, 123, 35);
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 597, 332);
		jpnlDevice.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNv = new JLabel("név:");
		lblNv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNv.setBounds(0, 11, 140, 35);
		panel_1.add(lblNv);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(245, 255, 250));
		textField_1.setBounds(142, 11, 189, 35);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(245, 255, 250));
		textField_2.setBounds(341, 11, 95, 35);
		panel_1.add(textField_2);
		
		JLabel lblEszkz = new JLabel("eszköz:");
		lblEszkz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEszkz.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEszkz.setBounds(0, 57, 140, 35);
		panel_1.add(lblEszkz);
		
		JLabel label = new JLabel("azonosító: ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(0, 103, 140, 35);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("azonosító: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(0, 149, 140, 35);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("azonosító: ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(0, 195, 140, 35);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("azonosító: ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(0, 241, 140, 35);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("azonosító: ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(0, 287, 140, 35);
		panel_1.add(label_4);
		panel.setLayout(null);
	}
}
