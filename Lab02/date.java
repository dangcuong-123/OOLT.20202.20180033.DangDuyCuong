package date;
import java.util.Scanner;

public class date {
	public static int checkmonth(String stringmonth) {
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
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<arraymonth[i].length;j++) {
				if(arraymonth[i][j].equals(stringmonth)) {
					return i+1;
				}
			}
		}
		return 0;
	}
	
	
	public static int checkyear(int year) {
		if (year % 100 == 0){
	        if (year % 400 == 0){
	        	return 1;
	        }
	        else{
	        	return 0;
	        }
	    }
	    else if (year % 4 == 0) {
	    	return 1;
	    }
	    else{
	    	return 0;
	    }
	}
	
	public static void main(String[] args) {
		int commonyear[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int leapyear[] = {31,29,31,30,31,30,31,31,30,31,30,31};

		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap thang: ");
		String stringmonth = scanner.nextLine();
		int month = checkmonth(stringmonth);
		
		int year,ok;
		System.out.print("Nhap nam: ");
		year = scanner.nextInt();
		ok = checkyear(year);
		if(ok == 1) {
			System.out.print("So ngay trong thang " + month);
			System.out.print(" nam " + year + " la: " + leapyear[month-1]);
		}
		else {
			System.out.print("So ngay trong thang " + month + " nam " + year + " la: " + commonyear[month-1]);
		}
	}
}
