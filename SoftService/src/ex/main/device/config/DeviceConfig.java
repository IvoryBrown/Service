package ex.main.device.config;

public class DeviceConfig {
	private Integer idg;
	private String serial;
	private String deviceName;
	private String status;
	private String priorit;
	private String comment;

	public DeviceConfig(Integer dIdg, String dSerial, String dDeviceName, String dStatus, String dPriorit,
			String dComment) {
		this.idg = dIdg;
		this.serial = dSerial;
		this.deviceName = dDeviceName;
		this.status = dStatus;
		this.priorit = dPriorit;
		this.comment = dComment;
	}

	public Integer getIdg() {
		return idg;
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
}
