package com.zk.controller;

import com.zk.entity.Student;
import com.zk.repository.StudentReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    StudentReposity studentReposity;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentReposity.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable long id){
        return studentReposity.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentReposity.saveOrUpdate(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentReposity.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentReposity.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前端口" + this.port;
    }
}
