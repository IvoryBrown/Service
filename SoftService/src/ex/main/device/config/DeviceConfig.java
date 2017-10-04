package ex.main.device.config;

public class DeviceConfig {
	private Integer idg;
	private String clientName;
	private String deviceName;
	private String type;
	private String serial;
	private String status;
	private String priorit;
	private String addDate;
	private String exitDate;
	private String completedDate;
	private String softwer;
	private String hardver;
	private String cleaning;
	private String fault;
	private String comment;
	private Integer clientId;

	public DeviceConfig(Integer idg, String clientName, String deviceName, String type, String serial, String status,
			String priorit, String addDate, String exitDate, String completedDate, String softwer, String hardver,
			String cleaning, String fault, String comment, Integer clientId) {
		super();
		this.idg = idg;
		this.clientName = clientName;
		this.deviceName = deviceName;
		this.type = type;
		this.serial = serial;
		this.status = status;
		this.priorit = priorit;
		this.addDate = addDate;
		this.exitDate = exitDate;
		this.completedDate = completedDate;
		this.softwer = softwer;
		this.hardver = hardver;
		this.cleaning = cleaning;
		this.fault = fault;
		this.comment = comment;
		this.clientId = clientId;
	}

	

	public Integer getIdg() {
		return idg;
	}

	public String getClientName() {
		return clientName;
	}

	public String getSerial() {
		return serial;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getStatus() {
		return status;
	}

	public String getPriorit() {
		return priorit;
	}

	public String getAddDate() {
		return addDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public String getComment() {
		return comment;
	}

	public Integer getClientId() {
		return clientId;
	}

	public String getType() {
		return type;
	}

	public String getSoftwer() {
		return softwer;
	}

	public String getHardver() {
		return hardver;
	}

	public String getCleaning() {
		return cleaning;
	}

	public String getFault() {
		return fault;
	}
}
