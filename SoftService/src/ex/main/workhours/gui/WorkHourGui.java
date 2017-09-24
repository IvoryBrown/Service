package ex.main.workhours.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ex.main.deviceimage.gui.DeviceImageJDBCSetDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WorkHourGui extends DeviceImageJDBCSetDAO {
	private JTextField txtWorkHoursSearch;
	protected JTable jtblWorkingHours;
	protected JDateChooser txtWorkHourAddDate, txtWorkHourEndDate, txtWorkHourCompletedDate;
	protected JButton btnWorkHoursDelete, btnWorkHoursEdit, btnWorkHoursNew, btnWorkHoursSearch, btnWorkHoursNull;
	protected JTextField txtWorkHourComment;
	private JLabel lblAddDate;
	private JLabel lblEndDate;
	private JLabel lblCompletedDate;
	private JLabel lblComment;
	protected JPanel pnlWorkHoursSett;

	public WorkHourGui() {
		jplWorkingHours.setLayout(null);

		 pnlWorkHoursSett = new JPanel();
		pnlWorkHoursSett.setLayout(null);
		pnlWorkHoursSett.setBounds(10, 11, 815, 63);
		jplWorkingHours.add(pnlWorkHoursSett);

		btnWorkHoursDelete = new JButton("törlés");
		btnWorkHoursDelete.setBounds(565, 12, 109, 37);
		pnlWorkHoursSett.add(btnWorkHoursDelete);

		btnWorkHoursEdit = new JButton("szerkesztés");
		btnWorkHoursEdit.setBounds(446, 12, 109, 37);
		pnlWorkHoursSett.add(btnWorkHoursEdit);

		btnWorkHoursNew = new JButton("új dátum");
		btnWorkHoursNew.setBounds(327, 11, 109, 37);
		pnlWorkHoursSett.add(btnWorkHoursNew);

		txtWorkHoursSearch = new JTextField();
		txtWorkHoursSearch.setColumns(10);
		txtWorkHoursSearch.setBackground(new Color(127, 255, 212));
		txtWorkHoursSearch.setBounds(10, 13, 185, 35);
		pnlWorkHoursSett.add(txtWorkHoursSearch);

		btnWorkHoursSearch = new JButton("keresés");
		btnWorkHoursSearch.setBounds(208, 12, 109, 37);
		pnlWorkHoursSett.add(btnWorkHoursSearch);

		btnWorkHoursNull = new JButton("null");
		btnWorkHoursNull.setBounds(684, 12, 109, 37);
		pnlWorkHoursSett.add(btnWorkHoursNull);

		JScrollPane scrPaneWorkingHours = new JScrollPane();
		scrPaneWorkingHours.setBounds(10, 85, 428, 493);
		jplWorkingHours.add(scrPaneWorkingHours);

		jtblWorkingHours = new JTable();
		scrPaneWorkingHours.setViewportView(jtblWorkingHours);

		txtWorkHourAddDate = new JDateChooser();
		txtWorkHourAddDate.setBackground(new Color(245, 255, 250));
		txtWorkHourAddDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourAddDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourAddDate.setBounds(153, 105, 189, 35);
		pnlWorkingHoursSetting.add(txtWorkHourAddDate);

		txtWorkHourEndDate = new JDateChooser();
		txtWorkHourEndDate.setBackground(new Color(245, 255, 250));
		txtWorkHourEndDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourEndDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourEndDate.setBounds(153, 151, 189, 35);
		pnlWorkingHoursSetting.add(txtWorkHourEndDate);

		txtWorkHourCompletedDate = new JDateChooser();
		txtWorkHourCompletedDate.setBackground(new Color(245, 255, 250));
		txtWorkHourCompletedDate.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourCompletedDate.setDateFormatString("yyyy-MM-dd");
		txtWorkHourCompletedDate.setBounds(153, 197, 189, 35);
		pnlWorkingHoursSetting.add(txtWorkHourCompletedDate);

		txtWorkHourComment = new JTextField();
		txtWorkHourComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWorkHourComment.setColumns(10);
		txtWorkHourComment.setBackground(new Color(245, 255, 250));
		txtWorkHourComment.setBounds(153, 243, 189, 131);
		pnlWorkingHoursSetting.add(txtWorkHourComment);
		
		lblAddDate = new JLabel("rögzítés: ");
		lblAddDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddDate.setBounds(10, 105, 140, 35);
		pnlWorkingHoursSetting.add(lblAddDate);
		
		lblEndDate = new JLabel("határidő: ");
		lblEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEndDate.setBounds(10, 151, 140, 35);
		pnlWorkingHoursSetting.add(lblEndDate);
		
		lblCompletedDate = new JLabel("elkészült: ");
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompletedDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompletedDate.setBounds(10, 197, 140, 35);
		pnlWorkingHoursSetting.add(lblCompletedDate);
		
		lblComment = new JLabel("megjegyzés: ");
		lblComment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComment.setBounds(10, 243, 140, 35);
		pnlWorkingHoursSetting.add(lblComment);

	}
}
