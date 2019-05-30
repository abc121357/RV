package bitcamp.baby.ch7.video.scr;

import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.baby.ch7.video.dao.GogakDAO;
import bitcamp.baby.ch7.video.dao.GogakDAOImpl;
import bitcamp.baby.ch7.video.vo.GogakVO;

public class GogakScr {

	public ArrayList selectGogak(GogakVO vo){
		ArrayList aList=null;
		aList=new ArrayList();
		GogakDAO sDao=null;
		
		sDao=new GogakDAOImpl();
		aList=sDao.selectGogak(vo);
		
		
		return aList;
	}
	
	public int insertGogak(String g_Name,int g_Age,String g_Addr,String g_Tel){
		
		int nCnt=0;
		GogakVO vo=null;
		GogakDAO iDao=null;
		vo=new GogakVO();
		iDao=new GogakDAOImpl();
		vo.setG_Name(g_Name);
		vo.setG_Age(g_Age);
		vo.setG_Addr(g_Addr);
		vo.setG_Tel(g_Tel);
		nCnt=iDao.insertGogak(vo);
		
		return nCnt;
	}
	
	public int updateGogak(String g_Num,String g_Tel){
		int nCnt=0;
		GogakDAO uDao=null;
		GogakVO vo=null;
		vo=new GogakVO();
		vo.setG_Code(g_Num);
		vo.setG_Tel(g_Tel);
		uDao=new GogakDAOImpl();
		nCnt=uDao.updateGogak(vo);
		
		return nCnt;
	}
	
	public int deleteGogak(String no){
		GogakVO vo=null;
		int nCnt=0;	
		GogakDAO dDao=null;
		vo=new GogakVO();
		vo.setG_Code(no);
		
		dDao=new GogakDAOImpl();
		nCnt=dDao.deleteGogak(vo);
		
		return nCnt;
	}
	
	
	
	public static void main(String args[]){
		
		System.out.println("�����Լ�����");
		
		Scanner sc=null;
		String YN=null;
		GogakVO gVo=null;
		GogakScr gDao=null;
		ArrayList aList=null;
		int nCnt=0;
		
		
		
		
		
		while(true){
			System.out.println("�� ������ I(�Է�) S(��ȸ) U(����) D(����) �ϳ��� �����ϼ���.");
			sc=new Scanner(System.in);
			YN=sc.next();
			gDao=new GogakScr();
			
			//������ �Է��ϱ� ���� i�� �Է��Ѵ�.
			if("I".equals(YN.toUpperCase())){
			String name=null;
			int age=0;
			String addr=null;
			String tel=null;
			System.err.println("insert���ǿ� ����\n");
			System.out.println("������ �Է��մϴ�.");
			
			System.out.println("�̸� �Է� : ");
			sc=new Scanner(System.in);
			name=sc.nextLine();
			System.out.println("���� �Է� : ");
			Scanner sci=new Scanner(System.in);
			age=sci.nextInt();
			System.out.println("�ּ� �Է� : ");
			
			addr=sc.nextLine();
			System.out.println("���� �Է� : ");
			tel=sc.nextLine();
			nCnt=gDao.insertGogak(name,age,addr,tel);
			System.out.println(nCnt+"�� �ԷµǾ����ϴ�.");
			
			}
			//������ �˻��ϱ� ���� s�� �Է��Ѵ�.
			if("S".equals(YN.toUpperCase())){	
			System.out.println("������ ��ȸ�մϴ�.");
			gVo=new GogakVO();
			String num=null;
			System.out.println("��ȸ�� ��ȣ�� �Է��ϼ���.(Ex : 0000) >>>");
			num=sc.next();
			gVo.setG_Code(num);
			aList=gDao.selectGogak(gVo);
			//selectGogak���� �޾ƿ� ������ ���
			System.err.println("aList���� �޾ƿ� vo�� �н��ϴ�.\n");
			for(int i=0; i<aList.size();i++){
				gVo=(GogakVO)aList.get(i);
				if(gVo!=null){
					
				System.out.println("�� ��ȣ // �� �̸� // �� ���� // �� �ּ� // �� ���� // �������������� // �� ���� ������ // �� ���� ������ // Ư��ȸ������ " );
				System.out.print(gVo.getG_Code()+", ");
				System.out.print(gVo.getG_Name()+", ");
				System.out.print(gVo.getG_Age()+", ");
				System.out.print(gVo.getG_Addr()+", ");
				System.out.print(gVo.getG_Tel()+", ");
				System.out.print(gVo.getDeleteYN()+", ");
				System.out.print(gVo.getCreateDate()+", ");
				System.out.print(gVo.getUpdateDate()+", ");
				System.out.println(gVo.getVIPYN());
				}
				else
				{
					System.out.println("Vo�� ������ �����ϴ�.");
				}
			}
			
			}
			//������ �����ϱ� ���� u�� �Է��Ѵ�.
			if("U".equals(YN.toUpperCase())){
			System.out.println("������ �����մϴ�.");
			gDao=new GogakScr();
			String num=null;
			String tel=null;
			
			System.out.println("������ ���ϴ� ��ȣ�� �Է��ϼ���.(Ex : 0000) >>>");
			num=sc.next();
			System.out.println("������ ��ȭ��ȣ�� �Է��ϼ���.");
			tel=sc.next();
			nCnt=gDao.updateGogak(num,tel);
			
			System.out.println(nCnt+"�� �����Ǿ����ϴ�.");
			
			}
			//������ �����ϱ� ���� d�� �Է��Ѵ�.
			if("D".equals(YN.toUpperCase())){
			String num=null;
			System.out.println("������ �����մϴ�.");
			
			sc=new Scanner(System.in);
			System.out.println("������ ��ȣ�� �Է��ϼ���.(Ex : 0000) >>> ");
			num=sc.nextLine();
			gDao=new GogakScr();
			
			nCnt=gDao.deleteGogak(num);
			System.out.println(nCnt + "�� �����Ǿ����ϴ�.");
			
			}
			if("Y".equals(YN.toUpperCase())){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
		
		
		
	}
	
	
	
	
}
