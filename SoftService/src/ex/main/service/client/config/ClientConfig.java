package ex.main.service.client.config;

public class ClientConfig {
	private Integer iDm;
	private String iD;
	private String companyName;
	private String name;
	private String mobil;
	private String homeAddress;
	private String comment;

	public ClientConfig(Integer cIdm,String cID,String companyName, String cName, String cMobil, String cHomeAddress, String cComment) {
		this.iDm= cIdm;
		this.iD = cID;
		this.companyName=companyName;
		this.name = cName;
		this.mobil = cMobil;
		this.homeAddress = cHomeAddress;
		this.comment = cComment;
	}

	public Integer getiDm() {
		return iDm;
	}

	public String getiD() {
		return iD;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getName() {
		return name;
	}

	public String getMobil() {
		return mobil;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getComment() {
		return comment;
	}

}
