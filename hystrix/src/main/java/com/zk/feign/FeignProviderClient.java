package com.zk.feign;

import com.zk.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider") //要访问的微服务
public interface FeignProviderClient {
    @GetMapping("/student/findAll")//在provider中怎么访问就怎么写
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();
}
