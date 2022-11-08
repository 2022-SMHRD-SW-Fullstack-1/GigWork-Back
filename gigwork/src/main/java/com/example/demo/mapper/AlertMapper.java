package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Alert;

@Mapper
public interface AlertMapper {
	
	@Insert("insert into T_CHATTING_CONTENT values (null, #{mem_nick}, #{alert_cnt}, #{alert_time}, #{sendfrom})")
	public void addChatAlert(Alert alert);

	@Select("select * from t_alert where mem_nick=#{nick}")
	public List<Alert> getAlertList(String nick);
}
