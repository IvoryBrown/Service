package ex.main.service.worksheet.config;

public class WorkSheetConfig {
	private String clientNameWorkSheet;
	private String deviceNameWorkSheet;
	private String addDateWorkSheet;
	private String endDateWorkSheet;
	private String completeDateWorkSheet;
	private String statusWorkSheet;
	private String prioritWorkSheet;

	public WorkSheetConfig(String clientNameWorkSheet, String deviceNameWorkSheet, String statusWorkSheet,
			String prioritWorkSheet, String addDateWorkSheet, String endDateWorkSheet, String completeDateWorkSheet) {
		this.clientNameWorkSheet = clientNameWorkSheet;
		this.deviceNameWorkSheet = deviceNameWorkSheet;
		this.addDateWorkSheet = addDateWorkSheet;
		this.endDateWorkSheet = endDateWorkSheet;
		this.completeDateWorkSheet = completeDateWorkSheet;
		this.statusWorkSheet = statusWorkSheet;
		this.prioritWorkSheet = prioritWorkSheet;
	}

	public String getClientNameWorkSheet() {
		return clientNameWorkSheet;
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
