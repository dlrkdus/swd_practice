package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HelloService {
    @Autowired
    private Map<String, Performer> performers=new HashMap<String, Performer>(); //Map 객체 생성, HashMap 타입으로 선언하니 타입 불일치로 자동주입이 안됐다.

//    @Autowired
//    public HelloService(List<Performer> list){
//      for (Performer performer : list) {
//			performers.put(performer.getBeanName(), performer);
//		}
//    } //생성자에 Autowired 붙여서 id와 Performer Map 자동 주입할거다

    public String makePerformance(String id){
        return performers.get(id).perform();
    }

    public String getGreeting(String requester) {		// business method
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 10) {
            return "Good morning, "+requester+"!";
        } else if (hour >= 12 && hour <= 15) {
            return "Did you have lunch, "+requester+"?";
        } else if (hour >= 18 && hour <= 24) {
            return "Good evening, "+requester+"!";
        }
        return "Hello, "+requester+"!";
    }

}
