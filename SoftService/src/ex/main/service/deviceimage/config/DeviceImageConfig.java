package ex.main.service.deviceimage.config;

public class DeviceImageConfig {

	private Integer deviceImageId;
	private String clientName;
	private String deviceName;
	private String deviceSerial;
	private Integer deviceId;
	private byte[] picture;

	public DeviceImageConfig(Integer deviceImageId, String dClientName, String dDeviceName, String dDeviceSerial,
			Integer dDeviceId, byte[] dPicture) {
		this.deviceImageId = deviceImageId;
		this.clientName = dClientName;
		this.deviceName = dDeviceName;
		this.deviceSerial = dDeviceSerial;
		this.deviceId = dDeviceId;
		this.picture = dPicture;
	}

	public Integer getDeviceImageId() {
		return deviceImageId;
	}

	public String getClientName() {
		return clientName;
	}

	public String getDeviceImageName() {
		return deviceName;
	}

	public String getDeviceSerial() {
		return deviceSerial;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public byte[] getPicture() {
		return picture;
	}
}
