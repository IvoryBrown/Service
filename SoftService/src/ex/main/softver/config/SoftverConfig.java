package ex.main.softver.config;

public class SoftverConfig {
	private Integer softverId;
	private String softverName;
	private String softverComment;
	private Integer softverDeviceId;

	public SoftverConfig(Integer softverId, String softverName, String softverComment, Integer softverDeviceId) {
		super();
		this.softverId = softverId;
		this.softverName = softverName;
		this.softverComment = softverComment;
		this.softverDeviceId = softverDeviceId;
	}

	public Integer getSoftverId() {
		return softverId;
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
