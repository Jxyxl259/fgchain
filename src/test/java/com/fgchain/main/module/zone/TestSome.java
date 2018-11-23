package com.fgchain.main.module.zone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestSome
 * @Description
 * @Author jiangxy
 * @Date 2018\11\23 0023 10:21
 * @Version 1.0.0
 */
public class TestSome {

    @Test
    public void testIntListToString(){

        List<Integer> integerIds = Arrays.asList(1,2,3,4,5,6);

        String s = integerIds.toString();

        System.out.println(integerIds + "\t integerIds.toString():" + s );

        Integer[] array = integerIds.toArray(new Integer[integerIds.size()]);

        String s1 = array.toString();

        System.out.println(array + "\t array.toString();:" + s1 );

//        ArrayList<Integer> ids = new ArrayList<>(integerIds);
//
//        String[] strIds = (ids.toArray(new String[integerIds.size()]));
//
//        System.out.println(strIds);

    }

}
