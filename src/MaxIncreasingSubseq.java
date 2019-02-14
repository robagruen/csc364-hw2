import java.util.*;
import java.lang.StringBuilder;

public class MaxIncreasingSubseq {

    public static void main(String[] args) {
        // Create a scanner for the user to input a String and capture into userString variable
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String userString = input.nextLine();
        // Create an array of characters and and put each letter from the input word into the array
        char[] charArray = new char[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            charArray[i] = userString.charAt(i);
        }
        char[] arr = new char[8];
        arr[0] = 'k';
        arr[1] = 'e';
        arr[2] = 'n';
        arr[3] = 't';
        arr[4] = 'u';
        arr[5] = 'c';
        arr[6] = 'k';
        arr[7] = 'y';
        System.out.print("The maximum increasing subsequence is ");
        increasingSubsequence(arr);
    }


    static void increasingSubsequence(char a[]) {
        if (a.length == 1) {
            System.out.print(a[0]);
        }

        int[] score = new int[a.length];
        int[] prev = new int[a.length];
        int max = 0;
        int indexOfMax = 0;

        //score[i] = 1 + max{score[j]:  j < i && a[j] < a[i]}

        for (int i = 0; i < a.length; i++) {
            score[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && score[j] >= score[i]) {
                    score[i] = score[j] + 1;
                    prev[i] = j;
                    if (score[i] > max) {
                        max = score[i];
                        indexOfMax = i;
                    }
                }
            }
        }

        char[] printChars = new char[max];
        int newMax = max;
//        char newChar = a[indexOfMax];
//        int somethingI = 0;
//        printChars[somethingI++] = newChar;
//
//        for (int i = indexOfMax-1; i > 0; i--) {
//            int x = prev[i];
//            if (x > -1) {
//                printChars[somethingI++] = a[x];
//            }
//        }

        for (int i = 0; i < printChars.length; i++) {
            for (int j = 0; j < prev.length; j++) {
                if (prev[j] == ((max-1))) {
                    printChars[i] = a[j];
                    max--;
                }
            }
        }

        int j = 0;
        for (int i = 0; i < newMax; i++) {
            System.out.print(printChars[j]);
            j++;
        }
        // yutnk
        // kntuy

    }

}