import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        IsWeird(N);
        scanner.close();
    }

    public static void IsWeird(int N) {
        if(N % 2 != 0){
            System.out.print("Weird");
        }
        else if (N % 2 == 0 && N >= 2 && N <= 5){
            System.out.print("Not Weird");
        }
        else if (N % 2 == 0 && N >= 6 && N <= 20){
            System.out.print("Weird");
        }
        else if (N % 2 == 0 && N > 20){
            System.out.print("Not Weird");
        }
    }
}
