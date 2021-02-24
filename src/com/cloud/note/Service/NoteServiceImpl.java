package com.cloud.note.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.note.dao.NoteDao;
import com.cloud.note.entity.Note;
import com.cloud.note.entity.NoteResult;
import com.cloud.note.util.NoteUtil;

@Service
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteDao notedao;
	@Override
	public NoteResult loadNote(String noteBookId) {
	NoteResult result=new NoteResult();
	List<Note>notes=notedao.findByNoteBookId(noteBookId);
	System.out.println(noteBookId);
	if(notes!=null) {
	/*for(Note note:notes)
	{
		System.out.println(note.toString());
	}*/
	System.out.println("笔记共有:"+notes.size());
	result.setStatus(0);
	result.setMsg("加载成功");
	result.setData(notes);}
	else
	{
		result.setStatus(1);
		result.setMsg("加载失败");
		
	}
	return result;
	}
	@Override
	public NoteResult addNote(String noteName, String bookId, String UserId) {
		System.out.print("进入到这个方法了了了");
		NoteResult result=new NoteResult();
		Note note=new Note();
		String noteId=NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(UserId);
		note.setCn_note_title(noteName);
		BigInteger createTime;
		BigInteger lastEditTime;
		createTime=BigInteger.valueOf(System.currentTimeMillis());
		lastEditTime=BigInteger.valueOf(System.currentTimeMillis());
        note.setCn_note_create_time(createTime);
        note.setCn_note_last_modify_time(lastEditTime);
        Random random=new Random();
        int a1=random.nextInt(10);
        String b1=Integer.toString(a1);
        int a2=random.nextInt(10);
        String b2=Integer.toString(a2);
        note.setCn_note_type_id(b1);
        note.setCn_note_status_id("1");
        note.setCn_note_body("<p>fzyfzyfzy</p>");
        notedao.insertNote(note);
        result.setStatus(0);
        result.setMsg("添加成功");
        result.setData(noteId);
		return result;
	}
	@Override
	public NoteResult findNote(String noteId) {
		System.out.println("进入到了查询笔记的界面");
		NoteResult result=new NoteResult();
		Note note=notedao.findNoteByNoteId(noteId);
		if(note!=null) {
		result.setData(note);
		result.setStatus(0);
		result.setMsg("查找成功");
		}
		else
		{
			result.setStatus(1);
			result.setMsg("查询失败");
		}
		return result;
	}
	@Override
	public NoteResult saveNoteChange(String noteId, String noteTitle, String noteBody) {
		BigInteger last_time;
		last_time=BigInteger.valueOf(System.currentTimeMillis());
		notedao.saveChangeNote(noteId, noteTitle, noteBody, last_time);
		NoteResult result=new NoteResult();
		result.setData(noteId);
		result.setMsg("修改成功");
		result.setStatus(0);
		return result;
	}
	@Override
	public NoteResult deleteNote(String noteId) {
		System.out.println("进行移到回收站");
		NoteResult result=new NoteResult();
		notedao.removeNT(noteId);
		result.setMsg("删除成功，放到了回收站中去");
		return result;
	}
	@Override
	public NoteResult moveNote(String noteId, String bookId) {
		NoteResult result=new NoteResult();
		//Note note=notedao.findNoteByNoteId(noteId);
		//TODO把它添加到另一个笔记本中去
		notedao.removeNOther(noteId, bookId);
		result.setMsg("移动成功");
		result.setStatus(0);
		return result;
	}
	@Override
	public NoteResult deleteNoteNever(String noteId) {
		System.out.println("进行彻底删除");
		NoteResult result=new NoteResult();
		notedao.deleteNote(noteId);
		result.setMsg("删除成功");
		return result;
	}
	@Override
	public NoteResult rollBackNote(String userId) {
		NoteResult result=new NoteResult();
		List<Note> notes=notedao.rollBackNote(userId);
		if(notes!=null)
		{
			result.setData(notes);
			result.setMsg("显示出回收站中的内容");
			result.setStatus(0);
		}
		else
		{
			result.setMsg("回收站为空");
			result.setStatus(0);
		}
		
		return result;
	}

}
