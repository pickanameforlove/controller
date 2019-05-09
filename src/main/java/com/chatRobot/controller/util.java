package com.chatRobot.controller;
public class util {
    public static boolean isBetween(String low,String high,String s){
        int l = convert(low);
        int h = convert(high);
        int res = convert(s);
        if(res>=l&&res<=h){
            return true;
        }else {
            return false;
        }
    }
    public static int convert(String s){
        int a = s.length();
        int res = 0;
        for(int i=a-1;i>=0;i--){
            int m = s.charAt(i) - '0';
            res += Math.pow(10,a-1-i)*m;
        }
        return res;
    }
}
