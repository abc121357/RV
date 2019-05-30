package bitcamp.baby.ch7.video.vo;

public class VideoVO {

	private String v_Code;
	private String v_Title;
	private String v_Genre;
	private int v_Pay;
	private String v_RentState;
	private String v_MakeCompany;
	private String v_MakeDate;
	private int v_ViewAge;
	private String DeleteYN;
	private String createDate;
	private String updateDate;
	
	public VideoVO() {
	}
	
	public VideoVO(String v_Code, String v_Title, String v_Genre, int v_Pay, String v_RentState, String v_MakeCompany,
			String v_MakeDate, int v_ViewAge, String deleteYN, String createDate, String updateDate) {
	
		this.v_Code = v_Code;
		this.v_Title = v_Title;
		this.v_Genre = v_Genre;
		this.v_Pay = v_Pay;
		this.v_RentState = v_RentState;
		this.v_MakeCompany = v_MakeCompany;
		this.v_MakeDate = v_MakeDate;
		this.v_ViewAge = v_ViewAge;
		DeleteYN = deleteYN;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getV_Code() {
		return v_Code;
	}

	public void setV_Code(String v_Code) {
		this.v_Code = v_Code;
	}

	public String getV_Title() {
		return v_Title;
	}

	public void setV_Title(String v_Title) {
		this.v_Title = v_Title;
	}

	public String getV_Genre() {
		return v_Genre;
	}

	public void setV_Genre(String v_Genre) {
		this.v_Genre = v_Genre;
	}

	public int getV_Pay() {
		return v_Pay;
	}

	public void setV_Pay(int v_Pay) {
		this.v_Pay = v_Pay;
	}

	public String getV_RentState() {
		return v_RentState;
	}

	public void setV_RentState(String v_RentState) {
		this.v_RentState = v_RentState;
	}

	public String getV_MakeCompany() {
		return v_MakeCompany;
	}

	public void setV_MakeCompany(String v_MakeCompany) {
		this.v_MakeCompany = v_MakeCompany;
	}

	public String getV_MakeDate() {
		return v_MakeDate;
	}

	public void setV_MakeDate(String v_MakeDate) {
		this.v_MakeDate = v_MakeDate;
	}

	public int getV_ViewAge() {
		return v_ViewAge;
	}

	public void setV_ViewAge(int v_ViewAge) {
		this.v_ViewAge = v_ViewAge;
	}

	public String getDeleteYN() {
		return DeleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		DeleteYN = deleteYN;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
