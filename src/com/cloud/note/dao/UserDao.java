package com.cloud.note.dao;

import org.apache.ibatis.annotations.Param;

import com.cloud.note.entity.User;

public interface UserDao {

	//ע��
	public void save(User user);
	
	//�������ݿ����������ж���
	public int selectCountByName(String name);
	//��ѯ���ݿ����Ƿ�������û������ҷ�������û�
	public User findByName(String name);
	//�޸�����
	public void updatePassword(@Param(value="userId")String userId,@Param(value="userPassword")String new_password);
    //��ѯ����
	public String selectPasswordByUserId(String userId);
}
