
package com.iyihua.itimes.services.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iyihua.itimes.services.item.model.Item;

/**
 * @author iyihua
 */
public interface ItemMapper {

	// @Select("select * from items where state = #{state}")
	// City findByState(@Param("state") String state);
	@Select("select * from items")
	List<Item> findAll();

}
