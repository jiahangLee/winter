package com.winter.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test2 {

    private Logger logger = LoggerFactory.getLogger(Test2.class);

    @Test
    public void test01(){
        log.debug("debug...");
        logger.info("info...{},other:{}",123,456);
        logger.error("error...");

    }
}
