package bitcamp.baby.ch7.video.dao;

public abstract class GogakSqlMap {

	public static String getSelectQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("Select                                 \n");
	sb.append("G.G_CODE                               \n");
	sb.append(",G.G_NAME                              \n");
	sb.append(",G.G_AGE                               \n");
	sb.append(",G.G_ADDR                              \n");
	sb.append(",G.G_TEL                               \n");
	sb.append(",G.DELETEYN                            \n");
	sb.append(",TO_CHAR(G.CREATEDATE,'YYYY-MM-DD')    \n");
	sb.append(",TO_CHAR(G.UPDATEDATE,'YYYY-MM-DD')    \n");
	sb.append("FROM                                   \n");
	sb.append("orauser01.GOGAK G                      \n");
	sb.append("WHERE G.G_CODE=?                       \n");
	sb.append("AND DELETEYN='Y'                       \n");
	
	
	return sb.toString();
	}
	
	public static String getAllSelectQuery(){
		StringBuffer sb=new StringBuffer();
		sb.append("Select                                 \n");
		sb.append("G.G_CODE                               \n");
		sb.append(",G.G_NAME                              \n");
		sb.append(",G.G_AGE                               \n");
		sb.append(",G.G_ADDR                              \n");
		sb.append(",G.G_TEL                               \n");
		sb.append(",G.DELETEYN                            \n");
		sb.append(",TO_CHAR(G.CREATEDATE,'YYYY-MM-DD')    \n");
		sb.append(",TO_CHAR(G.UPDATEDATE,'YYYY-MM-DD')    \n");
		sb.append("FROM                                   \n");
		sb.append("orauser01.GOGAK G                      \n");
		sb.append("WHERE 1=1						      \n");
		sb.append("AND DELETEYN='Y'                       \n");
	
		return sb.toString();
	}
		
	public static String getInsertQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("INSERT                 \n");
	sb.append("INTO                   \n");
	sb.append("GOGAK                  \n");
	sb.append("VALUES(                \n");
	sb.append("GOGAK_SEQUENCE.NEXTVAL \n");
	sb.append(",?                     \n");
	sb.append(",?                     \n");
	sb.append(",?                     \n");
	sb.append(",?                     \n");
	sb.append(",'Y'                   \n");
	sb.append(",SYSDATE               \n");
	sb.append(",SYSDATE)              \n");
	
	return sb.toString();
	}
	
	public static String getUpdateQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("UPDATE                 \n");
	sb.append("orauser01.GOGAK G      \n");
	sb.append("SET                    \n");
	sb.append("G.G_AGE                \n");
	sb.append("=?                     \n");
	sb.append(",UPDATEDATE=SYSDATE    \n");
	sb.append("WHERE                  \n");
	sb.append("1=1 AND                \n");
	sb.append("G.DELETEYN = 'Y' AND   \n");
	sb.append("G.G_CODE               \n");
	sb.append("=?                     \n");
	
	
	return sb.toString();
	}
	
	public static String getDeleteQuery(){
	StringBuffer sb=new StringBuffer();
	sb.append("UPDATE                \n");
	sb.append("orauser01.GOGAK G     \n");
	sb.append("SET                   \n");
	sb.append("G.DELETEYN            \n");
	sb.append("='N'                  \n");
	sb.append(",UPDATEDATE=SYSDATE   \n");
	sb.append("WHERE                 \n");
	sb.append("1=1                   \n");
	sb.append("AND G.DELETEYN        \n");
	sb.append("='Y'                  \n");
	sb.append("AND G.G_CODE=?        \n");
	
	return sb.toString();
	}
	
	
}
