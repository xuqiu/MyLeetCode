package com.github.xuqiu.leetcode;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-07 17:10
 */
public class BasicTest {
    @Test
    public void test(){
        final Optional<Object> optional = Stream.of("").map(s -> null).findFirst();
        System.out.println(optional.isPresent());
    }
    @Test
    public void testSplit() {
        String str = "Hello*World?Java*";
        str.charAt(str.length()-1);
        String[] parts1 = str.split("[*?]",0);
        System.out.println("以 * 分割的结果：");
        for (String part : parts1) {
            System.out.println(part);
        }

    }
}
