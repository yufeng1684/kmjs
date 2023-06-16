package org.kmjs.java;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        HashMap<Person, String> hashMap = new HashMap<>();
        hashMap.put(new Person(1, "xiaoming"), "Musician");
        hashMap.put(new Person(1, "xiaoming"), "Musician");
        hashMap.put(new Person(2, "xiaohong"), "Scientist");
        hashMap.put(new Person(2, "xiaobai"), "Astronaut");
        System.out.println(hashMap);

        for(Map.Entry<Person, String> entry : hashMap.entrySet()) {
            System.out.println("key is " + entry.getKey() + " value is " + entry.getValue());
        }

        for(Person person : hashMap.keySet()) {
            System.out.println("person is " + person);
        }

        for(String string : hashMap.values()) {
            System.out.println("value is " + string);
        }
    }
}
