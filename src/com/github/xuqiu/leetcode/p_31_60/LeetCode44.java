package com.github.xuqiu.leetcode.p_31_60;

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
        p = p.replaceAll("\\*+", "*");
        //掐头
        while (!p.isEmpty()&&!s.isEmpty()) {
            char cp = p.charAt(0);
            if (cp == '*') {
                break;
            }
            char cs = s.charAt(0);
            if (cs == cp || cp == '?') {
                p = p.substring(1);
                s = s.substring(1);
            }else{
                return false;
            }
        }
        //去尾
        while (!p.isEmpty()&&!s.isEmpty()) {
            char cp = p.charAt(p.length() - 1);
            if (cp == '*') {
                break;
            }
            char cs = s.charAt(s.length() - 1);
            if (cs == cp || cp =='?') {
                p = p.substring(0, p.length()-1 );
                s = s.substring(0, s.length()-1);
            }else{
                return false;
            }
        }
        if (p.isEmpty()){
            return s.isEmpty();
        }
        String[] words = p.split("\\*");
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            s = findAndCut(s, word);
            if (s==null){
                return false;
            }
        }
        return s != null;
    }

    private String findAndCut(String s, String word) {
        if (s.length()<word.length()) {
            return null;
        }
        if (word.indexOf('?')>-1){
            char[] charArray = word.toCharArray();
            int abcIndex = 0;
            char abc = '?';
            for (; abcIndex < charArray.length; abcIndex++) {
                char c = charArray[abcIndex];
                if (c != '?') {
                    abc = c;
                    break;
                }
            }
            if (abc == '?'){
                return s.substring(word.length());
            }
            int sIndex = s.indexOf(abc, abcIndex);
            if (sIndex == -1) {
                return null;
            }
            s = s.substring(sIndex);
            String p = word.substring(abcIndex);
            if (s.length() < p.length()){
                return null;
            }
            //掐头
            for (int i = 0; i < p.length(); i++) {
                char cp = p.charAt(i);
                char cs = s.charAt(i);
                if (cs != cp && cp != '?') {
                    if (sIndex == 0) {
                        s=s.substring(1);
                    }
                    return findAndCut(s, word);
                }
            }
            return s.substring(p.length());
        }else {
            int i = s.indexOf(word);
            if (i > -1) {
                return s.substring(i + word.length());
            } else {
                return null;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(isMatch("baab", "*?ab*"));//true
        System.out.println(isMatch("a", "aa"));//false
        System.out.println(isMatch("bb", "*?b"));//true
        System.out.println(isMatch("c", "*?*"));//true
        System.out.println(isMatch("acdcb", "a*c?b"));//false
        System.out.println(isMatch("abcabczzzde", "*abc???de*"));//true
        System.out.println();
        System.out.println(isMatch("hi", "*?"));//true
        System.out.println(isMatch("", ""));//true
        System.out.println(isMatch("b", "?"));//true
        System.out.println(isMatch("aa", "a"));//false
        System.out.println();
        System.out.println(isMatch("aa", "*"));//true
        System.out.println(isMatch("aa", "a*"));//true
        System.out.println(isMatch("cb", "?a"));//false
        System.out.println(isMatch("cb", "?b"));//true
        System.out.println();
        System.out.println(isMatch("abcd", "*b"));//false
        System.out.println(isMatch("abcd", "a*b"));//false
        System.out.println(isMatch("abcd", "a*b*"));//true
        System.out.println(isMatch("abcd", "*b*"));//true
        System.out.println();
        System.out.println(isMatch("abcd", "*cb*"));//false
        System.out.println(isMatch("adceb", "*a*b"));//true
        System.out.println();
        String s;
        String p;
        long start = System.currentTimeMillis();
        s="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        p="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(isMatch(s, p));
        s ="aaaaaabbaabaaaaabababbabbaababbaabaababaaaaabaaaabaaaabababbbabbbbaabbababbbbababbaaababbbabbbaaaaaaabbaabbbbababbabbaaabababaaaabaaabaaabbbbbabaaabbbaabbbbbbbaabaaababaaaababbbbbaabaaabbabaabbaabbaaaaba";
        p ="*bbb**a*******abb*b**a**bbbbaab*b*aaba*a*b**a*abb*aa****b*bb**abbbb*b**bbbabaa*b**ba**a**ba**b*a*a**aaa";
        System.out.println(isMatch(s, p));
        s ="aaaabaabaabbbabaabaabbbbaabaaabaaabbabbbaaabbbbbbabababbaabbabbbbaababaaabbbababbbaabbbaabbaaabbbaabbbbbaaaabaaabaabbabbbaabababbaabbbabababbaabaaababbbbbabaababbbabbabaaaaaababbbbaabbbbaaababbbbaabbbbb";
        p ="**a*b*b**b*b****bb******b***babaab*ba*a*aaa***baa****b***bbbb*bbaa*a***a*a*****a*b*a*a**ba***aa*a**a*";
        System.out.println(isMatch(s, p));
        System.out.println(System.currentTimeMillis() - start);
    }
}
