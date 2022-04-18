package com.movsisyan.program;

import com.movsisyan.model.StringManipulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        String s = "racecar";
        String f = "-125oyhgf12p8";
        String f1 = "-55+412-3788";
        String d = "can World can be better can palych can";
        System.out.println(Arrays.toString(StringManipulation.parseIntegers(f)));
        System.out.println(StringManipulation.hasLetter(s));
        System.out.println(StringManipulation.isLetter(s));
        System.out.println(StringManipulation.hasDigit(s));
        System.out.println(StringManipulation.hasUpperCase(s));
        System.out.println(StringManipulation.hasLowerCase(s));
        System.out.println(StringManipulation.erase(s, 9, 15));
        System.out.println(StringManipulation.eraseSB(s, 15, 19));
        System.out.println(StringManipulation.insertC(s, 3, f));
        System.out.println(StringManipulation.getStringDigit(f));
        System.out.println(StringManipulation.getStringDigit(f));
        System.out.println(StringManipulation.parseInt(f));
        System.out.println(Arrays.toString(StringManipulation.parseIntegers("-5+3-4")));
        System.out.println(StringManipulation.isPolindrom(s));
        System.out.println(StringManipulation.evaluate("-5+4-3"));
        System.out.println(StringManipulation.getLongestWord(d));
        System.out.println(StringManipulation.capitalization(d));
        System.out.println(StringManipulation.getSubstringIndexes(d, "can"));
        System.out.println(StringManipulation.randomString(false, true, 4));
        System.out.println(StringManipulation.pickUpPinCode(StringManipulation.randomString(false, true, 4)));
        System.out.println(Arrays.toString(StringManipulation.parseIntegers(f)));
        try(BufferedReader bf = new BufferedReader(new FileReader("file.txt"))) {
            while(bf.ready()) {
                String s1 = bf.readLine();
                System.out.println(StringManipulation.pickUpPassword(s1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
