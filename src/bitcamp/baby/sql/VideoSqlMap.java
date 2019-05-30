package bitcamp.baby.sql;

import bitcamp.baby.common.ChaeBun;

//DATE 자료형에는 TO_CHAR를 꼭쓰자!!
public abstract class VideoSqlMap {
	
	public static final String[] COMMON_USE_QEURY={
	"SELECT /*+INDEX_DESC(SYS_C0011176)*/"
	+ "NVL(MAX(SUBSTR(V.V_CODE,10)),0)+1 commNo FROM VIDEO V"
	}; 
	
	
	//비디오조회
	public static String getSelectQuery(){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT                                           ");
		sb.append("				 V.V_CODE                           ");
		sb.append("				,V.V_TITLE                          ");
		sb.append("				,V.V_GENRE                          ");
		sb.append("				,V.V_PAY                            ");
		sb.append("				,V.V_RENTSTATE                      ");
		sb.append("				,V.V_MAKECOMPANY                    ");
		sb.append("				,TO_CHAR(V.V_MAKEDATE,'YYYY-MM-DD') ");
		sb.append("				,V.V_VIEWAGE                        ");
		sb.append("				,TO_CHAR(V.CREATEDATE,'YYYY-MM-DD') ");
		sb.append("				,TO_CHAR(V.UPDATEDATE,'YYYY-MM-DD') ");
		sb.append("FROM                 			                ");
		sb.append("				ORAUSER01.VIDEO V    			    ");
		sb.append("WHERE                			                ");
		sb.append("				1=1                  			    ");
		sb.append("AND 			V.DELETEYN='Y'   			        ");
		sb.append("AND 			SUBSTR(V.V_CODE,10)=?               ");
		
		return sb.toString();
	}
	
	
	//비디오입력
	public static String getInsertQuery(){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("INSERT INTO          			  ");
		sb.append("               VIDEO               ");
		sb.append("VALUES(              			  ");
		sb.append("               ?                   ");// 1.  비디오번호
		sb.append("              ,?                   ");// 2.  제목
		sb.append("              ,?                   ");// 3.  장르
		sb.append("              ,?                   ");// 4.  대여료
		sb.append("              ,'N'                 ");// 5.  대여구분
		sb.append("              ,?                   ");// 6.  출시사
		sb.append("              ,?                   ");// 7.  출시일
		sb.append("              ,?                   ");// 8.  관람등급
		sb.append("              ,'Y'                 ");// 9.  비디오삭제여부
		sb.append("              ,SYSDATE             ");// 10. 생성일
		sb.append("              ,SYSDATE )           ");// 11. 수정일
		
		return sb.toString();
	}
	
	public static String getUpdateQuery(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("UPDATE ORAUSER01.VIDEO V       ");
		sb.append("SET V_PAY=?                    ");
		sb.append(",UPDATEDATE=SYSDATE            ");
		sb.append("WHERE 1=1                      ");
		sb.append("AND V.DELETEYN='Y'             ");
		sb.append("AND SUBSTR(V.V_CODE,10)=?                 ");
		
		
		return sb.toString();
	}
	
	public static String getDeleteQuery(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("UPDATE                          ");
		sb.append(" ORAUSER01.VIDEO V              ");
		sb.append("SET V.UPDATEDATE=SYSDATE        ");
		sb.append(",V.DELETEYN='N'                 ");
		sb.append("WHERE 1=1                       ");
		sb.append("AND V.DELETEYN='Y'              ");
		sb.append("AND SUBSTR(V.V_CODE,10)=?                  ");
		
		
		
		
		
		return sb.toString();
		
		
	}
	
	
	
	
	
	
	
}
