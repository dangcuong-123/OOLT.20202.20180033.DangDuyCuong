import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
	private int day, month, year;
	
	public MyDate() {
		Calendar today = Calendar.getInstance();
		this.day = today.get(Calendar.DATE);
		this.month = today.get(Calendar.MONTH) + 1;
		this.year = today.get(Calendar.YEAR);
	}
	
	public MyDate(int day, int month, int year) {
		if (CheckDate(day,month,year) == 1) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else {
			System.out.println("nhập không đúng");
		}
	}
	public void ConvertString(String date) {
		int day = 0, month = 0, year = 0, checkday = 0, checkmonth = 0;
		String[] dateString = date.split(" ");
		if(dateString.length < 3) {
			System.out.println("nhập không đúng");
		}
		else {
			String arraymonth [][] = {{"January","Jan.","Jan","1"},
					{"February","Feb.","Feb","2"},
					{"March","Mar.","Mar","3"},
					{"April","Apr.","Apr","4"},
					{"May","May","5"},
					{"June","Jun","6"},
					{"July","Jul","7"},
					{"August","Aug.","Aug","8"},
					{"September","Sept.","Sept","9"},
					{"October","Oct.","Oct","10"},
					{"November","Nov.","Nov","11"},
					{"December","Dec.","Dec","12"}};
			
			for (int i=0;i<12;i++) {
				for (int j=0;j<arraymonth[i].length;j++) {
					if (arraymonth[i][j].equals(dateString[0])) {
						month = i + 1;
						checkmonth = 1;
						break;
					}
				}
				if(checkmonth == 1) 
					break;
			}
			if(checkmonth == 0) {
				System.out.println("nhập không đúng");
				return;
			}
			
			String arrayday [][] = {{"1","1st"},{"2","2nd"},{"3","3rd"},{"4","4th"},{"5","5th"},
					{"6","6th"},{"7","7th"},{"8","8th"},{"9","9th"},{"10","10th"},{"11","11th"},{"12","12th"},
					{"13","13th"},{"14","14th"},{"15","15th"},{"16","16th"},{"17","17th"},{"18","18th"},{"19","19th"},{"20","20th"},
					{"21","21th"},{"22","22th"},{"23","23th"},{"24","24th"},{"25","25th"},{"26","26th"},{"27","27th"},{"28","28th"},
					{"29","29th"},{"30","30th"},{"31","31th"}};
			for (int i=0;i<31;i++) {
				for (int j=0;j<arrayday[i].length;j++) {
					if (arrayday[i][j].equals(dateString[1])) {
						day = i + 1;
						checkday = 1;
						break;
					}
				}
				if(checkday == 1) 
					break;
			}
			if(checkday == 0) {
				System.out.println("nhập không đúng");
				return;
			}
			year = Integer.parseInt(dateString[2]);
			if(CheckDate(day, month, year) == 1) {
				this.day = day;
				this.month = month;
				this.year = year;
			}
			else 
				System.out.println("nhập không đúng");
		}
	}
	public MyDate(String date) { // dinh dang mm/dd/yy eg. "February 18th 2019"
		ConvertString(date);
	}
	
	public int CheckDate(int day, int month, int year) {
		if(year < 0 || month < 1 || day < 1 || day > 31 || month > 12) {
			return 0;
		}
		int checkyear = 0;
		int commonyear[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int leapyear[] = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		if (year % 100 == 0) {
	        if (year % 400 == 0) {
	        	checkyear = 1;
	        }
	    }
	    else if (year % 4 == 0) {
	    	checkyear = 1;
	    }
		if (checkyear == 1 && day > leapyear[month - 1]) {
			return 0;
		}
		if (checkyear == 0 &&  day > commonyear[month - 1]) {
			return 0;
		}
		return 1;
	}
	
	public void accept() {
		System.out.println("nhập ngay thang theo dinh dang mm dd yy (eg: February 18th 2019): ");
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
		ConvertString(date);
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(1 <= day && day <= 31) {
			this.day = day;
		}
		else System.out.println("nhập không đúng");
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(1 <= month && month <= 12) {
			this.month = month;
		}
		else System.out.println("nhập không đúng");
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >= 0) {
			this.year = year;
		}
		else System.out.println("nhập không đúng");
	}
	public void print(){
        System.out.println( "The Date \n" + "day: " + day + ", month: " + month + ", year: " + year);
    }
	
}
