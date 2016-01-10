package com.iyihua.itimes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.itimes.mapper.ItemMapper;
import com.iyihua.itimes.model.Item;
import com.iyihua.model.base.ItemDTO;
import com.iyihua.model.component.Page;
import com.iyihua.model.query.UserItemQueryDTO;
import com.iyihua.remote.base.ItemRemote;

@Service
public class ItemService implements ItemRemote {

	@Autowired
	ItemMapper itemMapper;
	
	@Override
	public List<ItemDTO> findItemsByUserId(Long userId) {
		List<ItemDTO> result = new ArrayList<ItemDTO>();
		List<Item> items = itemMapper.findAll();
		if (items != null && items.size() > 0) {
			for (Item item : items) {
				ItemDTO dto = new ItemDTO();
				BeanUtils.copyProperties(item, dto);
				result.add(dto);
			}
		}
		return result;
	}

	@Override
	public List<ItemDTO> findItemsByParams(ItemDTO item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> findItemsByQueryParams(UserItemQueryDTO query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemDTO> findItemsByQueryParamsWithPage(UserItemQueryDTO query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDTO saveItem(ItemDTO item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(Long itemId) {
		// TODO Auto-generated method stub
		
	}

}
