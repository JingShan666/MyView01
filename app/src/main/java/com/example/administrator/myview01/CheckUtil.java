package com.example.administrator.myview01;

import java.util.Random;

/**
 * Created by Liu on 2017/8/21 0021.
 * 功能：验证码相关工具类
 */

public class CheckUtil {
    private static StringBuilder mBuilder = new StringBuilder();
    private static final int DEFAULT_CODE_LENGTH = 4;//验证码的长度  这里是4位
    private static Random mRandom = new Random();

    private static final char[] CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    /**
     * 功能：通过这个方法可以获得一个长度为4的，元素为0-9的int类型的数组
     */
    public static int[] getCheckNum(){

        //创建一个int数组,用于保存随机产生的4位数字
        int []num= new int[4];

        for (int i=0;i<4;i++){
            //Math.random():获取0~1随机数
            num[i]= (int) (Math.random()*10);
        }
        return num;
    }

    /**
     * 随机产生划线的起始点坐标和结束点坐标
     * @param height 传入CheckView的高度值
     * @param width 传入CheckView的宽度值
     * @return 起始点坐标和结束点坐标
     */

    /**
     *  计算验证码的绘制y点位置
     * @param height 传入CheckView的高度值
     * @return
     */
    public static int getPositon(int height){
        int tempPositoin = (int) (Math.random() * height);
        if(tempPositoin < 20){
            tempPositoin += 20;
        }
        return tempPositoin;
    }

    //生成验证码
    public static String createCode() {
        mBuilder.delete(0, mBuilder.length()); //使用之前首先清空内容

        for (int i = 0; i < DEFAULT_CODE_LENGTH; i++) {
            mBuilder.append(CHARS[mRandom.nextInt(CHARS.length)]);
        }

        return mBuilder.toString();
    }

    /**
     * 随机产生点的圆心点坐标
     * @param height 传入CheckView的高度值
     * @param width 传入CheckView的宽度值
     * @return
     */
    public static int[] getPoint(int height, int width){
        int [] tempCheckNum = {0,0,0,0};
        tempCheckNum[0] = (int) (Math.random() * width);
        tempCheckNum[1] = (int) (Math.random() * height);
        return tempCheckNum;
    }


}
