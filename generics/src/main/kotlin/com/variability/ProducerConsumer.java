package com.variability;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args) {
        List<Object> to = new ArrayList<Object>();
        to.add(10);

        List<String> from = new ArrayList<String>();
        from.add("hello");


        transfer(to, from);

        System.out.println(to.get(0));
        System.out.println(to.get(1));

    }

     static void transfer(@NotNull List<Object> to, List<String> from){
         to.addAll(from);
     }

}
