package org.preetika.interviewParker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by preetika.shukla on 19/08/15.
 */
public class ParanthesisChecker {
    public static int contains (char[] array , char cur){
        int returnIndex = -1;
        for (int i = 0 ; i < array.length ; i ++){
            if (array[i] == cur)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.nextLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        char openingBraces[] = {'[','{','('};
        char closingBraces[] = {']','}',')'};
        int i = 0;
        for (; i < array.length; i++) {
            char current = array[i];
            if (contains(openingBraces , current) !=-1)
                stack.push(current);
            else if (contains(closingBraces, current) !=-1){
                int index = contains( closingBraces , current) ;
                if (!stack.isEmpty() && stack.peek() == openingBraces[index])
                    stack.pop();
                else {
                    System.err.println("InValid String");
                    stack.push (current);
                    break;
                }
            }
        }

        if (stack.isEmpty() && i == array.length)
            System.out.println ("Perfectly Valid String");
    }
}
