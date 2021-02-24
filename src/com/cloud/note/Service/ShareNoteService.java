package com.cloud.note.Service;

import com.cloud.note.entity.NoteResult;

public interface ShareNoteService {
    //添加分析笔记
	public NoteResult addShareNote(String noteId);
	//按照笔记号进行查询共享笔记
	public NoteResult selectShareNoteByNId(String noteId);
	//模糊搜索笔记中的内容
	public NoteResult searchShareNote(String words);
}
