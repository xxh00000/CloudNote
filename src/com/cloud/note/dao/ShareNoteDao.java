package com.cloud.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.note.entity.ShareNote;

public interface ShareNoteDao {

	public void insertShareNote(ShareNote shareNote);
	
	public ShareNote selectShareNoteByNId(String noteId);
	
	public List<ShareNote> selectShareNoteByWords(@Param(value="words")String words);
}
