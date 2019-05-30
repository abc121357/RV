package bitcamp.baby.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import bitcamp.baby.sql.GogakSqlMap;
import bitcamp.baby.sql.VideoSqlMap;

public abstract class ChaeBun {

	//video 테이블 채번
	public static final String VIDEO_CHAR_V="V";
	//Gogak 테이블 채번
	public static final String GOGAK_CHAR_G="G";
	//RentReturn 테이블 채번
	public static final String RENTRETURN_CHAR_R="R";
	
	
	public static String commV(){
	String v_Code= "";	
	int commYear_= 0;
	int commMonth_= 0;
	int commDay_= 0;
	String commYear=null;
	String commMonth=null;
	String commDay=null;
	Connection c=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	c=ConnPropertyOraUser.getConnection();
	try{
		
	ps=c.prepareStatement(VideoSqlMap.COMMON_USE_QEURY[0]);
	rs=ps.executeQuery();
	if(rs!=null){
		rs.next();
		v_Code=String.valueOf(rs.getString("commNo"));
	}
	//캘린더 클래스객체를 만들어서 변수안에 집어넣는다.
	Calendar cal=Calendar.getInstance();
	//그 객체로 날짜를 반환한다.
	commYear_=cal.get(cal.YEAR);
	commMonth_=cal.get(cal.MONTH)+1;
	commDay_=cal.get(cal.DAY_OF_MONTH);
	
	commYear=String.valueOf(commYear_);
	commMonth=String.valueOf(commMonth_);
	commDay=String.valueOf(commDay_);
	
	if(commMonth_ < 10 )
	{
		commMonth="0"+String.valueOf(commMonth_);
	}
	//갯수의 자릿수가 1이면 0을 3개
	if(v_Code.length()==1){
		v_Code="000"+v_Code;
	}
	
	if(v_Code.length()==2){
		v_Code="00"+v_Code;
	}
	if(v_Code.length()==3){
		v_Code="0"+v_Code;
	}
	
	v_Code=VIDEO_CHAR_V
			+commYear
			+commMonth
			+commDay
			+v_Code;
	if(c!=null){
	ConnPropertyOraUser.conClose(c, ps, rs);
	}
	
	}catch(SQLException e){
		System.out.println("채번 에러 문제 이유 : "+e);
	}finally{
		try{
		ConnPropertyOraUser.conClose(c, ps, rs);
		}catch(Exception e){
		e.printStackTrace();
		}
	}
	
		
		
	return v_Code;	
	}
	
	// Gogak 채번
	public static String commG(){
		String g_Code= "";	
		int commYear_= 0;
		int commMonth_= 0;
		int commDay_= 0;
		String commYear=null;
		String commMonth=null;
		String commDay=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		c=ConnPropertyOraUser.getConnection();
		try{
			
		ps=c.prepareStatement(GogakSqlMap.COMMON_USE_QEURY[GogakSqlMap.QUERY_G_INDEX_0]);
		rs=ps.executeQuery();
		if(rs!=null){
			rs.next();
			g_Code=String.valueOf(rs.getString("commNo"));
		}
		//캘린더 클래스객체를 만들어서 변수안에 집어넣는다.
		Calendar cal=Calendar.getInstance();
		//그 객체로 날짜를 반환한다.
		commYear_=cal.get(cal.YEAR);
		commMonth_=cal.get(cal.MONTH)+1;
		commDay_=cal.get(cal.DAY_OF_MONTH);
		
		commYear=String.valueOf(commYear_);
		commMonth=String.valueOf(commMonth_);
		commDay=String.valueOf(commDay_);
		
		if(commMonth_ < 10 )
		{
			commMonth="0"+String.valueOf(commMonth_);
		}
		//갯수의 자릿수가 1이면 0을 3개
		if(g_Code.length()==1){
			g_Code="000"+g_Code;
		}
		
		if(g_Code.length()==2){
			g_Code="00"+g_Code;
		}
		if(g_Code.length()==3){
			g_Code="0"+g_Code;
		}
		
		g_Code=GOGAK_CHAR_G
				+commYear
				+commMonth
				+commDay
				+g_Code;
		if(c!=null){
		ConnPropertyOraUser.conClose(c, ps, rs);
		}
		
		}catch(SQLException e){
			System.out.println("채번 에러 문제 이유 : "+e);
		}finally{
			try{
			ConnPropertyOraUser.conClose(c, ps, rs);
			}catch(Exception e){
			e.printStackTrace();
			}
		}
		
			
			
		return g_Code;	
		}
}
