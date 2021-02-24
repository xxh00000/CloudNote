package com.cloud.note.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.note.dao.NoteDao;
import com.cloud.note.dao.ShareNoteDao;
import com.cloud.note.entity.Note;
import com.cloud.note.entity.NoteResult;
import com.cloud.note.entity.ShareNote;
import com.cloud.note.util.NoteUtil;
@Service
public class ShareNoteServiceImpl implements ShareNoteService {

	@Resource
	ShareNoteDao sharedao;
	
	@Resource
	NoteDao notedao;
	
	@Override
	public NoteResult addShareNote(String noteId) {
		NoteResult result=new NoteResult();
		ShareNote temp=sharedao.selectShareNoteByNId(noteId);
       if(temp!=null)
		{
			result.setData(temp.getCn_share_id());
			result.setMsg("已经添加至分享");
			result.setStatus(0);
		}
		else {
		Note note=notedao.findNoteByNoteId(noteId);
		String title=note.getCn_note_title();
		String body=note.getCn_note_body();
		String sharenoteid=NoteUtil.createId();
		ShareNote shareNote=new ShareNote();
		shareNote.setCn_share_id(sharenoteid);
		shareNote.setCn_share_body(body);
		shareNote.setCn_share_title(title);
		shareNote.setCn_note_id(noteId);
		sharedao.insertShareNote(shareNote);
	     result.setData(sharenoteid);
		result.setMsg("分享成功");
		result.setStatus(0);}
		return result;
	}

	@Override
	public NoteResult selectShareNoteByNId(String noteId) {
		NoteResult result=new NoteResult();
		ShareNote shareNote=sharedao.selectShareNoteByNId(noteId);
		result.setData(shareNote);
		result.setMsg("查询成功");
		result.setStatus(0);
		return null;
	}

	@Override
	public NoteResult searchShareNote(String words) {
		NoteResult result=new NoteResult();
		words="%"+words+"%";
		List<ShareNote>notes=sharedao.selectShareNoteByWords(words);
		if(notes!=null)
		{
			result.setData(notes);
			result.setMsg("查询成功");
			result.setStatus(0);
		}
		else {
			result.setMsg("查询失败");
			result.setStatus(0);
		}
		return result;
	}

}
