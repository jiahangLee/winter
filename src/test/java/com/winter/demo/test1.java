package com.winter.demo;

import com.winter.demo.service.PrivilegeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {

    @Autowired
    private PrivilegeService privilegeService;

    @Test
    public void Test01(){
        privilegeService.findAllPrivilege(1,10);
// 断言的使用
    }
}
