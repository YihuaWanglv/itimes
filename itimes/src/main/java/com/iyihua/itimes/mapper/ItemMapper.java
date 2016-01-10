
package com.iyihua.itimes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.iyihua.itimes.model.Item;
import com.iyihua.itimes.repository.provider.SampleProvider;



/**
 * @author iyihua
 */
public interface ItemMapper {

	// @Select("select * from items where state = #{state}")
	// City findByState(@Param("state") String state);
	@Select("select * from items")
	List<Item> findAll();
	
//	@SelectProvider(type = SampleProvider.class,  
//            method = "findUserByParams") 
//	List<Item> findItemsByParams(@Param("item")Item item);
	

}
