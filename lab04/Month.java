package Lab04;

public class Month {
	public int inputMonth(String month) {
        switch(month) {
        case "January": case "Jan.": case "Jan": case "1":   return 1;
        case "February": case "Feb.": case "Feb": case "2":  return 2;
        case "March": case "Mar.": case "Mar": case "3":     return 3;
        case "April": case "Apr.": case "Apr": case "4":     return 4;
        case "May": case "May.": case "5":                   return 5;
        case "June": case "Jun.": case "Jun": case "6":      return 6;
        case "July": case "Jul.": case "Jul": case "7":      return 7;
        case "August": case "Aug.": case "Aug": case "8":    return 8;
        case "September": case "Sep.": case "Sep": case "9": return 9;
        case "October": case "Oct.": case "Oct": case "10":  return 10;
        case "November": case "Nov.": case "Nov": case "11": return 11;
        case "December": case "Dec.": case "Dec": case "12": return 12;
        default:
            throw new ArithmeticException("Invalid month");
        }
    }
}
