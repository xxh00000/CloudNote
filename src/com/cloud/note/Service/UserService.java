package com.cloud.note.Service;

import java.security.NoSuchAlgorithmException;

import com.cloud.note.entity.NoteResult;

public interface UserService {
    //ע��
	public NoteResult register(String name,String password,String nick) throws Exception;
	//��¼
	public NoteResult checkLogin(String name,String password) throws NoSuchAlgorithmException;
    //�޸�����
	public NoteResult changePassword(String userId,String last_password,String new_password) throws NoSuchAlgorithmException;
}
