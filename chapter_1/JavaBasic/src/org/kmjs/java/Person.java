package org.kmjs.java;

import java.util.Objects;

public class Person {
    private final String name;
    private final long id;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id is " + id + " name is " + name;
    }

    @Override
    public int hashCode() {
        return (int)id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Person person = (Person) obj;
        return person.getId() == this.id && Objects.equals(person.getName(), this.name);
    }
}
