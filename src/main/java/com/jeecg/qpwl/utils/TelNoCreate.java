package com.jeecg.qpwl.utils;

/**
 * 生成随机电话号码
 * @author liuya
 *
 */
public class TelNoCreate {
    /**
     * 返回手机号码 
     */
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        String tel = first+second+third;
        tel = tel.substring(0,3)+"****"+tel.substring(7);
        return tel;
    }
    
    private static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
}
