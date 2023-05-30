package multicampus.kb03.mvc0503;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
//	종류 3가지
//	@RequestMapping //기본제공
//	@GetMapping  //sp4
//	@PostMapping //sp4
	
//	@GetMapping("/greeting/{name}")
//	public String greeting(
//			@PathVariable String name,
//			Model model) {
//		ModelAndView mav = new ModelAndView();
//		model.addAttribute("msg", "이름: " +name);
//		
//		return "greeting";
//	}
	
	@GetMapping("/greeting/{name}")
	public ModelAndView greeting(
			@PathVariable String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "이름: " +name);
		mav.setViewName("greeting");
		
		return mav;
	}
	
}
