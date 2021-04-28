package Lab04;

public class DateUtils {
	public static int compare(MyDate x,MyDate y){ //1 : x > y ; -1 : x < y ; 0 : x = y
        if(x.getYear() > y.getYear())
            return 1;
        else if (x.getYear() < y.getYear())
            return -1;
        else{
            if(x.getMonth() > y.getMonth())
                return 1;
            else if(x.getMonth() < y.getMonth())
                return -1;
            else {
                if(x.getDay() > y.getDay())
                    return 1;
                else if(x.getDay() < y.getDay())
                    return -1;
                else
                    return 0;
            }
        }
    }
    public static void sortDate(MyDate[] arr){
        MyDate temp;
        if(arr.length > 0) {
            for (int i = 0 ; i < arr.length ; i++) {
                for (int j = i+1 ; j < arr.length ; j++) {
                    if(compare(arr[i],arr[j])>0){
                    	temp = new MyDate(arr[i].getDay(),arr[i].getMonth(),arr[i].getYear());
                        arr[i] = new MyDate(arr[j].getDay(),arr[j].getMonth(),arr[j].getYear());
                        arr[j] = new MyDate(temp.getDay(),temp.getMonth(),temp.getYear());
                    }
                }
            }
        }
    }
}
