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
	
	public int insertGogak(String name,int age,String addr,String tel){
		
		int num=0;
		GogakVO vo=null;
		GogakDAO iDao=null;
		vo=new GogakVO();
		iDao=new GogakDAOImpl();
		vo.setG_Name(name);
		vo.setG_Age(age);
		vo.setG_Addr(addr);
		vo.setG_Tel(tel);
		num=iDao.insertGogak(vo);
		
		return num;
	}
	
	public int updateGogak(int num,int age){
		int nCnt=0;
		GogakDAO uDao=null;
		GogakVO vo=null;
		vo=new GogakVO();
		vo.setG_Code(num);
		vo.setG_Age(age);
		uDao=new GogakDAOImpl();
		nCnt=uDao.updateGogak(vo);
		
		return nCnt;
	}
	
	public int deleteGogak(int no){
		GogakVO vo=null;
		int num=0;	
		GogakDAO dDao=null;
		vo=new GogakVO();
		vo.setG_Code(no);
		
		dDao=new GogakDAOImpl();
		num=dDao.deleteGogak(vo);
		
		return num;
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
			int num=0;
			System.out.println("��ȸ�� ��ȣ�� �Է��ϼ���.");
			num=sc.nextInt();
			gVo.setG_Code(num);
			aList=gDao.selectGogak(gVo);
			//selectGogak���� �޾ƿ� ������ ���
			System.err.println("aList���� �޾ƿ� vo�� �н��ϴ�.\n");
			for(int i=0; i<aList.size();i++){
				gVo=(GogakVO)aList.get(i);
				if(gVo!=null){
					
				System.out.println("�� ��ȣ // �� �̸� // �� ���� // �� �ּ� // �� ���� // �������������� // �� ���� ������ // �� ���� ������ " );
				System.out.print(gVo.getG_Code()+", ");
				System.out.print(gVo.getG_Name()+", ");
				System.out.print(gVo.getG_Age()+", ");
				System.out.print(gVo.getG_Addr()+", ");
				System.out.print(gVo.getG_Tel()+", ");
				System.out.print(gVo.getG_DeleteYN()+", ");
				System.out.print(gVo.getG_CreateDate()+", ");
				System.out.println(gVo.getG_UpdateDate());
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
			gVo=new GogakVO();
			gDao=new GogakScr();
			int num=0;
			int age=0;
			
			System.out.println("������ ���ϴ� ��ȣ�� �Է��ϼ���.");
			num=sc.nextInt();
			System.out.println("������ ���̸� �Է��ϼ���.");
			age=sc.nextInt();
			nCnt=gDao.updateGogak(num,age);
			
			System.out.println(nCnt+"�� �����Ǿ����ϴ�.");
			
			}
			//������ �����ϱ� ���� d�� �Է��Ѵ�.
			if("D".equals(YN.toUpperCase())){
			int num=0;
			System.out.println("������ �����մϴ�.");
			
			sc=new Scanner(System.in);
			System.out.println("������ ��ȣ�� �Է��ϼ���.");
			num=sc.nextInt();
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
