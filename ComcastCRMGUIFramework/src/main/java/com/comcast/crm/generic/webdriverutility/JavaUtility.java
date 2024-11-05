package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{


public int getRandomNumber()
{
	
Random ranDom=new Random();
int ranDomNumber=ranDom.nextInt(5000);
return ranDomNumber;
}

public String getSystemDateyyyyMMdd()
{
	Date dateObj = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date=sdf.format(dateObj);
    return date;
}
public String getRequiredDateyyyyMMdd(int days)
{
	 Date dateObj=new Date();
	 SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
//	 String  startDate=sim.format(dateObj);
	// System.out.println(startDate);
	 
	//Calendar cal= sim.getCalendar();
	 Calendar cal= Calendar.getInstance();
	//cal.add(Calendar.DAY_OF_MONTH, -30);
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate=sim.format(cal.getTime());
	//System.out.println(endDate);
	
	return reqDate;

}


}
