package com.github.xuqiu.leetcode.p_1_25;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-18 09:50
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        return in("",0,n);
    }
    public List<String> in(String head, int in, int left){
        in++;
        left--;
        head = head + "(";
        List<String> result = new ArrayList<>();
        if(left>0) {
            result.addAll(in(head, in, left));
        }
        result.addAll(out(head,in,left));
        return result;
    }
    public List<String> out(String head, int in, int left){
        in--;
        head = head+")";
        if(in ==0 && left==0){
            return List.of(head);
        }
        List<String> result = new ArrayList<>();
        if(left>0) {
            result.addAll(in(head, in, left));
        }
        if(in>0) {
            result.addAll(out(head,in,left));
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(generateParenthesis(4)));
    }
}
