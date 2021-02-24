package com.cloud.note.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.note.entity.Note;

public interface NoteDao {

	//���رʼǱ��еıʼ�
	public List<Note> findByNoteBookId(String noteBookId);
	//��ӱʼǱ�
	public void insertNote(Note note);
	//���ձʼ�ID���в�ѯ��صıʼǵ���ϸ��
	public Note findNoteByNoteId(String noteId);
	//���ڽ����޸ĵıʼǽ��б���
	public void saveChangeNote(@Param(value="noteId")String noteId,@Param(value="title")String title,@Param(value="body")String body,@Param(value="time")BigInteger h);
   //���г���ɾ���ʼ�
	public void deleteNote(String noteId);
	//�ѱʼ��Ƶ�����վ��ȥ
	public void removeNT(String noteId);
	//�ѸñʼǷŵ���һ���ʼǱ���ȥ
	public void removeNOther(@Param(value="noteId")String noteId,@Param(value="bookId")String bookId);

	//���ػ���վ�еıʼ�
	public List<Note> rollBackNote(String userId);
}
