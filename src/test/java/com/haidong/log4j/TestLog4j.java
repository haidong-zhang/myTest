package com.haidong.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	private static Logger logger = Logger.getLogger(TestLog4j.class);
	@Test
	public void Test1 () {
		logger.error("----------------------");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
