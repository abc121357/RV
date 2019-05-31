package bitcamp.baby.ch7.video.vo;

public class RentReturnVO {

	private String r_Code; // 대여번호
	private String g_Code; // 대여한 고객 번호
	private String v_Code; // 대여한 비디오 번호
	private String r_RentDate; //대여일
	private String r_PlanDate; // 반납예정일자 대여일의 +2
	private String r_ReturnDate; // 반납일
	private int r_TotalPay; //대여 총액
	private int r_OverDueDate; // 연체일수
	private String deleteYN; // 반납완료여부 y가 완료 n이 미반납
	private String createDate; // 생성일
	private String updateDate; // 수정일
	
	public RentReturnVO() {
		
	}

	public RentReturnVO(String r_Code, String g_Code, String v_Code, String r_RentDate, String r_PlanDate,
			String r_ReturnDate, int r_TotalPay, int r_OverDueDate, String deleteYN, String createDate,
			String updateDate) {
		this.r_Code = r_Code;
		this.g_Code = g_Code;
		this.v_Code = v_Code;
		this.r_RentDate = r_RentDate;
		this.r_PlanDate = r_PlanDate;
		this.r_ReturnDate = r_ReturnDate;
		this.r_TotalPay = r_TotalPay;
		this.r_OverDueDate = r_OverDueDate;
		this.deleteYN = deleteYN;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getR_Code() {
		return r_Code;
	}

	public void setR_Code(String r_Code) {
		this.r_Code = r_Code;
	}

	public String getG_Code() {
		return g_Code;
	}

	public void setG_Code(String g_Code) {
		this.g_Code = g_Code;
	}

	public String getV_Code() {
		return v_Code;
	}

	public void setV_Code(String v_Code) {
		this.v_Code = v_Code;
	}

	public String getR_RentDate() {
		return r_RentDate;
	}

	public void setR_RentDate(String r_RentDate) {
		this.r_RentDate = r_RentDate;
	}

	public String getR_PlanDate() {
		return r_PlanDate;
	}

	public void setR_PlanDate(String r_PlanDate) {
		this.r_PlanDate = r_PlanDate;
	}

	public String getR_ReturnDate() {
		return r_ReturnDate;
	}

	public void setR_ReturnDate(String r_ReturnDate) {
		this.r_ReturnDate = r_ReturnDate;
	}

	public int getR_TotalPay() {
		return r_TotalPay;
	}

	public void setR_TotalPay(int r_TotalPay) {
		this.r_TotalPay = r_TotalPay;
	}

	public int getR_OverDueDate() {
		return r_OverDueDate;
	}

	public void setR_OverDueDate(int r_OverDueDate) {
		this.r_OverDueDate = r_OverDueDate;
	}

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
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
