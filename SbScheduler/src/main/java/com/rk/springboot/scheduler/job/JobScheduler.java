package com.rk.springboot.scheduler.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

	// Execute the task every minute starting at 4:00 PM and ending at 4:59 PM,
	// every day
	@Scheduled(cron = "0 * 16 * * ?")
	public void cornJobScdlr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
	}

	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Fixed Delay scheduler:: " + strDate);
	}

}
