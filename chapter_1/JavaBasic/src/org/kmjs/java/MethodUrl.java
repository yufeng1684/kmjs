package org.kmjs.java;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodUrl {
    public int ID() default -1;
    public String Describe();
    public String URL();
}
