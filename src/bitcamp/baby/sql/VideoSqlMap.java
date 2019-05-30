package bitcamp.baby.sql;

import bitcamp.baby.common.ChaeBun;

//DATE �ڷ������� TO_CHAR�� ������!!
public abstract class VideoSqlMap {
	
	public static final String[] COMMON_USE_QEURY={
	"SELECT /*+INDEX_DESC(SYS_C0011176)*/"
	+ "NVL(MAX(SUBSTR(V.V_CODE,10)),0)+1 commNo FROM VIDEO V"
	}; 
	
	
	//������ȸ
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
	
	
	//�����Է�
	public static String getInsertQuery(){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("INSERT INTO          			  ");
		sb.append("               VIDEO               ");
		sb.append("VALUES(              			  ");
		sb.append("               ?                   ");// 1.  ������ȣ
		sb.append("              ,?                   ");// 2.  ����
		sb.append("              ,?                   ");// 3.  �帣
		sb.append("              ,?                   ");// 4.  �뿩��
		sb.append("              ,'N'                 ");// 5.  �뿩����
		sb.append("              ,?                   ");// 6.  ��û�
		sb.append("              ,?                   ");// 7.  �����
		sb.append("              ,?                   ");// 8.  �������
		sb.append("              ,'Y'                 ");// 9.  ������������
		sb.append("              ,SYSDATE             ");// 10. ������
		sb.append("              ,SYSDATE )           ");// 11. ������
		
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
