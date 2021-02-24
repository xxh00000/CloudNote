package com.cloud.note.Service;

import com.cloud.note.entity.NoteResult;

public interface NoteBookService {
	//加载
	public NoteResult loadBooks(String userId);
	//添加笔记本
	public NoteResult addNoteBook(String bookName,String userid);
}
