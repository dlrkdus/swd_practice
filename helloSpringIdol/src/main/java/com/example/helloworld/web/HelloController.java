package com.example.helloworld.web;

import com.example.helloworld.domain.PerformRequest;
import com.example.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/perform")		// request handler method
	public ModelAndView helloAndPerform1(@RequestParam(value="id", required=false) String name,
										@RequestParam(value="requester", required=false) String requester) {
		String greeting = helloService.getGreeting(requester);
		if (name != null) greeting = greeting + "I'm "+name;
		String performance=helloService.makePerformance(name);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance",performance);
		return mav;
	}

	@RequestMapping("/perform/{id}/requester/{requester}")		// request handler method
	public ModelAndView helloAndPerform2(@PathVariable(value="id") String name,
										@PathVariable(value="requester") String requester) {
		return helloAndPerform1(name,requester);
	}

	@RequestMapping("/performUsingComm")
	public ModelAndView helloAndPerformUsingComm(PerformRequest request){
		// PerformRequest 객체를 통해 id와 requester를 전송받음
		String id = request.getId();
		String requester = request.getRequester();

		String greeting = helloService.getGreeting(requester);
		if (id != null) greeting = greeting + "I'm "+id;
		String performance=helloService.makePerformance(id);

		ModelAndView mav=new ModelAndView("/perform");
		mav.addObject("greeting",greeting); //Model 은 addAttribute 라면
		mav.addObject("performance",performance); //ModelAndView 는 addObject

		return mav; // 이런식으로 ModelAndView 로도 구현 가능
	}

}
