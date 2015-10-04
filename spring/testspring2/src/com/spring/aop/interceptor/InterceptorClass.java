package com.spring.aop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by xumingjie on 15/10/4.
 */

@Aspect
public class InterceptorClass {
    @Pointcut("execution (* com.spring.aop.service.impl.PersonServiceBean.*(..))")
    private void myPointCutMethod(){};

    @Before("myPointCutMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println("before advice:"+name);
    }

    @AfterReturning(pointcut="myPointCutMethod()", returning="result")
    public void doWriteLog(String result){
        System.out.println("after advice"+":"+result);
    }

    @After("myPointCutMethod()")
    public void doMemoryClear(){
        System.out.println("finally advice");
    }

    @AfterThrowing(pointcut="myPointCutMethod()", throwing="e")
    public void doWriteErrorLog(Exception e){
        System.out.println("Exception advice");
    }

    @Around("myPointCutMethod()")
    public Object doAroundMethod(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("enter around advice method.");
        Object obj = pjp.proceed();
        System.out.println("exit around advice method.");
        return obj;
    }
}
