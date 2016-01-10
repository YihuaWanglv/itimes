package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.TagsDTO;

public interface TagsRemote {

	public List<TagsDTO> findTagsByUserId(Long userId);
	
	public TagsDTO saveTags(TagsDTO tags);
	
	public void deleteTags(Long tagsId);
}
