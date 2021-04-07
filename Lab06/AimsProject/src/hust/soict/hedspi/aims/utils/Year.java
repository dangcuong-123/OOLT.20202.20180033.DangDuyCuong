package hust.soict.hedspi.aims.utils;

public class Year {
    public int inputYear(String inputYear) {
        if (inputYear == null || inputYear.equals("")) {
            throw new ArithmeticException("Invalid year string");
        }
        
        int yearPart1 = 0;
        int yearPart2 = 0;
        String[] tokens = inputYear.split(" ");
        int tokensLength = tokens.length;
        
        if (tokensLength < 1 || tokensLength > 3) {
            throw new ArithmeticException("Invalid year string");
        }
        
        yearPart1 = TokLv1(tokens[0]);
        if (tokensLength > 1) {
            yearPart1 *= 100;
            if (!tokens[1].equals("hundred")) {
                yearPart2 = TokLv1(tokens[1]);
            } else if (tokensLength == 3) {
                yearPart2 = TokLv1(tokens[2]);
                if (yearPart2 > 9) {
                    throw new ArithmeticException("Invalid year string");
                }
            }
        }
        
        int year = yearPart1 + yearPart2;
        return year;
    }
    
    private int TokLv1(String tokenLv1) {
        String tokenLv2 = tokenLv1;
        String extraPart = "";
        int tokenLength = 0;
        
        tokenLength = tokenLv1.length();
        if (tokenLength > 4) {
            if (tokenLv2.substring(tokenLength - 4).equals("teen")) {
                extraPart += tokenLv2.substring(0, tokenLength - 4);
                if (extraPart.equals("thir")) {
                    extraPart = "three";
                } else if (extraPart.equals("fif")) {
                    extraPart = "five";
                } else if (extraPart.equals("eigh")) {
                    extraPart += "t";
                }
                tokenLv2 = "ten"; 
                return TokLv2(tokenLv2, extraPart);
            }
        }
        if (tokenLv2.indexOf('-') != -1) {
            String[] tokensLv2 = tokenLv2.split("-");
            return TokLv2(tokensLv2[0], tokensLv2[1]);
        }
        return TokLv2(tokenLv2, "");
    }
    
    private int TokLv2(String tokenLv2, String extraPart) {
        String tokenLv3 = tokenLv2;
        
        int intYearToken = 0;
        intYearToken += TokLv3(tokenLv3);
        intYearToken += TokLv3(extraPart);
        
        return intYearToken;
    }
    
    private int TokLv3(String tokenLv3) {
        switch(tokenLv3) {
        case "":       return 0;
        case "one":    return 1;
        case "two":    return 2;
        case "three":  return 3;
        case "four":   return 4;
        case "five":   return 5;
        case "six":    return 6;
        case "seven":  return 7;
        case "eight":  return 8;
        case "nine":   return 9;
        case "ten":    return 10;
        case "eleven": return 11;
        case "twelve": return 12;
        case "twenty": return 20;
        case "thirty": return 30;
        case "forty":  return 40;
        case "fifty":  return 50;
        case "sixty":  return 60;
        case "seventy":return 70;
        case "eighty": return 80;
        case "ninety": return 90;
        default:
            throw new ArithmeticException("Invalid number string");
        }
    }
}
