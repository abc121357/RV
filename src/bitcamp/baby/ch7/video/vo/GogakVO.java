package bitcamp.baby.ch7.video.vo;

public class GogakVO {

	private int g_Code;
	private String g_Name;
	private int g_Age;
	private String g_Addr;
	private String g_Tel;
	private String g_DeleteYN;
	private String g_CreateDate;
	private String g_UpdateDate;

	
	public GogakVO(){
		
	}


	public GogakVO(int g_Code,String g_Name, int g_Age, String g_Addr, String g_Tel, String g_DeleteYN, String g_CreateDate,
			String g_UpdateDate) {
		this.g_Code = g_Code;
		this.g_Name = g_Name;
		this.g_Age = g_Age;
		this.g_Addr = g_Addr;
		this.g_Tel = g_Tel;
		this.g_DeleteYN = g_DeleteYN;
		this.g_CreateDate = g_CreateDate;
		this.g_UpdateDate = g_UpdateDate;
	}


	public int getG_Code() {
		return g_Code;
	}


	public void setG_Code(int g_Code) {
		this.g_Code = g_Code;
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


	public String getG_DeleteYN() {
		return g_DeleteYN;
	}


	public void setG_DeleteYN(String g_DeleteYN) {
		this.g_DeleteYN = g_DeleteYN;
	}


	public String getG_CreateDate() {
		return g_CreateDate;
	}


	public void setG_CreateDate(String g_CreateDate) {
		this.g_CreateDate = g_CreateDate;
	}


	public String getG_UpdateDate() {
		return g_UpdateDate;
	}


	public void setG_UpdateDate(String g_UpdateDate) {
		this.g_UpdateDate = g_UpdateDate;
	}


	public String getG_Name() {
		return g_Name;
	}


	public void setG_Name(String g_Name) {
		this.g_Name = g_Name;
	}
	

}
