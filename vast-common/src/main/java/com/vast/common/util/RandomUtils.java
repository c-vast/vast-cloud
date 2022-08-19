package com.vast.common.util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 随机数工具类
 */
public class RandomUtils {
    /**
     * 混合模式
     * 该模式生成字母+数字的组合
     */
    public static int ModeMixed = 0;
    /**
     * 数字模式
     */
    public static int ModeNumber = 1;
    /**
     * 字母模式
     */
    public static int ModeChar = 2;

    private static final Random random;

    static {
        random = new Random();
    }

    /**
     * 随机字符串
     *
     * @param model {@link RandomUtils#ModeChar,RandomUtils#ModeMixed,RandomUtils#ModeNumber}
     * @return
     */
    public static String randomString(int length, int model) {
        if (model == ModeMixed) {
            StringBuilder stringBuilder = new StringBuilder();
            //混合模式
            for (int i = 0; i < length; i++) {
                if (random.nextBoolean()) {
                    stringBuilder.append(randomChar());
                } else {
                    stringBuilder.append(random.nextInt(9));
                }
            }
            return stringBuilder.toString();
        } else if (model == ModeNumber) {
            //数字模式
            int max = (int) Math.pow(10, length) - 1;
            int r = random.nextInt(max);
            return String.format("%0".concat(String.valueOf(length)).concat("d"), r);
        } else if (model == ModeChar) {
            //字符模式
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                stringBuilder.append(randomChar());
            }
            return stringBuilder.toString();
        } else {
            throw new RuntimeException("未知随机数生成模式");
        }
    }

    private static char randomChar() {
        int num = random.nextInt(26);
        if (random.nextBoolean()) {
            //从大写字母中拿
            num += 65;
        } else {
            //从小写字母中拿
            num += 97;
        }

        return (char) num;
    }

    public static String getRandomStr(int len) {
        if (len<1||len>9){
            throw new RuntimeException("长度不正确 1-9");
        }
        Random random = new Random();
        String b=String.format("%0"+len+"d", 9).replace("0","9");
        int rd = random.nextInt(Integer.parseInt(b)) + 1;
        String rdStr = String.valueOf(rd);
        if (rdStr.length() < len) {
            String p=String.format("%0"+len+"d", 0);
            DecimalFormat df = new DecimalFormat(p);
            rdStr = df.format(rd);
        }
        return rdStr;
    }
}
