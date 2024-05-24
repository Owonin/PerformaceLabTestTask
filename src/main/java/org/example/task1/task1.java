package org.example.task1;

public class task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);


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
