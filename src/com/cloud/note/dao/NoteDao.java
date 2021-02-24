package com.cloud.note.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.note.entity.Note;

public interface NoteDao {

	//加载笔记本中的笔记
	public List<Note> findByNoteBookId(String noteBookId);
	//添加笔记本
	public void insertNote(Note note);
	//按照笔记ID进行查询相关的笔记的详细新
	public Note findNoteByNoteId(String noteId);
	//对于进行修改的笔记进行保存
	public void saveChangeNote(@Param(value="noteId")String noteId,@Param(value="title")String title,@Param(value="body")String body,@Param(value="time")BigInteger h);
   //进行彻底删除笔记
	public void deleteNote(String noteId);
	//把笔记移到回收站中去
	public void removeNT(String noteId);
	//把该笔记放到另一个笔记本中去
	public void removeNOther(@Param(value="noteId")String noteId,@Param(value="bookId")String bookId);

	//加载回收站中的笔记
	public List<Note> rollBackNote(String userId);
}
