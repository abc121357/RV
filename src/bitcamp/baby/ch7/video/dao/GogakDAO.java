package bitcamp.baby.ch7.video.dao;

import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.GogakVO;
//dao�� �������̽��� �����Ѵ�.
public interface GogakDAO {

	public ArrayList selectGogak(GogakVO vo);
	
	public int insertGogak(GogakVO vo);	
	
	public int updateGogak(GogakVO vo);
	
	public int deleteGogak(GogakVO vo);
	
}
