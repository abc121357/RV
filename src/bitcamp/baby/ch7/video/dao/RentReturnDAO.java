package bitcamp.baby.ch7.video.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.ch7.video.vo.RentReturnVO;
import bitcamp.baby.ch7.video.vo.VideoVO;

public interface RentReturnDAO {

	public ArrayList selectRentReturn(RentReturnVO vo);
	public boolean insertRentReturn(GogakVO gVo, VideoVO vVo, RentReturnVO rVo);
	public int updateRentReturn(RentReturnVO vo);
	public int deleteRentReturn(RentReturnVO vo);
}
