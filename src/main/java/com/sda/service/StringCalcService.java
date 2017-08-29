package com.sda.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by RENT on 2017-08-29.
 */
public class StringCalcService {

    public int calc(String value) {

        //dostaje cos postacji "5;3" i oblicza sume tych cyfr

        String[] split = StringUtils.split(value, ';');

        //zamiana tablicy stringow na tablice intow
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        int sum = IntStream.of(array).sum();

        return sum;
    }

}
