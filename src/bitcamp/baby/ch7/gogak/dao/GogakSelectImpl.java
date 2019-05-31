package bitcamp.baby.ch7.gogak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bitcamp.baby.ch7.video.vo.GogakVO;

public interface GogakSelectImpl {

	public PreparedStatement getQuery(Connection c);
	
	
}
