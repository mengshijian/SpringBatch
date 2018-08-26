package com.cml.learning.framework.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationUtils {

    public static List<Class> loadAnnotationClass(String packageBase,Class annotationClass){
        List<Class> list = new ArrayList<>();
        return null;
    }

    public static void main(String[] args){
        //String path2 = Thread.currentThread().getContextClassLoader().getResource("/com/cml/learning/framework/util").getPath();
        String path2 = AnnotationUtils.class.getPackage().toString();
        System.out.println("path2 = " + path2);
       /* ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] res = resolver.getResources("classpath*:/com/cml/learning/framework/util/*.class");
            Arrays.stream(res).forEach(e -> {
                try {
                    System.out.println(e.getFile().getPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
