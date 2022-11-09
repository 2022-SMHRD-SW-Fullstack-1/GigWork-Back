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
	
	@Select("select * from T_CHATTING_ROOM where MEM_NICK = #{nick} or PARTNER_NICK = #{nick}")
	public List<ChattingRoom> getChattingRoom(String nick);
	
	@Select("select * from T_CHATTING_CONTENT where CR_SEQ = #{roomNum} order by CC_SEQ")
	public List<ChattingContent> getChatContent(String roomNum);
	
	public void putChatContent(ChattingContent data);
	
	@Insert("insert into T_CHATTING_ROOM values (null, #{mem_nick}, sysdate, #{partner_nick}, 'c', #{post_num})")
	public void createChatRoom(ChattingRoom data);
}