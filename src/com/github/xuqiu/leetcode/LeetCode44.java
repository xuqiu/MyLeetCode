package com.github.xuqiu.leetcode;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-18 18:06
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        if(p.length()>10) {
            final String longestP = Arrays.stream(p.split("\\*")).max(Comparator.comparing(String::length)).orElse("");
            if (longestP.length() > 4 && !s.contains(longestP)) {
                return false;
            }
        }
        return isMatchIterate(s, p);
    }
    private boolean isMatchIterate(String s, String p) {
        if (s.equals(p) || "*".equals(p)) {
            return true;
        }
        if(p.isEmpty()){
            return false;
        }
        if(s.length()<p.replaceAll("\\*","").length()){
            return false;
        }


        if(s.isEmpty()){
            return p.charAt(0) == '*' && isMatchIterate(s, p.substring(1));
        }
        while(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            s = s.substring(1);
            p = p.substring(1);
            if(p.isEmpty()){
                return s.isEmpty();
            }
            if("*".equals(p)){
                return true;
            }
            if(s.isEmpty()){
                break;
            }
        }
        if(p.charAt(0) != '*'){
            return false;
        }
        while(p.charAt(1) == '*'){
            p=p.substring(1);
            if(p.length()==1){
                return true;
            }
        }
        if(isMatchIterate(s,p.substring(1))){
            return true;
        }
        while(s.length()>1&&s.charAt(1) != p.charAt(1) && p.charAt(1) != '?'){
            s=s.substring(1);
        }
        return isMatchIterate(s.substring(1),p);

    }
    @Test
    public void test() {
        System.out.println(isMatch("hi", "*?"));
//        System.out.println(isMatch("", ""));
//        System.out.println(isMatch("b", "?"));
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "*"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("cb", "?a"));
//        System.out.println(isMatch("cb", "?b"));
//        System.out.println(isMatch("abcd", "*b"));
//        System.out.println(isMatch("abcd", "a*b"));
//        System.out.println(isMatch("abcd", "a*b*"));
//        System.out.println(isMatch("abcd", "*b*"));
//        System.out.println(isMatch("abcd", "*cb*"));
//        System.out.println(isMatch("adceb", "*a*b"));
//        String s="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
//        String p="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
//        System.out.println(isMatch(s, p));
    }
}
