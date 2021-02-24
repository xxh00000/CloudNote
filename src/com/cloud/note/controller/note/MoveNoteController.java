package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class MoveNoteController {

	@Resource
	NoteService service;
	@RequestMapping("/moveNote.do")
	@ResponseBody
	public NoteResult moveNote(String noteId,String bookId)
	{
		NoteResult result=service.moveNote(noteId, bookId);
		return result;
	}
}
