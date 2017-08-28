package com.sda.service;

import com.sda.util.MyStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Created by RENT on 2017-08-28.
 */
public class WriteService {

    public String action(String name) {

        /*
        String valueToReturn = "Hello, my friend";

        if (!StringUtils.isBlank(name) && StringUtils.isAllUpperCase(name)) {
            valueToReturn = "HELLO, " + name;
        }
        else if (!StringUtils.isBlank(name)) {
            valueToReturn = "Hello, " + name;
        }

        return valueToReturn;
        */

        String prefix = initPrefix(name);
        String suffix = initSuffix(name);
        String middleValue = initMiddleValue(name);

        return prefix + middleValue + suffix;
    }

    private String initPrefix(String name) {
        return MyStringUtils.isUpperCase(name) ? "HELLO, " : "Hello, ";
    }

    private String initSuffix(String name) {
        return MyStringUtils.isUpperCase(name) ? "!" : "";
    }

    private String initMiddleValue(String name) {
        /*
        String valueToReturn = name;

        if (StringUtils.isNotBlank(valueToReturn)) {

            String[] split = StringUtils.split(name, ", ");

            if (split.length > 1) {
                String tmp = "";
                for (int i = 0; i < split.length - 1; i++) {
                    tmp += split[i] + ", ";
                }
                tmp = tmp.substring(0, tmp.length() - 2) + " and " + split[split.length - 1];
                System.out.println(tmp);

                valueToReturn = tmp;
            }
        }

        return (StringUtils.isBlank(name)) ? "my friend" : valueToReturn;
        */

        String valueToReturn = null;

        if (MyStringUtils.isArray(name)) {
            valueToReturn = MyStringUtils.convertToString(name.split(", "));
        }

        return valueToReturn != null ? valueToReturn :
                (StringUtils.isBlank(name) ? "my friend" : name);

    }



}
