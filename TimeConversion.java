import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
       static String timeConversion(String s) {
       if(s.substring(8).equals("PM")) {
    	   int hh = Integer.parseInt(s.substring(0,2));
           if(hh!=12){
               hh +=12;
           }
    	   String hhs;
    	   if(hh==24) {
    		   
    		   hhs = "00";
    	   }
    	   else {
    		   hhs = ""+hh;
    	   }
    	   return ""+hhs+s.substring(2,8);
       }
       else {
               	   int hh = Integer.parseInt(s.substring(0,2));
if(hh==12){
    return "00"+s.substring(2,8);
}
           else{
                          return s.substring(0,8);

           }
       }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
