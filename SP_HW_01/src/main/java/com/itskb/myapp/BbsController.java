package com.itskb.myapp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itskb.myapp.dao.MyBbsDao;
import com.itskb.myapp.dto.BbsDto;



@Controller
public class BbsController {
	
	//MyBatis DB에 연결
	@Autowired
	private MyBbsDao bbsDao;
	
	@RequestMapping("/bbs/login")
	public String bbs_list(Model model) {
		List<BbsDto> list = bbsDao.selectAll();
		model.addAttribute("bbs_list", list);
		return "bbs/login";
	}
	
	@RequestMapping("/bbs/register")
	public String bbs_list2(Model model) {
		List<BbsDto> list = bbsDao.selectAll();
		model.addAttribute("bbs_list2", list);
		return "bbs/register";
	}
	
}
