package com.winter.demo.controller;

import com.winter.demo.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Two {

    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping(value = "se")
    public String se(){
        return privilegeService.findAllPrivilege(1,10).toString();
    }

}
