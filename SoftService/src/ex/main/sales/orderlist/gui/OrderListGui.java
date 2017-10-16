package ex.main.sales.orderlist.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import ex.main.sales.worksheet.WorkSheetJDBCSetDAO;

public class OrderListGui extends WorkSheetJDBCSetDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4081536249718275538L;

	public OrderListGui() {
		

		setComponent();
	}

	private void setComponent() {
		pnlOrderList.setLayout(null);

		final JPanel sss = new JPanel();
		sss.setPreferredSize(new Dimension(1190, 1000));
		sss.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(sss);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 1214, 509);
		pnlOrderList.add(scrollPane);

		JLabel label = new JLabel("azonosító: ");
		label.setBounds(10, 11, 247, 35);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label);

		JLabel label_1 = new JLabel("azonosító: ");
		label_1.setBounds(267, 11, 918, 35);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(153, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_1);

		JLabel label_2 = new JLabel("név: ");
		label_2.setBounds(10, 57, 247, 35);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(153, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_2);

		JLabel label_3 = new JLabel("név: ");
		label_3.setBounds(267, 57, 918, 35);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(153, 0, 0));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_3);

		JLabel label_4 = new JLabel("telefon: ");
		label_4.setBounds(10, 103, 247, 35);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(153, 0, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_4);

		JLabel label_5 = new JLabel("telefon: ");
		label_5.setBounds(267, 103, 918, 35);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(153, 0, 0));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_5);

		JLabel label_6 = new JLabel("lakcím: ");
		label_6.setBounds(10, 149, 247, 35);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(153, 0, 0));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_6);

		JLabel label_7 = new JLabel("lakcím: ");
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(267, 149, 918, 35);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(153, 0, 0));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_7);

		JLabel label_8 = new JLabel("megjegyzés: ");
		label_8.setBounds(10, 195, 247, 35);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(153, 0, 0));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_8);

		JLabel label_9 = new JLabel("megjegyzés: ");
		label_9.setBounds(267, 195, 918, 35);
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setForeground(new Color(153, 0, 0));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		sss.add(label_9);
	}
}
