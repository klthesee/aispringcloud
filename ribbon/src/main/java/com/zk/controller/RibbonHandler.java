package com.zk.controller;

import com.zk.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://provider/student/findAll",Collection.class);  //直接通过服务者的应用名去访问
    }

    @RequestMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://provider/student/index",String.class);
    }

}
