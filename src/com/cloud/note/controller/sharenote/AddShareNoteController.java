package com.cloud.note.controller.sharenote;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.ShareNoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/sharenote")
public class AddShareNoteController {
@Resource
ShareNoteService service;
@RequestMapping("/addShareNote.do")
@ResponseBody
public NoteResult addShareNote(String noteId)
{
	NoteResult result=service.addShareNote(noteId);
	return result;
}
}
