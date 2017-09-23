package ex.main.workhours.config;

public class WorkHoursConfig {

	private String serialDevice;
	private String addDate;
	private String exitDate;
	private Integer spentDate;
	private String completedDate;
	private String commentWorkHours;
	private Integer deviceId;

	public WorkHoursConfig(String serialDevice, String addDate, String exitDate, Integer spentDate,
			String completedDate, String commentWorkHours, Integer deviceId) {
		this.serialDevice = serialDevice;
		this.addDate = addDate;
		this.exitDate = exitDate;
		this.spentDate = spentDate;
		this.completedDate = completedDate;
		this.commentWorkHours = commentWorkHours;
		this.deviceId = deviceId;
	}

	public String getSerialDevice() {
		return serialDevice;
	}

	public String getAddDate() {
		return addDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public Integer getSpentDate() {
		return spentDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public String getCommentWorkHours() {
		return commentWorkHours;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

}
