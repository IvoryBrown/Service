package ex.main.device.config;

public class DeviceConfig {
	private Integer idg;
	private String clientName;
	private String deviceName;
	private String serial;
	private String status;
	private String priorit;
	private String comment;
	private Integer clientId;

	public DeviceConfig(Integer dIdg, String dClientName, String dDeviceName, String dSerial, String dStatus,
			String dPriorit, String dComment, Integer dClientId) {
		this.idg = dIdg;
		this.clientName = dClientName;
		this.deviceName = dDeviceName;
		this.serial = dSerial;
		this.status = dStatus;
		this.priorit = dPriorit;
		this.comment = dComment;
		this.clientId = dClientId;
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

	public String getComment() {
		return comment;
	}

	public Integer getClientId() {
		return clientId;
	}
}
