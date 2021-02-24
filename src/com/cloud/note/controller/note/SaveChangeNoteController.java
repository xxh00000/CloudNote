package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class SaveChangeNoteController {
@Resource
NoteService service;
@RequestMapping("/saveChangeNote.do")
@ResponseBody
public NoteResult saveChangeNote(String noteId,String noteTitle,String noteBody)
{
	NoteResult result=service.saveNoteChange(noteId, noteTitle, noteBody);
	return result;
	
}
}
