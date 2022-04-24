import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-21 22:12
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        final Map<Integer,Integer> currentMap = new HashMap<>();
        final Map<Integer,Integer> maxMap = new HashMap<>();
        final char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(currentMap.containsKey((int)c)){
                int oldVal = currentMap.get((int)c);
                final Set<Map.Entry<Integer, Integer>> entrySet = currentMap.entrySet();
                entrySet.removeIf(entry -> entry.getValue() > oldVal);
            }
            currentMap.put((int)c,0);
            currentMap.replaceAll((k, v) -> v + 1);
            for (Integer key : currentMap.keySet()) {
                maxMap.put(key,Math.max(currentMap.get(key),maxMap.get(key)==null?0:maxMap.get(key)));
            }

        }
        return maxMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }
    public int lengthOfLongestSubstring2(String s) {
        BitSet bitSet = new BitSet(128);
        int maxLength=0;
        int start=0,end=0;

        final char[] charArray = s.toCharArray();
        while(end<charArray.length){
            final int c = charArray[end];
            if(bitSet.get(c)){
                int i;
                for (i = start; charArray[i] != c; i++) {
                    bitSet.clear(charArray[i]);
                }
                start=i+1;
            }
            bitSet.set(c);
            end++;
            maxLength = Math.max(maxLength, end-start);
        }
        return maxLength;
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring2("tmmzuxt"));
//        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

}
