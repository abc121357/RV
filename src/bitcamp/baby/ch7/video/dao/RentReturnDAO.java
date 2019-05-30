package bitcamp.baby.ch7.video.dao;

import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.RentReturnVO;

public interface RentReturnDAO {

	public ArrayList selectRentReturn(RentReturnVO vo);
	public int insertRentReturn(RentReturnVO vo);
	public int updateRentReturn(RentReturnVO vo);
	public int deleteRentReturn(RentReturnVO vo);
}
