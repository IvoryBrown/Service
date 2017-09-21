package ex.main.deviceimage.config;

public class DeviceImageConfig {

	private byte[] picture;
	private String clientName;
	private String deviceSerial;
	private Integer deviceId;

	public DeviceImageConfig(byte[] dPicture, String dClientName, String dDeviceSerial, Integer dDeviceId) {
		this.picture = dPicture;
		this.clientName = dClientName;
		this.deviceSerial = dDeviceSerial;
		this.deviceId = dDeviceId;
	}

	public byte[] getPicture() {
		return picture;
	}

	public String getClientName() {
		return clientName;
	}

	public String getDeviceSerial() {
		return deviceSerial;
	}

	public Integer getDeviceId() {
		return deviceId;
	}
}
