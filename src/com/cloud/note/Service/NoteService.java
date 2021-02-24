package com.cloud.note.Service;

import com.cloud.note.entity.NoteResult;

public interface NoteService {

	public NoteResult loadNote(String noteBookId);
	
	public NoteResult addNote(String noteName,String bookId,String UserId);
	
	public NoteResult findNote(String noteId);
	
	public NoteResult saveNoteChange(String noteId,String noteTitle,String noteBody);
	
	public NoteResult deleteNote(String noteId);
	
	public NoteResult moveNote(String noteId,String bookId);
	
	public NoteResult deleteNoteNever(String noteId);
	
	public NoteResult rollBackNote(String userId);
}
