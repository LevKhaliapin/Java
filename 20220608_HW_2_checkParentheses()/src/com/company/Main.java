package com.company;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    /*
    HW 20220608
    Second level: Дана строка содержащая разного вида скобки.
    Написать метод, который проверяет, насколько правильно расставлены скобки в строке.
     */

    public static void main(String[] args) {
        String str = "(sfgr(fsdf)gf[fdgf])";
        String str2 = "sfgr(fsdf)gf[fdgf])";
        String str3 = "(sfgr(fsdf)gf[fdgf]]";
        String str4 = "(sfgr{fsdf})gf[fdgf])";
        String str5 = "(((){[]{}}))";
        String str6 = "((()";
        String str7 = ")(";
        String str8 = "()(){}{}[][]";


        System.out.println(checkParentheses(str));
        System.out.println(checkParentheses(str2));
        System.out.println(checkParentheses(str3));
        System.out.println(checkParentheses(str4));
        System.out.println(checkParentheses(str5));
        System.out.println(checkParentheses(str6));
        System.out.println(checkParentheses(str7));
        System.out.println(checkParentheses(str8));

    }

    public static boolean checkParentheses(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                deque.addLast(')');
            }
            if (str.charAt(i) == '[') {
                deque.addLast(']');
            }
            if (str.charAt(i) == '{') {
                deque.addLast('}');
            }
            if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                if (deque.size() == 0 || deque.getLast() != str.charAt(i)) {
                    return false;
                }
                if (deque.getLast() == str.charAt(i)) {
                    deque.removeLast();
                }
            }
        }
        return deque.size() == 0;
    }
}
