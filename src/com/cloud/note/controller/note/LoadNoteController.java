package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
@Resource
private NoteService service;
@RequestMapping("/loadNote.do")
@ResponseBody
public NoteResult loadNote(String noteBookId) {
	NoteResult result=service.loadNote(noteBookId);
	return result;
}
}
