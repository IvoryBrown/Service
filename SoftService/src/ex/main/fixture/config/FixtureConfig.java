package ex.main.fixture.config;

public class FixtureConfig {

	private Integer fixtureId;
	private String fixtureDeviceName;
	private String fixtureDeviceSerial;
	private String fixtureName;
	private String fixtureSerial;
	private String fixtureComment;
	private Integer fixtureDeviceId;

	public FixtureConfig(Integer fixtureId, String fixtureDeviceName, String fixtureDeviceSerial, String fixtureName,
			String fixtureSerial, String fixtureComment, Integer fixtureDeviceId) {
		super();
		this.fixtureId = fixtureId;
		this.fixtureDeviceName = fixtureDeviceName;
		this.fixtureDeviceSerial = fixtureDeviceSerial;
		this.fixtureName = fixtureName;
		this.fixtureSerial = fixtureSerial;
		this.fixtureComment = fixtureComment;
		this.fixtureDeviceId = fixtureDeviceId;
	}

	public Integer getFixtureId() {
		return fixtureId;
	}

	public String getFixtureDeviceName() {
		return fixtureDeviceName;
	}

	public String getFixtureDeviceSerial() {
		return fixtureDeviceSerial;
	}

	public String getFixtureName() {
		return fixtureName;
	}

	public String getFixtureSerial() {
		return fixtureSerial;
	}

	public String getFixtureComment() {
		return fixtureComment;
	}

	public Integer getFixtureDeviceId() {
		return fixtureDeviceId;
	}
}
