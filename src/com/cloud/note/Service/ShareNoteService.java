package com.cloud.note.Service;

import com.cloud.note.entity.NoteResult;

public interface ShareNoteService {
    //��ӷ����ʼ�
	public NoteResult addShareNote(String noteId);
	//���ձʼǺŽ��в�ѯ����ʼ�
	public NoteResult selectShareNoteByNId(String noteId);
	//ģ�������ʼ��е�����
	public NoteResult searchShareNote(String words);
}
