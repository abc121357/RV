package bitcamp.baby.ch7.video.scr;

import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.baby.ch7.video.dao.VidioDao;
import bitcamp.baby.ch7.video.dao.VidioDaoImpl;
import bitcamp.baby.ch7.video.vo.VidioVO;
import bitcamp.baby.common.Chaebun;

public class VidioScr {

	public ArrayList selectVidio(VidioVO vo){
		ArrayList aList=null;
		VidioDao vSdao=new VidioDaoImpl();
		aList=new ArrayList();
		aList=vSdao.selectVidio(vo);
		
		
		
		
		return aList;
	}
	
	public int insertVidio(String v_Title,String v_Genre, int v_Pay,int v_RentState,String v_MakeCompany, String v_MakeDate, int v_ViewAge){
	
		VidioVO vo = null;
		VidioDao vIdao=null;
		int nCnt=0;
		
		vIdao = new VidioDaoImpl();
		vo=new VidioVO();
		vo.setV_Title(v_Title);
		vo.setV_Genre(v_Genre);
		vo.setV_Pay(v_Pay);
		vo.setV_RentState(v_RentState);
		vo.setV_MakeCompany(v_MakeCompany);
		vo.setV_MakeDate(v_MakeDate);
		vo.setV_ViewAge(v_ViewAge);
		
		nCnt=vIdao.insertVidio(vo);
		
		
		return nCnt;
	}
	
	public int updateVidio(int v_Pay,String v_Code){
	VidioVO vo=null;	
	VidioDao vUdao = null;
	int nCnt=0;
	vo=new VidioVO();
	vUdao=new VidioDaoImpl();
	
	vo.setV_Pay(v_Pay);
	vo.setV_Code(v_Code);
	nCnt=vUdao.updateVidio(vo);
		
		
		
		return nCnt;
	}
	
	public int deleteVidio(String v_Code){
		
		VidioVO vo=null;
		VidioDao vDdao=null;
		int nCnt=0;
		
		vo=new VidioVO();
		vDdao=new VidioDaoImpl();
		
		vo.setV_Code(v_Code);
		nCnt=vDdao.DeleteVidio(vo);
		
		return nCnt;
	}
	
	
	
	
	public static void main(String args[]){
	ArrayList aList=null;
	Scanner sc=null;
	Scanner vSc=null;
	VidioScr vScr=null;
	String s=null;
	
	
	while(true){
	System.out.println("���� ������ I(�Է�) S(��ȸ) U(����) D(����) �ϳ��� �����ϼ���.");
	System.out.println("���α׷��� �����Ϸ��� Q�� �Է��ϼ���");
	sc=new Scanner(System.in);
	s=sc.next();
	
	if("I".equals(s.toUpperCase())){
	
		String v_Title=null;
		String v_Genre=null;
		int v_Pay=0;
		int v_RentState=0;
		String v_MakeCompany=null;
		String v_MakeDate=null;
		int v_ViewAge=0;
		int nCnt=0;
		
		System.out.println("���� ������ �Է��մϴ�.");
		//�Է��ϱ� ���� ���� ���� �����͸� ���´�.
		System.out.print("���� �̸� �Է� : ");
		vSc=new Scanner(System.in);
		v_Title=vSc.nextLine();
		System.out.println();

		System.out.print("���� �帣 �Է� : ");
		vSc=new Scanner(System.in);
		v_Genre=vSc.nextLine();
		System.out.println();
		
		System.out.print("���� �뿩�� �Է� : ");
		vSc=new Scanner(System.in);
		v_Pay=vSc.nextInt();
		System.out.println();
		
		System.out.print("���� �뿩���� �Է� : "); //1�� ������ �� 2�� �� �뿩
		vSc=new Scanner(System.in);
		v_RentState=vSc.nextInt();
		System.out.println();
		System.out.print("���� ���ۻ� �Է� : ");
		vSc=new Scanner(System.in);
		v_MakeCompany=vSc.nextLine();
		System.out.println();
		System.out.print("���� ������ �Է� : ");
		vSc=new Scanner(System.in);
		v_MakeDate=vSc.nextLine();
		System.out.println();
		System.out.print("���� ��û���� �Է� : ");
		vSc=new Scanner(System.in);
		v_ViewAge=vSc.nextInt();
		System.out.println();
		vScr=new VidioScr();
		nCnt=vScr.insertVidio(v_Title,v_Genre, v_Pay,v_RentState, v_MakeCompany, v_MakeDate, v_ViewAge);
		if(nCnt>0){
		System.out.println(nCnt+"ȸ ���ԉ���ϴ�.");
		}
		else
		{
		System.out.println("������ ���Ե��� �ʾҽ��ϴ�.");	
		}
		
		
	}
	
	else if("S".equals(s.toUpperCase())){

		VidioVO vo=new VidioVO();
		String num=null;
		
		System.out.println("���� ������ ã���ϴ�.");
		System.out.println("���ϴ� ������ ���� ��ȣ�� �Է��ϼ��� " );
		System.out.print("��ȣ �Է� : ");
		vSc=new Scanner(System.in);
		num = vSc.nextLine();
		
		
		vo.setV_Code(num);
		System.out.println();
		
		vScr=new VidioScr();
		aList=vScr.selectVidio(vo);
		System.out.println("���� ��ȣ //���� ���� // ���� �帣 //���� ��� // �뿩�Ⱓ // ���ۻ� // ���� ������ // ��û���� ");
		for(int i=0;i<aList.size(); i++){
			
			if(vo!=null){
			vo=(VidioVO)aList.get(i);
			System.out.print(vo.getV_Code() + " ");
			System.out.print(vo.getV_Title()+ " ");
			System.out.print(vo.getV_Genre()+ " ");
			System.out.print(vo.getV_Pay()+ " ");
			System.out.print(vo.getV_RentState()+ " ");
			System.out.print(vo.getV_MakeCompany()+ " ");
			System.out.print(vo.getV_MakeDate()+ " ");
			System.out.print(vo.getV_ViewAge()+ " ");
			System.out.print(vo.getCreateDate()+ " ");
			System.out.println(vo.getUpdateDate());
			}
		}
		
		if(aList.size()==0){
			System.out.println("������ ������ �����ϴ�.");
		}
		
		
	}
	
	else if("U".equals(s.toUpperCase())){
		int v_Pay=0;
		String v_Code=null;
		int nCnt=0;
		
		
		System.out.println("���� ������ �����մϴ�.");
		
		System.out.print("������ ������ ���� ��ȣ�� �Է��ϼ��� :");
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		System.out.print("���ϴ� ������ �Է��ϼ��� : ");
		v_Pay=vSc.nextInt();
		
		vScr=new VidioScr();
		nCnt=vScr.updateVidio(v_Pay, v_Code);
		if(nCnt>0){
		System.out.println(nCnt+"�� �����Ǿ����ϴ�.");
		}
		else{
			System.out.println("������ ������� �ʾҽ��ϴ�.");
		}
		
		
	}
	
	else if("D".equals(s.toUpperCase())){
		String v_Code=null;
		int nCnt=0;
		
		System.out.println("���� ������ ����ϴ�.");
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		
		vScr=new VidioScr();
		nCnt=vScr.deleteVidio(v_Code);
		
		if(nCnt>0)
		System.out.println(nCnt+"���� �������ϴ�.");
		else
			System.out.println("������ ����µ� �����߽��ϴ�.");
		
	}
	
	else if("Q".equals(s.toUpperCase())){
		
		System.out.println("�����մϴ�.");
		break;
	}
	
	
	
	
	
	}
		
		
		
		
		
		
		
		
	}
	
	
}
