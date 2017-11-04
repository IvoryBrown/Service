package ex.main.service.deviceimage;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import ex.main.sales.device.DeviceJDBCSetDAO;
import ex.main.service.deviceimage.config.DeviceImageConfig;
import ex.main.service.deviceimage.config.DeviceImageImplements;
import ex.main.service.deviceimage.gui.DeviceImageGui;
import ex.main.setting.database.DataBaseConnect;

public class DeviceImageJDBCSetDAO extends DeviceImageGui implements DeviceImageImplements {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1391054896161829962L;
	String ImgPath = null;
	private String[] rows;
	private Object columns[][];

	public DeviceImageJDBCSetDAO() {
		setActionDeviceImage();
		showProductsInJTableDeviceImage();
	}

	private void setActionDeviceImage() {
		rows = new String[] { "ID", "eszköz azonosító", "kép" };
		jtblDeviceImage.setModel(new javax.swing.table.DefaultTableModel(columns, rows));
		jtblDeviceImage.getColumn("ID").setMinWidth(50);
		jtblDeviceImage.getColumn("ID").setMaxWidth(50);
		jtblDeviceImage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClickedDeviceImage(evt);
			}
		});
		btnDeviceImageNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnInsertActionPerformedDeviceImage(evt);
			}
		});
		btnDeviceImageEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnUpdateActionPerformedDeviceImage(evt);
			}
		});
		btnDeviceImageUpload.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});
		btnDeviceImageDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int res = JOptionPane.showConfirmDialog(null, "Biztos törölni szeretnéd?", "Figyelmeztetés",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION)
					jDeleteActionPerformedDeviceImage(evt);
				else
					return;
			}
		});
		btnDeviceImageSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				showProductsInJTableDeviceImage();
			}
		});
		txtDeviceImageSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					showProductsInJTableDeviceImage();
				}
			}
		});
	}

	private boolean checkInputsDeviceImage() {
		if (txtDeviceImageIDDevice.getText().trim().isEmpty()) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	public ImageIcon ResizeImage(String imagePath, byte[] pic) {
		jlblDeviceImage.setIcon(null);
		ImageIcon myImage = null;
		if (imagePath != null) {
			myImage = new ImageIcon(imagePath);
			Image img = myImage.getImage();
			Image img2 = img.getScaledInstance(jlblDeviceImage.getWidth(), jlblDeviceImage.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(img2);
			return image;
		} else if (pic != null) {
			myImage = new ImageIcon(pic);
			Image img = myImage.getImage();
			Image img2 = img.getScaledInstance(jlblDeviceImage.getWidth(), jlblDeviceImage.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(img2);
			return image;
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<DeviceImageConfig> getDeviceImageProductList() {
		ArrayList<DeviceImageConfig> productListDeviceImage = new ArrayList<DeviceImageConfig>();
		Connection con = DataBaseConnect.getConnection();
		String query = "SELECT * FROM `image_gep`WHERE CONCAT (`gepadatok_ID_g`) LIKE '%"
				+ txtDeviceImageSearch.getText() + "%' ";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			DeviceImageConfig product;
			while (rs.next()) {
				product = new DeviceImageConfig(rs.getInt("ID_image_gep"), rs.getInt("gepadatok_ID_g"),
						rs.getBytes("Image_i"));
				productListDeviceImage.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DeviceImageJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				Logger.getLogger(DeviceJDBCSetDAO.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return productListDeviceImage;
	}

	private void showProductsInJTableDeviceImage() {
		ArrayList<DeviceImageConfig> listDeviceImage = getDeviceImageProductList();
		DefaultTableModel modelDevice = (DefaultTableModel) jtblDeviceImage.getModel();
		modelDevice.setRowCount(0);
		Object[] rowDevice = new Object[3];
		for (int i = 0; i < listDeviceImage.size(); i++) {
			rowDevice[0] = listDeviceImage.get(i).getDeviceImageId();
			rowDevice[1] = listDeviceImage.get(i).getDeviceId();
			rowDevice[2] = listDeviceImage.get(i).getPicture();

			modelDevice.addRow(rowDevice);
		}
	}

	private void ShowItemDeviceImage(int index) {
		txtDeviceImageIDDevice.setText((Integer.toString(getDeviceImageProductList().get(index).getDeviceId())));
		txtDeviceImageID.setText((Integer.toString(getDeviceImageProductList().get(index).getDeviceImageId())));
		jlblDeviceImage.setIcon(ResizeImage(null, getDeviceImageProductList().get(index).getPicture()));

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
			JOptionPane.showMessageDialog(null, "Nincs fájl kiválasztva");
		}
	}

	private void jBtnInsertActionPerformedDeviceImage(java.awt.event.ActionEvent evt) {
		if (checkInputsDeviceImage()) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement insertDeviceImage = con
						.prepareStatement("INSERT INTO image_gep(gepadatok_ID_g, Image_i)" + "values(?,?) ");
				insertDeviceImage.setString(1, txtDeviceImageIDDevice.getText());
				InputStream img = new FileInputStream(new File(ImgPath));
				insertDeviceImage.setBlob(2, img);
				insertDeviceImage.executeUpdate();
				showProductsInJTableDeviceImage();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Kép nem található: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}
	}

	private void jBtnUpdateActionPerformedDeviceImage(java.awt.event.ActionEvent evt) {
		if (checkInputsDeviceImage() && ImgPath != null) {
			String updateDevice = null;
			PreparedStatement psDeviceImage = null;
			Connection con = DataBaseConnect.getConnection();
			try {
				updateDevice = "UPDATE image_gep SET  Image_i = ?, gepadatok_ID_g = ? WHERE ID_image_gep = ?";
				psDeviceImage = con.prepareStatement(updateDevice);

				InputStream img = new FileInputStream(new File(ImgPath));
				psDeviceImage.setBlob(1, img);
				psDeviceImage.setString(2, txtDeviceImageIDDevice.getText());
				psDeviceImage.setString(3, txtDeviceImageID.getText());
				psDeviceImage.executeUpdate();
				showProductsInJTableDeviceImage();
				JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
			} catch (SQLException ex) {
				Logger.getLogger(DeviceImageJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Kép nem található");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jDeleteActionPerformedDeviceImage(java.awt.event.ActionEvent evt) {
		if (!txtDeviceImageID.getText().equals("")) {
			try {
				Connection con = DataBaseConnect.getConnection();
				PreparedStatement DELETE = con.prepareStatement("DELETE FROM image_gep WHERE ID_image_gep = ?");
				int id = Integer.parseInt(txtDeviceImageID.getText());
				DELETE.setInt(1, id);
				DELETE.executeUpdate();
				showProductsInJTableDeviceImage();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(DeviceImageJDBCSetDAO.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void JTable_ProductsMouseClickedDeviceImage(java.awt.event.MouseEvent evt) {
		int index = jtblDeviceImage.getSelectedRow();
		ShowItemDeviceImage(index);
	}
}
