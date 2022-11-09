package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Alert;

@Mapper
public interface AlertMapper {
	
	@Insert("insert into t_alert values (null, #{mem_nick}, #{alert_cnt}, sysdate, #{sendfrom}, #{ckecking})")
	public void addChatAlert(Alert alert);

	@Select("select * from t_alert where mem_nick=#{nick}")
	public List<Alert> getAlertList(String nick);
	
	@Delete("delete from t_alert where alert_seq=#{alert_seq}")
	public void deleteAlert(String alert_seq);
}
