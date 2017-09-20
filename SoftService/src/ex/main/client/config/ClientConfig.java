package ex.main.client.config;

public class ClientConfig {
	private Integer iDm;
	private Integer iD;
	private String name;
	private String mobil;
	private String homeAddress;
	private String comment;

	public ClientConfig(Integer cIdm,Integer cID, String cName, String cMobil, String cHomeAddress, String cComment) {
		this.iDm= cIdm;
		this.iD = cID;
		this.name = cName;
		this.mobil = cMobil;
		this.homeAddress = cHomeAddress;
		this.comment = cComment;
	}

	public Integer getiDm() {
		return iDm;
	}

	public Integer getiD() {
		return iD;
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
