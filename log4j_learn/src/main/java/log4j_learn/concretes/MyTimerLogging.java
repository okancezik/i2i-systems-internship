package log4j_learn.concretes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import log4j_learn.abstracts.MyLogger;

public class MyTimerLogging implements MyLogger {

	final Logger logger;

	public MyTimerLogging() {
		logger = LogManager.getLogger();
	}

	@Override
	public void debug(String message) {
		logger.debug(message);
	}

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void error(String message) {
		logger.error(message);
	}

}
