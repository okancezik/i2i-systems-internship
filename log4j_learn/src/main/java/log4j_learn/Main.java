package log4j_learn;

import java.time.LocalDateTime;

import log4j_learn.concretes.MyTimerLogging;

public class Main {

	public static void main(String[] args) {

		LocalDateTime previousTime = LocalDateTime.now();
		MyTimerLogging myLogger = new MyTimerLogging();

		for (int i = 0; i < 36000; i++) {
			LocalDateTime currentTime = LocalDateTime.now();

			myLogger.debug("DEBUG MESSAGE");

			if (currentTime.getMinute() != previousTime.getMinute() && currentTime.getMinute() != 0) {
				myLogger.info("INFO MESSAGE");
			}

			if (currentTime.getHour() != previousTime.getHour()) {
				myLogger.error("ERROR MESSAGE");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			previousTime = currentTime;

		}

	}

}
