package org.x1.utils;

import java.util.Arrays;

/**
 * 作者：泡泡大湿
 * 时间： 2017/9/21.
 * 描述：
 */
public class RandomUtils {
    /**
     * 随机生成不重复数组
     * @param min
     * @param max
     */
    public static void nextInt(int min,int max){
        if(min>max)
            return;
        int[] number = new int[max];
        for (int i = 0;i<number.length;i++)
            number[i] = i+1;
        int[] result = new int[min];
        for (int i = 0;i<result.length;i++){
            int r = (int) (Math.random()*(max-1));
            result[i] = number[r];
            number[r] = number[max-1];
            max--;
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        nextInt(4,5);
    }
}
