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
	System.out.println("�ʼǹ���:"+notes.size());
	result.setStatus(0);
	result.setMsg("���سɹ�");
	result.setData(notes);}
	else
	{
		result.setStatus(1);
		result.setMsg("����ʧ��");
		
	}
	return result;
	}
	@Override
	public NoteResult addNote(String noteName, String bookId, String UserId) {
		System.out.print("���뵽�������������");
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
        result.setMsg("��ӳɹ�");
        result.setData(noteId);
		return result;
	}
	@Override
	public NoteResult findNote(String noteId) {
		System.out.println("���뵽�˲�ѯ�ʼǵĽ���");
		NoteResult result=new NoteResult();
		Note note=notedao.findNoteByNoteId(noteId);
		if(note!=null) {
		result.setData(note);
		result.setStatus(0);
		result.setMsg("���ҳɹ�");
		}
		else
		{
			result.setStatus(1);
			result.setMsg("��ѯʧ��");
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
		result.setMsg("�޸ĳɹ�");
		result.setStatus(0);
		return result;
	}
	@Override
	public NoteResult deleteNote(String noteId) {
		System.out.println("�����Ƶ�����վ");
		NoteResult result=new NoteResult();
		notedao.removeNT(noteId);
		result.setMsg("ɾ���ɹ����ŵ��˻���վ��ȥ");
		return result;
	}
	@Override
	public NoteResult moveNote(String noteId, String bookId) {
		NoteResult result=new NoteResult();
		//Note note=notedao.findNoteByNoteId(noteId);
		//TODO������ӵ���һ���ʼǱ���ȥ
		notedao.removeNOther(noteId, bookId);
		result.setMsg("�ƶ��ɹ�");
		result.setStatus(0);
		return result;
	}
	@Override
	public NoteResult deleteNoteNever(String noteId) {
		System.out.println("���г���ɾ��");
		NoteResult result=new NoteResult();
		notedao.deleteNote(noteId);
		result.setMsg("ɾ���ɹ�");
		return result;
	}
	@Override
	public NoteResult rollBackNote(String userId) {
		NoteResult result=new NoteResult();
		List<Note> notes=notedao.rollBackNote(userId);
		if(notes!=null)
		{
			result.setData(notes);
			result.setMsg("��ʾ������վ�е�����");
			result.setStatus(0);
		}
		else
		{
			result.setMsg("����վΪ��");
			result.setStatus(0);
		}
		
		return result;
	}

}
