package com.sda.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by RENT on 2017-08-28.
 */
public class MyStringUtils {

    public static boolean isUpperCase(String value) {
        return StringUtils.isNotBlank(value) && value != null && value.equals(value.toUpperCase());
    }

    public static boolean isArray(String value) {
        return StringUtils.isNotBlank(value) && StringUtils.contains(value, ", ");
    }

    public static String convertToString(String[] array) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (isPenultimate(array, i)) { //jesli jest przedostatni
                stringBuilder.append(" and ");
            } else if (!isLast(array, i)) { //jesli nie jest przedostatni i nie jest na koncu
                stringBuilder.append(", ");
            }
            //a jak jestem na koncu to nic nie robie
        }

        return stringBuilder.toString();
    }

    private static boolean isPenultimate(String[] array, int i) {
        return i == array.length - 2;
    }

    private static boolean isLast(String[] array, int i) {
        return i == array.length -1;
    }
}
