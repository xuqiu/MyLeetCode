package com.github.xuqiu.leetcode.p_31_60;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *       123
 *     x 456
 *  ----------
 *       738
 *      615
 *     492
 *  ----------
 *     56088
 *
 *
 *
 *       123
 *     x 987
 *  ----------
 *       861
 *      984
 *    1107
 *  ----------
 *    121401
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-16 18:01
 */
public class LeetCode43 {
    private static final Map<String, String> MULTI_TABLE = new HashMap<>(128);
    static{
        MULTI_TABLE.putAll(Map.of("11","01","21","02","31","03","41","04","51","05","61","06","71","07","81","08","91","09"));
        MULTI_TABLE.putAll(Map.of("12","02","22","04","32","06","42","08","52","10","62","12","72","14","82","16","92","18"));
        MULTI_TABLE.putAll(Map.of("13","03","23","06","33","09","43","12","53","15","63","18","73","21","83","24","93","27"));
        MULTI_TABLE.putAll(Map.of("14","04","24","08","34","12","44","16","54","20","64","24","74","28","84","32","94","36"));
        MULTI_TABLE.putAll(Map.of("15","05","25","10","35","15","45","20","55","25","65","30","75","35","85","40","95","45"));
        MULTI_TABLE.putAll(Map.of("16","06","26","12","36","18","46","24","56","30","66","36","76","42","86","48","96","54"));
        MULTI_TABLE.putAll(Map.of("17","07","27","14","37","21","47","28","57","35","67","42","77","49","87","56","97","63"));
        MULTI_TABLE.putAll(Map.of("18","08","28","16","38","24","48","32","58","40","68","48","78","56","88","64","98","72"));
        MULTI_TABLE.putAll(Map.of("19","09","29","18","39","27","49","36","59","45","69","54","79","63","89","72","99","81"));
    }
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder resultRevertBuilder = new StringBuilder();
        // let num2 shorter
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String [] toSumArr = new String[num2.length()];
        char[] charArray = num2.toCharArray();
        int lastSumLeft=0;
        for (int i2 = 0, charArrayLength = charArray.length; i2 < charArrayLength; i2++) {
            char n2 = charArray[charArrayLength-i2-1];
            char[] array = num1.toCharArray();
            char lastTen = '0';
            //reverse order
            boolean carry = false;
            StringBuilder sumLine = new StringBuilder();
            for (int i1 = 0, arrayLength = array.length; i1 < arrayLength; i1++) {
                if (n2 == '0') {
                    sumLine.append('0');
                    continue;
                }
                char n1 = array[arrayLength-i1-1];
                String multi = "00";
                if (n1!='0') {
                    multi = MULTI_TABLE.get(String.valueOf(new char[] { n1, n2 }));
                }
                int thisDigit = multi.charAt(1) + lastTen - 96 + (carry?1:0);
                lastTen=multi.charAt(0);
                carry = thisDigit>=10;
                sumLine.append(thisDigit % 10);
            }
            if(carry || lastTen>'0'){
                sumLine.append(lastTen - 48 + (carry?1:0));
            }
            toSumArr[i2]=sumLine.toString();

            for (int i = i2; i >= 0 ; i--) {
                final String iLine = toSumArr[i];
                if (iLine !=null) {
                    lastSumLeft += iLine.charAt(i2 - i) - 48;
                }
            }
            resultRevertBuilder.append(lastSumLeft%10);
            lastSumLeft = lastSumLeft/10;
        }
        //handle lastSum number
        int n2 = num2.length()-1;
        char[] array = toSumArr[n2].toCharArray();
        for (int il = 1, arrayLength = array.length; il < arrayLength; il++) {
            for (int i = n2; i >= 0 ; i--) {
                final String iLine = toSumArr[i];
                if (iLine !=null) {
                    if (iLine.length() <= (n2 - i + il)) {
                        break;
                    }
                    lastSumLeft += iLine.charAt(n2 - i + il) - 48;
                }
            }
            resultRevertBuilder.append(lastSumLeft%10);
            lastSumLeft = lastSumLeft/10;
        }


        return (lastSumLeft > 0? lastSumLeft:"")+resultRevertBuilder.reverse().toString();
    }
    @Test
    public void test(){
//        System.out.println(multiply("123","456"));
//        System.out.println(multiply("123","987"));
        System.out.println(multiply("1234123421341234","4567456745674567456723452345234523450970987097"));
    }

    @Test
    public void genMap(){
        for(int i=1;i<=9;i++) {

            System.out.print("MULTI_TABLE.putAll(Map.of(");
            for(int m=1;m<=9;m++) {
                int r=i*m;
                System.out.print("\"" + m + i + "\",\""+(r<10?"0":"") + r+ '"');
                if (m<9){
                    System.out.print(",");
                }
            }
            System.out.println("));");

        }
    }

}
