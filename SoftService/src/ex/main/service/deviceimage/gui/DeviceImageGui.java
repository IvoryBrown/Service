package ex.main.service.deviceimage.gui;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import ex.main.service.device.DeviceJDBCSetDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class DeviceImageGui extends DeviceJDBCSetDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9110616842061672928L;
	protected JTextField txtDeviceImageSearch;
	protected JTable jtblDeviceImage;
	protected JButton btnDeviceImageSearch, btnDeviceImageDelete, btnDeviceImageNew, btnDeviceImageEdit,
			btnDeviceImageUpload, btnUpdate;
	protected JLabel jlblDeviceImage;
	protected JScrollPane scrlDeviceImage;
	

	public DeviceImageGui() {
		txtDeviceImageID.setLocation(977, 40);
		txtDeviceImageIDDevice.setLocation(1082, 40);

		jlblDeviceImage = new JLabel();
		jlblDeviceImage.setOpaque(true);
		jlblDeviceImage.setBackground(new Color(204, 255, 255));
		jlblDeviceImage.setBounds(322, 86, 907, 492);
		jplDeviceImage.add(jlblDeviceImage);

		JPanel pnlDeviceImageSetting = new JPanel();
		pnlDeviceImageSetting.setLayout(null);
		pnlDeviceImageSetting.setBounds(10, 11, 942, 63);
		jplDeviceImage.add(pnlDeviceImageSetting);

		btnDeviceImageSearch = new JButton("keresés");
		btnDeviceImageSearch.setBounds(208, 12, 109, 37);
		pnlDeviceImageSetting.add(btnDeviceImageSearch);

		btnDeviceImageDelete = new JButton("törlés");
		btnDeviceImageDelete.setBounds(565, 12, 109, 37);
		pnlDeviceImageSetting.add(btnDeviceImageDelete);

		btnDeviceImageNew = new JButton("új kép");
		btnDeviceImageNew.setIcon(new ImageIcon("\\PNG\\Button Add-01.png"));

		btnDeviceImageNew.setBounds(327, 11, 109, 37);
		pnlDeviceImageSetting.add(btnDeviceImageNew);

		btnDeviceImageEdit = new JButton("szerkesztés");
		btnDeviceImageEdit.setBounds(446, 12, 109, 37);
		pnlDeviceImageSetting.add(btnDeviceImageEdit);

		txtDeviceImageSearch = new JTextField();
		txtDeviceImageSearch.setColumns(10);
		txtDeviceImageSearch.setBackground(new Color(127, 255, 212));
		txtDeviceImageSearch.setBounds(10, 13, 185, 35);
		pnlDeviceImageSetting.add(txtDeviceImageSearch);

		btnDeviceImageUpload = new JButton("kép feltöltés");
		btnDeviceImageUpload.setBounds(684, 12, 109, 37);
		pnlDeviceImageSetting.add(btnDeviceImageUpload);
		
		btnUpdate = new JButton("null");
		btnUpdate.setBounds(803, 12, 109, 37);
		pnlDeviceImageSetting.add(btnUpdate);

		scrlDeviceImage = new JScrollPane();
		scrlDeviceImage.setBounds(10, 85, 302, 493);
		jplDeviceImage.add(scrlDeviceImage);

		jtblDeviceImage = new JTable();
		scrlDeviceImage.setViewportView(jtblDeviceImage);

	}

}
