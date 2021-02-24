package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
@Resource
NoteService service;
@RequestMapping("/deleteNote.do")
@ResponseBody
public NoteResult deleteNote(String noteId)
{
	NoteResult result=service.deleteNote(noteId);
	return result;
}
}
