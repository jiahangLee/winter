package com.winter.demo.service;

import com.winter.demo.controller.GirlRepository;
import com.winter.demo.entity.Girl;
import com.winter.demo.util.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {

        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age < 10) {
            throw new GirlException(100,"你还在上小学");
        }else if (age > 10 && age < 16) {
            throw new GirlException(101,"你还在上初中");
        }
    }
}
