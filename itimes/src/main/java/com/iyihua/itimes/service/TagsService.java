package com.iyihua.itimes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iyihua.itimes.model.Tags;
import com.iyihua.itimes.repository.TagsRepository;
import com.iyihua.model.base.TagsDTO;
import com.iyihua.remote.base.TagsRemote;

@Service
public class TagsService implements TagsRemote {

	@Autowired
	TagsRepository tagsRepository;
	
	@Override
	public List<TagsDTO> findTagsByUserId(Long userId) {
		Assert.notNull(userId, "userId can not be null!");
		List<TagsDTO> result = new ArrayList<TagsDTO>();
		List<Tags> tags = tagsRepository.findByUserId(userId);
		if (tags != null && tags.size() > 0) {
			for (Tags tag : tags) {
				TagsDTO dto = new TagsDTO();
				BeanUtils.copyProperties(tag, dto);
				result.add(dto);
			}
		}
		return result;
	}

	@Override
	public TagsDTO saveTags(TagsDTO tags) {
		Tags save = new Tags();
		BeanUtils.copyProperties(tags, save);
		save = tagsRepository.save(save);
		BeanUtils.copyProperties(save, tags);
		return tags;
	}

	@Override
	public void deleteTags(Long tagsId) {
		tagsRepository.delete(tagsId);
	}

}

