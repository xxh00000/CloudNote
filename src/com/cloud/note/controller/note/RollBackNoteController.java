package com.cloud.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.note.Service.NoteService;
import com.cloud.note.entity.NoteResult;

@Controller
@RequestMapping("/note")
public class RollBackNoteController {

	@Resource
	private NoteService service;
	@RequestMapping("/rollBackNote.do")
	@ResponseBody
	public NoteResult rollBackNote(String userId)
	{
		NoteResult result=service.rollBackNote(userId);
		return result;
	}
}
