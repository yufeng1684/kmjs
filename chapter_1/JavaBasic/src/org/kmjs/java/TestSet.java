package org.kmjs.java;

import java.util.*;

public class TestSet {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(new Person(1, "xiaoming"));
        set.add(new Person(2, "hanmeimei"));
        set.add(new Person(2, "hanmeimei"));
        set.add(new Person(3, "lilei"));
        System.out.println(set);
        set.remove(new Person(2, "hanmeimei"));
        System.out.println(set);
        for (Object obj : set) {
            if (obj instanceof Person) {
                System.out.println((Person) obj);
            }
        }

        TreeSet<Person> set1 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Long.compare(o1.getId(), o2.getId());
            }
        });

        set1.add(new Person(40, "lilei"));
        set1.add(new Person(29, "xiaoming"));
        set1.add(new Person(41, "xiaoming"));
        set1.add(new Person(32, "xiaoming"));
        set1.add(new Person(50, "xiaoming"));
        set1.add(new Person(37, "xiaoming"));
        System.out.println(set1);
    }
}
