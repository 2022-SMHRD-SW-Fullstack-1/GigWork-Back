package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.ChattingContent;
import com.example.demo.model.ChattingRoom;
import com.example.demo.model.Matching;
import com.example.demo.model.MatchingInsert;
import com.example.demo.model.Post;

@Mapper
public interface ChatMapper {

	@Select("select * from T_CHATTING_CONTENT")
	public List<ChattingContent> getChattingContent();
	
	@Select("select * from T_CHATTING_ROOM where MEM_NICK = #{nick} or PARTNER_NICK = #{nick} order by cr_seq")
	public List<ChattingRoom> getChattingRoom(String nick);
	
	@Select("select * from T_CHATTING_CONTENT where CR_SEQ = #{roomNum} order by CC_SEQ")
	public List<ChattingContent> getChatContent(String roomNum);
	
	public void putChatContent(ChattingContent data);
	
	@Insert("insert into T_CHATTING_ROOM values (null, #{mem_nick}, sysdate, #{partner_nick}, 'c', #{post_num})")
	public void createChatRoom(ChattingRoom data);
	
	@Select("select * from ( select * from T_CHATTING_ROOM order by cr_seq desc) where rownum = 1")
	public ChattingRoom getChatRoom();
	
	@Select("select * from T_POST where post_num=#{post_num}")
	public Post getPostInfo(int post_num);
	
	@Update("update T_CHATTING_ROOM set cr_status='t' where cr_seq=#{roomnum}")
	public void updateCR(int roomnum);
	
	@Update("update T_POST set status='거래중' where post_num=#{post_num}")
	public void updatePost(int post_num);
	
	@Update("update T_POST set status='거래완료' where post_num=#{post_num}")
	public void updatePost2(int post_num);
	
	@Insert("insert into T_MATCHING values (null, #{post_num}, #{match_id}, sysdate)")
	public void addMatching(MatchingInsert mi);
	
	@Select("select mem_id from T_MEMBER where name=#{nick}")
	public String whatIsId(String nick);
}