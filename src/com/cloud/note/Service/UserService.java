package com.cloud.note.Service;

import java.security.NoSuchAlgorithmException;

import com.cloud.note.entity.NoteResult;

public interface UserService {
    //×¢²á
	public NoteResult register(String name,String password,String nick) throws Exception;
	//µÇÂ¼
	public NoteResult checkLogin(String name,String password) throws NoSuchAlgorithmException;
    //ÐÞ¸ÄÃÜÂë
	public NoteResult changePassword(String userId,String last_password,String new_password) throws NoSuchAlgorithmException;
}
