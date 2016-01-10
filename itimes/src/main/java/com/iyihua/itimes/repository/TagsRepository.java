
package com.iyihua.itimes.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iyihua.itimes.model.Tags;

public interface TagsRepository extends CrudRepository<Tags, Long> {

	List<Tags> findByUserId(Long userId);

}
