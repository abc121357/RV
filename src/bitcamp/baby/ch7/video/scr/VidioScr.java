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
	System.out.println("비디오 정보중 I(입력) S(조회) U(갱신) D(삭제) 하나를 선택하세여.");
	System.out.println("프로그램을 종료하려면 Q를 입력하세여");
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
		
		System.out.println("비디오 정보를 입력합니다.");
		//입력하기 위해 가장 먼저 데이터를 적는다.
		System.out.print("비디오 이름 입력 : ");
		vSc=new Scanner(System.in);
		v_Title=vSc.nextLine();
		System.out.println();

		System.out.print("비디오 장르 입력 : ");
		vSc=new Scanner(System.in);
		v_Genre=vSc.nextLine();
		System.out.println();
		
		System.out.print("비디오 대여료 입력 : ");
		vSc=new Scanner(System.in);
		v_Pay=vSc.nextInt();
		System.out.println();
		
		System.out.print("비디오 대여구분 입력 : "); //1은 빌리는 중 2는 미 대여
		vSc=new Scanner(System.in);
		v_RentState=vSc.nextInt();
		System.out.println();
		System.out.print("비디오 제작사 입력 : ");
		vSc=new Scanner(System.in);
		v_MakeCompany=vSc.nextLine();
		System.out.println();
		System.out.print("비디오 제작일 입력 : ");
		vSc=new Scanner(System.in);
		v_MakeDate=vSc.nextLine();
		System.out.println();
		System.out.print("비디오 시청연령 입력 : ");
		vSc=new Scanner(System.in);
		v_ViewAge=vSc.nextInt();
		System.out.println();
		vScr=new VidioScr();
		nCnt=vScr.insertVidio(v_Title,v_Genre, v_Pay,v_RentState, v_MakeCompany, v_MakeDate, v_ViewAge);
		if(nCnt>0){
		System.out.println(nCnt+"회 삽입됬습니다.");
		}
		else
		{
		System.out.println("내용이 삽입되지 않았습니다.");	
		}
		
		
	}
	
	else if("S".equals(s.toUpperCase())){

		VidioVO vo=new VidioVO();
		String num=null;
		
		System.out.println("비디오 정보를 찾습니다.");
		System.out.println("원하는 비디오의 고유 번호를 입력하세여 " );
		System.out.print("번호 입력 : ");
		vSc=new Scanner(System.in);
		num = vSc.nextLine();
		
		
		vo.setV_Code(num);
		System.out.println();
		
		vScr=new VidioScr();
		aList=vScr.selectVidio(vo);
		System.out.println("고유 번호 //비디오 제목 // 비디오 장르 //비디오 요금 // 대여기간 // 제작사 // 비디오 제작일 // 시청연령 ");
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
			System.out.println("비디오의 내용이 없습니다.");
		}
		
		
	}
	
	else if("U".equals(s.toUpperCase())){
		int v_Pay=0;
		String v_Code=null;
		int nCnt=0;
		
		
		System.out.println("비디오 정보를 수정합니다.");
		
		System.out.print("가격을 수정할 비디오 번호를 입력하세여 :");
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		System.out.print("원하는 가격을 입력하세여 : ");
		v_Pay=vSc.nextInt();
		
		vScr=new VidioScr();
		nCnt=vScr.updateVidio(v_Pay, v_Code);
		if(nCnt>0){
		System.out.println(nCnt+"건 수정되었습니다.");
		}
		else{
			System.out.println("내용이 변경되지 않았습니다.");
		}
		
		
	}
	
	else if("D".equals(s.toUpperCase())){
		String v_Code=null;
		int nCnt=0;
		
		System.out.println("비디오 정보를 지웁니다.");
		System.out.print("지울 번호를 입력하세여 : ");
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		
		vScr=new VidioScr();
		nCnt=vScr.deleteVidio(v_Code);
		
		if(nCnt>0)
		System.out.println(nCnt+"개를 지웠습니다.");
		else
			System.out.println("정보를 지우는데 실패했습니다.");
		
	}
	
	else if("Q".equals(s.toUpperCase())){
		
		System.out.println("종료합니다.");
		break;
	}
	
	
	
	
	
	}
		
		
		
		
		
		
		
		
	}
	
	
}
