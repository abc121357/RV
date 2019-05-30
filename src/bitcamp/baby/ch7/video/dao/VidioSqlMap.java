package bitcamp.baby.ch7.video.dao;

import bitcamp.baby.common.Chaebun;

//DATE �ڷ������� TO_CHAR�� ������!!
public abstract class VidioSqlMap {

	
	public static final String[] COMMON_USE_QEURY={
	"SELECT /*+INDEX_DESC(SYS_C0011144)*/"
	+ "NVL(MAX(SUBSTR(V.V_CODE,12)),0)+1 commNo FROM VIDIO V"
	}; 
	
	
	
	public static String getSelectQuery(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT                              ");
		sb.append("V.V_CODE                            ");
		sb.append(",V.V_TITLE                          ");
		sb.append(",V.V_GENRE                          ");
		sb.append(",V.V_PAY                            ");
		sb.append(",V.V_RENTSTATE                      ");
		sb.append(",V.V_MAKECOMPANY                    ");
		sb.append(",TO_CHAR(V.V_MAKEDATE,'YYYY-MM-DD') ");
		sb.append(",V.V_VIEWAGE                        ");
		sb.append(",TO_CHAR(V.CREATEDATE,'YYYY-MM-DD') ");
		sb.append(",TO_CHAR(V.UPDATEDATE,'YYYY-MM-DD') ");
		sb.append("FROM                 			   ");
		sb.append("ORAUSER01.VIDIO V    			   ");
		sb.append("WHERE                			   ");
		sb.append("1=1                  			   ");
		sb.append("AND V.DELETEYN='Y'   			   ");
		sb.append("AND V.V_CODE=?        			   ");
		
		
		
		return sb.toString();
	}
	
	public static String getInsertQuery(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("INSERT INTO          ");
		sb.append("VIDIO                ");
		sb.append("VALUES(              ");
		sb.append("?                    ");// 1. ��ȣ
		sb.append(",?                   ");// 2. Ÿ��Ʋ
		sb.append(",?                   ");// 3. �帣
		sb.append(",?                   ");// 4. ���
		sb.append(",?                   ");// 5. �뿩�Ⱓ
		sb.append(",?                   ");// 6. ���ۻ�
		sb.append(",?                   ");// 7. ����������
		sb.append(",?                   ");// 8. ��û����
		sb.append(",'Y'                 ");
		sb.append(",SYSDATE             ");
		sb.append(",SYSDATE)            ");
		
		return sb.toString();
	}
	
	public static String getUpdateQuery(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("UPDATE ORAUSER01.VIDIO V       ");
		sb.append("SET V_PAY=?                    ");
		sb.append(",UPDATEDATE=SYSDATE            ");
		sb.append("WHERE 1=1                      ");
		sb.append("AND V.DELETEYN='Y'             ");
		sb.append("AND V.V_CODE=?                 ");
		
		
		return sb.toString();
	}
	
	public static String getDeleteQuery(){
		StringBuffer sb=new StringBuffer();
		
		sb.append("UPDATE                          ");
		sb.append(" ORAUSER01.VIDIO V              ");
		sb.append("SET V.UPDATEDATE=SYSDATE        ");
		sb.append(",V.DELETEYN='N'                 ");
		sb.append("WHERE 1=1                       ");
		sb.append("AND V.DELETEYN='Y'              ");
		sb.append("AND V.V_CODE=?                  ");
		
		
		
		
		
		return sb.toString();
		
		
	}
	
	
	
	
	
	
	
}
