package bitcamp.baby.ch7.video.vo;

public class GogakVO {

	private String g_Code;
	private String g_Name;
	private int g_Age;
	private String g_Addr;
	private String g_Tel;
	private String DeleteYN;
	private String CreateDate;
	private String UpdateDate;
	private String VIPYN;
	
	public GogakVO() {
		
	}

	public GogakVO(String g_Code, String g_Name, int g_Age, String g_Addr, String g_Tel, String deleteYN,
			String createDate, String updateDate, String vIPYN) {
		
		this.g_Code = g_Code;
		this.g_Name = g_Name;
		this.g_Age = g_Age;
		this.g_Addr = g_Addr;
		this.g_Tel = g_Tel;
		DeleteYN = deleteYN;
		CreateDate = createDate;
		UpdateDate = updateDate;
		VIPYN = vIPYN;
	}

	public String getG_Code() {
		return g_Code;
	}

	public void setG_Code(String g_Code) {
		this.g_Code = g_Code;
	}

	public String getG_Name() {
		return g_Name;
	}

	public void setG_Name(String g_Name) {
		this.g_Name = g_Name;
	}

	public int getG_Age() {
		return g_Age;
	}

	public void setG_Age(int g_Age) {
		this.g_Age = g_Age;
	}

	public String getG_Addr() {
		return g_Addr;
	}

	public void setG_Addr(String g_Addr) {
		this.g_Addr = g_Addr;
	}

	public String getG_Tel() {
		return g_Tel;
	}

	public void setG_Tel(String g_Tel) {
		this.g_Tel = g_Tel;
	}

	public String getDeleteYN() {
		return DeleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		DeleteYN = deleteYN;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}

	public String getVIPYN() {
		return VIPYN;
	}

	public void setVIPYN(String vIPYN) {
		VIPYN = vIPYN;
	}


	
	


}
