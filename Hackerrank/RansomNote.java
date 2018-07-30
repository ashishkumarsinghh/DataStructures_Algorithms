import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> mag = new HashMap<String, Integer>();
        HashMap<String, Integer> notes = new HashMap<String, Integer>();

        for(int i = 0; i<magazine.length; i++){
            if(mag.containsKey(magazine[i])){
                mag.put(magazine[i], mag.get(magazine[i])+1);
            }
            else{
                mag.put(magazine[i], 1);
            }
        }
        for(int i = 0; i<note.length; i++){
            if(notes.containsKey(note[i])){
                notes.put(note[i], notes.get(note[i])+1);
            }
            else{
                notes.put(note[i], 1);
            }
        }
        for(int i = 0; i < note.length; i++){
            if(!mag.containsKey(note[i]) || mag.get(note[i]) < notes.get(note[i])){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
