import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-05 16:05
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        final long start = System.currentTimeMillis();
        Arrays.sort(nums);
        int result=0;
        int minSub = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            if(i>0 && n1 == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length-1; j++) {
                int n2 = nums[j];
                if(j-1>i && n2 == nums[j-1]){
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    int n3 = nums[k];
                    if (k - 1 > j && n3 == nums[k - 1]) {
                        continue;
                    }
                    final int sum = n1 + n2 + n3;
                    int thisSub = Math.abs(sum - target);
                    if(thisSub < minSub){
                        minSub = thisSub;
                        result = sum;
                    }else if(sum> target){
                        break;
                    }
                }
            }
        }
        return result;
    }
    @Test
    public void test(){

        final int result = threeSumClosest(new int[] {0,5,-1,-2,4,-1,0,-3,4,-5},1);

        System.out.println(result);
    }
}
