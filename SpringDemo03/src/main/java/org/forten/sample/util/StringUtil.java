package org.forten.sample.util;

import java.util.Random;

/**
 * Created by Administrator on 2016/7/26.
 */
public class StringUtil {
    public static final Random random = new Random();
    public static final String letterAndNumber = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String getRandomLetterAndNumberStr(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("生成的随机字符串长度必须大于1");
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letterAndNumber.length());
            String temp = letterAndNumber.substring(index, index + 1);
            sb.append(temp);
        }
        return sb.toString();
    }
}
