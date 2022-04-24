import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-22 17:29
 */
public class LeetCode5 {
    int start, end, max,maxStart,maxEnd;
    public String longestPalindrome(String s) {
        start =0;
        end=0;
        max = 1;
        maxStart=0;
        maxEnd=0;
        final char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            findOdd(i,charArray);
            findEven(i,charArray);
        }
        return max>1?s.substring(maxStart,maxEnd+1): !s.isEmpty() ?s.substring(0,1):"";
    }

    private void findOdd(int i, char[] charArray) {
        int sideLength=1;
        while(i-sideLength>=0
            && i+sideLength<=charArray.length-1
            && charArray[i-sideLength] == charArray[i+sideLength]){
            sideLength++;
        }
        final int palLength = (sideLength - 1) * 2 + 1;
        if (palLength>max){
            max=palLength;
            maxStart=i-sideLength+1;
            maxEnd=i+sideLength-1;
        }
    }
    private void findEven(int i, char[] charArray) {
        if(i>charArray.length-2 || charArray[i]!=charArray[i+1]){
            return;
        }
        int sideLength=1;
        while(i-sideLength>=0
            && i+sideLength+1<=charArray.length-1
            && charArray[i-sideLength] == charArray[i+sideLength+1]){
            sideLength++;
        }
        final int palLength = (sideLength - 1) * 2 + 2;
        if (palLength>max){
            max=palLength;
            maxStart=i-sideLength+1;
            maxEnd=i+sideLength-1+1;
        }
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("cc"));
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("babadddab"));
    }

}
