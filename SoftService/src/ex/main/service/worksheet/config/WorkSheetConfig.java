package ex.main.service.worksheet.config;

public class WorkSheetConfig {
	private String clientNameNumber;
	private String clientNameWorkSheet;
	// eszköz
	private Integer deviceId;
	private String deviceNameWorkSheet;
	private String addDateWorkSheet;
	private String endDateWorkSheet;
	private String completeDateWorkSheet;
	private String statusWorkSheet;
	private String prioritWorkSheet;

	public WorkSheetConfig(String clientNameNumber, String clientNameWorkSheet, Integer deviceId,
			String deviceNameWorkSheet, String statusWorkSheet, String prioritWorkSheet, String addDateWorkSheet,
			String endDateWorkSheet, String completeDateWorkSheet) {
		this.clientNameNumber = clientNameNumber;
		this.clientNameWorkSheet = clientNameWorkSheet;
		this.deviceId = deviceId;
		this.deviceNameWorkSheet = deviceNameWorkSheet;
		this.addDateWorkSheet = addDateWorkSheet;
		this.endDateWorkSheet = endDateWorkSheet;
		this.completeDateWorkSheet = completeDateWorkSheet;
		this.statusWorkSheet = statusWorkSheet;
		this.prioritWorkSheet = prioritWorkSheet;
	}

	public String getClientNameNumber() {
		return clientNameNumber;
	}

	public String getClientNameWorkSheet() {
		return clientNameWorkSheet;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public String getDeviceNameWorkSheet() {
		return deviceNameWorkSheet;
	}

	public String getAddDateWorkSheet() {
		return addDateWorkSheet;
	}

	public String getEndDateWorkSheet() {
		return endDateWorkSheet;
	}

	public String getCompleteDateWorkSheet() {
		return completeDateWorkSheet;
	}

	public String getStatusWorkSheet() {
		return statusWorkSheet;
	}

	public String getPrioritWorkSheet() {
		return prioritWorkSheet;
	}
}
