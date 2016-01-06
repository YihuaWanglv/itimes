package com.iyihua.bootdemo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.iyihua.bootdemo.model.User;

interface UserRepository extends Repository<User, Long> {

	Page<User> findAll(Pageable pageable);

	Page<User> findByNameContainingAndTypeContainingAllIgnoringCase(String name,
			Integer type, Pageable pageable);

	User findByNameAndTypeAllIgnoringCase(String name, Integer type);

}
