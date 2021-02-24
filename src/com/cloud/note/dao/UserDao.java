package com.cloud.note.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.note.entity.User;

public interface UserDao {

	//注册
	public void save(User user);
	
	//查找数据库中重名的有多少
	public int selectCountByName(String name);
	//查询数据库中是否有这个用户，并且返回这个用户
	public User findByName(String name);
	//修改密码
	public void updatePassword(@Param(value="userId")String userId,@Param(value="userPassword")String new_password);
    //查询密码
	public String selectPasswordByUserId(String userId);
}
