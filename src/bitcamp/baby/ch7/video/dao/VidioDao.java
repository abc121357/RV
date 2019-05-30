package bitcamp.baby.ch7.video.dao;

import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.VidioVO;

public interface VidioDao {

	public ArrayList selectVidio(VidioVO vo);
	public int insertVidio(VidioVO vo);
	public int updateVidio(VidioVO vo);
	public int DeleteVidio(VidioVO vo);
	
}
