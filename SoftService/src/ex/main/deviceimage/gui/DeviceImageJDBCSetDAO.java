package ex.main.deviceimage.gui;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import ex.main.deviceimage.config.DeviceImageConfig;
import ex.main.deviceimage.config.DeviceImageImplements;
import ex.main.setting.DataBaseConnect;

public class DeviceImageJDBCSetDAO extends DeviceImageGui implements DeviceImageImplements {
	String ImgPath = null;
	public DeviceImageJDBCSetDAO() {
		setActionDeviceImage();
		showProductsInJTableDeviceImage();
	}

	private void setActionDeviceImage() {
		jtblDeviceImage.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ügyfél", "sorozatszám", "" }));
		jtblDeviceImage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedDeviceImage(evt);
			}
		});
		btnDeviceImageUpload.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});
	}

	public ImageIcon ResizeImage(String imagePath, byte[] pic) {
		ImageIcon myImage = null;
		if (imagePath != null) {
			myImage = new ImageIcon(imagePath);
		} else {
			myImage = new ImageIcon(pic);
		}
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(jlblDeviceImage.getWidth(), jlblDeviceImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}

	@Override
	public ArrayList<DeviceImageConfig> getDeviceImageProductList() {
		ArrayList<DeviceImageConfig> productListDeviceImage = new ArrayList<DeviceImageConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM image_gep ";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			DeviceImageConfig product;
			while (rs.next()) {
				product = new DeviceImageConfig(rs.getBytes("Image_i"), rs.getString("ugyfel_nev_i"),
						rs.getString("sorozatszam_i"), rs.getInt("gepadatok_ID_g"));
				productListDeviceImage.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceImageJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productListDeviceImage;
	}

	private void showProductsInJTableDeviceImage() {
		ArrayList<DeviceImageConfig> listDeviceImage = getDeviceImageProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jtblDeviceImage.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[2];
		for (int i = 0; i < listDeviceImage.size(); i++) {
			rowDevice[0] = listDeviceImage.get(i).getClientName();
			rowDevice[1] = listDeviceImage.get(i).getDeviceSerial();
			modelDevice.addRow(rowDevice);
		}
	}

	private void ShowItemDeviceImage(int index) {
		jlblDeviceImage.setIcon(ResizeImage(null, getDeviceImageProductList().get(index).getPicture()));
		txtDeviceImageClientName.setText(getDeviceImageProductList().get(index).getClientName());
		txtDeviceImageDeviceId.setText((Integer.toString(getDeviceImageProductList().get(index).getDeviceId())));
		txtDeviceImageSerialDevice.setText(getDeviceImageProductList().get(index).getDeviceSerial());

	}
	private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			jlblDeviceImage.setIcon(ResizeImage(path, null));
			ImgPath = path;
		} else {
			System.out.println("Nincs fájl kiválasztva");
		}
	}

	private void JTable_ProductsMouseClickedDeviceImage(java.awt.event.MouseEvent evt) {
		int index = jtblDeviceImage.getSelectedRow();
		ShowItemDeviceImage(index);
	}
}
