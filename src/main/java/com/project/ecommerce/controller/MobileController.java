package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.Mobile;
import com.project.ecommerce.repos.MobileRepository;

@RestController
public class MobileController {
	
	String s = "";
	
	@Autowired
	MobileRepository mobileRepository;
	
	@RequestMapping("/")
	public List<Mobile> filterMobile(@RequestParam(name="s", required = false, defaultValue="") String s, @RequestParam(name="offset", required = false, defaultValue="0") int page, @RequestParam(name="limit", required = false, defaultValue="5") int entries){
		int offsetLimit = page * entries;
		if(s.isEmpty()) {
			return mobileRepository.findAll(offsetLimit,entries);
		}
		else {
			List<Mobile> m = mobileRepository.findBySearch(s,offsetLimit,entries);
			return m;
		}
	}
	
}
