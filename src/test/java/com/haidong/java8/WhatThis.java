package com.haidong.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Don
 * @Date: 2019/2/23 15:55
 */
public class WhatThis {

    public void whatThis(){
        //转全小写
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(str -> {
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }

    public static void main(String[] args) {
        WhatThis wt = new WhatThis();
        wt.whatThis();
    }
}
