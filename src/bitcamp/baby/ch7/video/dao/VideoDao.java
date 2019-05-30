package bitcamp.baby.ch7.video.dao;

import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.VideoVO;

public interface VideoDao {

	public ArrayList selectVideo(VideoVO vo);
	public int insertVideo(VideoVO vo);
	public int updateVideo(VideoVO vo);
	public int DeleteVideo(VideoVO vo);
	
}
