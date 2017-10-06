package ex.main.service.device.config;

public class DeviceConfig {
	private Integer idg;
	private String clientName;
	private String deviceName;
	private String type;
	private String serial;
	private String status;
	private String priorit;
	private String buyingDate;
	private String addDate;
	private String exitDate;
	private String completedDate;
	private String softwer;
	private String hardver;
	private String cleaning;
	private String password;
	private String accesssory;
	private String injury;
	private String fault;
	private String comment;
	private Integer clientId;
	
	public DeviceConfig(Integer idg, String clientName, String deviceName, String type, String serial, String status,
			String priorit, String buyingDate, String addDate, String exitDate, String completedDate, String softwer,
			String hardver, String cleaning, String password, String accesssory, String injury, String fault,
			String comment, Integer clientId) {
		super();
		this.idg = idg;
		this.clientName = clientName;
		this.deviceName = deviceName;
		this.type = type;
		this.serial = serial;
		this.status = status;
		this.priorit = priorit;
		this.buyingDate = buyingDate;
		this.addDate = addDate;
		this.exitDate = exitDate;
		this.completedDate = completedDate;
		this.softwer = softwer;
		this.hardver = hardver;
		this.cleaning = cleaning;
		this.password = password;
		this.accesssory = accesssory;
		this.injury = injury;
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

	public String getDeviceName() {
		return deviceName;
	}

	public String getType() {
		return type;
	}

	public String getSerial() {
		return serial;
	}

	public String getStatus() {
		return status;
	}

	public String getPriorit() {
		return priorit;
	}

	public String getBuyingDate() {
		return buyingDate;
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

	public String getSoftwer() {
		return softwer;
	}

	public String getHardver() {
		return hardver;
	}

	public String getCleaning() {
		return cleaning;
	}

	public String getPassword() {
		return password;
	}

	public String getAccesssory() {
		return accesssory;
	}

	public String getInjury() {
		return injury;
	}

	public String getFault() {
		return fault;
	}

	public String getComment() {
		return comment;
	}

	public Integer getClientId() {
		return clientId;
	}

	
	

	
}
