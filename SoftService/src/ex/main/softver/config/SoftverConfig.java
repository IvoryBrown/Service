package ex.main.softver.config;

public class SoftverConfig {
	private Integer softverId;
	private String softverDeviceName;
	private String softverDeviceSerial;
	private String softverName;
	private String softverComment;
	private Integer softverDeviceId;

	public SoftverConfig(Integer softverId, String softverDeviceName, String softverDeviceSerial, String softverName,
			String softverComment, Integer softverDeviceId) {
		super();
		this.softverId = softverId;
		this.softverDeviceName = softverDeviceName;
		this.softverDeviceSerial = softverDeviceSerial;
		this.softverName = softverName;
		this.softverComment = softverComment;
		this.softverDeviceId = softverDeviceId;
	}

	public Integer getSoftverId() {
		return softverId;
	}

	public String getSoftverDeviceName() {
		return softverDeviceName;
	}

	public String getSoftverDeviceSerial() {
		return softverDeviceSerial;
	}

	public String getSoftverName() {
		return softverName;
	}

	public String getSoftverComment() {
		return softverComment;
	}

	public Integer getSoftverDeviceId() {
		return softverDeviceId;
	}

}
