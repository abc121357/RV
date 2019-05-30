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
		
		vScr=new VideoScr();
		nCnt=vScr.insertVideo(v_Title,v_Genre, v_Pay, v_MakeCompany, v_MakeDate, v_ViewAge);
		
			if(nCnt>0){
				System.out.println(nCnt+"회 삽입됬습니다.");
				}
			else
			{
				System.out.println("내용이 삽입되지 않았습니다.");	
			}
		
		
	}
	
	else if("S".equals(s.toUpperCase())){

		VideoVO vo=new VideoVO();
		String num=null;
		
		System.out.println("비디오 정보를 찾습니다.");
		System.out.println("원하는 비디오의 고유 번호를 입력하세요.(Ex : 0000) >>> " );
		System.out.print("번호 입력 : ");
		
		vSc=new Scanner(System.in);
		num = vSc.nextLine();
		
		
		vo.setV_Code(num);
		System.out.println();
		
		vScr=new VideoScr();
		aList=vScr.selectVideo(vo);
		System.out.println("비디오번호 //제목 //장르 //대여료 // 대여구분 // 출시사 // 출시일 // 관람등급 //생성일//수정일");
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
			System.out.println("비디오의 내용이 없습니다.");
		}
		
		
	}
	
	else if("U".equals(s.toUpperCase())){
		int v_Pay=0;
		String v_Code=null;
		int nCnt=0;
		
		
		System.out.println("비디오 정보를 수정합니다.");
		
		System.out.print("가격을 수정할 비디오 번호를 입력하세요.(Ex : 0000) >>> ");
		
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		System.out.print("원하는 가격을 입력하세여 : ");
		v_Pay=vSc.nextInt();
		
		vScr=new VideoScr();
		nCnt=vScr.updateVideo(v_Pay, v_Code);
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
		
		System.out.println("비디오 정보를 삭제합니다.");
		System.out.print("삭제할 비디오 번호를 입력하세여 (Ex : 0000) >>> ");
		
		vSc=new Scanner(System.in);
		v_Code=vSc.nextLine();
		
		vScr=new VideoScr();
		nCnt=vScr.deleteVideo(v_Code);
		
		if(nCnt>0)
		System.out.println(nCnt+"개를 삭제했습니다.");
		else
			System.out.println("정보를 삭제하는데 실패했습니다.");
		
	}
	
	else if("Q".equals(s.toUpperCase())){
		
		System.out.println("종료합니다.");
		break;
	}
	
	
	
	
	
	}
		
		
		
		
		
		
		
		
	}
	
	
}
