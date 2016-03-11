package com.java.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xhans on 2016/3/11.
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> userCases, Class<?> cl){
        for (Method method : cl.getDeclaredMethods()){
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null){
                System.out.println("Found Use Case:" + useCase.id() +
                        " " + useCase.description());
                userCases.remove(new Integer(useCase.id()));
            }
        }
        for(int i : userCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }
    
    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
