package com.cloud.note.Service;

import com.cloud.note.entity.NoteResult;

public interface NoteBookService {
	//����
	public NoteResult loadBooks(String userId);
	//��ӱʼǱ�
	public NoteResult addNoteBook(String bookName,String userid);
}
