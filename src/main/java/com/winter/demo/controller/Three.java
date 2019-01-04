package com.winter.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Three {

    private static final Logger logger = LoggerFactory.getLogger(Three.class);
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}
