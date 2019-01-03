package com.winter.demo.controller;

import com.winter.demo.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "girls")
    public Girl girlAdd(Girl girl) {
        return girlRepository.save(girl);
    }

    @GetMapping(value = "girls/{id}")
    public Optional<Girl> girlOne(@PathVariable(value = "id") Integer id){
        return girlRepository.findById(id);
    }

    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable(value = "id") Integer id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable(value = "id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlByAge(@PathVariable(value = "age") Integer age) {
        return girlRepository.findByAge(age);
    }
}
