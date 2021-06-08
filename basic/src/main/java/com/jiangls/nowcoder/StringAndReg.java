package com.jiangls.nowcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *   相对开音节构成的结构为辅音+元音（aeiou）+辅音(r除外)+e，常见的单词有bike、cake等。
 *   给定一个字符串，以空格为分隔符，反转每个单词中的字母，若单词中包含如数字等其他非字母时不进行反转。
 *   反转后计算其中含有相对开音节结构的子串个数（连续的子串中部分字符可以重复）。
 *
 *   输入：ekam a ekac 输出：2
 *   输入：!ekam a ekekac 输出：2 说明：反转后为!ekam a cakeke 因!ekam含非英文字符所以未反转，其中 cake、keke为相对开音节子串，返回2
 *
 *   主要考查的时对正则表达式的运用，以及对类Pattern、Matcher中方法的熟悉程度
 *
 *
 */
public class StringAndReg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] StrArray = input.split(" ");
        AtomicInteger count = new AtomicInteger();

        final Pattern nonAlphabetPattern = Pattern.compile("[^a-zA-Z]");
        final Pattern openSyllablePattern = Pattern.compile("[^aeiou][aeiou][^aeiour][e]");

        Arrays.stream(StrArray).forEach(str -> {
            // 纯字母字符串反转
            if (!nonAlphabetPattern.matcher(str).find()) {
                StringBuffer stringBuffer = new StringBuffer(str);
                String inputReversed = stringBuffer.reverse().toString();

                // 字符串长度大于4，从0开始递增4个字符串匹配正则表达式
                if (inputReversed.length() >= 4) {
                    for(int i = 0; i < inputReversed.length() - 4 + 1; i++) {
                        String subStr = inputReversed.substring(i, i+4);
                        Matcher matcher = openSyllablePattern.matcher(subStr);
                        if (matcher.matches()) {
                            count.getAndIncrement();
                        }

                    }
                }
            }
        });

        System.out.println(count);

    }

}
