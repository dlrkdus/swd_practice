package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HelloService {
    private HashMap<String, Performer> performerHashMap=new HashMap<String, Performer>();

    @Autowired
    public HelloService(HashMap<String, Performer> performerHashMap){
        this.performerHashMap=performerHashMap;
    } //생성자에 Autowired 붙여서 id와 Performer Map 자동 주입할거다

}
