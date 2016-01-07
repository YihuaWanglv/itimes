package com.iyihua.itimes.services.item.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.itimes.services.item.mapper.ItemMapper;
import com.iyihua.itimes.services.item.model.Item;

@Service
public class MyService {

    @Autowired
    private ItemMapper itemMapper;
    
    public List<Item> getDemo() {
    	List<Item> r = itemMapper.findAll();
    	return r;
    }
    
}
