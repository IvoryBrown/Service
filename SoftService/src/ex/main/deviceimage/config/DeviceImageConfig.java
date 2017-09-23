package ex.main.deviceimage.config;

public class DeviceImageConfig {

	private String clientName;
	private String deviceName;
	private String deviceSerial;
	private Integer deviceId;
	private byte[] picture;

	public DeviceImageConfig( String dClientName, String dDeviceName, String dDeviceSerial, Integer dDeviceId,byte[] dPicture) {
		this.clientName = dClientName;
		this.deviceName= dDeviceName;
		this.deviceSerial = dDeviceSerial;
		this.deviceId = dDeviceId;
		this.picture = dPicture;
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
