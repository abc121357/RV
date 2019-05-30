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
		
		System.out.println("메인함수진입");
		
		Scanner sc=null;
		String YN=null;
		GogakVO gVo=null;
		GogakScr gDao=null;
		ArrayList aList=null;
		int nCnt=0;
		
		
		
		
		
		while(true){
			System.out.println("고객 정보중 I(입력) S(조회) U(갱신) D(삭제) 하나를 선택하세요.");
			sc=new Scanner(System.in);
			YN=sc.next();
			gDao=new GogakScr();
			
			//정보를 입력하기 위해 i를 입력한다.
			if("I".equals(YN.toUpperCase())){
			String name=null;
			int age=0;
			String addr=null;
			String tel=null;
			System.err.println("insert조건에 진입\n");
			System.out.println("정보를 입력합니다.");
			
			System.out.println("이름 입력 : ");
			sc=new Scanner(System.in);
			name=sc.nextLine();
			System.out.println("나이 입력 : ");
			Scanner sci=new Scanner(System.in);
			age=sci.nextInt();
			System.out.println("주소 입력 : ");
			
			addr=sc.nextLine();
			System.out.println("전번 입력 : ");
			tel=sc.nextLine();
			nCnt=gDao.insertGogak(name,age,addr,tel);
			System.out.println(nCnt+"건 입력되었습니다.");
			
			}
			//정보를 검색하기 위해 s를 입력한다.
			if("S".equals(YN.toUpperCase())){	
			System.out.println("정보를 조회합니다.");
			gVo=new GogakVO();
			String num=null;
			System.out.println("조회할 번호를 입력하세요.(Ex : 0000) >>>");
			num=sc.next();
			gVo.setG_Code(num);
			aList=gDao.selectGogak(gVo);
			//selectGogak으로 받아온 정보를 출력
			System.err.println("aList에서 받아온 vo를 읽습니다.\n");
			for(int i=0; i<aList.size();i++){
				gVo=(GogakVO)aList.get(i);
				if(gVo!=null){
					
				System.out.println("고객 번호 // 고객 이름 // 고객 나이 // 고객 주소 // 고객 폰번 // 고객정보삭제여부 // 고객 정보 생성일 // 고객 정보 수정일 // 특별회원여부 " );
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
					System.out.println("Vo에 정보가 없습니다.");
				}
			}
			
			}
			//정보를 수정하기 위해 u를 입력한다.
			if("U".equals(YN.toUpperCase())){
			System.out.println("정보를 갱신합니다.");
			gDao=new GogakScr();
			String num=null;
			String tel=null;
			
			System.out.println("수정을 원하는 번호를 입력하세요.(Ex : 0000) >>>");
			num=sc.next();
			System.out.println("수정할 전화번호를 입력하세요.");
			tel=sc.next();
			nCnt=gDao.updateGogak(num,tel);
			
			System.out.println(nCnt+"번 수정되었습니다.");
			
			}
			//정보를 삭제하기 위해 d를 입력한다.
			if("D".equals(YN.toUpperCase())){
			String num=null;
			System.out.println("정보를 삭제합니다.");
			
			sc=new Scanner(System.in);
			System.out.println("삭제할 번호를 입력하세요.(Ex : 0000) >>> ");
			num=sc.nextLine();
			gDao=new GogakScr();
			
			nCnt=gDao.deleteGogak(num);
			System.out.println(nCnt + "번 삭제되었습니다.");
			
			}
			if("Y".equals(YN.toUpperCase())){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		
		
	}
	
	
	
	
}
