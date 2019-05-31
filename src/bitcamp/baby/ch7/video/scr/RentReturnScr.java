package bitcamp.baby.ch7.video.scr;

import java.util.Scanner;

import bitcamp.baby.ch7.video.dao.RentReturnDAO;
import bitcamp.baby.ch7.video.dao.RentReturnDAOImpl;
import bitcamp.baby.ch7.video.dao.RentReturnDAOImpl3;
import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.ch7.video.vo.RentReturnVO;
import bitcamp.baby.ch7.video.vo.VideoVO;

public class RentReturnScr {

	
	public boolean insertUpdateFun(String g_Code,String v_Code){
		RentReturnVO rVo=null;
		GogakVO gVo=null;
		VideoVO vVo=null;
		boolean bi=false;
		RentReturnDAO iUdao=null;
		
		rVo=new RentReturnVO();
		gVo=new GogakVO();
		vVo=new VideoVO();
		
		gVo.setG_Code(g_Code);
		vVo.setV_Code(v_Code);
		
		iUdao=new RentReturnDAOImpl();
		System.out.println(gVo.getG_Code() + ","+vVo.getV_Code());
		bi=iUdao.insertRentReturn(gVo, vVo, rVo);
				
				return bi;
		
		
	}
	
	



public static void main(String args[]){
		
		Scanner sc=null;
		String YN=null;
		RentReturnScr scr=null;
		String g_Code=null;
		String v_Code=null;
		while(true){
		System.out.println("I를 입력하면 insert가 갱신");
		sc=new Scanner(System.in);
		YN=sc.next();
		if("I".equals(YN.toUpperCase())){
			System.out.print("고객 코드 입력 : ");
			g_Code=sc.next();
			System.out.print("비디오 코드 입력 : ");
			v_Code=sc.next();
			scr=new RentReturnScr();
			scr.insertUpdateFun(g_Code, v_Code);
		}
		
		
		}
		
	}
	
	
	
	
	
}
