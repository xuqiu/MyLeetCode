package com.github.xuqiu.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-20 15:56
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        char[] haystackArr = haystack.toCharArray();
        final char[] needleArr = needle.toCharArray();
        for (int i = 0, charArrayLength = haystackArr.length; i < charArrayLength-needleArr.length+1; i++) {
            if (haystackArr[i] == needleArr[0]) {
                boolean bingo = true;
                for (int j = 1, needleArrLength = needleArr.length; j < needleArrLength; j++) {
                    if(needleArr[j] != haystackArr[i+j]){
                        bingo = false;
                        break;
                    }
                }
                if (bingo){
                    return i;
                }
            }
        }
        return -1;
    }
    @Test
    public void test(){
        System.out.println(strStr("123","234"));
    }

}
