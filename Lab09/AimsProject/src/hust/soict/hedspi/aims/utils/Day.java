package hust.soict.hedspi.aims.utils;

public class Day {
	public int inputDay(String inputDay) {
        if (inputDay == null || inputDay.equals("")) {
            throw new ArithmeticException("Invalid day string");
        }
        
        int day = 0;
        String[] tokens = inputDay.split("-"); 
        String extraPart = "";
        boolean isPartOfToken = false;
        int tailTokenLength = 0;
        
        if (tokens.length != 1 && tokens.length != 2) {
            throw new ArithmeticException("Invalid day string");
        } else if (tokens.length == 1) {
            tailTokenLength = tokens[0].length();
            if (tailTokenLength > 6) {
                if (tokens[0].substring(tailTokenLength - 6).equals("teenth")) {
                    isPartOfToken = true;
                    extraPart += tokens[0].substring(0, tailTokenLength - 6);
                    if (extraPart.equals("thir")) {
                        extraPart += "d"; 
                    } else if (extraPart.equals("nine")) {
                        extraPart = "ninth";
                    } else {
                        extraPart += "th"; 
                    }
                    tokens[0] = "tenth"; 
                }
            }
        } else if (tokens.length == 2) {
            isPartOfToken = true;
        }
        
        if (!extraPart.equals("")) {
            day += getIntFromDayToken(extraPart, isPartOfToken);
        }
        
        for (int i = 0; i < tokens.length; i++) {
            day += getIntFromDayToken(tokens[i], isPartOfToken);
        }
        
        return day;
    }
    
    private int getIntFromDayToken(String token, boolean isPartOfToken) {
        switch(token) {
        case "first":   return 1;
        case "second":  return 2;
        case "third":   return 3;
        case "fourth":  return 4;
        case "fifth":   return 5;
        case "sixth":   return 6;
        case "seventh": return 7;
        case "eighth":  return 8;
        case "ninth":   return 9;
        case "tenth":   return 10;
        case "eleventh":return 11;
        case "twelfth": return 12;
        case "twenty":
            if (!isPartOfToken) {
                break;
            }
        case "twentieth": return 20;
        case "thirty":
            if (!isPartOfToken) {
                break;
            }
        case "thirtieth": return 30;
        default:
            throw new ArithmeticException("Invalid day string");
        }
        
        throw new ArithmeticException("Invalid day string");
    }
}
