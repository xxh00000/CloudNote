package com.cloud.note.dao;

import java.util.List;

import com.cloud.note.entity.NoteBook;

public interface NoteBookDao {
        //根据用户ID查询当前用户的笔记本
	public List<NoteBook> findByUserId(String userId);
	//拥有用户ID,笔记本ID，创建时间，笔记本名称，完成添加用笔记本的功能
	public void InsertNoteBook(NoteBook book);
    //获得现在的时间， TimeStamp time=new TimeStamp(System.currentTimeMillis());
	
}
