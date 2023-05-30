package com.multicampus.mvc0428;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.dao.MyBbsDao;
import com.multicampus.dto.BbsDto;

@Controller
public class BbsController {
	
	//MyBatis DB에 연결
	@Autowired
	private MyBbsDao bbsDao;
	
	@RequestMapping("/bbs/list")
	public String bbs_list(Model model) {
		List<BbsDto> list = bbsDao.selectAll();
		model.addAttribute("bbs_list", list);
		return "bbs/list";
	}
	
}
