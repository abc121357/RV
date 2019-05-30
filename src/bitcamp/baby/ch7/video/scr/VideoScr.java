package bitcamp.baby.ch7.video.scr;

import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.baby.ch7.video.dao.VideoDao;
import bitcamp.baby.ch7.video.dao.VideoDaoImpl;
import bitcamp.baby.ch7.video.vo.VideoVO;
import bitcamp.baby.common.ChaeBun;

public class VideoScr {

	public ArrayList selectVideo(VideoVO vo){
		ArrayList aList=null;
		VideoDao vSdao=new VideoDaoImpl();
		aList=new ArrayList();
		aList=vSdao.selectVideo(vo);
		

		return aList;
	}
	
	public int insertVideo(String v_Title,String v_Genre, int v_Pay,String v_MakeCompany, String v_MakeDate, int v_ViewAge){
	
		VideoVO vo = null;
		VideoDao vIdao=null;
		int nCnt=0;
		
		vIdao = new VideoDaoImpl();
		vo=new VideoVO();
		vo.setV_Title(v_Title);
		vo.setV_Genre(v_Genre);
		vo.setV_Pay(v_Pay);
		vo.setV_MakeCompany(v_MakeCompany);
		vo.setV_MakeDate(v_MakeDate);
		vo.setV_ViewAge(v_ViewAge);
		
		nCnt=vIdao.insertVideo(vo);
		
		
		return nCnt;
	}
	
	public int updateVideo(int v_Pay,String v_Code){
	VideoVO vo=null;	
	VideoDao vUdao = null;
	int nCnt=0;
	vo=new VideoVO();
	vUdao=new VideoDaoImpl();
	
	vo.setV_Pay(v_Pay);
	vo.setV_Code(v_Code);
	nCnt=vUdao.updateVideo(vo);
		
		
		
		return nCnt;
	}
	
	public int deleteVideo(String v_Code){
		
		VideoVO vo=null;
		VideoDao vDdao=null;
		int nCnt=0;
		
		vo=new VideoVO();
		vDdao=new VideoDaoImpl();
		
		vo.setV_Code(v_Code);
		nCnt=vDdao.DeleteVideo(vo);
		
		return nCnt;
	}
	
	
	
	
	public static void main(String args[]){
	ArrayList aList=null;
	Scanner sc=null;
	Scanner vSc=null;
	VideoScr vScr=null;
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
		
		vScr=new VideoScr();
		nCnt=vScr.insertVideo(v_Title,v_Genre, v_Pay, v_MakeCompany, v_MakeDate, v_ViewAge);
		
			if(nCnt>0){
				System.out.println(nCnt+"ȸ ���ԉ���ϴ�.");
				}
			else
			{
				System.out.println("������ ���Ե��� �ʾҽ��ϴ�.");	
			}
		
		
	}
	
	else if("S".equals(s.toUpperCase())){

		VideoVO vo=new VideoVO();
		String num=null;
		
		System.out.println("���� ������ ã���ϴ�.");
		System.out.println("���ϴ� ������ ���� ��ȣ�� �Է��ϼ���.(Ex : 0000) >>> " );
		System.out.print("��ȣ �Է� : ");
		
		vSc=new Scanner(System.in);
		num = vSc.nextLine();
		
		
		vo.setV_Code(num);
		System.out.println();
		
		vScr=new VideoScr();
		aList=vScr.selectVideo(vo);
		System.out.println("������ȣ //���� //�帣 //�뿩�� // �뿩���� // ��û� // ����� // ������� //������//������");
		for(int i=0;i<aList.size(); i++){
			
			if(vo!=null){
			vo=(VideoVO)aList.get(i);
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
		
		System.out.print("������ ������ ���� ��ȣ�� �Է��ϼ���.(Ex : 0000) >>> ");
		
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		System.out.print("���ϴ� ������ �Է��ϼ��� : ");
		v_Pay=vSc.nextInt();
		
		vScr=new VideoScr();
		nCnt=vScr.updateVideo(v_Pay, v_Code);
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
		
		System.out.println("���� ������ �����մϴ�.");
		System.out.print("������ ���� ��ȣ�� �Է��ϼ��� (Ex : 0000) >>> ");
		
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		
		vScr=new VideoScr();
		nCnt=vScr.deleteVideo(v_Code);
		
		if(nCnt>0)
		System.out.println(nCnt+"���� �����߽��ϴ�.");
		else
			System.out.println("������ �����ϴµ� �����߽��ϴ�.");
		
	}
	
	else if("Q".equals(s.toUpperCase())){
		
		System.out.println("�����մϴ�.");
		break;
	}
	
	
	
	
	
	}
		
		
		
		
		
		
		
		
	}
	
	
}
