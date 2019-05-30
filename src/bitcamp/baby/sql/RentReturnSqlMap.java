package bitcamp.baby.sql;

public abstract class RentReturnSqlMap {

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
	
}
