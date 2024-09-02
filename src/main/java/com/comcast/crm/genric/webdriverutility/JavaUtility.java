package com.comcast.crm.genric.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
  
	public int getRandomNumber(){
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateObj =new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
		String date = sdf.format(dateObj);
		return date;
	}
	public String getRequriedDateYYYYDDMM(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM--dd");
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
