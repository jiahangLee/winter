package com.winter.demo.controller;

import com.winter.demo.entity.Girl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping(value = "") // requestMapping 可以用在这也可以用在方法前面代替GetMapping
public class First {

    @RequestMapping(value = "hello/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable(value = "id") Integer id){
        System.out.println("Hello World");
        return "Hello World"+id;
    }

    @GetMapping(value = "hello1")
    public String hello1(@RequestParam(value = "id",defaultValue = "23",required = true) Integer id){
        return "Hello1:"+id;
    }

    @PostMapping(value = "hello2")
    public String hello2(@RequestBody Girl girl){
        System.out.println(girl.toString());
        return girl.toString();
    }
}
