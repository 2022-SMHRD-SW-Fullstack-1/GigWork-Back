package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.ChattingContent;
import com.example.demo.model.ChattingRoom;

@Mapper
public interface ChatMapper {

	@Select("select * from T_CHATTING_CONTENT")
	public List<ChattingContent> getChattingContent();
	
	@Select("select * from T_CHATTING_ROOM where MEM_ID = #{id} or PARTNER_ID = #{id}")
	public List<ChattingRoom> getChattingRoom(String id);
	
	@Select("select * from T_CHATTING_CONTENT where CR_SEQ = #{roomNum}")
	public List<ChattingContent> getChatContent(String roomNum);
	
	public void putChatContent(ChattingContent data);
}
