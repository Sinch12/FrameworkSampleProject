package practice.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	public static void main(String[] args) {
java.util.Date dateobj = new java.util.Date();  
System.out.println(dateobj.toString());
SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
String actdate = s.format(dateobj);
System.out.println(actdate);

//SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
Calendar cal = s.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,-30);
String reqdate = s .format(cal.getTime());
System.out.println(reqdate);


	}

}
