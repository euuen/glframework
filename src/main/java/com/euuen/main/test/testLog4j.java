package com.euuen.main.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testLog4j {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(testLog4j.class);
        logger.info("hello");
        logger.debug("fuzzy");
    }
}
