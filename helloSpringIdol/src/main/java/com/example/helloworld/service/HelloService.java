package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;

@Service
public class HelloService {

    private HashMap<String, Performer> performerHashMap=new HashMap<String, Performer>(); //HaspMap 객체 생성

    @Autowired
    public HelloService(HashMap<String, Performer> performerHashMap){
        this.performerHashMap=performerHashMap;
    } //생성자에 Autowired 붙여서 id와 Performer Map 자동 주입할거다

    public String getGreeting() {		// business method
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 10) {
            return "Good morning! ";
        } else if (hour >= 12 && hour <= 15) {
            return "Did you have lunch? ";
        } else if (hour >= 18 && hour <= 24) {
            return "Good evening! ";
        }
        return "Hello! ";
    }

}
