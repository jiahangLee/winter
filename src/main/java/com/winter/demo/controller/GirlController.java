package com.winter.demo.controller;

import com.winter.demo.entity.Girl;
import com.winter.demo.entity.Result;
import com.winter.demo.service.GirlService;
import com.winter.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "girls")
    public Result<Girl> girlAdd(@Valid  Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
//            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(girlRepository.save(girl));
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
        log.info("我是好人inner");
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        log.info("访问接口前");
        girlService.getAge(id);
        log.info("访问接口后");
    }
}
