
package com.iyihua.itimes.services.item.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iyihua.model.base.UserDTO;

/**
 * @author iyihua
 */
public interface UserMapper {

	@Select("select * from user where id = #{id}")
	UserDTO findById(@Param("id") Long id);

}
