package bitcamp.baby.ch7.video.vo;

public class RentReturnVO {

	private String r_Code; // �뿩��ȣ
	private int g_Code; // �뿩�� �� ��ȣ
	private String v_Code; // �뿩�� ���� ��ȣ
	private String r_RentDate; //�뿩��
	private String r_PlanDate; // �ݳ��������� �뿩���� +2
	private String r_ReturnDate; // �ݳ���
	private int r_TotalPay; //�뿩 �Ѿ�
	private int r_OverDueDate; // ��ü�ϼ�
	private String deleteYN; // �ݳ��ϷῩ�� y�� �Ϸ� n�� �̹ݳ�
	private String createDate; // ������
	private String updateDate; // ������
	
	
	
	
	
	public int getR_TotalPay() {
		return r_TotalPay;
	}




	public void setR_TotalPay(int r_TotalPay) {
		this.r_TotalPay = r_TotalPay;
	}




	
	
	
	public String getR_ReturnDate() {
		return r_ReturnDate;
	}




	public void setR_ReturnDate(String r_ReturnDate) {
		this.r_ReturnDate = r_ReturnDate;
	}





	
	public String getR_Code() {
		return r_Code;
	}




	public void setR_Code(String r_Code) {
		this.r_Code = r_Code;
	}




	public int getG_Code() {
		return g_Code;
	}




	public void setG_Code(int g_Code) {
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









	public int getR_OverDueDate() {
		return r_OverDueDate;
	}




	public void setR_OverDueDate(int r_OverDueDate) {
		this.r_OverDueDate = r_OverDueDate;
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



	
	public RentReturnVO(){
		
	}
	
	
	
	
	
	
}
