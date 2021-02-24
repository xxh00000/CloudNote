package com.cloud.note.controller.sharenote;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.ShareNoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/sharenote")
public class SearchShareNoteController {
@Resource
private ShareNoteService service;
@RequestMapping("/searchShareNote.do")
@ResponseBody
public NoteResult searchShareNote(String words)
{
	NoteResult result=service.searchShareNote(words);
	return result;
	
}
}
