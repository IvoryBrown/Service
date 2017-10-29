package ex.main.sales.client.config;

public class ClientConfig {
	private Integer salesClientID;
	private String salesClientNumber;
	private String salesClientCompanyName;
	private String salesClientName;
	private String salesClientMobil;
	private String salesClientHomeAddress;
	private String salesClientComment;

	public ClientConfig(Integer salesClientID, String salesClientNumber, String salesClientCompanyName,
			String salesClientName, String salesClientMobil, String salesClientHomeAddress, String salesClientComment) {
		super();
		this.salesClientID = salesClientID;
		this.salesClientNumber = salesClientNumber;
		this.salesClientCompanyName = salesClientCompanyName;
		this.salesClientName = salesClientName;
		this.salesClientMobil = salesClientMobil;
		this.salesClientHomeAddress = salesClientHomeAddress;
		this.salesClientComment = salesClientComment;
	}

	public Integer getSalesClientID() {
		return salesClientID;
	}

	public String getSalesClientNumber() {
		return salesClientNumber;
	}

	public String getSalesClientCompanyName() {
		return salesClientCompanyName;
	}

	public String getSalesClientName() {
		return salesClientName;
	}

	public String getSalesClientMobil() {
		return salesClientMobil;
	}

	public String getSalesClientHomeAddress() {
		return salesClientHomeAddress;
	}

	public String getSalesClientComment() {
		return salesClientComment;
	}
}
