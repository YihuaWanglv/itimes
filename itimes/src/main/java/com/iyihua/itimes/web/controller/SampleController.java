package com.iyihua.itimes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.itimes.mapper.ItemDao;
import com.iyihua.itimes.mapper.ItemMapper;
import com.iyihua.itimes.model.Category;
import com.iyihua.itimes.model.Item;
import com.iyihua.itimes.model.User;
import com.iyihua.itimes.repository.ItemRepository;
import com.iyihua.itimes.service.ItemService;
import com.iyihua.itimes.service.MyService;
import com.iyihua.model.base.ItemDTO;
import com.iyihua.model.base.UserDTO;
import com.iyihua.remote.base.ItemRemote;
import com.iyihua.remote.base.UserRemote;

@Controller
public class SampleController {

	@Autowired
	MyService myService;
	
//	@Autowired
//	UserRemote userService;
	
	@Autowired
	ItemRemote itemService;
	
	@Autowired
	ItemDao itemDao;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		String data = "";
		
		User user = myService.getUser("iyihua", 0);
		if (user != null) {
			System.err.println("user:" + user.getName());
		} else {
			System.err.println("null...........");
		}
		List<Category> categories = myService.listCategory();
		if (categories != null) {
			for (Category category : categories) {
				data += categories.toString();
			}
		}
		
//		UserDTO ud = userService.findUserById(2L);
//		if (ud != null) {
//			data += ud.getId() + "," + ud.getName();
//		}
//		List<ItemDTO> items = itemService.findItemsByUserId(1L);
//		if (items != null && items.size() > 0) {
//			for (ItemDTO i : items) {
//				data += i.getDescription();
//			}
//		}
		Item item = new Item();
		item.setUserId(1L);
		Item i = itemDao.selectCityById(1L);
		data += i.getDescription();
		return "Hello World!" + data;
	}

	
}
