package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AplicationUtils {

    // 2002-03-03 18:00:00

    public static String generatePrettyDateFromSQLDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy hh:mm");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+strDate);
        return strDate;
    }

    public static Date generateDateFromString(String stringDate) throws ParseException {
        Date date1=new SimpleDateFormat("dd MM yyyy hh:mm").parse(stringDate);
        return date1;
    }

}
