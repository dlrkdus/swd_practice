package com.example.helloworld.web;

import java.util.Calendar;

import com.example.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springidol.SpringIdol;

@Controller
public class HelloController {
	
	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hello.do")		// request handler method
	public ModelAndView helloAndPerform1(@RequestParam(value="name", required=false) String name) {
		String greeting = helloService.getGreeting();
		if (name != null) greeting = greeting + name;
		String performance=helloService.makePerformance(name);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance",performance);
		return mav;
	}


}
