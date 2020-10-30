package com.variability;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer2 {

    public static void main(String[] args) {
        List<String> to = new ArrayList<String>();
        to.add("world");

        List<String> from = new ArrayList<String>();
        from.add("hello");

        transfer(to, from);

        System.out.println(to);
        //System.out.println(from);
    }

    static  void transfer(@NotNull List<? super String> to, List<? extends String> from){
        to.addAll(from);
       // from.addAll(to);
    }
}
