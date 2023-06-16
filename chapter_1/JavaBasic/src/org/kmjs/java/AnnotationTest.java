package org.kmjs.java;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
    private String name;

    @MethodUrl(ID=1, Describe = "获取名字", URL="/JavaAn/getName")
    public String getName() {
        return name;
    }

    @MethodUrl(ID=2, Describe = "设置名字", URL="/JavaAn/setName")
    public String setName() {
        return name;
    }

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("org.kmjs.java.AnnotationTest");
            Method[] methods = clazz.getMethods();
            for(Method method :methods) {
                MethodUrl methodUrl = method.getDeclaredAnnotation(MethodUrl.class);
                if(methodUrl != null) {
                    System.out.println(method.getName() + "function ID is " +
                            methodUrl.ID() + " and url is localhost:8080" + methodUrl.URL() +
                            " for " + methodUrl.Describe());
                }
            }
//            Annotation[] methodUrls = clazz.getDeclaredAnnotations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
