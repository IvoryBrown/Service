package ex.main.service.deviceimage.config;

public class DeviceImageConfig {

	private Integer deviceImageId;
	private Integer deviceId;
	private byte[] picture;

	public DeviceImageConfig(Integer deviceImageId, Integer dDeviceId, byte[] dPicture) {
		this.deviceImageId = deviceImageId;
		this.deviceId = dDeviceId;
		this.picture = dPicture;
	}

	public Integer getDeviceImageId() {
		return deviceImageId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public byte[] getPicture() {
		return picture;
	}
}
