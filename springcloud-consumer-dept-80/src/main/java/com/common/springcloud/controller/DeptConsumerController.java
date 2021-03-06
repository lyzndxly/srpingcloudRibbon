package com.common.springcloud.controller;

import com.common.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者 没有servicec层
    //RestTemplate ...方法供我们调用就可以了！ 注册sring中
    //(url, 实体: Map, Class<T> ResponseType)
    @Autowired
    private RestTemplate restTemplate;

    //Ribbon 我们这里的地址，应该是一个变量，通过服务名来访问
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    //对应配置文件中的name
//    #spring配置
//    spring:
//    application:
//    name: SPRINGCLOUD-PROVIDER-DEPT
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX +"/dept/add", dept, boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);

    }

}
