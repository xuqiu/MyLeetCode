package com.github.xuqiu.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-22 16:13
 */
public class LeetCode706 {

    public static class MyHashMap {
        Integer[][][] values= new Integer[100][100][100];

        public MyHashMap() {

        }

        public void put(int key, int value) {
            this.values[key/10000%100][key/100%100][key%100] = value;
        }

        public int get(int key) {
            final Integer value = this.values[key / 10000 % 100][key / 100 % 100][key % 100];
            return value==null?-1:value;
        }

        public void remove(int key) {
            this.values[key/10000%100][key/100%100][key%100] = -1;
        }
    }
    @Test
    public void test(){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,123);
        myHashMap.put(9999,124);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(9999));
        myHashMap.remove(1);
        System.out.println(myHashMap.get(9999));
        System.out.println(myHashMap.get(1));
    }

}
