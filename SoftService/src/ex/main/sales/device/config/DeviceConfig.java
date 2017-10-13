package ex.main.sales.device.config;

public class DeviceConfig {
	private Integer salesDeviceID; // eszköz id
	private String salesDeviceClientName; // ügyfél név
	private String salesDeviceName; // eszköz
	private String salesDevicdetType; // tipus
	private String salesDeviceStatus; // állapot
	private String salesDevicePriorit; // prioritás
	private String salesDeviceBuyingDate;// vásárlás
	private String salesDeviceAddDate; // rögzités
	private String salesDeviceExitDate;// határidő
	private String salesDeviceSoftwer; // softver
	private String salesDeviceCleaning;// takarítás
	private String salesDevicePassword; // jelszó
	private String salesDeviceAccesssory; // Tartozék
	private String salesDeviceInjury; // sérülés
	private String comment; // hibaleírás
	private Integer clientId; // ügyfél id

	public DeviceConfig(Integer salesDeviceID, String salesDeviceClientName, String salesDeviceName,
			String salesDevicdetType, String salesDeviceStatus, String salesDevicePriorit, String salesDeviceBuyingDate,
			String salesDeviceAddDate, String salesDeviceExitDate, String salesDeviceSoftwer,
			String salesDeviceCleaning, String salesDevicePassword, String salesDeviceAccesssory,
			String salesDeviceInjury, String comment, Integer clientId) {
		super();
		this.salesDeviceID = salesDeviceID;
		this.salesDeviceClientName = salesDeviceClientName;
		this.salesDeviceName = salesDeviceName;
		this.salesDevicdetType = salesDevicdetType;
		this.salesDeviceStatus = salesDeviceStatus;
		this.salesDevicePriorit = salesDevicePriorit;
		this.salesDeviceBuyingDate = salesDeviceBuyingDate;
		this.salesDeviceAddDate = salesDeviceAddDate;
		this.salesDeviceExitDate = salesDeviceExitDate;
		this.salesDeviceSoftwer = salesDeviceSoftwer;
		this.salesDeviceCleaning = salesDeviceCleaning;
		this.salesDevicePassword = salesDevicePassword;
		this.salesDeviceAccesssory = salesDeviceAccesssory;
		this.salesDeviceInjury = salesDeviceInjury;
		this.comment = comment;
		this.clientId = clientId;
	}

	public Integer getSalesDeviceID() {
		return salesDeviceID;
	}

	public String getSalesDeviceClientName() {
		return salesDeviceClientName;
	}

	public String getSalesDeviceName() {
		return salesDeviceName;
	}

	public String getSalesDevicdetType() {
		return salesDevicdetType;
	}

	public String getSalesDeviceStatus() {
		return salesDeviceStatus;
	}

	public String getSalesDevicePriorit() {
		return salesDevicePriorit;
	}

	public String getSalesDeviceBuyingDate() {
		return salesDeviceBuyingDate;
	}

	public String getSalesDeviceAddDate() {
		return salesDeviceAddDate;
	}

	public String getSalesDeviceExitDate() {
		return salesDeviceExitDate;
	}

	public String getSalesDeviceSoftwer() {
		return salesDeviceSoftwer;
	}

	public String getSalesDeviceCleaning() {
		return salesDeviceCleaning;
	}

	public String getSalesDevicePassword() {
		return salesDevicePassword;
	}

	public String getSalesDeviceAccesssory() {
		return salesDeviceAccesssory;
	}

	public String getSalesDeviceInjury() {
		return salesDeviceInjury;
	}

	public String getComment() {
		return comment;
	}

	public Integer getClientId() {
		return clientId;
	}
}
