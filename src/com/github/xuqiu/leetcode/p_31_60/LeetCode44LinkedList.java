package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-18 18:06
 */
public class LeetCode44LinkedList {

    public boolean isMatch(String s, String p) {
        LinkedList<Character> sl = new LinkedList<>();
        LinkedList<Character> pl = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            sl.addLast(s.charAt(i));
        }
        for (int i = 0; i < p.length(); i++) {
            pl.addLast(p.charAt(i));
        }
        //掐头
        while (!pl.isEmpty()&&!sl.isEmpty()) {
            char cp = pl.get(0);
            if (cp == '*') {
                break;
            }
            char cs = sl.get(0);
            if (cs == cp || cp == '?') {
                pl.removeFirst();
                sl.removeFirst();
            }else{
                return false;
            }
        }
        //去尾
        while (!pl.isEmpty()&&!sl.isEmpty()) {
            char cp = pl.get(pl.size() - 1);
            if (cp == '*') {
                break;
            }
            char cs = sl.get(sl.size()-1);
            if (cs == cp || cp == '?') {
                pl.removeLast();
                sl.removeLast();
            }else{
                return false;
            }
        }
        if (pl.isEmpty()){
            return sl.isEmpty();
        }

        return findAndCut(sl, pl);
    }

    private Boolean findAndCut(LinkedList<Character> sl, LinkedList<Character> pl) {
        if (pl.isEmpty()){
            return sl.isEmpty();
        }

        while (!pl.isEmpty() && pl.get(0).equals('*')){
            pl.removeFirst();
        }
        if (pl.isEmpty()) {
            return true;
        }
        LinkedList<Character> word = new LinkedList<>();
        for (Character c : pl) {
            if (c.equals('*')) {
                break;
            }
            word.add(c);
        }
        if (sl.size()<word.size()) {
            return false;
        }
        int abcIndex = 0;
        char abc = '?';
        for (; abcIndex < word.size(); abcIndex++) {
            char c = word.get(abcIndex);
            if (c != '?') {
                abc = c;
                break;
            }
        }
        if (abc == '?'){
            for (int i = 0; i < word.size(); i++) {
                sl.removeFirst();
                pl.removeFirst();
            }
            return findAndCut(sl, pl);
        }
        int sIndex = -1;
        for (int i = abcIndex; i < sl.size(); i++) {
            if (sl.get(i) == abc) {
                sIndex = i;
                break;
            }
        }
        if (sIndex == -1) {
            return false;
        }
        for (int i = 0; i < sIndex; i++) {
            sl.removeFirst();
        }
        for (int i = 0; i < abcIndex; i++) {
            word.removeFirst();
            pl.removeFirst();
        }
        if (sl.size() < word.size()){
            return false;
        }
        //掐头
        for (int i = 0; i < word.size(); i++) {
            char cp = word.get(i);
            char cs = sl.get(i);
            if (cs != cp && cp != '?') {
                if (sIndex == 0) {
                    sl.removeFirst();
                }
                return findAndCut(sl, pl);
            }
        }
        for (int i = 0; i < word.size(); i++) {
            sl.removeFirst();
            pl.removeFirst();
        }
        return findAndCut(sl, pl);
    }

    @Test
    public void test() {
        System.out.println(isMatch("aaaa", "***a"));//true
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
