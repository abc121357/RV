package bitcamp.baby.sql;

public abstract class RentReturnSqlMap {

	public static final int QUERY_R_INDEX_0 =0;
	
	
	public static final String[] COMMON_USE_QUERY={
			"SELECT /*+INDEX_DESC(SYS_C0011207)*/"
			+ "NVL(MAX(SUBSTR(R.R_CODE,10)),0)+1 commNo FROM RENTRETURN R"}; 
	
	
	public static String SELECT_QUERY = "SELECT R.R_CODE,R.G_CODE,R.V_CODE,TO_CHAR(R.R_RENTDATE,'YYYY-MM-DD'),"
			+ "TO_CHAR(R.R_PLANDATE,'YYYY-MM-DD'),"
			+ "TO_CHAR(R.R_RETURNDATE,'YYYY-MM-DD'),"
			+ "R.R_TOTALPAY,R.R_OVERDUEDATE,R.DELETEYN,R.CREATEDATE,R.UPDATEDATE"
			+ "FROM RENTRETURN R WHERE 1 = 1  AND SUBSTR(R.V_CODE,10) = ?";     
	
	public static String INSERT_QUERY =
		"INSERT INTO RENTRETURN VALUES  "
		+ "( ? ,?, ? ,SYSDATE ,SYSDATE+2 ,NULL "
		+ ",(SELECT S.V_PAY FROM VIDEO S WHERE S.V_CODE=?),"
		+ "NULL,'N',SYSDATE,SYSDATE)";

	public static String INSERT_UPDATE_QUERY =
		"UPDATE VIDEO V SET V.V_RENTSTATE = 'X' "
		+ "WHERE  1 = 1 AND V.DELETEYN = 'Y' "
		+ "AND V.V_CODE = (SELECT V.V_CODE FROM RENTRETURN R, VIDEO V WHERE 1=1 "
		+ "AND   V.V_CODE = R.V_CODE AND R.V_CODE=?)";
	
	public static String UPDATE_QUERY =
		"UPDATE RENTRETURN SET  R_TOTALPAY = R_TOTALPAY - '1000' "
		+ "WHERE  1 = 1 AND    DELETEYN = 'N' AND SUBSTR(R_CODE, 10) = ?";
	
	public static String DELETE_QUERY = 
		"UPDATE RENTRETURN SET  DELETEYN = 'Y' ,R_RETURNDATE = SYSDATE "
		+ "WHERE 1 = 1 AND   DELETEYN = 'N' AND   R_CODE = ?";

	public static String DELETE_UPDATE_QUERY = 
		"UPDATE VIDEO V SET V.V_RENTSTATE = 'O' "
		+ "WHERE  1 = 1 AND V.DELETEYN = 'Y' "
		+ "AND V.V_CODE = (SELECT V.V_CODE FROM RENTRETURN R, VIDEO V "
		+ "WHERE 1=1 AND   V.V_CODE = R.V_CODE AND SUBSTR(R.V_CODE, 10)=?)";
	
}
	
	
	
	
	
	
	
	
	/*
	public static String getSelectQuery(){
		// Query
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT  		                      	 		");
		sb.append("		  R.R_CODE     	               			");
		sb.append("		 ,R.G_CODE                    		    ");
		sb.append("      ,R.V_CODE                       		");
		sb.append("		 ,TO_CHAR(R.R_RENTDATE,'YYYY-MM-DD')	");
		sb.append("		 ,TO_CHAR(R.R_PLANDATE,'YYYY-MM-DD') 	");
		sb.append("		 ,TO_CHAR(R.R_RETURNDATE,'YYYY-MM-DD') 	");
		sb.append("		 ,R.R_TOTALPAY                    		");
		sb.append("		 ,R.R_OVERDUEDATE                 		");
		sb.append("		 ,R.DELETEYN                       		");
		sb.append("		 ,R.CREATEDATE                          ");
		sb.append("		 ,R.UPDATEDATE                    		");
		sb.append("FROM                             			");
		sb.append("		 RENTRETURN R                   		");
		sb.append("WHERE 1 = 1                   				");
		sb.append("AND   SUBSTR(R.V_CODE,10) = '0001'        	");
		
		return sb.toString();
	}
	
public static String getInsertQuery(){
	
	// Query
	StringBuffer sb=new StringBuffer();
	sb.append("INSERT                  ");
	sb.append("INTO                    ");
	sb.append("RENTALRETURN            ");
	sb.append("VALUES(                 ");
	sb.append("?                       ");
	sb.append(",?                      ");
	sb.append(",?                      ");
	sb.append(",SYSDATE                ");
	sb.append(",?                      ");
	sb.append(",NULL                   ");
	sb.append(",(SELECT S.V_PAY FROM VIDIO S WHERE S.V_CODE='V201905280002') ");
	sb.append(",FROM VIDIO S                      ");
	sb.append(",WHERE S.V_CODE='V201905280002')   ");
	sb.append(",NULL                              ");
	sb.append(",'N'                               ");
	sb.append("SYSDATE                            ");
	sb.append("SYSDATE                            ");
	
	return sb.toString();
	
	
	
	}
	
public static String getUpdateQuery(){
	
	// Query
	StringBuffer sb=new StringBuffer();
	sb.append("UPDATE                 ");
	sb.append("RENTALRETURN           ");
	sb.append("SET                    ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	
	
	return sb.toString();
}

public static String getDeleteQuery(){
	
	// Query
	StringBuffer sb=new StringBuffer();
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	sb.append("                       ");
	
	
	return sb.toString();
}
*/	

