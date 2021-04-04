package com.vast.common.util;

/**
 * 隐私util
 */
public class ConcealUtils {

    /**
     * 隐私替换
     * @param str   str
     * @return
     */
    public static String conceal(String str){
        if (str == null || str.length() <= 1){
            return str;
        }else if (str.length() == 2){
            return str.substring(1).concat("*");
        }else if (str.length() <= 5){
            String star = "";
            for (int i = 0; i < str.length() - 2; i++) {
                star = star.concat("*");
            }
            return str.substring(0,1).concat(star).concat(str.substring(str.length() -1));
        }else if (str.length() <= 8){
            //前2后1
            String star = "";
            for (int i = 0; i < str.length() - 3; i++) {
                star = star.concat("*");
            }
            return str.substring(0,2).concat(star).concat(str.substring(str.length() -1));
        }else if (str.length() <= 10){
            //前三后2
            String star = "";
            for (int i = 0; i < str.length() - 5; i++) {
                star = star.concat("*");
            }
            return str.substring(0,3).concat(star).concat(str.substring(str.length() -2));
        }else{
            //前三后四
            String star = "";
            for (int i = 0; i < str.length() - 7; i++) {
                star = star.concat("*");
            }
            return str.substring(0,3).concat(star).concat(str.substring(str.length() -4));
        }
    }
}
