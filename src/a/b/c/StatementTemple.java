package a.b.c;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface StatementTemple {

	public PreparedStatement makePreparedStatement(Connection c);
	
}
