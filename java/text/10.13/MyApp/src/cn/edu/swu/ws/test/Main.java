package cn.edu.swu.ws.test;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();

        List<Fruit> list = new LinkedList();
        list.add(orange);
        list.add(apple);

        list.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Fruit fruit : list) {
            System.out.println(fruit.getName());
        }

        list.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {

                if (o1.getTotal() == o2.getTotal()) {
                    return 0;
                }

                return o1.getTotal() > o2.getTotal() ? -1 : 1;
            }
        });

        System.out.println(".........................");

        for (Fruit fruit : list) {
            System.out.println(fruit.getName());
        }


        Set<Fruit> set = new HashSet<>();
        set.add(apple);
        set.add(orange);
        set.add(apple);

        for (Fruit fruit : set) {
            System.out.println(fruit);
        }

        System.out.println(".........................");

        Map<String, Fruit> map = new HashMap<>();
        map.put(apple.getName(), apple);
        map.put(orange.getName(), orange);


        System.out.println(map.get("apple").getTotal());

    }


}