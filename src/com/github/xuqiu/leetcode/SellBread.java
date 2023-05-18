package com.github.xuqiu.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-26 17:42
 */
public class SellBread {


    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            test1();
        }
    }
    @Test
    public void test1(){

        AtomicInteger money110 = new AtomicInteger(10000);
        AtomicInteger money120 = new AtomicInteger(10000);
        AtomicInteger money130 = new AtomicInteger(10000);
        AtomicInteger money140 = new AtomicInteger(10000);

        AtomicInteger bread110 = new AtomicInteger(0);
        AtomicInteger bread120 = new AtomicInteger(0);
        AtomicInteger bread130 = new AtomicInteger(0);
        AtomicInteger bread140 = new AtomicInteger(0);


        for (int i = 0; i < 10000; i++) {
            int random = Double.valueOf(Math.random() * 1000).intValue();
            int sell = 100+random%5*10;
            money110.addAndGet(110-bread110.get()*-4);
            money120.addAndGet(120-bread120.get()*-4);
            money130.addAndGet(130-bread130.get()*-4);
            money140.addAndGet(140-bread140.get()*-4);

//            money110.addAndGet(Math.min(bread110.get(),sell)*3+ sell>bread110.get()?(Math.min(sell-bread110.get(), 110)*5):0);
//            money120.addAndGet(Math.min(bread120.get(),sell)*3+ sell>bread120.get()?(Math.min(sell-bread120.get(), 120)*5):0);
//            money130.addAndGet(Math.min(bread130.get(),sell)*3+ sell>bread130.get()?(Math.min(sell-bread130.get(), 130)*5):0);
//            money140.addAndGet(Math.min(bread140.get(),sell)*3+ sell>bread140.get()?(Math.min(sell-bread140.get(), 140)*5):0);
//
//            money110.addAndGet(Math.min(sell, 110)*5 + (sell>110?Math.min(sell-110,bread110.get())*3:0));
//            money120.addAndGet(Math.min(sell, 120)*5 + (sell>120?Math.min(sell-120,bread120.get())*3:0));
//            money130.addAndGet(Math.min(sell, 130)*5 + (sell>130?Math.min(sell-130,bread130.get())*3:0));
//            money140.addAndGet(Math.min(sell, 140)*5 + (sell>140?Math.min(sell-140,bread140.get())*3:0));

            money110.addAndGet(Math.min(sell, 110-bread110.get())*5 + Math.min(bread110.get(),sell+bread110.get()-110)*3);
            money110.addAndGet(Math.min(sell, 110-bread110.get())*5 + Math.min(bread110.get(),sell+bread110.get()-110)*3);
            money110.addAndGet(Math.min(sell, 110-bread110.get())*5 + Math.min(bread110.get(),sell+bread110.get()-110)*3);
            money110.addAndGet(Math.min(sell, 110-bread110.get())*5 + Math.min(bread110.get(),sell+bread110.get()-110)*3);
            money120.addAndGet(Math.min(sell, 120)*5 + (sell>120?Math.min(sell-120,bread120.get())*3:0));
            money130.addAndGet(Math.min(sell, 130)*5 + (sell>130?Math.min(sell-130,bread130.get())*3:0));
            money140.addAndGet(Math.min(sell, 140)*5 + (sell>140?Math.min(sell-140,bread140.get())*3:0));

            bread110.set(Math.max(110 + bread110.get() - sell,0));
            bread120.set(Math.max(120 + bread120.get() - sell,0));
            bread130.set(Math.max(130 + bread130.get() - sell,0));
            bread140.set(Math.max(140 + bread140.get() - sell,0));

        }
        System.out.printf("110:%s,120:%s,130:%s,140:%s%n",
            money110.get(), money120.get(), money130.get(), money140.get());


    }

}
