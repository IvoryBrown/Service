package ex.main.service.fixture.config;

public class FixtureConfig {

	private Integer fixtureId;
	private Integer fixtureDeviceId;
	private String fixtureName;
	private String fixtureManufacturer;
	private String fixtureSerial;
	private String fixtureComment;

	public FixtureConfig(Integer fixtureId, String fixtureName, String fixtureManufacturer, String fixtureSerial,
			String fixtureComment, Integer fixtureDeviceId) {
		super();
		this.fixtureId = fixtureId;
		this.fixtureName = fixtureName;
		this.fixtureManufacturer = fixtureManufacturer;
		this.fixtureSerial = fixtureSerial;
		this.fixtureComment = fixtureComment;
		this.fixtureDeviceId = fixtureDeviceId;
	}

	public Integer getFixtureId() {
		return fixtureId;
	}

	public String getFixtureName() {
		return fixtureName;
	}

	public String getFixtureManufacturer() {
		return fixtureManufacturer;
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
