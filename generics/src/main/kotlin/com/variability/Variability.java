package com.variability;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Variability {
    public static void main(String[] args) {
        // Java
//        List<String> strs = new ArrayList<String>();
//        List<Object> objs = strs; // !!! Причина вышеуказанной проблемы заключена здесь, Java запрещает так делать
//        objs.add(1); // Тут мы помещаем Integer в список String'ов
//        String s = strs.get(0); // !!! ClassCastException: не можем кастовать Integer к String

        foo(new BigDecimal(10));
    }


    public static void foo(Object obj){

        System.out.println(obj);
    }
}
