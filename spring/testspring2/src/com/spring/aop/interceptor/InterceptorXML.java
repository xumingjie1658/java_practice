package com.spring.aop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by xumingjie on 15/10/4.
 */
public class InterceptorXML {

    public void doAccessCheck(){
        System.out.println("before advice");
    }

    public void doWriteLog(){
        System.out.println("after advice"+":");
    }

    public void doMemoryClear(){
        System.out.println("finally advice");
    }

    public void doWriteErrorLog(){
        System.out.println("Exception advice");
    }

    public Object doAroundMethod(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("enter around advice method.");

        Object obj = pjp.proceed();

        System.out.println("exit around advice method.");

        return obj;
    }
}
