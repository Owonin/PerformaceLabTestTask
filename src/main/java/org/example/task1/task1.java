package org.example.task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int currentIndex = 0;

        StringBuilder stringBuilder = new StringBuilder("1");

        do {
            currentIndex += m-1;
            currentIndex = currentIndex<n ? currentIndex : currentIndex%n;

            stringBuilder.append(currentIndex+1);
        } while(currentIndex!=0);

        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        System.out.println(stringBuilder);
    }
}
