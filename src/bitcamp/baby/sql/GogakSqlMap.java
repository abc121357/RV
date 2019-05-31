package bitcamp.baby.sql;

public abstract class GogakSqlMap {

	public static final int QUERY_G_INDEX_0=0;
	
	public static final String[] COMMON_USE_QEURY={
			"SELECT /*+INDEX_DESC(SYS_C0011168)*/"
			+ "NVL(MAX(SUBSTR(G.G_CODE,12)),0)+1 commNo FROM GOGAK G"
			}; 
	
	public static String getSelectQuery(){
	StringBuffer sb=new StringBuffer(); 
	sb.append("Select                                            \n");
	sb.append("             G.G_CODE                             \n");
	sb.append("            ,G.G_NAME                             \n");
	sb.append("			   ,G.G_AGE                              \n");
	sb.append("			   ,G.G_ADDR                             \n");
	sb.append("  		   ,G.G_TEL                              \n");
	sb.append("			   ,G.DELETEYN                           \n");
	sb.append(" 		   ,TO_CHAR(G.CREATEDATE,'YYYY-MM-DD')   \n");
	sb.append("			   ,TO_CHAR(G.UPDATEDATE,'YYYY-MM-DD')   \n");
	sb.append("			   ,G.VIPYN                              \n");
	sb.append("FROM                                              \n");
	sb.append("			    orauser01.GOGAK G                    \n");
	sb.append("WHERE 		1=1                                  \n");
	sb.append("AND 			SUBSTR(G.G_CODE,10)=?                           \n");
	sb.append("AND 			G.DELETEYN='Y'                       \n");
	
	
	return sb.toString();
	}

		
	public static String getInsertQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("INSERT                 			   \n");
	sb.append("INTO                   			   \n");
	sb.append("            GOGAK                   \n");
	sb.append("VALUES(                  		   \n");
	sb.append("				 ?                     \n"); 
	sb.append("				,?                     \n");
	sb.append("				,?                     \n");
	sb.append("				,?                     \n");
	sb.append("				,?                     \n");
	sb.append("				,'Y'                   \n");
	sb.append("				,SYSDATE               \n");
	sb.append("				,SYSDATE               \n");
	sb.append("				,'N')                  \n");
	
	return sb.toString();
	}
	
	public static String getUpdateQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("UPDATE                 \n");
	sb.append("				orauser01.GOGAK G      \n");
	sb.append("SET                    			   \n");
	sb.append("				G.G_TEL=?              \n");
	sb.append("            ,UPDATEDATE=SYSDATE     \n");
	sb.append("WHERE                               \n");
	sb.append("				1=1                    \n");
	sb.append("AND 			G.DELETEYN = 'Y'       \n");
	sb.append("AND 			SUBSTR(G.G_CODE,10)=? 	\n");

	
	return sb.toString();
	}
	
	public static String getDeleteQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("UPDATE                            \n");
	sb.append("				orauser01.GOGAK G    \n");
	sb.append("SET                               \n");
	sb.append("				G.DELETEYN='N'       \n");
	sb.append("			   ,UPDATEDATE=SYSDATE   \n");
	sb.append("WHERE                             \n");
	sb.append("				1=1                  \n");
	sb.append("AND 			G.DELETEYN  ='Y'     \n");
	sb.append("AND 			SUBSTR(G.G_CODE,10)=?           \n");
	
	return sb.toString();
	}
	
	
}
