import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-24 10:11
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int lineNum = 0;
        int addOrSub = 1;
        String[] resultArr = new String[numRows];
        for (int i = 0; i < s.length(); i++) {
            if(resultArr[lineNum]==null) {
                resultArr[lineNum] = "";
            }
            resultArr[lineNum] += s.charAt(i);
            lineNum = lineNum+addOrSub;
            if(lineNum == numRows){
                lineNum =lineNum -2;
                addOrSub = -1;
            }
            if(lineNum == -1){
                lineNum = 1;
                addOrSub = 1;
            }
        }
        return Arrays.stream(resultArr).filter(Objects::nonNull).collect(Collectors.joining(""));
    }

    @Test
    public void test(){
        System.out.println(convert("PAYPALISHIRING",3));
    }

}
