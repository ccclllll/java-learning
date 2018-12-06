package com.chapter.string;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        String expression = "(-|\\+)?\\d+$";
        String rex = "^(\\w|\\W)+[@]\\w+[.]\\w{1,3}";
        String codeRex = "^\\d{17}(\\d|[a-zA-Z])";



        Pattern pattern = Pattern.compile("\\d+&[012]{2}");
        Pattern pattern1 = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL);

        Matcher matcher = pattern.matcher("123&12&12");

        String s = matcher.replaceFirst("0000");
        System.out.println(s);


        Matcher matcher1 = pattern1.matcher("/*!asdd!*/");
        while (matcher1.find()){
            System.out.println(matcher1.group());
        }


        Scanner scanner = new Scanner("123123asasd\n1232131asda\nasda");
        String pattern3 = "(\\d+)(\\w+)"; //圆括号为组
        while (scanner.hasNext(pattern3)){
            scanner.next(pattern3);
            MatchResult result = scanner.match();
            System.out.println(result.group(2));//这里的group正好与圆括号的组对应
        }
    }
}
