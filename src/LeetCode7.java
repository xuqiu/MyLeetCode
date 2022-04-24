import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-24 11:04
 */
public class LeetCode7 {
    public int reverse(int x) {
        String reverseStr;
        final String s = String.valueOf(x);

        if (s.startsWith("-")) {
            reverseStr = "-" +new StringBuffer(s.substring(1)).reverse();
        }else{
            reverseStr = new StringBuffer(s).reverse().toString();
        }
        try {
            return Integer.parseInt(reverseStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    @Test
    public void test(){
        System.out.println(reverse(10010));
    }
}
