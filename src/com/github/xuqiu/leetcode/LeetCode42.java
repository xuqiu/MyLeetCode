package com.github.xuqiu.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Trapping Rain Water
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-16 15:45
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int result = 0;
        int[] toFillMap = new int[100001];
        int highest = 0;
        int lastH = 0;
        for (int i = 0, heightLength = height.length; i < heightLength; i++) {
            int h = height[i];
            if (h < highest) {
                //collect pit water fast
                if (0<i && i< heightLength-1 && h < height[i-1] && h<height[i+1]){
                    int pitTop = Math.min(height[i-1],height[i+1]);
                    result += pitTop - h;
                    h = pitTop;
                }

                for (int deep = h + 1; deep <= highest; deep++) {
                    toFillMap[deep]++;
                }
            } else {
                highest = h;
            } if (h > lastH) {
                for (int deep = lastH + 1; deep <= h; deep++) {
                    final int toFill = toFillMap[deep];
                    if (toFill == 0) {
                        break;
                    }
                    result += toFill;
                    toFillMap[deep] = 0;
                }
            }
            lastH = h;

        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }


}
