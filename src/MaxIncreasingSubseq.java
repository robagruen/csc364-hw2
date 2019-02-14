//Rob Gruen
//CSC 364
//HW2 - Max Inscreasing Subsequences

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

        System.out.print("The maximum increasing subsequence is ");
        increasingSubsequence(charArray);
        System.out.println();
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

        for (int printCharsIndex = (newMax - 1); printCharsIndex > -1; printCharsIndex--) {
            for (int scoreIndex = 0; scoreIndex < a.length; scoreIndex++) {
                if (max == score[scoreIndex]) {
                    max--;
                    printChars[printCharsIndex] = a[scoreIndex];
                    break;
                }
            }
        }

        int j = 0;
        for (int i = 0; i < newMax; i++) {
            System.out.print(printChars[j]);
            j++;
        }

    }

}